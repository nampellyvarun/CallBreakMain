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
        ArrayList<Card> seating=cfs.CutForSeatLogic(gCards.cardsList);
        HashMap<String,Player> hm=AppContext.getInstance().getPlayerCollection();
        String s = GameEncoder.getInstance().buildCFS(hm, seating);
        Iterator hmIterator = hm.entrySet().iterator();
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            SendMessage.getInstance().send((Player) mapElement.getValue(), s);
        }
        
    }
    
}