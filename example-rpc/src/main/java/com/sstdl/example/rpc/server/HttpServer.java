package com.sstdl.example.rpc.server;

/**
 * @author SSTDL
 * @description 启动服务器
 */
public interface HttpServer {
    /**
     * 启动服务器
     *
     * @param port
     */
    void doStart(int port);
}
