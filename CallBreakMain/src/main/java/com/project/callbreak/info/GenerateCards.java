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
        
        ArrayList<Card> cl = new ArrayList<>();
    
        cl.add(new Card(14,'s',false));
        cl.add(new Card(13,'s',true));
        cl.add(new Card(12,'s',true));
        cl.add(new Card(11,'s',true));
        cl.add(new Card(10,'s',false));
        cl.add(new Card(9,'s',false));
        cl.add(new Card(8,'s',false));
        cl.add(new Card(7,'s',false));
        cl.add(new Card(6,'s',false));
        cl.add(new Card(5,'s',false));
        cl.add(new Card(4,'s',false));
        cl.add(new Card(3,'s',false));
        cl.add(new Card(2,'s',false));
    
        cl.add(new Card(14,'h',false));
        cl.add(new Card(13,'h',true));
        cl.add(new Card(12,'h',true));
        cl.add(new Card(11,'h',true));
        cl.add(new Card(10,'h',false));
        cl.add(new Card(9,'h',false));
        cl.add(new Card(8,'h',false));
        cl.add(new Card(7,'h',false));
        cl.add(new Card(6,'h',false));
        cl.add(new Card(5,'h',false));
        cl.add(new Card(4,'h',false));
        cl.add(new Card(3,'h',false));
        cl.add(new Card(2,'h',false));
        
        cl.add(new Card(14,'d',false));
        cl.add(new Card(13,'d',true));
        cl.add(new Card(12,'d',true));
        cl.add(new Card(11,'d',true));
        cl.add(new Card(10,'d',false));
        cl.add(new Card(9,'d',false));
        cl.add(new Card(8,'d',false));
        cl.add(new Card(7,'d',false));
        cl.add(new Card(6,'d',false));
        cl.add(new Card(5,'d',false));
        cl.add(new Card(4,'d',false));
        cl.add(new Card(3,'d',false));
        cl.add(new Card(2,'d',false));
        
        cl.add(new Card(14,'c',false));
        cl.add(new Card(13,'c',true));
        cl.add(new Card(12,'c',true));
        cl.add(new Card(11,'c',true));
        cl.add(new Card(10,'c',false));
        cl.add(new Card(9,'c',false));
        cl.add(new Card(8,'c',false));
        cl.add(new Card(7,'c',false));
        cl.add(new Card(6,'c',false));
        cl.add(new Card(5,'c',false));
        cl.add(new Card(4,'c',false));
        cl.add(new Card(3,'c',false));
        cl.add(new Card(2,'c',false));
        
        return cl;
    } 
    
    public ArrayList generateCardNumberList(){
        ArrayList<Integer> cnl = new ArrayList<>();
        for(int i=0;i<52;i++){
            cnl.add(i);
        }
        return cnl;
    }
    
    public ArrayList<Integer> cardNumberList = generateCardNumberList();
    
    public ArrayList<Card> cardsList = createCards();
    
}
