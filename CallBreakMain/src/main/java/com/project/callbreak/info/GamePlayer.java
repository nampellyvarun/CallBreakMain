/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.info;

import java.util.ArrayList;

/**
 *
 * @author srivarun
 */
public class GamePlayer {
    private String playerId;
    private ArrayList<Card> playerCards;
    private int tricksWon;
    private int bid;
    private float roundScore;
    private float totalScore;
    

    public GamePlayer(String playerId, ArrayList<Card> playerCards, int tricksWon, int bid, float roundScore,float totalScore) {
        this.playerId = playerId;
        this.playerCards = playerCards;
        this.tricksWon = tricksWon;
        this.bid = bid;
        this.roundScore = roundScore;
        this.totalScore= totalScore;
    }

    public GamePlayer(String playerId, ArrayList<Card> playerCards) {
        this.playerId = playerId;
        this.playerCards = playerCards;
    }
    
    

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public int getTricksWon() {
        return tricksWon;
    }

    public void setTricksWon(int tricksWon) {
        this.tricksWon = tricksWon;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public float getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(float roundScore) {
        this.roundScore = roundScore;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(float totalScore) {
        this.totalScore = totalScore;
    }
    

    @Override
    public String toString() {
        String s="";
        for(Card c : playerCards){
            s=s+c.getPlayerId();
            s=s+":";
            s=s+c.getCardNumber();
            s=s+":";
            s=s+c.getSuit();
            s=s+".";
        }
        return playerId+","+tricksWon+","+bid+","+roundScore+","+totalScore+","+s;
    }



}
