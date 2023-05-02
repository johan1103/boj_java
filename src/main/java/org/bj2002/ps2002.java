package org.bj2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ps2002 {
    public static int arr[] = new int[1004];
    public static Queue<String> inCars = new LinkedList<>();
    public static Queue<String> outCars = new LinkedList<>();
    public static List<String> markedCars = new ArrayList<>();
    public static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String car = br.readLine();
            inCars.add(car);
        }
        for(int i=0;i<n;i++){
            String car = br.readLine();
            outCars.add(car);
        }
        markingCars();
        System.out.println(result);
    }

    public static void markingCars(){
        while (!inCars.isEmpty()){
            boolean flag = false;
            String car = inCars.peek();
            inCars.remove();
            for(int i=0;i<markedCars.size();i++){
                String mc = markedCars.get(i);
                if(Objects.equals(mc, car)){
                    flag=true;
                    break;
                }
            }
            if(flag==true)
                continue;
            /**
             * 문자열 비교할 때 == 말고 equals 써야함 주의!
             */
            while(!(Objects.equals(outCars.peek(), car))){
                markedCars.add(outCars.peek());
                outCars.remove();
                result+=1;
            }
            outCars.remove();
        }
    }
}
