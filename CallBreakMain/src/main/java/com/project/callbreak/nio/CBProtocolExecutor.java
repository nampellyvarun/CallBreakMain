/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.callbreak.nio;

import io.netty.channel.ChannelHandlerContext;
import java.util.ArrayList;
import java.util.Arrays;

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
        
    }

}