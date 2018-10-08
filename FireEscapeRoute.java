
import java.util.*;
import java.io.*;

class arman
{
    static int find(int set[],int index)
    {
        if(set[index]>0)
        {
         int parent=find(set,set[index]);
         set[index]=parent;
         return parent;
        }
        
        return index;
    }
    public static void main (String[] args) {
        FastReader in=new FastReader();
        int t=in.nextInt();
        while(t--!=0)
        {
            int n=in.nextInt();
            int m=in.nextInt();
            int noOfSet=n;
            int set[]=new int[n+1];
            Arrays.fill(set,-1);
            for(int i=0;i<m;i++)
            {
                int a=in.nextInt();
                int b=in.nextInt();
                int p_a=find(set,a);
                int p_b=find(set,b);
                if(p_a!=p_b){
                   set[p_a]=set[p_a]+set[p_b];
                   set[p_b]=p_a;
                   noOfSet--;
                }
            }
            int k=noOfSet;
            long select=1;
            int p=1000000007;
            for(int i=1;i<=n&&k!=0;i++)
            {
                if(set[i]<0)
                {
                    k--;
                    select=((select%p)*(Math.abs(set[i])%p))%p;
                }
            }
            System.out.println(noOfSet+" "+select);
        }
    }
}
class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
