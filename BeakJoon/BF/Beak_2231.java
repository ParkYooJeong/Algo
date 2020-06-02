import java.io.*;
import java.util.*;

public class Beak_2231 {
    public static void main(String[] args) throws  IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String num=sc.readLine();
        int len=num.length();
        int start=Integer.parseInt(num)-9*len;
        int min=0;

        if(start<0){
          if(len==1) min=Integer.parseInt(num)/2;
          else {
            for(int i=10;i<18;i++){
              int check=i+1+i%10;
              if(Integer.parseInt(num)==check){
                min=i;
                break;
              }
            }
          }
        }

        else{
          for(int i=start;i<Integer.parseInt(num);i++){
            int check=i;
            for(int j=1;j<=len;j++){
              int na=i%(int)Math.pow(10,(len-j+1));
              int mok=na/(int)Math.pow(10,(len-j));
              check+=mok;
            }
            if(Integer.parseInt(num)==check){
               min=i;
                break;
                 }
        }
        }
         
        System.out.println(min);
        
    }
}
