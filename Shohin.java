package com.metro.dao;

public class Shohin {

    private String syohin_code;
    private String syohin_name;

    // コンストラクター
    public Shohin(String line) {
        // 最終行の場合は、HIGHバリューを設定する
        if (line == null) {
            syohin_code = "ZZZZZZZ";
        } else {
            // 区切り文字カンマで区切って設定する
            String[] lines = line.split(",");
            syohin_code = lines[0];
            syohin_name = lines[1];
        }
    }
    
    public String getSyohin_code() {
        return syohin_code;
    }
    public void setSyohin_code(String syohin_code) {
        this.syohin_code = syohin_code;
    }
    public String getSyohin_name() {
        return syohin_name;
    }
    public void setSyohin_name(String syohin_name) {
        this.syohin_name = syohin_name;
    }
 
}
