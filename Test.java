给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

方法一：
class Solution {
    public int integerBreak(int n) {
        if(n<=3) return n-1;

        int a=n/3;
        int b=n%3;
        if(b==0) return (int)Math.pow(3,a);
        if(b==1) return (int)Math.pow(3,a-1)*4;
        if(b==2) return (int)Math.pow(3,a)*2;
        return 0;
    }
}

方法二：

class Solution {
    public int integerBreak(int n) {
        if(n<=3) return n-1;
       int[] dp=new int[n+1];
       dp[0]=1;
       dp[1]=1;
       dp[2]=1;
       dp[3]=1;
       for(int i=4;i<=n;i++){
           for(int j=i-1;j>0;j--){
               dp[i]=Math.max(dp[i],dp[i-j]*j);
               dp[i]=Math.max(dp[i],(i-j)*j);
           }
       }
       return dp[n];
    }
}