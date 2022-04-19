/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.services;

import com.project.callbreak.info.GamePlayer;

/**
 *
 * @author srivarun
 */
public class Score {
    public void ScoreCalculation(){
        CardsDistribution cd = new CardsDistribution();
        for(GamePlayer p : cd.alp){
            int bid=p.getBid();
            int tricksWon=p.getTricksWon();
            float roundScore=p.getRoundScore();
            float totalScore=p.getTotalScore();
            if(bid == tricksWon){
                roundScore = bid;
            }
            else if(bid < tricksWon){
                roundScore = (float) ((float)bid + (0.1*(tricksWon-bid)));  
            }
            else{
                roundScore = bid - tricksWon;
            }
            totalScore = totalScore+roundScore;
            p.setRoundScore(roundScore);
            p.setTotalScore(totalScore);
        }
        

    }
    
}
