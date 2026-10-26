import java.util.*;

public class Demo{
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        Math m1 = new Math();
        System.out.print(m1.combination(n, r));
        sc.close();

    }
}
class Math{
    long fac[];
    long M = 1000000007;
    long mulMod(long A, long B)
    {
        return ((A%M)*(B%M))%M;
    }
    Math()
    {
        fac = new long[1000001];
        fac[0] = 1;
        fac[1] = 1;
        for(int i = 2;i<1000001;i++)
        {
            fac[i] = mulMod(fac[i-1], i);
        }
    }
    long pow(long A,long B)
    {
        if(B == 0) return 1;
        if(B == 1) return A;
        long hf = pow(A,B/2);
        long ans = mulMod(hf,hf);
        if((B&1L) != 0)
        {
            return mulMod(ans, A);
        }
        return ans;
    }
    long MI(long A,long M)
    {
        return pow(A, M-2);
    }
    int combination(int n, int r)
    {
        long ans =mulMod(mulMod(fac[n],MI(fac[n-r],M)), MI(fac[r],M));
        return (int)ans;
    }
}