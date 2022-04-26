/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Card;
import com.project.callbreak.info.Chair;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.server.impl.AppContext;
import java.util.ArrayList;

/**
 *
 * @author srivarun
 */
public class TrickProtocol {
    public void trickCardProtocol(String tableId,Card card){
        String string = GameEncoder.getInstance().buildCard(tableId,card);
        Table table = AppContext.getInstance().getTableByTableId(tableId);
        ArrayList<Chair> chairList = table.getChairs();
        for(Chair chair : chairList){
            SendMessage.getInstance().send(string, chair.getPlayer());
        }
    }
}
