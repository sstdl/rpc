package com.sstdl.example.rpc.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.sstdl.example.rpc.model.RpcRequest;
import com.sstdl.example.rpc.model.RpcResponse;
import com.sstdl.example.rpc.serializer.JdkSerializer;
import com.sstdl.example.rpc.serializer.Serializer;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author SSTDL
 * @description 服务代理（JDK 动态代理）
 */
public class ServiceProxy implements InvocationHandler {
    /**
     * 调用代理
     * 当用户调用某个接口的方法时，会改为调用 invoke 方法
     * 在 invoke 方法中，可以获取到要调用的方法信息、传入的参数列表等
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();

        // 构造请求
        RpcRequest request = RpcRequest.builder()
                .serviceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameterTypes(method.getParameterTypes())
                .args(args).build();
        try {
            // 序列化
            byte[] bytes = serializer.serialize(request);
            // 发送请求
            // 请求的服务提供者地址被硬编码，需要使用注册中心和服务发现机制来解决
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bytes)
                    .execute()){
                byte[] res = httpResponse.bodyBytes();
                RpcResponse rpcResponse = serializer.deserialize(res, RpcResponse.class);
                return rpcResponse.getData();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
