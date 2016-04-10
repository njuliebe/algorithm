package com.liebe.sort;

/**
 * Created by sjtu on 16-3-16.
 */
public class BubbleSort {
    public void sort(int[] array,int length){
        int i,j;
        int tmp;
        for(i=0;i<length;i++){
            for(j=0;j<length-i-1;j++){
                if(array[j+1] <array[j]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    public void sort_flag(int[] array, int length){
        int i,j;
        int tmp;
        i = 0;
        boolean flag = true;
        while(flag){
            flag = false;
            for(j=0;j<length-i-1;j++){
                if(array[j+1] < array[j]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = true;
                }
            }
            i++;
        }
    }

    public static void main(String[] args){
        int[] array= {2,13,3,43,5,7,12,100,6,4};
        int length = array.length;
        BubbleSort bs = new BubbleSort();
        bs.sort_flag(array,length);
        for(int ele:array)
            System.out.println(ele);
    }
}
