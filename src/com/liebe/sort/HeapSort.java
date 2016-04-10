package com.liebe.sort;

/**
 * Created by sjtu on 16-4-5.
 */
//堆排序法,小顶堆
//从a[1]开始
public class HeapSort {
    public void HeapAdjust(int[] array,int s,int len){
        int child = 2*s;
        int tmp = array[s];
        while(child < len){
            if(child+1<len && array[child]>array[child+1])
                child++;
            if(array[s] > array[child]){
                array[s] = array[child];
                s = child;
                child = child*2;
            }else
                break;
            array[s] = tmp;
        }
    }

    public void buildHeap(int[] array,int len){
        for(int i=len/2;i>0;i--){
            HeapAdjust(array,i,len);
        }
    }

    public void sort(int[] array,int len){
        buildHeap(array,len);
        for(int i=len-1;i>0;i--){
            int tmp = array[1];
            array[1] = array[i];
            array[i] = tmp;
            System.out.println(array[i]);
            HeapAdjust(array,1,i);
        }
    }

    public static void main(String[] args){
        int[] a = new int[]{15,1,2,7,3,6,11,15,8,4};
        HeapSort hs = new HeapSort();
//        hs.buildHeap(a);
//        for(int ele:a)
//            System.out.print(" "+ele);
        hs.sort(a,a.length);
    }

}
