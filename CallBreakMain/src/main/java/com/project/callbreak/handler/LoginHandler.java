/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.callbreak.handler;

import com.project.callbreak.gameencoders.GameEncoder;
import com.project.callbreak.info.Player;
import com.project.callbreak.messagesender.SendMessage;
import com.project.callbreak.nio.HandlerInterface;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author srivarun
 */

public class LoginHandler implements HandlerInterface{

    public int userCount = 0;
    Player p = new Player();
    
    @Override
    public String handle(String string,Player player) {
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
                    if(userID.equals(st2.nextToken())){
                        if(pwd.equals(st2.nextToken())){
                            x=1;
                            userCount+=1;
                            player.setStatus("100");
                            s = GameEncoder.getInstance().buildLoginAck("100");
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
        }
        else{
            System.out.println("Invalid");
            player.setStatus("111");
            s = GameEncoder.getInstance().buildLoginAck("111");
            
            }
        
        SendMessage.getInstance().send(p, s);
     return null;   
    }

   
}
    

