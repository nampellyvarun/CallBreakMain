/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.messagesender;

import com.project.callbreak.info.Player;


/**
 *
 * @author srivarun
 */
public class SendMessage {
    private static SendMessage instance = null;
    public static SendMessage getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new SendMessage() : instance;
            }
        }
        return instance;
    }
    public void send(String string,Player player){
        //System.out.println(player.getNci());
        player.getNci().sendMessage(string);
    }
}
