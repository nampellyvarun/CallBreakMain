/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.*;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.nio.HandlerInterface;
import com.project.callbreak.protocols.PositionProtocol;
import com.project.callbreak.server.impl.AppContext;
import com.project.callbreak.timer.StartGameTimer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/**
 *
 * @author srivarun
 */

public class LoginHandler implements HandlerInterface{
    private static LoginHandler instance = null;
    public static LoginHandler getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new LoginHandler() : instance;
            }
        }
        return instance;
    }
    
    public int userCount = 0;
    @Override
    public String handle(String string,Player player) {
        System.out.println("Login handler parameters "+string+" "+player.toString());
        string = string.trim();
        
        StringTokenizer stringTokenizer = new StringTokenizer(string,",");
        String userID = stringTokenizer.nextToken();
        String pwd = stringTokenizer.nextToken();
        FileReader fileReader = null;
        int x = 0;
        String stringStatus="";
        try {
            File file = new File("Details.txt");
            fileReader = new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            try {
                while((line=bufferedReader.readLine())!=null)
                {
                    StringTokenizer st2 = new StringTokenizer(line,",");
                    String userid = st2.nextToken();
                    String pass = st2.nextToken();
                    System.out.println("");
                    
                    if(userID.equals(userid) && pwd.equals(pass)){
//                        System.out.println("From server - Userid: "+userid+" password: "+pass);
//                        System.out.println("From client - Userid: "+userID+" password: "+pwd);
                        x=1;
                        userCount++;
                        player.setStatus("100");
                        stringStatus = GameEncoder.getInstance().buildLoginAck("100");
                        if(AppContext.getInstance().getTableCollection().isEmpty()){
                            LinkedHashMap<String,Table> tableCollection = new LinkedHashMap<>();
                            AppContext.getInstance().setTableCollection(tableCollection);
                            Table table = new Table();
                            table.setTableId();
                            String tableId=table.getTableId();
                            GamePlayer gamePlayer = new GamePlayer(player.getUserId());
                            table.addChair(gamePlayer);
                            table.setStatus("registering");
                            AppContext.getInstance().addTable(tableId, table);
                            System.out.println("Table1: 1st player joined the game"+gamePlayer.getPlayerId());
 
                        }
                        else{
                            Table table  = AppContext.getInstance().getLatestTable();
                            if(table.getStatus().equals("registering")){
                                GamePlayer gamePlayer = new GamePlayer(player.getUserId());
                                System.out.println("GamePlayerid :"+gamePlayer.getPlayerId());
                                table.addChair(gamePlayer);
                                System.out.println("Table1: other players joining the game"+gamePlayer.getPlayerId());
                                if(table.getChairs().size()==4){
                                    String tableId = table.getTableId();
                                    System.out.println("Table ready to start");
                                    ArrayList<Chair> chairList = table.getChairs();
                                    for(Chair chair : chairList){
                                        chair.getPlayer().setTableId(tableId);
                                    }
                                    table.setStatus("full");
                                }
                            }
                            else{
                                Table table1 = new Table();
                                table1.setTableId();
                                String tableId = table1.getTableId();
                                GamePlayer gamePlayer = new GamePlayer(player.getUserId());
                                System.out.println(gamePlayer.getPlayerId());
                                table1.addChair(gamePlayer);
                                AppContext.getInstance().addTable(tableId, table1);
                            }
                        }    
                        break;            
                    }  
                }
            } catch (IOException ex) {
                System.out.println(ex);
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
        if(x==1){
            System.out.println("Valid");
            player.setStatus("100");
            stringStatus = GameEncoder.getInstance().buildLoginAck("100");
            player.setUserId(userID);
            System.out.println("Ak status: "+stringStatus); 
        }
        else{
            System.out.println("Invalid");
            player.setStatus("111");
            stringStatus = GameEncoder.getInstance().buildLoginAck("111");
            System.out.println("Ak status: "+stringStatus);
        }
        try {
            SendMessage.getInstance().send(stringStatus,player);
            Table table  = AppContext.getInstance().getLatestTable();
            PositionProtocol positionProtocol = new PositionProtocol();
            positionProtocol.playerPositions(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        stringStatus = "";
        
        if(AppContext.getInstance().getLatestTable().getChairs().size() ==4){
            Table table = AppContext.getInstance().getLatestTable();
            StartGameTimer startGameTimer = new StartGameTimer();
            String stringStart = "sTime#5";
            SendMessage.getInstance().sendMessageToTablePlayers(stringStart, table);
            System.out.println();
            startGameTimer.start();
            System.out.println("Waited for 5 sec successfully");
        }
//        if(userCount%4==0 ){
//            StartGameTimer startGameTimer = new StartGameTimer();
//            String stringStart = "sTime#5";
//            Table table  = AppContext.getInstance().getLatestTable();
//            SendMessage.getInstance().sendMessageToTablePlayers(stringStart, table);
//            System.out.println();
//            startGameTimer.start();
//            System.out.println("Waited for 5 sec successfully");
//        }
        return null;   
    }

   
}
    

