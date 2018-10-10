import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
    static boolean isPossible(int a[],int n,int sum)
    {
        boolean m[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
         m[i][0]=true;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(a[i-1]>j)m[i][j]=m[i-1][j];
                else
                m[i][j]=m[i-1][j-a[i-1]]||m[i-1][j];
            }
        }
        return m[n][sum];
    }
	public static void main (String[] args)
	 {
	   
	   Scanner in=new Scanner(System.in);
	   int t=in.nextInt();
	   while(t--!=0)
	   {
	       int n=in.nextInt();
	       int a[]=new int[n];
	       int sum=0;
	       for(int i=0;i<n;i++)
	       {
	           a[i]=in.nextInt();
	           sum+=a[i];
	       }
	       if(sum%2==1)System.out.println("NO");
	       else
	       {
	           sum/=2;
	           if(isPossible(a,n,sum))
	           System.out.println("YES");
	           else
	           System.out.println("NO");
	       }
	   }
	 }
}
