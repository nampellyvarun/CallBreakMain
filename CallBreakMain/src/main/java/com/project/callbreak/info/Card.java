/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.info;

import java.util.Objects;

/**
 *
 * @author srivarun
 */
public class Card implements Comparable<Card>{
    private int cardNumber;
    private char suit;
    private Boolean isFaceCard;
    int playerId;
    


    public Card(int cardNumber, char suit, Boolean isFaceCard) {
        this.cardNumber = cardNumber;
        this.suit = suit;
        this.isFaceCard = isFaceCard;
        this.playerId=0;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public Boolean getIsFaceCard() {
        return isFaceCard;
    }

    public void setIsFaceCard(Boolean isFaceCard) {
        this.isFaceCard = isFaceCard;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cardNumber);
        hash = 97 * hash + Objects.hashCode(this.suit);
        hash = 97 * hash + Objects.hashCode(this.isFaceCard);
        hash = 97 * hash + this.playerId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.playerId != other.playerId) {
            return false;
        }
        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }
        if (!Objects.equals(this.suit, other.suit)) {
            return false;
        }
        return Objects.equals(this.isFaceCard, other.isFaceCard);
    }

    @Override
    public String toString() {
        return "cardNumber=" + cardNumber + ",suit=" + suit + ",playerId=" + playerId;
    }



    @Override
    public int compareTo(Card t) {
        if((int)this.suit  < (int)t.suit){
            return 1;
        }
        else if((int)this.suit  > (int)t.suit){
            return -1;
        }
        else{
            if(this.cardNumber < t.cardNumber){
                return 1;
            }
            else{
                return -1;
            }
        }
    }

}

