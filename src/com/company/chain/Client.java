package com.company.chain;

public class Client {
    public static void main(String[] args) {
        ITree tree = new Tree();
        tree.addNext(new Chain("1"));
        tree.addNext(new Chain("2"));
        tree.addNext(new Chain("3"));
        tree.addNext(new Chain("4"));
        tree.addNext(new Chain("5"));
        tree.addNext(new Chain("6"));
        Result result = tree.doWork(new Request());
        System.out.printf("result:" + result.getResult());
    }
}
