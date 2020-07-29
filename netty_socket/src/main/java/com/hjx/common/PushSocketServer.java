package com.hjx.common;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;
import com.hjx.common.EventListenner;
import com.hjx.properties.NettySocketProperties;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 服务启动类 ：实现InitializingBean接口启动服务
 * <p>
 * 也可以在springboot 启动的时候启动，扫描到这个类就行
 */

@Component
@Slf4j
public class PushSocketServer implements InitializingBean {

    @Resource
    private EventListenner eventListenner;

    @Autowired
    private NettySocketProperties nettySocketProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        Configuration config = new Configuration();
        config.setPort(nettySocketProperties.getSocketPort());

        SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);
        socketConfig.setTcpNoDelay(true);
        socketConfig.setSoLinger(0);
        config.setSocketConfig(socketConfig);
        config.setHostname(nettySocketProperties.getSocketHostname());

        SocketIOServer server = new SocketIOServer(config);
        server.addListeners(eventListenner);
        server.start();

        System.out.println("启动正常");
        log.info("启动正常");

    }
}
