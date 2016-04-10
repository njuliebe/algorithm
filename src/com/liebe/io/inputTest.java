package com.liebe.io;

import java.io.*;
import java.util.Arrays;

/**
 * Created by sjtu on 16-4-2.
 */
public class inputTest {
    public static void main(String[] args) throws FileNotFoundException,IOException{
//        InputStream input = new FileInputStream("/home/sjtu/bandwidth.sh");
//        FileReader fileReader = new FileReader("/home/sjtu/bandwidth.sh");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        char[] data = new char[10];
//
//        try{
//            String s = bufferedReader.readLine();
//            while(s != null){
//                s = bufferedReader.readLine();
//                System.out.println(s);
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        System.out.println(Arrays.toString(data));

/*        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
        while(line != null ){
            writer.write(line);
            writer.newLine();
            line = reader.readLine();
        }
        writer.flush();
        int i=0;
        StringBuffer string = new StringBuffer();
        while(i++ < 100){
            string.append(Math.random());
            string.append("\n");
        }
        writer.write(string.toString());
        writer.flush();
        writer.close();
        reader.close();
*/
/*        BufferedReader buReader = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter buWriter = new BufferedWriter(new FileWriter("test2.txt"));

        String s = buReader.readLine();
        while(s != null){
            buWriter.write(s);
            buWriter.newLine();
            s = buReader.readLine();

            buWriter.flush();
        }
        buReader.close();
        buWriter.close();
        */
        System.out.println("5"+2);
    }
}
