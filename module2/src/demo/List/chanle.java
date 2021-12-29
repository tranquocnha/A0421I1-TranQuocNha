package demo.List;

import java.util.Scanner;

public class chanle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(compareSumOfDigits(scanner.nextLine()));

    }
    public static int compareSumOfDigits(String input) {
        int sum=0;
        int chan=0;
        int le=0;
        int i = input.length()-1;
        while(i>=0){
            sum = Integer.parseInt(String.valueOf(input.charAt(i)));
            if(sum%2==0){
                chan+=sum;
            }else{
                le+=sum;
            }
            i--;
        }
        return le-chan;
    }


}
