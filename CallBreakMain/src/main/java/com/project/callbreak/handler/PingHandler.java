/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.info.Player;
import com.project.callbreak.nio.HandlerInterface;

/**
 *
 * @author abhirajd
 */
public class PingHandler implements HandlerInterface{

    @Override
    public String handle(String string, Player player) {
        System.out.println("Ping Handler Called");
        return null;
        
    }
    
}