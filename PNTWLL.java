import java.util.*;

import java.io.*;

class GFG  extends ArrayList<Integer> {
 
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t--!=0)
		{
		    int n=in.nextInt();
		    int m=in.nextInt();
		    int a[]=new int[n];
		    int c[]=new int[n];
		    GFG al=new GFG();
		   GFG color=new GFG();
		    for(int i=0;i<n;i++)
		        a[i]=in.nextInt();

		    for(int i=0;i<n;i++)
		        c[i]=in.nextInt();
		        
		    for(int i=0;i<n-1;i++)
		    {
		        if(a[i]>a[i+1])
		        {
		           int index=Collections.binarySearch(al,a[i],Collections.reverseOrder());
		           if(index<0)
		           {
		               index=Math.abs(index)-1;
		           }
		           al.removeRange(index,al.size());
		           color.removeRange(index,color.size());
		           al.add(a[i]);
		           color.add(c[i]);
		        }
		    }
		    
		   int index=Collections.binarySearch(al,a[n-1],Collections.reverseOrder());
           if(index<0)
           {
               index=Math.abs(index)-1;
           }
           al.removeRange(index,al.size());
           color.removeRange(index,color.size());
           al.add(a[n-1]);
           color.add(c[n-1]);
           Set<Integer> set=new HashSet<>();
           for(int i:color)
           {
               set.add(i);
           }
		    int answer=(al.size()>set.size())?set.size():al.size();
		    System.out.println(answer);
		}
	}
}
