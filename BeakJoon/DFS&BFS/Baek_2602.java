import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
class Beak_126 {
  static  boolean [][]connect;
  static int count=0;

  public static void dfs(boolean visit[],int start){
   visit[start]=true;

   for(int i=1;i<visit.length;i++){
     if((connect[i][start]||connect[start][i])&&!visit[i]){
       count++;
       dfs(visit,i);
     }
   }
  }

    public static void main(String args[]) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine()," ");

       int vertex_number = Integer.parseInt(st.nextToken());
       st = new StringTokenizer(br.readLine(), " ");
       int line_number = Integer.parseInt(st.nextToken());

       connect = new boolean[vertex_number+1][vertex_number+1];
       boolean []visit = new boolean[vertex_number+1];
 
       for(int i=0;i<line_number;i++){
         int linel;int liner;
         st = new StringTokenizer(br.readLine(), " ");

         linel = Integer.parseInt(st.nextToken());
         liner = Integer.parseInt(st.nextToken());
         connect[linel][liner]=true;
       }

       dfs(visit,1);
       System.out.println(count);
     
    }
}
