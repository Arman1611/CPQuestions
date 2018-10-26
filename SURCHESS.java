import java.io.*;
import java.util.*;

class arman
{
    static int dp[][]=new int[201][201];
    static int Q[]=new int[201];
    static int Q1[]=new int[201];
    static class FastReader 
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

    public static void main (String[] args) {
        FastReader in=new FastReader();
        int n=in.nextInt();
        int m=in.nextInt();
        ArrayList<String> A=new ArrayList<>();
        ArrayList<String> B=new ArrayList<>();
        ArrayList<String> C=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            String s=in.next();
            A.add(s);
        }
        
        
        for(int i=0;i<n;i++)
        {
            String sb="",sc="";
            for(int j=0;j<n;j++)
            {
                if(i%2==0)
                {
                    if(j%2==0)
                    {
                        sb+='1';
                        sc+='0';
                    }
                    else
                    {
                        sb+='0';
                        sc+='1';
                    }
                }
                else{
                    if(j%2==1)
                    {
                        sb+='1';
                        sc+='0';
                    }
                    else
                    {
                        sb+='0';
                        sc+='1';
                    }
                }
            }
            B.add(sb);
            C.add(sc);
        }

        compareWith(A,B,n,m,1);
        compareWith(A,C,n,m,0);

        int q=in.nextInt();
        while(q--!=0)
        {
            int c=in.nextInt();
            int answer=-1;
            for(int i=1;i<=Math.min(m,n);i++)
            {
                if(c >= Q[i] ||c >= Q1[i])
                {
                  answer=Math.max(answer,i);
                }
            }
            System.out.println(answer);
        }
 
    }

    public static void compareWith(ArrayList<String> A,ArrayList<String> B,int n,int m,int z)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                int a=0;
                if(A.get(i-1).charAt(j-1)!=B.get(i-1).charAt(j-1)) a=1;

                dp[i][j]= a + dp[i-1][j] + dp[i][j-1] -dp[i-1][j-1];
            }
        }
        Arrays.fill(Q,Integer.MAX_VALUE);
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
               int k=i,l=j,index=1;
               while(k<=n && l<=m)
               {
                   int a=findError(i,j,k,l);
                   Q[index]=Math.min(a,Q[index]);
                   k++;l++;index++;
               }
            }
        }

        if(z==1)
        {
            for(int i=1;i<=Math.min(m,n);i++)
               Q1[i]=Q[i];
        }

    }

    public static int findError(int i,int j,int k,int l)
    {
        return dp[k][l]-dp[i-1][l]-dp[k][j-1]+dp[i-1][j-1];
    }
}