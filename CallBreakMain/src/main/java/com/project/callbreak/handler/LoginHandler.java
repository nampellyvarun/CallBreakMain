/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Player;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.nio.HandlerInterface;
import com.project.callbreak.server.impl.AppContext;
import com.project.callbreak.timer.StartGameTimer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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
    
        StringTokenizer st1 = new StringTokenizer(string,",");
        String userID = st1.nextToken();
        String pwd = st1.nextToken();
        FileReader fr = null;
        int x = 0;
        String s="";
        try {
            File f = new File("Details.txt");
            fr = new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            String line;
            try {
                while((line=br.readLine())!=null)
                {
                    StringTokenizer st2 = new StringTokenizer(line,",");
                    String userid = st2.nextToken();
                    String pass = st2.nextToken();
                    System.out.println("");
                    System.out.println("From server - Userid: "+userid+" password: "+pass);
                    System.out.println("From client - Userid: "+userID+" password: "+pwd);
                    if(userID.equals(userid)){
                        if(pwd.equals(pass)){
                            x=1;
                            userCount+=1;
                            player.setStatus("100");
                            player.setUserId(userID);
                            s = GameEncoder.getInstance().buildLoginAck("100");
                            break;
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
                fr.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
        if(x==1){
            System.out.println("Valid");
            player.setStatus("100");
            s = GameEncoder.getInstance().buildLoginAck("100");
            player.setUserId(userID);
            System.out.println("Ak status: "+s);
        }
        else{
            System.out.println("Invalid");
            player.setStatus("111");
            s = GameEncoder.getInstance().buildLoginAck("111");
            System.out.println("Ak status: "+s);
            }
        
        try {
            SendMessage.getInstance().send(player, s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SendMessage.getInstance().send(player, s);
        if(userCount==4){
            StartGameTimer sgt = new StartGameTimer();
            String s1 = "sTime#5";
            HashMap<String,Player> hm=AppContext.getInstance().getPlayerCollection();
            Iterator hmIterator = hm.entrySet().iterator();
            while (hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)hmIterator.next();
                SendMessage.getInstance().send((Player) mapElement.getValue(), s1);
            }
            sgt.start();
        }
     return null;   
    }

   
}
    

