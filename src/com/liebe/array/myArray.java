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
//            System.out.println(this.getClass().getName());
        }
    }

//dynamic programming
//longest increasing sequence
//O(N*N)
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

//O(NlogN)
    //在array的s到t之间找到第一个大于key的位置
    public int binSearch(int[] array, int s, int e, int key){
        int mid = 0;
        if(array[e] < key)
            return e+1;
        while(s < e){
            mid = (s+e)/2;
            if(array[mid] < key)
                s = mid+1;
            else
                e = mid;
        }
        return s;
    }

    public int getLIS2(int[] array){
        int len = 0;
        int[] B = new int[array.length];

        int j = 0;
        B[0] = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i] >= B[j]){
                j++;
                B[j] = array[i];
            }else{
                int pos = binSearch(B,0,j,array[i]);
                B[pos] = array[i];
            }
        }
        return j+1;
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

//longest common subsequence
    public int getLCSS(String x, String y){
        int maxLen = 0;
        char[] a = x.toCharArray();
        char[] b = y.toCharArray();

        int[][] dp = new int[a.length][b.length];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i] == b[j]){
                    if(i*j != 0)
                        dp[i][j] = dp[i-1][j-1]+1;
                    if(i==0 || j==0)
                        dp[i][j] = 1;
                }else{
                    if(i*j != 0)
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    else if(i==0 && j==0)
                        dp[0][0] = 0;
                    else
                        dp[i][j] = dp[0][0];
                }

                if(dp[i][j] > maxLen)
                    maxLen = dp[i][j];
            }
        }
        return maxLen;
    }


//minimum string distance
    public int getStringDistance(String a, String b){
        int len1 = a.length();
        int len2 = b.length();

        int[][] dp= new int[len1][len2];

        char[] arraya = a.toCharArray();
        char[] arrayb = b.toCharArray();
//初始化表，但是这个赋值应该有问题
        for(int i=0;i<len1;i++) dp[i][0] = i;
        for(int j=0;j<len2;j++) dp[0][j] = j;

        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                if(arraya[i] == arrayb[j])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
            }

        }

        return dp[len1-1][len2-1];
    }

//最大数对之差
//数对差是指数组中数字减去它右边数字的差

    public int maxDiff(int[] array){
        int len = array.length;
        int f = 0;
        int m = array[0];

        for(int i=0;i<len;i++){
            f = Math.max(f,m-array[i]);
            m = Math.max(m,array[i]);
        }
        return f;
    }

//在数组中删除最少的数使得数组满足从小到大再从大到小的规律
    public int delMin(int[] array){
        int len = array.length;

        int[] pre = new int[len];
        int[] last = new int[len];

        for(int i=0;i<len;i++){
            pre[i] = 1;
            for(int j=0;j<i;j++)
                if(array[j] <= array[i] && pre[j]+1 > pre[i])
                    pre[i] = pre[j]+1;
        }

        for(int i=len-1;i>=0;i--){
            last[i] = 1;
            for(int j=len-1;j>i;j--){
                if(array[j] <= array[i] && last[j]+1 > last[i])
                    last[i] = last[j]+1;
            }
        }

        int max = 0;
        for(int i=0;i<len;i++){
            if(pre[i]+last[i] > max)
                max = pre[i]+last[i];
        }

        return len-max+1;
    }

//堆排在NewHeapSort算法里

    public static void main(String[] args){
//        int[] array = new int[]{15,1,2,7,3,6,11,15,8,4};
        int[] array = new int[]{1,2,7,3,6,11,15,8,4,23,5,9,44};

        myArray arr = new myArray();

//        arr.selectKMin(array,6);
//        int[] result = arr.getLISArray(array);
//        for(int ele:result)
//        System.out.println(ele);
//        System.out.println(arr.getLIS2(array));

//        String x = "yu are fariends";
//        String y = "ywu are fappy";
//        int len = arr.getLCS(x,y);
//        System.out.println(len);

//        String x = "yfdeu atere hirwppx";
//        String y = "yffeewu atwre fpewpy";
//        int len = arr.getLCSS(x,y);
//        System.out.println(len);

//        String x = "abxc";
//        String y = "x";
//        System.out.println(arr.getStringDistance(x,y));

//        System.out.println(arr.maxDiff(array));
        System.out.println(arr.delMin(array));

    }
}
