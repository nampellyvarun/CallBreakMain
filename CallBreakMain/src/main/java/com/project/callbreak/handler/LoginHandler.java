/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.*;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.nio.HandlerInterface;
import com.project.callbreak.server.impl.AppContext;
import com.project.callbreak.timer.StartGameTimer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
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
                    System.out.println("From server - Userid: "+userid+" password: "+pass);
                    System.out.println("From client - Userid: "+userID+" password: "+pwd);
                    if(userID.equals(userid)){
                        if(pwd.equals(pass)){
                            if(AppContext.getInstance().getTableCollection().isEmpty()){
                                LinkedHashMap<String,Table> tableCollection = new LinkedHashMap<>();
                                AppContext.getInstance().setTableCollection(tableCollection);
                                Table table = new Table();
                                table.setTableId();
                                String tableId = table.getTableId();
                                x=1;
                                userCount+=1;
                                player.setStatus("100");
                                player.setUserId(userID);
                                stringStatus = GameEncoder.getInstance().buildLoginAck("100");
                                
                                GamePlayer gamePlayer = new GamePlayer();

                                table.addChair(gamePlayer);
                                if(table.getChairs().size()!=4){
                                    ArrayList<Chair> alChair = table.getChairs();
                                    AppContext.getInstance().addTable(tableId, table);
                                }
                                
                                break;
                            }
                            else{
                                
                                LinkedHashMap<String,Table> tableCollection = AppContext.getInstance().getTableCollection();
                                Table table = tableCollection.get(tableCollection.size()-1);
                                if(table.getChairs().size()==4){
                                    ArrayList<Chair> alChair = table.getChairs();
                                    AppContext.getInstance().addTable(tableId, table);
                                }
                                
                            }
                        }
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
            SendMessage.getInstance().send(player, stringStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SendMessage.getInstance().send(player, stringStatus);
        
        
        if(userCount==4){
            StartGameTimer startGameTimer = new StartGameTimer();
            String stringStart = "sTime#5";
            HashMap<String,Player> hm=AppContext.getInstance().getPlayerCollection();
            Iterator hmIterator = hm.entrySet().iterator();
            while (hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)hmIterator.next();
                SendMessage.getInstance().send((Player) mapElement.getValue(), stringStart);
            }
            startGameTimer.start();
            
        }
     return null;   
    }

   
}
    

