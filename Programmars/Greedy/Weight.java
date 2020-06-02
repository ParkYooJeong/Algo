import java.util.*;
class Weight {
    public int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        for(int i : weight){
            if(answer>=i){
                answer+=i;
            }else{
                break;
            }
        }      
        return answer;
    }
}