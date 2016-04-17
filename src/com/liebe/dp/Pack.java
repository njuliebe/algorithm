package com.liebe.dp;

/**
 * Created by sjtu on 16-4-15.
 */
/*
* 01背包问题
* 有N件物品和一个容量为V的背包。第i件物品的体积是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。
* 以dp[i][j] 表示把前i件物品放入容量为j的背包中的价值，状态方程为
* dp[i][j]=max{d[i-1][j],d[i-1][j-C[i-1]]+W[i-1]}，其中C[i-1]为第i-1件物品的体积，W[i-1]为第
* i-1件物品的价值
*/
public class Pack {
    private int[] cost;
    private int[] value;
    private int volume;

    public Pack(int[] cost,int[] value,int volume){
        this.cost = cost;
        this.value = value;
        this.volume = volume;
    }

    public int getSolution(){
        int len = cost.length;
        int[] flag = new int[len+1];

        int[][] dp = new int[100][100];

        for(int i=1;i<=len;i++){
            for(int j=0;j<=volume;j++){
                if(j>=cost[i-1])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-cost[i-1]]+value[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        int vol = volume;
        for(int i=len;i>0;i--){
            if(dp[i][vol] > dp[i-1][vol]){
                flag[i-1] = 1;
                vol = vol-cost[i-1];
            }
        }
        for(int i=0;i<len;i++){
            if(flag[i] == 1){
                System.out.print(cost[i]+" ");
            }
        }
        System.out.println();

        return dp[len][volume];
    }

    public static void main(String[] args){
        int[] cost = new int[]{15,4,13,20,5};
        int[] value = new int[]{20,10,12,14,6};
        int volume = 40;

        Pack pack = new Pack(cost,value,volume);

        System.out.println(pack.getSolution());
    }

}
