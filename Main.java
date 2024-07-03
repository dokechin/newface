package com.metro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.metro.dao.Order;
import com.metro.dao.Shohin;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader inmastReader = Files.newBufferedReader(Paths.get("INMAST"));
              BufferedReader intranReader= Files.newBufferedReader(Paths.get("INTRAN"));
              PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("OTDATA")));){

            // マスタの読み込み　および　マスタオブジェクトShohinへ設定
            String inmastLine = inmastReader.readLine();
            Shohin shohin = new Shohin(inmastLine);            
            // トランザクションの読み込み　および　トランザクションオブジェクトOrderへ設定
            String intranLine = intranReader.readLine();
            Order order = new Order(intranLine);

            // マスタおよびトランザクションが最終行に到達するまでループする
            while(!shohin.getSyohin_code().equals("ZZZZZZZ") || !order.getSyohin_code().equals("ZZZZZZZ")  ) {
                if ( shohin.getSyohin_code() .compareTo(order.getSyohin_code()) < 0) {
                    // マスタにあり、トランザクションにない場合、次のマスタを読み込む
                    inmastLine = inmastReader.readLine();
                    shohin = new Shohin(inmastLine);            
                } else if (shohin.getSyohin_code() .compareTo(order.getSyohin_code()) == 0) {
                    // マスタ及びトランザクションにある場合、個数および金額を合計して、出力
                    int sum_kosuu = 0;
                    int sum_kingaku = 0;
                    String out_hanbai_ymd = order.getHanbai_ymd();
                    while(shohin.getSyohin_code() .compareTo(order.getSyohin_code()) == 0) {
                        sum_kosuu = sum_kosuu + Integer.parseInt(order.getHanbai_kosuu());
                        sum_kingaku = sum_kingaku + Integer.parseInt(order.getHanbai_kingaku());
                        intranLine = intranReader.readLine();
                        order = new Order(intranLine);               
                    }
                    pw.format("%s,%s,%06d,%010d\r\n", shohin.getSyohin_name(),out_hanbai_ymd,sum_kosuu,sum_kingaku);
                    
                } else {
                    // トランザクションにのみある場合、次のトランザクションを読み込む
                    System.out.println(String.format("TRAN ONLY %s", order.getSyohin_code()));
                    intranLine = intranReader.readLine();
                    order = new Order(intranLine);
                }
            }
        }
        catch (IOException e) {
            // 例外処理
            e.printStackTrace();
        }       
    }

}
