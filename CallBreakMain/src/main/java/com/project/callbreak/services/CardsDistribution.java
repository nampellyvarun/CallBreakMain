/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.services;
import com.project.callbreak.info.CreateCardsList;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.GamePlayer;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author srivarun
 */
public class CardsDistribution {
    
    private static CardsDistribution instance = null;
    public static CardsDistribution getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new CardsDistribution() : instance;
            }
        }
        return instance;
    }
    
    public ArrayList<GamePlayer> alp = new ArrayList<>();
    
    public CreateCardsList CardsDistributionLogic(ArrayList<Card> cardsList){
        
        
        ArrayList<Integer> allSpadeCards = new ArrayList<>();

//Adding all Spade cards to allSpadeCards list
        for(int i=0;i<13;i++){
            allSpadeCards.add(i);
        }
        
        ArrayList<Integer> nonSpadeFaceCards = new ArrayList<>();

//Adding all Non-Spade Face Cards to nonSpadeFaceCards list    
        
        nonSpadeFaceCards.add(13);
        nonSpadeFaceCards.add(14);
        nonSpadeFaceCards.add(15);
        nonSpadeFaceCards.add(16);
        nonSpadeFaceCards.add(26);
        nonSpadeFaceCards.add(27);
        nonSpadeFaceCards.add(28);
        nonSpadeFaceCards.add(29);
        nonSpadeFaceCards.add(39);
        nonSpadeFaceCards.add(40);
        nonSpadeFaceCards.add(41);
        nonSpadeFaceCards.add(42);

        

        
        ArrayList<Integer> nonSpadeNumberCards = new ArrayList<>();
        
//Adding all Non-Spade Number Cards to nonSpadeNumberCards list                
        for(int i=17;i<26;i++){
            nonSpadeNumberCards.add(i);
        }
        for(int i=30;i<39;i++){
            nonSpadeNumberCards.add(i);
        }
        for(int i=43;i<52;i++){
            nonSpadeNumberCards.add(i);
        }
        
        CreateCardsList ccl = new CreateCardsList();
        
        ArrayList<Card> player1List = ccl.getPlayer1List();
        ArrayList<Card> player2List = ccl.getPlayer2List();
        ArrayList<Card> player3List = ccl.getPlayer3List();
        ArrayList<Card> player4List = ccl.getPlayer4List();
        

//Shuffling the arrays using Collections
        Collections.shuffle(allSpadeCards);
        Collections.shuffle(nonSpadeNumberCards);
        Collections.shuffle(nonSpadeFaceCards);
        
        

//Assigning a spade card to each player
        Card c = cardsList.get(allSpadeCards.remove(0));
        c.setPlayerId("1");
        player1List.add(c);
        c = cardsList.get(allSpadeCards.remove(0));
        c.setPlayerId("2");
        player2List.add(c);
        c = cardsList.get(allSpadeCards.remove(0));
        c.setPlayerId("3");
        player3List.add(c);
        c = cardsList.get(allSpadeCards.remove(0));
        c.setPlayerId("4");
        player4List.add(c);
       
        
        
//Assigning a face card to each player if player doesn't have a face card
        if(player1List.get(0).getIsFaceCard() == false){
            c = cardsList.get(nonSpadeFaceCards.remove(0));
            c.setPlayerId("1");
            player1List.add(c);
        }
        if(player2List.get(0).getIsFaceCard() == false){
            c = cardsList.get(nonSpadeFaceCards.remove(0));
            c.setPlayerId("2");
            player2List.add(c);
        }
        if(player3List.get(0).getIsFaceCard() == false){
            c = cardsList.get(nonSpadeFaceCards.remove(0));
            c.setPlayerId("3");
            player3List.add(c);
        }
        if(player4List.get(0).getIsFaceCard() == false){
            c = cardsList.get(nonSpadeFaceCards.remove(0));
            c.setPlayerId("4");
            player4List.add(c);
        }
        
        
        ArrayList<Integer> remainingCards = new ArrayList<>();

//Adding remaining cards to remainingCards list        
        remainingCards.addAll(allSpadeCards);
        remainingCards.addAll(nonSpadeFaceCards);
        remainingCards.addAll(nonSpadeNumberCards);

//Shuffling the remainingCardsList using Collections        
        Collections.shuffle(remainingCards);
       

//Assigning player 1 with a total of 13 random cards        
        while(!remainingCards.isEmpty()){
            if(player1List.size()!=13){
                c = cardsList.get(remainingCards.remove(0));
                c.setPlayerId("1");
                player1List.add(c);
            }
            else{
                break;
            }
        }
        
//Assigning player 2 with a total of 13 random cards          
        while(!remainingCards.isEmpty()){
            if(player2List.size()!=13){
                c = cardsList.get(remainingCards.remove(0));
                c.setPlayerId("2");
                player2List.add(c);
            }
            else{
                break;
            }
        }

//Assigning player 3 with a total of 13 random cards  
        while(!remainingCards.isEmpty()){
            if(player3List.size()!=13){
                c = cardsList.get(remainingCards.remove(0));
                c.setPlayerId("3");
                player3List.add(c);
            }
            else{
                break;
            }
        }

//Assigning player 4 with a total of 13 random cards          
        while(!remainingCards.isEmpty()){
            if(player4List.size()!=13){
                c = cardsList.get(remainingCards.remove(0));
                c.setPlayerId("4");
                player4List.add(c);
            }
            else{
                break;
            }
        }
        
        Collections.sort(player1List);
        Collections.sort(player2List);
        Collections.sort(player3List);
        Collections.sort(player4List);
        
        
        ccl.setPlayer1List(player1List);
        ccl.setPlayer2List(player2List);
        ccl.setPlayer3List(player3List);
        ccl.setPlayer4List(player4List);
        

        return ccl;
        
    }
    
    public void PlayerListCards(ArrayList<Card> cardsList){
//        String s= "";
        
        CreateCardsList ccl = CardsDistribution.getInstance().CardsDistributionLogic(cardsList);

        GamePlayer p1 = new GamePlayer("",ccl.getPlayer1List());
        GamePlayer p2 = new GamePlayer("",ccl.getPlayer2List());
        GamePlayer p3 = new GamePlayer("",ccl.getPlayer3List());
        GamePlayer p4 = new GamePlayer("",ccl.getPlayer4List());

        alp.add(p1);
        alp.add(p2);
        alp.add(p3);
        alp.add(p4);
    }
}

