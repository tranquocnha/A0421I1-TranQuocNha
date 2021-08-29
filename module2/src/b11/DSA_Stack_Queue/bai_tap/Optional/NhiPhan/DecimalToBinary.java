package b11.DSA_Stack_Queue.bai_tap.Optional.NhiPhan;

import java.util.Stack;

public class DecimalToBinary {
    public void covertToBinary(int num){
        Stack<Integer> stack=new Stack<>();

        while (num!=0){
            int modNum=num%2;
            stack.push(modNum);
            num/=2;
        }
        while (!stack.isEmpty()){
            System.out.printf("%d",stack.pop());
        }

    }
    public static void main(String[] args) {
        int decimalNumber = 3434565;
        System.out.println("so he thap phan: "+decimalNumber);
        new DecimalToBinary().covertToBinary(decimalNumber);
    }
}
