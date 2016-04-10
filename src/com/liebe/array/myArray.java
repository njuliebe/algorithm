package com.liebe.array;

/**
 * Created by sjtu on 16-4-9.
 */
public class myArray {
//选取最小k个数

//选择排序
    public void selectKMin(int[] array,int k){
        int len = array.length;

        for(int i=0;i<k;i++){
            int min = array[i];
            int minKey = i;

            for(int j=i;j<len;j++){
                if(array[j] < min){
                    min = array[j];
                    minKey = j;
                }
            }
            int tmp = array[minKey];
            array[minKey] = array[i];
            array[i] = tmp;
            System.out.println(array[i]);
        }
    }

//dynamic programming
//longest increasing sequence
    public int getLIS(int[] array){
        int len = 1;
        int n = array.length;
        int[] d = new int[n];

        for(int i=0;i<n;i++){
            d[i] = 1;
            for(int j=0;j<i;j++){
                if(array[j]<=array[i] && d[j]+1>d[i]){
                    d[i] = d[j]+1;
                }
            }
            if(d[i]>len) len = d[i];
        }
        return len;
    }

    public int[] getLISArray(int[] array){
        int len = 1;
        int n = array.length;
        int[] d = new int[n];
        int[] pre = new int[n];

        int lastIndex = 0;
        for(int i=0;i<n;i++){
            d[i] = 1;
            for(int j=0;j<i;j++){
                if(array[j]<=array[i] && d[j]+1>d[i]) {
                    d[i] = d[j] + 1;
                    pre[i] = j;
                }
            }

            if(d[i] > len){
                len = d[i];
                lastIndex = i;
            }
        }
//        for(int ele:pre)
//        System.out.print(" "+ele);
//        System.out.println();

        int[] result = new int[len];
        result[len-1] = lastIndex;
        for(int i=len-2;i>-1;i--){
            int index = result[i+1];
            result[i] = pre[index];
        }
        return result;

    }

//longest common substring
    public int getLCS(String x,String y){
        int lenX = x.length();
        int lenY = y.length();
        char[] a = x.toCharArray();
        char[] b = y.toCharArray();

        int[][] dp = new int[lenX][lenY];
        int maxLen = 0;
        int maxIndex = 0;

        for(int i=0;i<lenX;i++){
            for(int j=0;j<lenY;j++){
                if(a[i] == b[j]) {
                    if(i*j != 0)
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (i == 0 || j == 0)
                        dp[i][j] = 1;

                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        maxIndex = i;
                    }
                }
            }
        }
        for(int i=maxIndex-maxLen+1;i<=maxIndex;i++)
            System.out.print(a[i]);
        System.out.println();
        return maxLen;
    }



//堆排在NewHeapSort算法里

    public static void main(String[] args){
        int[] array = new int[]{15,1,2,7,3,6,11,15,8,4};
        myArray arr = new myArray();
//        arr.selectKMin(array,6);
//        int[] result = arr.getLISArray(array);
//        for(int ele:result)
//        System.out.println(ele);

        String x = "yu are fariends";
        String y = "ywu are fappy";
        int len = arr.getLCS(x,y);
        System.out.println(len);

    }
}
