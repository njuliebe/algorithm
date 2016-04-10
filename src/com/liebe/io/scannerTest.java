package com.liebe.io;

import java.util.Scanner;

/**
 * Created by sjtu on 16-4-2.
 */
public class scannerTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()){
//            String string = scanner.nextLine();
//            System.out.println(string);
//        }
//        while(scanner.hasNext()){
//            String string = scanner.next();
//            System.out.println(string);
//        }
        while(scanner.hasNextInt()){
            int i = scanner.nextInt();
            System.out.println(i);
        }
    }
}
