package com.sstdl.example.provider;

import com.sstdl.example.common.service.UserService;
import com.sstdl.example.rpc.registry.LocalRegistry;
import com.sstdl.example.rpc.server.HttpServer;
import com.sstdl.example.rpc.server.VertxHttpServer;

/**
 * @author SSTDL
 * @description 提供者启动类
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 HTTP 服务器
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
