package com.liebe.sort;

/**
 * Created by sjtu on 16-4-10.
 */
public class AnHeapSort {
    public void HeapAdjust(int[] array,int s,int len){
        int child = 2*s+1;
        int tmp = array[s];
        while(child < len){
            if(child+1<len && array[child+1]<array[child])
                child++;
            if(array[s] > array[child]){
                array[s] = array[child];
                s = child;
                child = child*2+1;
            }else break;
            array[s] = tmp;
        }
    }

    public void buildHeap(int[] array,int len){
        for(int i=(len-1)/2;i>=0;i--){
            HeapAdjust(array,i,len);
        }
    }

    public void sort(int[] array, int len){
        buildHeap(array,len);
        for(int i=len-1;i>=0;i--){
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            System.out.println(array[i]);
            HeapAdjust(array,0,i);
        }
    }


    public static void main(String[] args){
        int[] a = new int[]{1,2,7,3,6,11,15,8,4};
        AnHeapSort hs = new AnHeapSort();
//        hs.sort(a,a.length);
        hs.buildHeap(a,a.length);
        int len = a.length;
        for(int i=len-1;i>=len-4;i--){
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;

            System.out.println(a[i]);
            hs.HeapAdjust(a,0,i);
        }
    }
}
