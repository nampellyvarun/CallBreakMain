/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.info;

/**
 *
 * @author srivarun
 */

import java.util.ArrayList;
import java.util.Random;


public class Table {
    
    private ArrayList<Chair> alChairs = new ArrayList<>();
    private String tableId;
    private String status = null;
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addChair(GamePlayer gamePlayer)
    {
            Chair c = new Chair();
            c.setGamePlayer(gamePlayer);
            alChairs.add(c);
    }
    
    public ArrayList<Chair> getChairs(){
        return alChairs;
    }

    public String getTableId() {
        return tableId;
    }
    
    public void setTableId() {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 5;
            Random random = new Random();
            StringBuilder sb = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int) 
                  (random.nextFloat() * (rightLimit - leftLimit + 1));
                sb.append((char) randomLimitedInt);
            }
            this.tableId = sb.toString();
    }
}