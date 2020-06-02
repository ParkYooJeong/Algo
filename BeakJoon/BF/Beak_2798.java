import java.util.*;
public class Beak_2798 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int value=sc.nextInt();
        int card[]=new int[num];
        
        for(int j=0 ;j<num;j++){
            card[j]=sc.nextInt();
        }
        int max=0;
        int save=0;
        for(int i=0;i<card.length;i++){
          if(card[i]<value){
            save=card[i];

             for(int j=i+1;j<card.length; j++){
                 if(value>card[i]+card[j]) {
                   save=card[j]+card[i];

                    for(int k=j+1;k<card.length;k++){
                      if(value>=(card[i]+card[j]+card[k]))
                      save=card[i]+card[j]+card[k];
                      if(max<save) max=save;
                       }
                 }
                 }
          }
        }
        System.out.println(max);        
    }}