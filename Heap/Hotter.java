import java.util.*;

class Hotter {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        int sum=0;


        for(int i:scoville){
            q.add(i);
        }

        while(!q.isEmpty()){       
            if(q.peek()>=K){                
                break;
            }
            if(q.size()==1) return -1;

            sum=q.poll()+q.poll()*2;            
            q.add(sum);
            answer++;
        }

        return answer;
    }
}