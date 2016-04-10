package com.liebe.sort;

/**
 * Created by sjtu on 16-3-15.
 */
public class SelectSort {
    //this is insert
    public void sort(int[] array,int length){
        int i=0;
        int j=0;
        int tmp;
        for(i=0;i<length;i++){
            tmp = array[i];
            for(j=i;j>0 && array[j-1]>tmp;j--){
                array[j] = array[j-1];
            }
            array[j] = tmp;
        }
    }

    public void select(int[] array){
        int len = array.length;
        for(int i=0;i<len;i++){
            int min = array[i];
            int minKey = i;
            int j;
            for(j=i;j<len;j++){
                if(array[j] < min){
                    min = array[j];
                    minKey = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minKey];
            array[minKey] = tmp;

        }
    }

    public static void main(String[] args){
        int[] array = {2,13,3,43,5,7,12,100,6,1};
        int length = array.length;
        SelectSort ss = new SelectSort();
        ss.select(array);
        for(int i:array){
            System.out.println(i);
        }
    }
}
