package com.liebe.dp;

/**
 * Created by sjtu on 16-4-17.
 */
/**
 * 完全背包问题：
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。
 * 第i种物品的费用是c[i]，价值是w[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 *
 *常见例子：
 * 将一个较大的钱，不超过1000的人民币，兑换成数量不限的100、50、10、5、2、1的组合
 */
public class CompletePack {
    private int[] value;
    private int M;

    public CompletePack(int[] value, int M){
        this.value = value;
        this.M = M;
    }

    public int getSolution(){
        int len = value.length;
        int[] d = new int[101];
        for(int i=1;i<=len;i++){
            for(int j=0;j<=M;j++)
                if(j>=value[i-1])
                d[j] = Math.max(d[j],d[j-value[i-1]]+value[i-1]);
            for(int k=0;k<=M;k++)
                System.out.print(d[k]+" ");
            System.out.println();
        }
        return d[100];
    }

    public static void main(String[] args){
        int[] value = new int[]{10,5,2,1};
        int M = 100;

        CompletePack cp = new CompletePack(value,M);
        System.out.println(cp.getSolution());
    }
}
