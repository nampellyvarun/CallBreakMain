/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.info.Card;
import com.project.callbreak.services.CardsDistribution;
import java.util.ArrayList;

/**
 *
 * @author srivarun
 */
public class CDProtocol {
//    public int round;
//
//    public int getRound() {
//        return round;
//    }
//
//    public void setRound(int round) {
//        this.round = round;
//    }
    
    public void cdProtocol(ArrayList<Card> cardsList){
//        if(round==5){
//            round=0;
//        }
        CardsDistribution cardDistribution = new CardsDistribution();
        cardDistribution.playerCardsList(cardsList);
    }
}
