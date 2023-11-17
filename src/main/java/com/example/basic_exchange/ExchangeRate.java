package com.example.basic_exchange;

public class ExchangeRate {
    private String from;
    private String to;
    private String rate;
    private String time;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ExchangeRate(String from, String to, String rate, String time) {
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.time = time;
    }
}
