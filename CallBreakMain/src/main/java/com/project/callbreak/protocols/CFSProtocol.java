/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.Chair;
import com.project.callbreak.info.GenerateCards;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.server.impl.AppContext;
import com.project.callbreak.services.CutForSeat;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author abhirajd
 */
public class CFSProtocol {
    public void cfsProtocol(GenerateCards gCards){
        CutForSeat cfs = new CutForSeat();
        
        Table table  = AppContext.getInstance().getLatestTable();
        
        ArrayList<Card> seating = cfs.CutForSeatLogic(gCards);
//        table.setSeating(seating);
//        
        String string = GameEncoder.getInstance().buildCFS(table, seating);
//        
//        seating=table.getSeating();
//        
        SendMessage.getInstance().sendMessageToTablePlayers(string, table);
        
        
        table.setDistributorId(seating.get(0).getPlayerId());
        System.out.println("seating before rotation:"+seating);        
        Collections.rotate(seating,3);
        System.out.println("seating after rotation:"+seating);
        ArrayList<String> activeUsers=new ArrayList<>();
        for(Card card:seating)
            activeUsers.add(card.getPlayerId());        
        table.setActiveUsers(activeUsers);
        
        CDProtocol cdp = new  CDProtocol();
        cdp.cdProtocol(gCards.cardList);
        
        
       

    }
    
}