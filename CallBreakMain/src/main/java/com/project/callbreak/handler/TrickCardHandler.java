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
import com.project.callbreak.protocols.TrickProtocol;
import com.project.callbreak.server.impl.AppContext;
import java.util.StringTokenizer;

/**
 *
 * @author srivarun
 */
public class TrickCardHandler implements HandlerInterface{

    @Override
    public String handle(String string, Player player) {
        System.out.println("TrickCardHandler called");
        StringTokenizer stringToknizer = new StringTokenizer(string,",");
        String tableId = player.getTableId();
        Card card = new Card(stringToknizer.nextToken(),stringToknizer.nextToken().charAt(0),Integer.parseInt(stringToknizer.nextToken()));
        Table table = AppContext.getInstance().getTableByTableId(tableId);
        table.addCard(card);
        GamePlayer gp = AppContext.getInstance().getGamePlayerByUserId(player.getUserId(), table);
        gp.getPlayerCards().remove(card);
        System.out.println("PlayerCards after discard "+gp.getPlayerCards().size()+"-"+gp.getPlayerCards());
        TrickProtocol trickProtocol = new TrickProtocol();
        trickProtocol.trickCardProtocol(player.getUserId(),table, card);
        
        return null;
    }


    
}
