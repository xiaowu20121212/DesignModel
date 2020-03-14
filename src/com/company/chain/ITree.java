package com.company.chain;

/**
 * 责任链对外可调用接口
 */
public interface ITree {
    /**
     * 对外调用处理
     * @param request 外部对处理者请求参数
     * @return
     */
    Result doWork(Request request);

    /**
     * 对外添加处理者
     * @param chain
     */
    void addNext(IChain chain);
}
