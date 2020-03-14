package com.company.chain;

/**
 * 处理者接口
 */
public interface IChain extends ITree{
    /**
     * 调用的调用，参数必须是下一个处理者
     * @param chain
     * @return
     */
    Result process(Request request, IChain chain);
}
