/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.info.Card;
import com.project.callbreak.info.Player;
import com.project.callbreak.info.Table;
import com.project.callbreak.nio.HandlerInterface;
import com.project.callbreak.protocols.TrickProtocol;
import com.project.callbreak.protocols.TrickWinnerProtocol;
import com.project.callbreak.server.impl.AppContext;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author srivarun
 */
public class TrickCardHandler implements HandlerInterface{

    @Override
    public String handle(String string, Player player) {
        StringTokenizer stringToknizer = new StringTokenizer(string,",");
        String tableId = stringToknizer.nextToken();
        Card card = new Card(stringToknizer.nextToken(),stringToknizer.nextToken().charAt(0),Integer.parseInt(stringToknizer.nextToken()));
        AppContext.getInstance().addCard(card);
        if(AppContext.getInstance().getTrickList().size()==4){
            ArrayList<Card> trickCards = AppContext.getInstance().getTrickList();
            Table table = AppContext.getInstance().getTableByTableId(tableId);
            TrickWinnerProtocol twp = new TrickWinnerProtocol();
            twp.trickWinnerCalculator(trickCards, table);
            AppContext.getInstance().setTrickList(null);
        }
        else{
            TrickProtocol trickProtocol = new TrickProtocol();
            trickProtocol.trickCardProtocol(tableId, card);
        }
        return null;
    }


    
}
