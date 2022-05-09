/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.Player;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.server.impl.AppContext;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author abhirajd
 */
public class ActiveUsersProtocol {
    public void activeUsers(Table table,String playerId){
        String string = GameEncoder.getInstance().buildActiveUser();
        Player player= AppContext.getInstance().getPlayerByUserId(playerId);
        SendMessage.getInstance().send(string,player);
       
        
    }
}
