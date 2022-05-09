/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.info.Card;
import com.project.callbreak.info.GamePlayer;
import com.project.callbreak.info.Player;
import com.project.callbreak.info.Table;
import com.project.callbreak.nio.HandlerInterface;
import com.project.callbreak.protocols.ActiveUsersProtocol;
import com.project.callbreak.protocols.TrickProtocol;
import com.project.callbreak.server.impl.AppContext;
import java.util.StringTokenizer;

/**
 *
 * @author abhirajd
 */
public class TrickCardHandler implements HandlerInterface{

    @Override
    public String handle(String string, Player player) {
        System.out.println("TrickCardHandler called");
        StringTokenizer stringToknizer = new StringTokenizer(string,",");
        String tableId = player.getTableId();
        Card card = new Card(player.getUserId(),stringToknizer.nextToken().charAt(0),Integer.parseInt(stringToknizer.nextToken()));
        Table table = AppContext.getInstance().getTableByTableId(tableId);
        table.addCard(card);
        GamePlayer gp = AppContext.getInstance().getGamePlayerByUserId(player.getUserId(), table);
        gp.getPlayerCards().remove(card);
        System.out.println("after removing card : " +gp.getPlayerCards());
        TrickProtocol trickProtocol = new TrickProtocol();
        trickProtocol.trickCardProtocol(player.getUserId(),table, card);
        
        System.out.println("user active called");
        ActiveUsersProtocol aup = new ActiveUsersProtocol();
        aup.activeUsers(table,table.getActiveUser());
        
        return null;
    }


    
}