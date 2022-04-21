/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.info;

/**
 *
 * @author srivarun
 */

public class Chair {
    private GamePlayer gamePlayer;
    private int chairId;
    private Player player;

    public Chair(){
        
    }
    
    public Chair(GamePlayer gamePlayer) {
        super();
        this.gamePlayer = gamePlayer;
    }
    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }
    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }
    public int getId() {
        return chairId;
    }
    public void setId(int chairId) {
        this.chairId = chairId;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

}
