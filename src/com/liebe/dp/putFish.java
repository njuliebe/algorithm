package com.liebe.dp;

/**
 * Created by sjtu on 16-4-15.
 */
//放鱼问题
    /*
    * 20个桶，每个桶中有10条鱼，用网从每个桶中抓鱼，每次可以抓住的条数随机，每个桶只能抓一次，问一共抓到180条的排列有多少种。
    * 等价于问题20条鱼在20个桶中有多少种分布情况，每个桶中鱼的数量为[0,10]
    * */
public class putFish {
    //递归解法
    public int allocate(int bucketNum,int fishNum){
        int[][] dp = new int[21][21];

        if(bucketNum == 0 && fishNum == 0)
            return 1;
        if(bucketNum == 0 || fishNum < 0)
            return 0;

        //子问题没有计算过就计算
        if(dp[bucketNum][fishNum] == 0){
            for(int i=0;i<=10;i++){
                dp[bucketNum][fishNum] += allocate(bucketNum-1,fishNum-i);
            }
        }
        return dp[bucketNum][fishNum];
    }

    //动态规划解法
    public int dpAllocate(int bucketN,int fishN){
        int[][] dp = new int[bucketN+1][fishN+1];

//        for(int i=0;i<=10;i++){
//            dp[1][i] = 1;
//        }

        dp[0][0] = 1;

        for(int i=1;i<=bucketN;i++){
            for(int j=0;j<=fishN;j++){
                for(int k=0;k<=10 && j-k>=0;k++)
                    dp[i][j] += dp[i-1][j-k];
            }
        }

        return dp[bucketN][fishN];
    }

    public static void main(String[] args){
        putFish p = new putFish();
        long begin ,end;
        begin = System.nanoTime();
        System.out.println(p.allocate(5,10));
        end = System.nanoTime();
        System.out.println("recursive cost time "+(end-begin));

        begin = System.nanoTime();
        System.out.println(p.dpAllocate(5,40));
        end = System.nanoTime();
        System.out.println("dp cost time "+(end-begin));
    }
}
