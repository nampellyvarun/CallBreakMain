/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.gameencoders;

import com.project.callbreak.info.Card;
import com.project.callbreak.info.Chair;
import com.project.callbreak.info.GamePlayer;
import com.project.callbreak.info.Player;
import com.project.callbreak.info.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



/**
 *
 * @author srivarun
 */
public class GameEncoder {
    private static GameEncoder instance = null;
    public static GameEncoder getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new GameEncoder() : instance;
            }
        }
        return instance;
    }
    
    static int i=0;
    
    public String buildLoginAck(String status){
        
        return "loginA#"+status;
        
    }
    public String buildPlayerCards(String tableId, int round, GamePlayer gamePlayer){
        
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Card> iter = gamePlayer.getPlayerCards().iterator();
        Card c = iter.next();
        
        stringBuilder.append(tableId).append(",").append(round).append(",").append(c.getSuit()).append("@").append(c.getCardNumber());
        while(iter.hasNext()){
            
            c = iter.next();
            stringBuilder.append(":").append(c.getSuit()).append("@").append(c.getCardNumber());
            
        }
        stringBuilder.append(",").append(gamePlayer.getPlayerId()).append(",").append(gamePlayer.getBid()).append(",").append(gamePlayer.getTricksWon()).append(",");
        stringBuilder.append(gamePlayer.getRoundScore()).append(",").append(gamePlayer.getTotalScore());
        System.out.println("playerCards and details protocol to client: "+stringBuilder.toString());
        return "cd#"+stringBuilder.toString();
    }
    
    public String buildCFS(HashMap<String,Player> playerCollection,ArrayList<Card> seating){
        
        StringBuilder stringBuilder = new StringBuilder();
        int j=0;
        ArrayList<String> playerIdList = new ArrayList<>();
        Iterator playerCollectionIterator = playerCollection.entrySet().iterator();
        while (playerCollectionIterator.hasNext()) {
              Map.Entry mapElement = (Map.Entry)playerCollectionIterator.next();
              playerIdList.add((String)mapElement.getKey());
        }
        Collections.shuffle(playerIdList);
        for(String playerId : playerIdList){
              seating.get(j).setPlayerId(playerId);
              stringBuilder.append(playerId).append(":").append(seating.get(j).getSuit()).append(":").append(seating.get(j).getCardNumber()).append(":").append(++j).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return "cfs#"+stringBuilder.toString();
   }
    
    public String buildPosition(Chair chair){
        
        StringBuilder stringBuilder = new StringBuilder();
        GamePlayer gamePlayer = chair.getGamePlayer();
        String playerId = gamePlayer.getPlayerId();
        stringBuilder.append(playerId).append(",").append(++i);
        if(i==4){
            i=0;
        }
        return "position#"+stringBuilder.toString();
        
    }
    
    public String buildTrickWinner(String winnerId, Table table){
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winnerId).append("@");
        ArrayList<Chair> chairList = table.getChairs();
        for( Chair chair : chairList)
        {
            GamePlayer gamePlayer = chair.getGamePlayer();
            if(winnerId.equals(gamePlayer.getPlayerId()))
            {
                int tricksWon = gamePlayer.getTricksWon();
                gamePlayer.setTricksWon(tricksWon+1);
            }
            stringBuilder.append(gamePlayer.getPlayerId()).append(":").append(gamePlayer.getTricksWon()).append(",");    

        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return "trickWinner#" + stringBuilder.toString();
        
    }
    
    public String buildScoreCard(Table table){
        
        ArrayList<Chair> chairList = table.getChairs();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(table.getTableId()).append("@");
        for(Chair chair : chairList){
            GamePlayer gamePlayer = chair.getGamePlayer();
            stringBuilder.append(gamePlayer.getRoundScore()).append(":").append(gamePlayer.getTotalScore()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        
        return "scoreCard#"+stringBuilder.toString();
        
    } 
    
    public String buildCard(String tableId,Card card){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tableId).append(",").append(card.getPlayerId()).append(",").append(card.getSuit()).append(",").append(card.getCardNumber());
        return "trickCard#"+stringBuilder.toString();
    }
    
}
