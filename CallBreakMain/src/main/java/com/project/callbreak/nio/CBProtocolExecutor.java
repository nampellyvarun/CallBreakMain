/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.callbreak.nio;

import com.project.callbreak.info.Player;
import com.project.callbreak.nio.impl.NioConnection;
import com.project.callbreak.server.impl.AppContext;
import io.netty.channel.ChannelHandlerContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;
import jdk.nashorn.internal.ir.Statement;

/**
 *
 * @author hithendra
 */
public class CBProtocolExecutor {
    
    private static CBProtocolExecutor instance = null;
    public static CBProtocolExecutor getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                instance = instance == null ? new CBProtocolExecutor() : instance;
            }
        }
        return instance;
    }

    public void executeProtocol(String buffer, ChannelHandlerContext ctx) {
        
        buffer = buffer.trim();
        System.out.println("protocol from client : "+buffer);
        StringTokenizer st = new StringTokenizer(buffer,"#");
        String protocol = st.nextToken();
        String details = st.nextToken();
        
        HandlerInterface handlerInterface = AppContext.getInstance().getMapHandler().get(protocol);
        
        
        String attachUserId = (String) ctx.attr(NIOConstants.ATTACHMENT).get();
        if (attachUserId == null){
            System.out.println("attachUserId is null");
            
            if(buffer.startsWith("login#")){    
//                Connection conn = null;
//                try {
//                    String url = "jdbc:mysql://10.0.21.66:3305/swaroop_gadusu\n" +"";
//                    conn = DriverManager.getConnection(url);
//                    System.out.println("Connected to database!");
//                    PreparedStatement ps1,ps2;
//                    ps1 = conn.prepareStatement("select count(*) from callbreak where username = ? and password=?");
//                    ps2 = conn.prepareStatement("select * from callbreak");
//                    
//                } catch (SQLException e) {
//                    throw new Error("Problem", e);
//                } finally {
//                  try {
//                    if (conn != null) {
//                        conn.close();
//                    }
//                  } catch (SQLException ex) {
//                      System.out.println(ex.getMessage());
//                  }
//                }
                
                StringTokenizer st1 = new StringTokenizer(details,",");
                String s= st1.nextToken();     
                //System.out.println("UserId after split: "+s);
                ctx.attr(NIOConstants.ATTACHMENT).set(s);
                attachUserId=s;
                Player player = new Player();
                player.setUserId(s);
                NioConnection nioConnectionInt = new NioConnection();
                
                if (ctx != null) {
                    nioConnectionInt.setChannel(ctx.channel());
                    nioConnectionInt.setChannelContext(ctx);
                    nioConnectionInt.setProtocol(ctx.attr(NIOConstants.PROTOCOL).get());
                    player.setNci(nioConnectionInt);
                    AppContext.getInstance().addPlayer(s, player);
                    
                }
                
            }
        }
        //System.out.println("attachUserId: "+(String) ctx.attr(NIOConstants.ATTACHMENT).get());
        Player player = AppContext.getInstance().getPlayerByUserId(attachUserId);
        
        if(handlerInterface != null){
            handlerInterface.handle(details,player);
        }
        else{
            System.out.println("Handler not found");
        }
            
    }         
}

