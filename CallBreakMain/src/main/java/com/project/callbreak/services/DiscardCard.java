package com.project.callbreak.services;

import com.project.callbreak.info.GamePlayer;

public class DiscardCard {
    GamePlayer ActivePlayer;

    public DiscardCard(GamePlayer ActivePlayer) {
        super();
        this.ActivePlayer=ActivePlayer;
        // TODO Auto-generated constructor stub
        
    }
    public  boolean acknowledge()
    {
        return true;
    }

}