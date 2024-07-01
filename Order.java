package com.metro.dao;

public class Order {
    private String syohin_code;
    private String hanbai_ymd;
    private String hanbai_kosuu;
    private String hanbai_kingaku;

    public Order(String line) {
        if (line == null) {
            syohin_code ="ZZZZZZZ";
        } else {
            String[] lines = line.split(",");
            syohin_code = lines[0];
            hanbai_ymd = lines[1];
            hanbai_kosuu = lines[2];
            hanbai_kingaku = lines[3];
        }
    }
    public String getSyohin_code() {
        return syohin_code;
    }
    public void setShohin_code(String syohin_code) {
        this.syohin_code = syohin_code;
    }
    public String getHanbai_ymd() {
        return hanbai_ymd;
    }
    public void setHanbai_ymd(String hanbai_ymd) {
        this.hanbai_ymd = hanbai_ymd;
    }
    public String getHanbai_kosuu() {
        return hanbai_kosuu;
    }
    public void setHanbai_kosuu(String hanbai_kosuu) {
        this.hanbai_kosuu = hanbai_kosuu;
    }
    public String getHanbai_kingaku() {
        return hanbai_kingaku;
    }
    public void setHanbai_kingaku(String hanbai_kingaku) {
        this.hanbai_kingaku = hanbai_kingaku;
    }
}
