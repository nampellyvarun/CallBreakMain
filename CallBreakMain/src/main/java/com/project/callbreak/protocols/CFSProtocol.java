/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.GenerateCards;
import com.project.callbreak.info.Player;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.server.impl.AppContext;
import com.project.callbreak.services.CutForSeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author abhirajd
 */
public class CFSProtocol {
    public void cfsProtocol(){
        GenerateCards gCards = new GenerateCards();
        CutForSeat cfs = new CutForSeat();
        ArrayList<Card> seating = cfs.CutForSeatLogic(gCards.cardList);
        HashMap<String,Player> hm = AppContext.getInstance().getPlayerCollection();
        String string = GameEncoder.getInstance().buildCFS(hm, seating);
        
        for (Map.Entry mapElement : hm.entrySet()) {
            SendMessage.getInstance().send(string,(Player) mapElement.getValue());
        }
        System.out.println("Cards: "+string);
        System.out.println();
        
        CDProtocol cdp = new  CDProtocol();
        cdp.cdProtocol(gCards.cardList);
    }
    
}