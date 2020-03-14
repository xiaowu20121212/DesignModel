package com.company.chain;

public class Result {
    private StringBuilder stringBuilder = new StringBuilder();
    public void appResult(String name) {
        stringBuilder.append(" " + name);
    }
    public String getResult() {
        return stringBuilder.toString();
    }
}
