import java.util.*;
class H_index {
    public int solution(int[] citations) {
        int count=0;int i;
        
        Arrays.sort(citations);
        
        for (i=citations.length;i>=0;i--){
            count=0;
            for(int j : citations){
                if (i<=j)
                    count++;     
            }
            if(i<=count)
                break;
        } 
        
        return i;
    }
}