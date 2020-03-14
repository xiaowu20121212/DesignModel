package com.company.chain;

public class Chain implements IChain {
    private IChain mChain;
    private String name;

    public Chain(String name) {
        this.name = name;
    }


    @Override
    public final Result process(Request request, IChain chain) {
        if (mChain == null) {
            return new Result();
        }
        return chain.doWork(request);
    }


    @Override
    public void addNext(IChain chain) {
        if (this.mChain == null) {
            this.mChain = chain;
        } else {
            this.mChain.addNext(chain);
        }
    }

    @Override
    public Result doWork(Request request) {
        Result result = process(request, mChain);
        result.appResult(name);
        return result;
    }
}
