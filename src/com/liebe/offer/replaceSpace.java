package com.liebe.offer;

/**
 * Created by sjtu on 16-3-31.
 */
/*
把字符串中的空格替换成 %20,时间复杂度为O(n)
*/
public class replaceSpace {
    public static void replace(String origin,StringBuffer replaced){
        int spaceNum = 0;
        char[] originArray = origin.toCharArray();
        for(int i=0;i<originArray.length;i++){
            if(originArray[i] == ' '){
                spaceNum++;
            }
        }
        for(char ele:originArray){
//            replaced.append(ele);
            System.out.print(ele);
        }
        int spaceCount = spaceNum;
        char[] replacedArray = new char[originArray.length+spaceNum*2];
        int i = replacedArray.length-1;
        System.out.println("length 1 "+originArray.length+" length 2 "+replacedArray.length);
        while(i>-1){
//            System.out.println("i = "+i);


            if(originArray[i-spaceCount*2] ==  ' '){
                replacedArray[i] = '0';
                replacedArray[i-1] = '2';
                replacedArray[i-2] = '%';
                i -= 3;
                spaceCount -= 1;
            }else{
                replacedArray[i] = originArray[i-spaceCount*2];
                i--;
            }
        }

//        String str = "hello";
//        replaced += str;
        for(int j=0;j<replacedArray.length;j++){
//            replaced.append(ele);
//            System.out.print(replacedArray[j]);
            replaced.append(replacedArray[j]);
        }
//        System.out.println();
//        System.out.println("array "+replacedArray.toString());
//        replaced = new String(replacedArray);
//        replaced.copyValueOf(replacedArray);
//        System.out.println("space count "+spaceNum);
    }
    public static void main(String[] args){
        String str = "we are happy";
//        char[] origin =  str.toCharArray();
        StringBuffer result =  new StringBuffer();
//        System.out.println(result);

        replace(str,result);
        System.out.println(result);
//        System.out.println("str len "+str.length()+" array len "+origin.length);
    }
}
