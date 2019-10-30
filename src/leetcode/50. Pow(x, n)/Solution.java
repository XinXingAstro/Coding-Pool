public class Solution {
    /**
     * My pow double.
     * Time complexity: O(logn)
     * 运行时间 ： 0ms
     *
     * @param x the x
     * @param n the n
     * @return the double
     */
    public double myPow(double x, int n) {
        if (n < 0) return 1/x * myPow(1/x, -(n+1));
        if (n == 0) return 1;
        if (n == 2) return x*x;
        if (n % 2 == 0) return myPow(myPow(x, n/2), 2);
        else return x * myPow(myPow(x, n/2), 2);
    }

    /**
     * My pow double.
     * Time complexity: O(logn)
     * 运行时间 ： 1ms
     *
     * @param x the x
     * @param n the n
     * @return the double
     */
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n<0){
            x=1/x;
            n=-n;
        }
        return pow(x,n);
    }
    public double pow(double x, int n){
        if(n==0) return 1;
        double res=pow(x,n/2);
        return n%2==0?res*res:res*res*x;
    }
}