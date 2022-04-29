/**
 *
 */
package com.project.callbreak.server.impl;

import com.project.callbreak.info.Chair;
import com.project.callbreak.info.Table;
import com.project.callbreak.messagesender.SendMessage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author Yellaiah This is boot strap server for all servers 
 server. command for starting the lobby server is "java BootStrap CBServer
 -DSERVER_CONFIG_XML=d:/opt/serverconfig_lobby.xml" Starting the
 RealPool/playpool (real pool/play pool ) is " "java BootStrap PoolServer
 -DSERVER_CONFIG_XML=d:/opt/serverconfig_realpool.xml "
 *
 *
 */
//CBServer.getInstance().start(args);
public class BootStrap  {

    public static void main(String[] args){
        try {
            
            CBServer.getInstance().start(args);
//            Thread t = new Thread();
//            for(int i=0;i<10;i++){
//                LinkedHashMap<String,Table> tableCollection = AppContext.getInstance().getTableCollection();
//                Table table = new Table();
//                for (Map.Entry<String, Table> entry : tableCollection.entrySet()) {
//                    table  = entry.getValue();      
//                } 
//                ArrayList<Chair> chairList = table.getChairs();
//                for(Chair chair : chairList){
//                    SendMessage.getInstance().send("Hello", chair.getPlayer());
//                }
//                t.start();
//            }
        } catch (Exception e) {
            System.out.println(" *  command for starting the lobby server is 'java BootStrap LobbyServer -DSERVER_CONFIG_XML=d:/opt/serverconfig.xml' " + e);
        }
        



//    int counter=0;          
//    @Override
//            public void run() {
//                
//                
//                while (true) {
//                    try {
//                        System.out.println("timer countdown startde: ");
//                        Thread.sleep(5000);
//                        
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }    
//                }
// 
            }
}



