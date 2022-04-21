/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.protocols;

/**
 *
 * @author srivarun
 */

import com.project.callbreak.info.Chair;
import com.project.callbreak.info.GamePlayer;
import com.project.callbreak.info.Table;
import java.util.ArrayList;

public class PositionProtocol {
    

    Table table=new Table();
    ArrayList<Chair> chairList=new ArrayList<>();
    public PositionProtocol(Table table) {
        super();
        this.table = table;
    }
    
    
    
    public String PlayerPositions()
    {
        chairList = table.getChairs();
        GamePlayer player;
        int ChairId;
        String protocol="Chairs#";
        StringBuilder playerPosition=new StringBuilder();
        playerPosition.append(protocol);
        int i = 0;
        int j;
        for( Chair a:chairList)
        {
            player=a.getGamePlayer();
            String posId=player.getPlayerId();

            playerPosition.append(posId);
            playerPosition.append(":");
            playerPosition.append(i);
            if(i<chairList.size()-1)
            {
                playerPosition.append(",");        
            }
            else
            {
                playerPosition.append(" ");
            }
            i++;
        }
        String postionString= playerPosition.toString();
        return postionString;
        }    
    
    

}