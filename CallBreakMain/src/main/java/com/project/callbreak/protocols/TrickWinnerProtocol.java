/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

/**
 *
 * @author srivarun
 */

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.Chair;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.services.TrickWinner;
import java.util.ArrayList;

public class TrickWinnerProtocol
{ 
    public void trickWinnerCalculator(ArrayList<Card> trickCards, Table table)
    {
        TrickWinner trickWinner = new TrickWinner();
        ArrayList<Chair> chairList = table.getChairs();
        String winnerId = trickWinner.trickWinnerCalculation(trickCards);
        
        String string = GameEncoder.getInstance().buildTrickWinner(winnerId,table);
        System.out.println("TrickWinner: "+ string);
        for(Chair chair : chairList){
            SendMessage.getInstance().send(string,chair.getPlayer());
        }  
    }
}