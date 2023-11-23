package com.example.accommodatedexchange;


import com.fasterxml.jackson.annotation.JsonFormat;

public class AccomodatedExchange {

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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRaw_amount() {
        return raw_amount;
    }

    public void setRaw_amount(double raw_amount) {
        this.raw_amount = raw_amount;
    }

    public double getAccommodated_amount() {
        return accommodated_amount;
    }

    public void setAccommodated_amount(double accommodated_amount) {
        this.accommodated_amount = accommodated_amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    private String from, to;
    private double rate, amount, discount, raw_amount, accommodated_amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private String time, source, environment;

    public AccomodatedExchange(String from, String to, double rate, double amount, double discount, double raw_amount, double accommodated_amount, String time, String source, String environment) {
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.amount = amount;
        this.discount = discount;
        this.raw_amount = raw_amount;
        this.accommodated_amount = accommodated_amount;
        this.time = time;
        this.source = source;
        this.environment = environment;
    }

}
