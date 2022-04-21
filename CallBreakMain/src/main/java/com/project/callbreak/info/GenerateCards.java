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
public class GenerateCards {
    private static GenerateCards instance = null;
    public static GenerateCards getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new GenerateCards() : instance;
            }
        }
        return instance;
    }
    
    
    
    public ArrayList createCards(){
        
        ArrayList<Card> cardList = new ArrayList<>();
    
        cardList.add(new Card(14,'s',false));
        cardList.add(new Card(13,'s',true));
        cardList.add(new Card(12,'s',true));
        cardList.add(new Card(11,'s',true));
        cardList.add(new Card(10,'s',false));
        cardList.add(new Card(9,'s',false));
        cardList.add(new Card(8,'s',false));
        cardList.add(new Card(7,'s',false));
        cardList.add(new Card(6,'s',false));
        cardList.add(new Card(5,'s',false));
        cardList.add(new Card(4,'s',false));
        cardList.add(new Card(3,'s',false));
        cardList.add(new Card(2,'s',false));
    
        cardList.add(new Card(14,'h',false));
        cardList.add(new Card(13,'h',true));
        cardList.add(new Card(12,'h',true));
        cardList.add(new Card(11,'h',true));
        cardList.add(new Card(10,'h',false));
        cardList.add(new Card(9,'h',false));
        cardList.add(new Card(8,'h',false));
        cardList.add(new Card(7,'h',false));
        cardList.add(new Card(6,'h',false));
        cardList.add(new Card(5,'h',false));
        cardList.add(new Card(4,'h',false));
        cardList.add(new Card(3,'h',false));
        cardList.add(new Card(2,'h',false));
        
        cardList.add(new Card(14,'d',false));
        cardList.add(new Card(13,'d',true));
        cardList.add(new Card(12,'d',true));
        cardList.add(new Card(11,'d',true));
        cardList.add(new Card(10,'d',false));
        cardList.add(new Card(9,'d',false));
        cardList.add(new Card(8,'d',false));
        cardList.add(new Card(7,'d',false));
        cardList.add(new Card(6,'d',false));
        cardList.add(new Card(5,'d',false));
        cardList.add(new Card(4,'d',false));
        cardList.add(new Card(3,'d',false));
        cardList.add(new Card(2,'d',false));
        
        cardList.add(new Card(14,'c',false));
        cardList.add(new Card(13,'c',true));
        cardList.add(new Card(12,'c',true));
        cardList.add(new Card(11,'c',true));
        cardList.add(new Card(10,'c',false));
        cardList.add(new Card(9,'c',false));
        cardList.add(new Card(8,'c',false));
        cardList.add(new Card(7,'c',false));
        cardList.add(new Card(6,'c',false));
        cardList.add(new Card(5,'c',false));
        cardList.add(new Card(4,'c',false));
        cardList.add(new Card(3,'c',false));
        cardList.add(new Card(2,'c',false));
        
        return cardList;
    } 
    
    public ArrayList generateCardNumberList(){
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i=0;i<52;i++){
            numberList.add(i);
        }
        return numberList;
    }
    
    public ArrayList<Integer> cardNumberList = generateCardNumberList();
    
    public ArrayList<Card> cardList = createCards();
    
}
