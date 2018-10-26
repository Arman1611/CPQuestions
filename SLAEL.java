import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t--!=0)
		{
		    int n=in.nextInt();
		    int k=in.nextInt();
		    int count=0,max=-1;
		    int f=0,index=-1;
		    int prev=-1;
		    for(int i=0;i<n;i++)
		    {
		        int a=in.nextInt();
		        if(a>k)
		        {
		            if(f==0)
		            {
		                f=1;
		                prev=a;
		                index=i;
		                count++;
		                max=Math.max(count,max);
		            }
		            else if(prev==a)
		            {
		                index=i;
		                count++;
		                max=Math.max(count,max);
		            }
		            else
		            {
		                count=i-index;
		                index=i;
		                prev=a;
		                max=Math.max(count,max);
		            }
		            
		        }
		        else
		        {
		            count++;
		            max=Math.max(count,max);
		        }
		        
		    }
		    
		    System.out.println(max);
		}
	}
}
