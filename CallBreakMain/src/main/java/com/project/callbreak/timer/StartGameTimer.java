/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.timer;

import com.project.callbreak.info.GenerateCards;
import com.project.callbreak.info.Table;
import com.project.callbreak.protocols.CDProtocol;
import com.project.callbreak.protocols.CFSProtocol;
import com.project.callbreak.server.impl.AppContext;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;

/**
 *
 * @author abhirajd
 */
public class StartGameTimer extends Thread{
    static Timer timer;
    //private int userCount;
    int counter=0;          
    @Override
            public void run() {
                
                
                while (true) {
                    try {
                        System.out.println("timer countdown: " + ++counter);
                        if (counter == 5) {
                            System.out.println("time has reached 5 now the game starts");
                            //timer.cancel();//end the timer
                            break;//end this loop
                        }
                        Thread.sleep(1000);
                        
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }    
                }
 
            }
 }