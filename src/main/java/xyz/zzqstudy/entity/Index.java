package xyz.zzqstudy.entity;

import org.springframework.stereotype.Component;

//@Component
public class Index {
    private String date;
    private String code;
    private String name;
    private double close;
    private double high;
    private double low;
    private double open;
    private double pctchange;
    private long volume;
    private long amount;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getOpen() {
        return open;
    }

    public double getPctchange() {
        return pctchange;
    }

    public long getVolume() {
        return volume;
    }

    public long getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public void setPctchange(double pctchange) {
        this.pctchange = pctchange;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Index{" +
                "date=" + date +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", open=" + open +
                ", pctchange=" + pctchange +
                ", volume=" + volume +
                ", amount=" + amount +
                '}';
    }
}
