package com.liebe.dp;

/**
 * Created by sjtu on 16-4-17.
 */

/*
* 从给定的N个正数中选取若干个数之和最接近M
* 其实还是01背包问题
* 最接近M和等于M可以采用同样的解法
*/

public class closestSum {
    private int[] value;
    private int M;

    public closestSum(int[] value, int M){
        this.value = value;
        this.M = M;
    }

    public int getSolution(){
        int[][] dp = new int[100][100];
        int len = value.length;

        for(int i=1;i<=len;i++){
            for(int j=0;j<=M;j++){
                //需要做一个判断，要用>=
                if(j >= value[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j-value[i-1]]+value[i-1],dp[i-1][j]);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }

        //dp数组可以用一个一维数组，可以降低空间复杂度，但是要用倒序
        int[] d = new int[100];
        for(int i=1;i<=len;i++){
            for(int j=M;j>=0;j--){
                if(j>=value[i-1])
                    d[j] = Math.max(d[j],d[j-value[i-1]]+value[i-1]);
            }
            for(int k=0;k<=M;k++)
                System.out.print(d[k]+" ");
            System.out.println();
        }

        System.out.println();

        //获得选中的元素
        int[] flag = new int[len];
        int val = dp[len][M];
        for(int i=len;i>0;i--){
            if(dp[i][val] > dp[i-1][val]){
                flag[i-1] = 1;
                val = val-value[i-1];
            }
        }

        for(int i=0;i<len;i++){
            if(flag[i] == 1)
                System.out.print(value[i]+" ");
        }
        System.out.println();


        for(int i=0;i<=len;i++){
            for(int j=0;j<=M;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        return dp[len][M];

    }

    public  static void  main(String[] args){
        int value[] = {2,9,5,7,4,11,10};
        int M = 33;
        closestSum cs = new closestSum(value,M);
        System.out.println(cs.getSolution());
    }
}
