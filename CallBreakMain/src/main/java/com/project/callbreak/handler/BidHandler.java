/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.info.Chair;
import com.project.callbreak.info.Player;
import com.project.callbreak.info.Table;
import com.project.callbreak.nio.HandlerInterface;
import com.project.callbreak.protocols.ActiveUsersProtocol;
import com.project.callbreak.protocols.BidAckProtocol;
import com.project.callbreak.server.impl.AppContext;
/**
 *
 * @author abhirajd
 */
public class BidHandler implements HandlerInterface{

    static int userCount;
    @Override
    public String handle(String string, Player player) {
        String userId = player.getUserId();
        Table table = AppContext.getInstance().getTableByTableId(player.getTableId());
        int bid =0;
        
        for (Chair chair : table.getChairs()) {
            if(chair.getGamePlayer().getPlayerId().equals(userId)){
                
                chair.getGamePlayer().setBid(Integer.parseInt(string));
                bid = chair.getGamePlayer().getBid();
            }
        }
        userCount++;
        BidAckProtocol bap = new BidAckProtocol();
        bap.bidAckProtocol(userId,table, bid);
        //System.out.println(table.toString());
        System.out.println("Bid handler called");
        System.out.println("Active users List: " +table.getActiveUsersList());
        if(userCount==4){
             ActiveUsersProtocol aup = new ActiveUsersProtocol();
             aup.activeUsers(table,table.getActiveUser());
             System.out.println("User count 4");
        }
        return null;
    }
    
}