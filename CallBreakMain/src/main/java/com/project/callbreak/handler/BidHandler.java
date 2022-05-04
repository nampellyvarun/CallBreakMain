/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.info.Chair;
import com.project.callbreak.info.Player;
import com.project.callbreak.info.Table;
import com.project.callbreak.nio.HandlerInterface;
import com.project.callbreak.protocols.BidAckProtocol;
import com.project.callbreak.server.impl.AppContext;
/**
 *
 * @author srivarun
 */
public class BidHandler implements HandlerInterface{

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
        
        BidAckProtocol bap = new BidAckProtocol();
        bap.bidAckProtocol(userId,table, bid);
        //System.out.println(table.toString());
        System.out.println("Bid handler called");
        return null;
    }
    
}
