/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.server.impl;

import com.project.callbreak.handler.BidHandler;
import com.project.callbreak.handler.LoginHandler;
import com.project.callbreak.handler.TrickCardHandler;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.Player;
import com.project.callbreak.info.Table;
import java.util.HashMap;
import com.project.callbreak.nio.HandlerInterface;
import java.util.ArrayList;
import java.util.LinkedHashMap;
/**
 *
 * @author srivarun
 */
public class AppContext {
    private static AppContext instance = null;
    public static AppContext getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new AppContext() : instance;
            }
        }
        return instance;
    }
    ArrayList<Card> trickList = new ArrayList<>();
    
    public void addCard(Card card){
        trickList.add(card);
    }

    public ArrayList<Card> getTrickList() {
        return trickList;
    }

    public void setTrickList(ArrayList<Card> trickList) {
        this.trickList = trickList;
    }
    
    
    LinkedHashMap<String,Table> tableCollection = new LinkedHashMap<>();

    public LinkedHashMap<String, Table> getTableCollection() {
        return tableCollection;
    }

    public void setTableCollection(LinkedHashMap<String, Table> tableCollection) {
        this.tableCollection = tableCollection;
    }
    
    public Table getTableByTableId(String tableId){
        return tableCollection.get(tableId);
    }
    
    public void addTable(String tableId,Table table){
        tableCollection.put(tableId,table);
    }
    
    
    HashMap<String,Player> playerCollection = new HashMap<>();

    public HashMap<String, Player> getPlayerCollection() {
        return playerCollection;
    }

    public void setPlayerCollection(HashMap<String, Player> playerCollection) {
        this.playerCollection = playerCollection;
    }

    public Player getPlayerByUserId(String userId) {
        return playerCollection.get(userId);
    }

    public void addPlayer(String userId,Player player) {
        playerCollection.put(userId, player);
    }
    
   HashMap<String,HandlerInterface> mapHandler = new HashMap<>(); 


    public HashMap<String, HandlerInterface> getMapHandler() {
        return mapHandler;
    }

    public void setMapHandler(HashMap<String, HandlerInterface> mapHandler) {
        this.mapHandler = mapHandler;
    }
    
    public void loadMapHandlers(){
        
        LoginHandler loginHandler = new LoginHandler();
        mapHandler.put("login",loginHandler);
        
        BidHandler bidHandler = new BidHandler();
        mapHandler.put("bid", bidHandler);
        
        TrickCardHandler trickCardHandler = new TrickCardHandler();
        mapHandler.put("trickCard",trickCardHandler);
    }

}
