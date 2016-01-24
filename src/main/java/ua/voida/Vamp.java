package ua.voida;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Vamp {
    public static void main(String[] args) {
        Random random = new Random();
        int a , b, c, d, ab, cd, i = 0;
        HashMap<String, String> map = new HashMap<>();
        while (i < 7){
            a = random.nextInt(10);
            b = random.nextInt(10);
            c = random.nextInt(10);
            d = random.nextInt(10);
            if ( b == 0 && d == 0) {
                continue;
            } else if ( ((a * 10 + b) * (c * 10 + d) ) / 1000 >= 1) {
                ab = a * 10 + b;
                cd = c * 10 + d;
                String before = "" + ab + "" + cd;
                String now = "" + ab * cd;
                i = vamp( before, now, map).size();
            }
        }
        map.forEach(( k, v) -> {
            System.out.println(k + " = " + v);
        });
    }
    public static  Map<String, String> vamp ( String before , String now,  Map<String, String> map ) {
        for (char i : before.toCharArray()) {
            if ( containz(before, i) != containz(now, i) ){
                return map;
            }
        }
        map.put(now, before.toCharArray()[0] + "" + before.toCharArray()[1] + " * " + before.toCharArray()[2] + "" + before.toCharArray()[3] );
        return map;
    }

    public static int containz ( String numbers, int number) {
        int k = 0;
        for (char i : numbers.toCharArray()) {
            if ( (int) i == number) {
                k++;
            }
        }
        return k;
    }
}
