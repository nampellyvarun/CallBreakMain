/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Chair;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.services.Score;
import java.util.ArrayList;

/**
 *
 * @author srivarun
 */
public class RoundScoreProtocol {
    
    public void roundScoreProtocol(Table table){
        Score score = new Score();
        ArrayList<Chair> chairList = table.getChairs();
        for(Chair chair : chairList ){
            
            score.ScoreCalculation(chair.getGamePlayer());
        }
        
        String string = GameEncoder.getInstance().buildScoreCard(table);
        
        SendMessage.getInstance().sendMessageToTablePlayers(string, table);
    }
    
}
