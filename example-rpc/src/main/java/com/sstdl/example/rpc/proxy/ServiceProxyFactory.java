package com.sstdl.example.rpc.proxy;

import java.lang.reflect.Proxy;

/**
 * @author SSTDL
 * @description 服务代理工厂（用于创建代理对象）
 */
public class ServiceProxyFactory {
    public static <T> T getProxy(Class<T> serviceClass) {
        // Proxy.newProxyInstance 为指定类型创建代理对象
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy()
        );
    }
}
