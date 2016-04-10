package com.liebe.sort;

/**
 * Created by sjtu on 16-3-16.
 */
public class QuickSort {
    public int partition(int[] a,int left, int right){
        int tmp;

        int privot = a[left];
        while(left < right){
            while(left<right && a[right]>=privot) --right;
            tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            while(left<right && a[left]<=privot) ++left;
            tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
        }
        return left;
    }

    public int partition2(int[] a,int left, int right){
        int tmp;

        int privot = a[left];
        while(left<right){
            while(left<right && a[right]>privot) right--;
            a[left] = a[right];
            while(left<right && a[left]<privot) left++;
            a[right] = a[left];
        }
        a[left] = privot;
        return left;
    }

    public void sort(int[] array,int left,int right){
        if(left<right){
            int privotLoc = partition2(array,left,right);
            sort(array,left,privotLoc-1);
            sort(array,privotLoc+1,right);
        }
    }

    public static void main(String[] args){
        int[] array = {2,13,3,43,5,7,12,100,6,4};
        int length = array.length;
        QuickSort ss = new QuickSort();
        ss.sort(array,0,length-1);
        for(int i:array){
            System.out.println(i);
        }
    }
}
