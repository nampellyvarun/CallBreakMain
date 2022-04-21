/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.gameencoders;

import com.project.callbreak.info.Card;
import com.project.callbreak.info.GamePlayer;
import com.project.callbreak.info.Player;
import java.util.ArrayList;
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
    
    public String buildLoginAck(String status){
        
        return "loginA#"+status;
        
    }
    public String buildPlayerCards(String userId, GamePlayer gPlayer){
        
        StringBuilder s = new StringBuilder();
        Iterator<Card> iter = gPlayer.getPlayerCards().iterator();
        Card c = iter.next();
        s.append(c.getSuit()).append(c.getCardNumber());
        while(iter.hasNext()){
            
            c = iter.next();
            s.append(",").append(c.getSuit()).append(c.getCardNumber());
            
        }
        s.append("$").append(userId).append(":").append(gPlayer.getBid()).append(":").append(gPlayer.getTricksWon()).append(":");
        s.append(gPlayer.getRoundScore()).append(":").append(gPlayer.getTotalScore());
        System.out.println("playerCards and details protocol to client: "+s);
        return "cd#"+s.toString();
    }
    
    public String buildCFS(HashMap<String,Player> hm,ArrayList<Card> seating){
      StringBuilder sb = new StringBuilder();
      int i=0;
      Iterator hmIterator = hm.entrySet().iterator();
      while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            sb.append(mapElement.getKey()).append(":").append(seating.get(i)).append(i++);
      }
      System.out.println(sb.toString());
      return sb.toString();
   }
    
}
