package demojava;

public class Demo {
   static public  void main(String[] args) {
        int a =28;
        int sum=0;
        for(int i=1;i<=a/2;i++){
            if(a%i==0)
                //tổng các ước số của a
                sum+=i;
        }
    }

}
