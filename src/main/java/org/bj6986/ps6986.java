package org.bj6986;

import java.util.*;

public class ps6986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Double> arr = new ArrayList<>();
        Deque<Double> deque1 = new ArrayDeque<>();
        Deque<Double> deque2 = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            double tmp = sc.nextDouble();
            arr.add(tmp);
        }
        Collections.sort(arr);
        for(double tmp : arr){
            deque1.addLast(tmp);
            deque2.addLast(tmp);
        }

        for (int i=0;i<c;i++){
            deque1.pollFirst();
            deque1.pollLast();
            deque2.pollFirst();
            deque2.pollLast();
        }
        for(int i=0;i<c;i++){
            deque2.addFirst(deque2.getFirst());
            deque2.addLast(deque2.getLast());
        }


        double total1 = 0;
        double total2 = 0;
        double size1 = deque1.size();
        double size2 = deque2.size();
        while (!deque1.isEmpty()){

            //System.out.println("deque1 "+deque1.getFirst());
            total1+=deque1.getFirst();
            deque1.pollFirst();
        }
        while (!deque2.isEmpty()){

            //System.out.println("deque2 "+deque2.getFirst());
            total2+=deque2.getFirst();
            deque2.pollFirst();
        }
        total1/=size1;
        total2/=size2;
        System.out.println(String.format("%.2f", total1)); //결과 : 3.142;
        System.out.println(String.format("%.2f", total2));
    }
}
