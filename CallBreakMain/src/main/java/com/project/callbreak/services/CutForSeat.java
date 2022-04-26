/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.thighRankt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.project.callbreak.services;

import com.project.callbreak.info.GenerateCards;
import com.project.callbreak.info.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author srivarun
 */
public class CutForSeat {


    public ArrayList<Card> CutForSeatLogic(ArrayList<Card> cardsList) {
        
        ArrayList<Card> alCFSCards = new ArrayList<>();
        
        GenerateCards gCards = new GenerateCards();
        
        ArrayList<Integer> cnl = gCards.cardNumberList;
        
        Collections.shuffle(cnl);




        
        //Generating 4 random cards and adding it to the HashSet
        for(int i=1;i<=4;i++){
            Card c = cardsList.get(cnl.remove(0));
            c.setPlayerId(Integer.toString(i));
            alCFSCards.add(c);
        }
              
        Iterator<Card> itr1 = alCFSCards.iterator();
        Card cDistributor = itr1.next();
                
        int highCard=cDistributor.getCardNumber();
        char suit = cDistributor.getSuit();
        while(itr1.hasNext()){
            Card c = itr1.next();
            if(c.getCardNumber() > highCard){
                highCard = c.getCardNumber();
                cDistributor = c;
            }
            else if(c.getCardNumber() == highCard){
                  if((int)c.getSuit()>(int)suit){
                      cDistributor = c;
                  }
            }
        }
        
        Iterator<Card> itr2 = alCFSCards.iterator();
        Card cDiscarder = itr2.next();
        
        int lowCard=cDistributor.getCardNumber();
        suit = cDistributor.getSuit();
        
        while(itr2.hasNext()){
            Card c = itr2.next();
            if(c.getCardNumber() < lowCard){
                lowCard = c.getCardNumber();
                cDiscarder = c;
            }
            else if(c.getCardNumber() == lowCard){
                  if((int)c.getSuit()>(int)suit){
                      cDiscarder = c;
                  }
            }
        }
        
        System.out.println(alCFSCards);
        System.out.println();
        
        ArrayList<Card> alSeatArrangement = new ArrayList<>();
        alSeatArrangement.add(cDistributor);
        alSeatArrangement.add(cDiscarder);
        alCFSCards.remove(cDistributor);
        alCFSCards.remove(cDiscarder);
        
        Iterator<Card> itr3 = alCFSCards.iterator();
        Card c2 = itr3.next();
        
        lowCard=c2.getCardNumber();
        suit = c2.getSuit();
        
        while(itr3.hasNext()){
            Card c = itr3.next();
            if(c.getCardNumber() < lowCard){
                lowCard = c.getCardNumber();
                c2 = c;
            }
            else if(c.getCardNumber() == lowCard){
                  if((int)c.getSuit()>(int)suit){
                      c2 = c;
                  }
            }
        }
        alSeatArrangement.add(c2);
        alCFSCards.remove(c2);
        alSeatArrangement.add(alCFSCards.remove(0));
        


        //Displaying the player who Distributes the cards and who Discards the cards

//        System.out.println(alSeatArrangement);
        StringBuilder sb = new StringBuilder();
        sb.append(alSeatArrangement.get(0).toString());
//        System.out.println(alSeatArrangement.get(0));
        for(int i=1;i<4;i++){
            sb.append(";").append(alSeatArrangement.get(i));
        }
//        System.out.println(s);
//        System.out.println(player+"-"+cDistributor);
//        System.out.println(player2+"-"+cDiscarder);
//        System.out.println("Player "+cDistributor.getPlayerId()+" Distributes the cards and Player "+cDiscarder.getPlayerId()+" Discards the first Card");
        return alSeatArrangement;
    }
    
    public String SeatArrangementCards(ArrayList<Card> cardsList){
        CutForSeat cfs = new CutForSeat();
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Card> seatCards = cfs.CutForSeatLogic(cardsList);
        for(Card c: seatCards){
            stringBuilder.append(c.toString()).append(";");
        } 
        
        stringBuilder.deleteCharAt(stringBuilder.length()-1);  
        return stringBuilder.toString();
    }
    
}
