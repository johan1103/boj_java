package org.bj18769;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ps18769 {

    public static ArrayList<Pair> map = new ArrayList<>();
    public static class Pair{
        public int first;
        public int second;
        public int cost;
        public Pair(int first,int second, int cost){
            this.first=first;
            this.second=second;
            this.cost=cost;
        }
    }
    public static int row;
    public static int col;
    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            for(int i=0;i<row;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<col-1;j++){
                    int dist = Integer.parseInt(st2.nextToken());
                    map.add(new Pair(i*col+j,i*col+j+1,dist));
                }
            }
            for(int i=0;i<row-1;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<col;j++){
                    int dist = Integer.parseInt(st2.nextToken());
                    map.add(new Pair(i*col+j,(i+1)*col+j,dist));
                }
            }
            //map.sort(map,(a,b)->a.cost-b.cost);
        }
    }
}
