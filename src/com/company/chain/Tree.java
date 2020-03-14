package com.company.chain;

/**
 * 实现对外接口
 */
public class Tree implements ITree {

    private IChain mRoot = new Chain("head");

    /**
     * 对外开始请求处理
     * @param request 外部对处理者请求参数
     * @return
     */
    @Override
    public Result doWork(Request request) {
        return mRoot.doWork(request);
    }

    /**
     * 添加处理者
     * @param chain
     */
    @Override
    public void addNext(IChain chain) {
        mRoot.addNext(chain);
    }
}
