package crawling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String collect = new BufferedReader(new InputStreamReader(new URL("https://www.naver.com/").openConnection().getInputStream())).lines().collect(Collectors.joining());
        rank(collect);

    }

    public static void rank(String str){
        for(Integer i = 1 ; i<11 ; i++){
            String s = str.split("<span class=\"ah_r\">" + i.toString() + "</span>" +
                    "<span class=\"ah_k\">")[1].split("</span>")[0];
            System.out.println(s);
        }
    }

}