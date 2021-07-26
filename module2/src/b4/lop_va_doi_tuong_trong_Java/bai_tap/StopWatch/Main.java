package b4.lop_va_doi_tuong_trong_Java.bai_tap.StopWatch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] time = new int[10000000];
        for (int i = 0; i < time.length; i++) {
            time[i]  = (int)(Math.random()*10000000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Arrays.sort(time);
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
