/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.callbreak.nio;

import com.project.callbreak.info.Player;
import com.project.callbreak.nio.impl.NioConnection;
import com.project.callbreak.server.impl.ApplicationContext;
import io.netty.channel.ChannelHandlerContext;
import java.util.StringTokenizer;

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
        StringTokenizer st = new StringTokenizer(buffer,"#");
        String protocol = st.nextToken();
        String details = st.nextToken();
        
        HandlerInterface hi = ApplicationContext.getInstance().getMapHandler().get(protocol);
        
        
        String attachUserId = (String) ctx.attr(NIOConstants.ATTACHMENT).get();
        if (attachUserId == null){
            if(buffer.startsWith("login#")){
                StringTokenizer st1 = new StringTokenizer(buffer,",");
                String s= st1.nextToken();         
                ctx.attr(NIOConstants.ATTACHMENT).set(s);
                Player player = new Player();
                player.setUserId(s);
                NioConnection nioConnectionInt = new NioConnection();
                
                if (ctx != null) {
                    nioConnectionInt.setChannel(ctx.channel());
                    nioConnectionInt.setChannelContext(ctx);
                    nioConnectionInt.setProtocol(ctx.attr(NIOConstants.PROTOCOL).get());
                    player.setNci(nioConnectionInt);
                    ApplicationContext.getInstance().addPlayer(s, player);
                }
                
            }
            
        }
        Player player = ApplicationContext.getInstance().getPlayerByUserId(attachUserId);
        
        if(hi!=null){
            hi.handle(details,player);
        }








//        //LoginAuthentication la = new LoginAuthentication();
//        if("login".equals(protocol)){
//            
//            int x = la.UserAuthentication(details);
//            if(x==1){
//                System.out.print("valid");
//            }
//            else{
//                System.out.print("invalid");
//            }
//        }
//        if("start".equals(protocol)){
//            GenerateCards gCards = new GenerateCards();
//            if(la.userCount==4){
//                CutForSeat cfs = new CutForSeat();
//                String s1;
//                s1 = cfs.SeatArrangementCards(gCards.cardsList);
//            }
//            else{
//                String s = "Waiting";
//            }
//        }
//        
//    }
            
//            StringTokenizer st = new StringTokenizer(buffer,"#");
//            String s = st.nextToken();
//            s = st.nextToken();
//            StringTokenizer st1 = new StringTokenizer(,"#");
//            GenerateCards gCards = new GenerateCards();
//        
//            
//
//            LoginAuthentication la = new LoginAuthentication();
//            String s="1235,hello@123";
//            
//            int x = la.UserAuthentication(s);
//            if(x==1){
//                System.out.println("Valid user");
//            }
//            else{
//                System.out.println("Invalid User");
//            }
//            
//            if(la.userCount==4){
//                CutForSeat cfs = new CutForSeat();
//                String s1;
//                s1 = cfs.SeatArrangementCards(gCards.cardsList);
//            }
//            CardsDistribution cd = new CardsDistribution();
//            cd.CardsDistributionLogic(gCards.cardsList);
//            
//            TrickWinner tw = new TrickWinner();
//            ArrayList<Card> trickList = new ArrayList<>();
//            tw.trickWinnerCalculation(trickList);
            
    }         
}

