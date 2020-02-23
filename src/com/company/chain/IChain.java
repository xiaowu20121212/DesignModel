package com.company.chain;

public interface IChain {
    Result doWork(IChain chain);
}
