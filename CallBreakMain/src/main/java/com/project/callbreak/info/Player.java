/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.info;

import com.project.callbreak.nio.api.NioConnectionInt;

/**
 *
 * @author srivarun
 */
public class Player {
    private String userId;
    private String status;
    private NioConnectionInt nci;

    public Player(String userId, String status, NioConnectionInt nci) {
        this.userId = userId;
        this.status = status;
        this.nci = nci;
    }

    public Player() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NioConnectionInt getNci() {
        return nci;
    }

    public void setNci(NioConnectionInt nci) {
        this.nci = nci;
    }
    
}
