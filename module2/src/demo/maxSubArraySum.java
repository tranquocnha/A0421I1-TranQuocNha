package demo;

public class maxSubArraySum {
    public static void main (String[] args)
    {
//        int [] a = {-1, -2, -5, -1};
//        System.out.println("Maximum contiguous sum is " +
//                maxSubArraySum(a));
        System.out.println(sumOfOddNumbers(3,5));
    }

    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far=0;
        int max_ending_here = 0;
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
    static int sumOfOddNumbers(int a, int b) {
        long sum = 0;
        if (a >= b) {
            return 0;
        }

        for (int i = a + 1; i < b; i++) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        return (int) (sum % 10000007);
    }
    int antiPrimes(int k) {
        int max=0;
        int d=0;
        if(k<4){
            return k;
        }
        for(int i=1; i<=k; i++){
            int count=0;
            for(int j=2; j<=i; j++){
                if(i%j==0){
                    count++;
                }

            }
            if(max<=count){
                max=count;
                d=i;
            }
        }
        return d;
    }
}
