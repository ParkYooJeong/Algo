import java.util.*;

class Immigration {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long start=0;
        long end=(long)times[0]*(long)n;
        long mid=0;        

        while(start<=end){
            boolean check=false;
            long count=0;
            mid=(start+end)/2;
            for(int i=0;i<times.length;i++){
                if(mid%times[i]==0) check=true;
                count+=mid/times[i];
            }

            if(count>=n) {
                 if(check)answer= (mid<answer)?mid:answer;                
                end=mid-1;
            }else{
                start=mid+1;
            }            
        }
        return answer;
    }
    public static void main(String[] args) {
    	Immigration s=new Immigration();
    	int[] arr={7,10};
    	long answer=s.solution(6, arr);
    	System.out.println(answer);
    }
}
