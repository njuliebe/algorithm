package com.liebe.sort;

/**
 * Created by sjtu on 16-3-15.
 */
public class ShellSort {
    public void sort(int[] array, int length){
        int i,j, gap;
        int tmp;
        for(gap=length/2;gap>0;gap/=2){
            for(i=gap;i<length;i++){
                tmp = array[i];
                for(j=i;j>=gap;j-=gap){
                    if(tmp<array[j-gap])
                        array[j] = array[j-gap];
                    else break;
                }
                array[j] = tmp;
            }
        }
    }

    public void sort2(int[] array,int length){
        int i,j,gap,tmp;
        int k;
        for(gap=length/2;gap>0;gap/=2){
            for(i=0;i<gap;i++){
                for(j=i+gap;j<length;j+=gap){
                    tmp = array[j];
                    k = j-gap;
                    while(k>=0&&array[k]>tmp){
                        array[k+gap] = array[k];
                        k -= gap;
                    }
                    array[k+gap] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        ShellSort ss = new ShellSort();
        int[] array= {2,13,3,43,5,7,12,100,6,4,33,42};
        int length = array.length;
        ss.sort2(array,length);
        for(int ele:array)
            System.out.println(ele);
    }
}
