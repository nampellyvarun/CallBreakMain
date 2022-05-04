/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.GenerateCards;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.server.impl.AppContext;
import com.project.callbreak.services.CutForSeat;
import java.util.ArrayList;

/**
 *
 * @author abhirajd
 */
public class CFSProtocol {
    public void cfsProtocol(GenerateCards gCards){
        CutForSeat cfs = new CutForSeat();
        ArrayList<Card> seating = cfs.CutForSeatLogic(gCards);
        Table table  = AppContext.getInstance().getLatestTable();
        String string = GameEncoder.getInstance().buildCFS(table, seating);
        
        SendMessage.getInstance().sendMessageToTablePlayers(string, table);
        
        CDProtocol cdp = new  CDProtocol();
        cdp.cdProtocol(gCards.cardList);

    }
    
}