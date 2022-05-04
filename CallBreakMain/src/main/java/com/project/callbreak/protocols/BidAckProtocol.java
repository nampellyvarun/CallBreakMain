/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Chair;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;
import java.util.ArrayList;

/**
 *
 * @author srivarun
 */
public class BidAckProtocol {
    public void bidAckProtocol(String userId,Table table,int bid){
        String string = GameEncoder.getInstance().buildBidAck(userId,bid);
        ArrayList<Chair> chairList = table.getChairs();
        SendMessage.getInstance().sendMessageToOtherPlayers(userId, string, table);
    }   
    
}
