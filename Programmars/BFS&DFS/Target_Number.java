class Target_Number {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers,target,0,0);        
        return answer;
        
    }
    public int dfs(int[] numbers,int target,int sum,int index){
        if(index==numbers.length){
            if(sum==target)
                return 1;
            return 0;
        }
        return dfs(numbers,target,sum+numbers[index],index+1)
            +dfs(numbers,target,sum-numbers[index],index+1);
        
    }
}
