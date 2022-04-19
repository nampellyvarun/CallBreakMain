/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.gameencoders;



/**
 *
 * @author srivarun
 */
public class GameEncoder {
    private static GameEncoder instance = null;
    public static GameEncoder getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new GameEncoder() : instance;
            }
        }
        return instance;
    }
    public String buildLoginAck(String status){
        return "loginA#"+status;
        
    }
}
