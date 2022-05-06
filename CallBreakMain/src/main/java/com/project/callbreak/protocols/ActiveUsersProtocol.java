package com.project.callbreak.protocols;

import com.project.callbreak.info.GamePlayer;
import com.project.callbreak.services.DiscardCard;
import com.project.callbreak.services.LinkedListPlayers;
import com.project.callbreak.services.LinkedListPlayers.Node;
import java.util.ArrayList;


public class ActiveUsersProtocol {
    
    ArrayList<GamePlayer> GamePlayers=new ArrayList<>();
    LinkedListPlayers playersList=new LinkedListPlayers();
    GamePlayer firstPlayer;
    
    public ActiveUsersProtocol(ArrayList<GamePlayer> gamePlayers) {
        super();
        this.GamePlayers = gamePlayers;
        
    }
    public void Calculate()
    {
        for(GamePlayer player: GamePlayers)
        {
            playersList.add(player, 0);
        }
        Node firstPlayer = playersList.returnList();
        Node temp=firstPlayer;
    
        for(int i=0;i<13;i++)
        {
            while(temp!=null && temp.flag!=1)
            {
                DiscardCard Discard = new DiscardCard(temp.player);
                boolean discard_ack=Discard.acknowledge();
                if(discard_ack==true)
                {
                    temp.flag=1;
                    temp=temp.next;
                }    
            }
            playersList.display();
            
            if(temp.flag==1 && temp!=null)
            {
                temp=firstPlayer;
                while(temp.next!=null&&temp.flag==1 )
                {

                    //call trickWinner Protocol
                    temp.flag=0;
                    temp=temp.next;
                }

                playersList.display();
            }


        }    
    }}