package com.liebe.string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by sjtu on 16-4-3.
 */
public class myString {
    public myString(){
    }

    //判断两个字符串是否包含,如果包含返回index
    public int match(String s, String t){
        int len1 = s.length();
        int len2 = t.length();
        int i = 0;
        for(i=0;i<len1-len2;i++){
            String tmp = s.substring(i,i+len2);
            if(tmp.equals(t))
                break;
        }
        if(i == len1-len2)
            return -1;
        return i;
    }


//kmp匹配算法,首先得到pattern字串的特征值
    public int[] getNext(String pattern){
        int len = pattern.length();
        int []next = new int[len];
        next[0] = -1;

        int i;
        for(i=1;i<len;i++){
            String tmp = pattern.substring(0,i);
//            System.out.println(tmp);
            int j = 1;
            int count = 0;
            for(j=1;j<i;j++) {
                if (tmp.substring(0, j).equals(tmp.substring(i - j, i)))
                    count=j;
            }
            next[i] = count;
        }
        return next;
    }

//得到next数组的简单算法，递推
    public int[] getNext2(String pattern){
        char[] array = pattern.toCharArray();
        int len = pattern.length();
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j= 0;
        while(j < len-1){
            if(k==-1 || array[k]==array[j])
                next[++j] = ++k;
            else
                k = next[k];
        }
        return next;
    }


    public int kmp(String s, String p){
        int []next = getNext(p);
        int i=0;
        int j=0;

        while(i<s.length() && j<p.length()){
            if(j==-1 || s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == p.length())
            return i-j;
        return -1;
    }

//反转字串,方法不好
    public String reverse(String s){
        StringBuffer str = new StringBuffer(s);
        for(int i=s.length()-2;i>=0;i--){
            str.append(s.charAt(i));
        }
        String result = str.substring(s.length()-1,str.length());
        return result;
    }

//遍历一半
    public String reverse2(String s){
        char[] origin = s.toCharArray();
        char c;
        int n = s.length();
        for(int i=0;i<n/2;i++){
            c = origin[i];
            origin[i] = origin[n-1-i];
            origin[n-1-i] = c;
        }
        return new String(origin);
    }

//最大子序列和
    //O(N*N)
    public int maxSubSequence(int a[]){
        int len = a.length;
        int maxSum = 0;
        int thisSum = 0;
        for(int i=0;i<len;i++){
            thisSum = 0;
            for(int j=i;j<len;j++){
                thisSum += a[j];
                if(thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }

    static int maxSubSum(int a[],int left,int right){
        if(left == right){
            if(a[left]>0)
                return a[left];
            else
//                return 0;
                return a[left];
        }

        int center,i;
        int maxLeftSum,maxRightSum;
        int leftBorderSum,rightBorderSum;
        int maxLeftBorderSum,maxRightBorderSum;

        center = (left+right)/2;
        maxLeftSum = maxSubSum(a,left,center);
        maxRightSum = maxSubSum(a,center+1,right);

        maxLeftBorderSum = 0;
        leftBorderSum = 0;

        for(i=center;i>=left;i--){
            leftBorderSum += a[i];
            if(leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        maxRightBorderSum = 0;
        rightBorderSum = 0;
        for(i=center+1;i<right;i++){
            rightBorderSum += a[i];
            if(rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return Math.max(maxLeftBorderSum+maxRightBorderSum,Math.max(maxLeftSum,maxRightSum));

    }
    //O(NlogN)
    public int maxSubSequence1(int a[]){
        int n = a.length;
        return maxSubSum(a,0,n-1);
    }

    //O(N)
    public int maxSubSequence2(int a[]){
        int len = a.length;
        int maxSum = 0;
        int thisSum = 0;
        for(int i=0;i<len;i++){
            thisSum += a[i];
            if(thisSum > maxSum)
                maxSum = thisSum;
            else if(thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }

//反转单词顺序

    public String reverseWord(String sentence){
        char[] array = sentence.toCharArray();
        int len = array.length;

        for(int i=0;i<len/2;i++){
            char tmp = array[i];
            array[i] = array[len-1-i];
            array[len-1-i] = tmp;
        }

        String tmpString = new String(array);
        System.out.println(tmpString);

        int begin = 0;
        int end = 0;
        int i = 0;
        while(i<len){
            while(i<len&&array[i] != ' '){
                i++;
            }
            end = i++;

            for(int j=begin;j<(begin+end)/2;j++){
                char tmp = array[j];
                array[j] = array[begin+end-1-j];
                array[begin+end-1-j] = tmp;
            }
            begin = i;
        }
//        String result = array.toString();
//        return result;
        return new String(array);

    }

//找到字串中第一个只出现一次的字符
    public char getFirstOnly(String string){
        HashMap<Character,Integer> hm = new HashMap<>();
        int len = string.length();
        for(int i=0;i<len;i++){
            if(hm.containsKey(string.charAt(i)))
                hm.put(string.charAt(i),hm.get(string.charAt(i))+1);
            else
                hm.put(string.charAt(i),1);
        }
        char c = 0;
        for(int i=0;i<len;i++){
            if(hm.get(string.charAt(i)) == 1){
                c = string.charAt(i);
                break;
            }
        }
        return c;
    }

    public static void main(String args[]){
        myString ms = new myString();
//        String s = "hello world";
//        String t = " ";
//        System.out.println("t in s "+ms.match(s,t));
        String s = "abcabcda";
//        String p = "abcdfhrgt";
//        System.out.println(ms.reverse2(p));
//
//        int[] a = new int[]{-8,-3,-5,4,-6,-4,-6,-6,-7,-4};
//        System.out.println(ms.maxSubSequence(a));
//        System.out.println(ms.maxSubSequence1(a));
//        System.out.println(ms.maxSubSequence2(a));

//        System.out.println(ms.kmp(s,p));
//        String s2 = s.substring(0,6);
//        System.out.println(s2);
//        int[] next = ms.getNext2(s);
//        for(int i=0;i<next.length;i++)
//            System.out.print(" "+next[i]);

//        String s = "I'm a student hello ";
//        String result = ms.reverseWord(s);
//        System.out.println(result);

//        char[] array = new char[]{'a','b','v','f'};
//        System.out.println(Arrays.toString(array));
//        System.out.println(new String(array));

        System.out.println(ms.getFirstOnly("abcebc"));
    }
}
