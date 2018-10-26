import java.io.*;
import java.util.*;

class Steps
{
    long num;
    long l;
    
    public Steps(long num,long l)
    {
        this.num=num;this.l=l;
    }
}
class arman
{
    static long ds(long n)
    {   
        if(n==0)return 0;
        if(n%9==0)return 9;
        else
        return n%9;
    }
    
    static long digitS(long n)
    {
        long sum=0;
        for(long i=n;i>0;i/=10)
        {
            sum+=i%10;
        }
        return sum;
    }
    static long findSteps(long n,long d,long k)
    {
        Queue<Steps> q=new LinkedList<>();
        q.add(new Steps(n,1));
        while(!q.isEmpty())
        {
            Steps s=q.poll();
            if(s.num==k)
            {
                return s.l-1;
            }
            long digitS_n=digitS(s.num);
            if(digitS_n!=s.num)
            q.add(new Steps(digitS(s.num),s.l+1));
            q.add(new Steps(s.num+d,s.l+1));
        }
        return -1;
    }
    public static void main (String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t--!=0)
        {
            long n=in.nextLong();
            long d=in.nextLong();
            
            long ds_n=ds(n);
            long ds_d=ds(d);
            long step;
            if(ds_d==1||ds_d==2||ds_d==4||ds_d==5||ds_d==7||ds_d==8)
            {
                step=findSteps(n,d,1);
                System.out.println("1 "+step);
            }
            else if(ds_d==3||ds_d==6)
            {
                long f=(ds_n%3==0)?3:ds_n%3;
                step=findSteps(n,d,f);
                System.out.println(f+" "+step);
            }
            else
            {
                step=findSteps(n,d,ds_n);
                System.out.println(ds_n+" "+step);
            }
            
            
        }
    }
}
