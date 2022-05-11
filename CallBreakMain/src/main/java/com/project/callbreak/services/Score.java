/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.services;

import com.project.callbreak.info.GamePlayer;
import com.project.callbreak.info.Table;

/**
 *
 * @author srivarun
 */
public class Score {
    public void ScoreCalculation(Table table,GamePlayer gamePlayer){

        int bid = gamePlayer.getBid();
        int tricksWon = gamePlayer.getTricksWon();
        float roundScore = 0;
        float totalScore = gamePlayer.getTotalScore();
        
        if(bid == tricksWon){
            roundScore = (float)bid;
        }
        else if(bid < tricksWon){
            roundScore = (float) ((float)bid + (0.1*(tricksWon-bid)));  
        }
        else{
            roundScore = tricksWon-bid;
        }
        
//        gamePlayer.addRoundScoreToScoreCard(table.getRound()+1, roundScore);
//        System.out.println(""+gamePlayer.getScoreCard());
        totalScore = totalScore+roundScore;
        gamePlayer.setRoundScore(roundScore);
        gamePlayer.setTotalScore(totalScore);
    }
    
}
