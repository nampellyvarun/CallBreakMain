package com.project.callbreak.server.impl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.project.callbreak.nio.CBInitializer;
import com.project.callbreak.nio.CBProtocolExecutor;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.HashedWheelTimerCust;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Amar Pratap, Yellaiah This class takes care initialization of lobby
 * server and make available to accept connection on specified port number. Also
 * initialize intercommunication(RMI registry)
 */
public class CBServer extends Server{

    private static CBServer cbServer = null;

    public ConcurrentMap<String, Integer> connectedSet = new ConcurrentHashMap<String, Integer>();

    public ConcurrentMap<String, Integer> getConnectedSet() {
        return connectedSet;
    }

    public void setConnectedSet(ConcurrentMap<String, Integer> connectedSet) {
        this.connectedSet = connectedSet;
    }

    public static CBServer getInstance() {
        if (null == cbServer) {
            cbServer = new CBServer();
        }
        return cbServer;
    }
    
    




    public String serverResponse()throws Exception{
        
        
//        ServerSocket ss=new ServerSocket(3335);
//        Socket s=ss.accept();
//        DataInputStream din=new DataInputStream(s.getInputStream());
//
//        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
//
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//
//
//        String str1="",str2="";
//        while(!str1.equals("stop")){
//        str1=din.readUTF();
//        //ChannelHandlerContext ctx = new ChannelHandlerContext() {};
//        //CBProtocolExecutor cbpe = new CBProtocolExecutor(str1,ctx);
////        System.out.println("client 1 says: "+str1);
//
//        System.out.print("server wants to say: "); 
//
//        str2=br.readLine();
//        dout.writeUTF(str2);
//
//        dout.flush();
//
//        }
//        din.close();
//
//        s.close();
//
//        ss.close();
        
        
        return null;
    

}


    @Override
    public void start(String args[]) {
        try {
            /* 
             * Initialise the server with server master details from the
             * database
             */
            //System.out.println("lobby webscoket started- yellaiah1");
            this.initialize();
            // System.out.println("lobby webscoket started- yellaiah11");
            //starting the Lobbywebsocket server
            //System.out.println("lobby webscoket started- yellaiah2");
            HashedWheelTimerCust timer = new HashedWheelTimerCust();
            super.createListner(new CBInitializer(timer));
            
            ApplicationContext.getInstance().loadMapHandlers();
            
            

        } catch (Exception ex) {
            System.out.println("Error while staring the server" + ex);
        }
    }

    @Override
    protected void initialize() throws Exception {

        try {
            super.initialize();
            /*
            Issue occured date :- 03 May 2018
            Issue :- Lobby server not getting started.
            Resolution :- Added 1 second sleep between these threads as we are facing issues with Loggers creation
            if both the threads are executed simultaneoulsy and Lobby server is getting hanged because of this.
            Also whenever a new thread is added add sleep accordingly if two threads are simulataneous.
             */
            System.out.println("LOBBY SERVER INITIALIZE - end");
        } catch (Exception e) {
            System.out.println("Exception at rmi " + e);
        }
    }

}