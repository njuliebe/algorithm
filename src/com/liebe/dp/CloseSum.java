package com.liebe.dp;

/**
 * Created by sjtu on 16-4-17.
 */

/*
* 从给定的N个正数中选取若干个数之和最接近M
* 其实还是01背包问题
*/

public class CloseSum {
    private int[] value;
    private int M;

    public CloseSum(int[] value,int M){
        this.value = value;
        this.M = M;
    }

    public int getSolution(){
        int[][] dp = new int[100][100];
        int len = value.length;
        for(int i=1;i<=len;i++){
            for(int j=0;j<=M;j++){
                if(j > value[i]){
                    dp[i][j] = Math.max(dp[i-1][j-value[i-1]]+value[i-1],dp[i-1][j]);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[len][M];

    }

    public  static void  main(String args){
        int value[] = {2,9,5,7,4,11,10};
        int M = 33;
        CloseSum cs = new CloseSum(value,M);
        System.out.println(cs.getSolution());
    }
}
