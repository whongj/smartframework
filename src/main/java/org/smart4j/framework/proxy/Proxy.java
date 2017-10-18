package org.smart4j.framework.proxy;

/**
 * Created by wanghongjie on 2017/10/18.
 */
public interface Proxy {
    /**
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;

}
