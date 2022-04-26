/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.info.Chair;
import com.project.callbreak.info.Player;
import com.project.callbreak.info.Table;
import com.project.callbreak.nio.HandlerInterface;
import com.project.callbreak.server.impl.AppContext;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 *
 * @author srivarun
 */
public class BidHandler implements HandlerInterface{

    @Override
    public String handle(String string, Player player) {
        String userId = player.getUserId();
        LinkedHashMap<String,Table> tableCollection = AppContext.getInstance().getTableCollection();
        Table table = new Table(); //know from where to get table
        for (Map.Entry<String, Table> entry : tableCollection.entrySet()) {
            table  = entry.getValue();      
        } 
        for (Chair chair : table.getChairs()) {
            if(chair.getGamePlayer().getPlayerId().equals(userId)){
                chair.getGamePlayer().setBid(Integer.parseInt(string));
            }
        }
        System.out.println(table.toString());
        return null;
    }
    
}
