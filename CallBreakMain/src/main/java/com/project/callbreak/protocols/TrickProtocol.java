/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;

/**
 *
 * @author srivarun
 */
public class TrickProtocol {
    public void trickCardProtocol(String userId, Table table,Card card){
        String string = GameEncoder.getInstance().buildCard(table.getTableId(),card);
        SendMessage.getInstance().sendMessageToOtherPlayers(userId, string, table);
        if(table.getTrickList().size()==4){
            TrickWinnerProtocol twp = new TrickWinnerProtocol();
            twp.trickWinnerCalculator(table);
            table.setTrickCount(table.getTrickCount()+1);
            if(table.getTrickCount()==13){
                RoundScoreProtocol rsp = new RoundScoreProtocol();
                rsp.roundScoreProtocol(table);
                table.setRound(table.getRound()+1);
                if(table.getRound()==5){
                    ResultProtocol rp = new ResultProtocol();
                    rp.resultProtocol(table);
                }
                table.setTrickCount(0);
            }
        }
    }
}
