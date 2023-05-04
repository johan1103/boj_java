package org.bj13911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ps13911 {

    public static long [] macDist = new long[10004];
    public static long[] starDist = new long[10004];
    public static ArrayList<Node>[] map = new ArrayList[100004];
    public static ArrayList<Integer> macs = new ArrayList<>();
    public static ArrayList<Integer> stars = new ArrayList<>();
    public static long INF_NUM = 20000000000L;
    public static int N;
    public static int M;

    public static class Node{
        public int node;
        public int cost;
        public Node(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public static void setMemory(){
        for(int i=0;i<10004;i++){
            macDist[i]=INF_NUM;
            starDist[i]=INF_NUM;
            map[i] = new ArrayList<>();
        }
    }

    public static class Pair{
        public int node;
        public long dist;
        public Pair(int node,long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public static void macDijkstra(){
        PriorityQueue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dist > o2.dist ? 1:-1;
            }
        });
        for(int i=0;i<macs.size();i++){
            macDist[macs.get(i)]=0;
            qu.add(new Pair(macs.get(i),0));
        }
        while(!qu.isEmpty()){
            int node = qu.peek().node;
            long dist = qu.peek().dist;
            qu.remove();
            for(int i=0;i<map[node].size();i++){
                int nNode = map[node].get(i).node;
                long nDist = dist+map[node].get(i).cost;
                if(nDist<macDist[nNode]){
                    macDist[nNode]=nDist;
                    qu.add(new Pair(nNode,nDist));
                }
            }
        }
    }
    public static void starDijkstra(){
        PriorityQueue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dist > o2.dist ? 1:-1;
            }
        });
        for(int i=0;i<stars.size();i++){
            starDist[stars.get(i)]=0;
            qu.add(new Pair(stars.get(i),0));
        }
        while(!qu.isEmpty()){
            int node = qu.peek().node;
            long dist = qu.peek().dist;
            qu.remove();
            //System.out.println("dist "+dist);
            for(int i=0;i<map[node].size();i++){
                int nNode = map[node].get(i).node;
                long nDist = dist+map[node].get(i).cost;
                if(nDist<starDist[nNode]){
                    starDist[nNode]=nDist;
                    qu.add(new Pair(nNode,nDist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        setMemory();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int s,e,c;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            //System.out.println("s "+s+", e "+e+", c "+c);
            map[s].add(new Node(e,c));
            map[e].add(new Node(s,c));
        }
        int macSize,starSize;
        long maxMac,maxStar;
        st = new StringTokenizer(br.readLine()," ");
        macSize = Integer.parseInt(st.nextToken());
        maxMac = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<macSize;i++){
            int macNum = Integer.parseInt(st.nextToken());
            macs.add(macNum);
        }
        st = new StringTokenizer(br.readLine()," ");
        starSize = Integer.parseInt(st.nextToken());
        maxStar = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<starSize;i++){
            int starNum = Integer.parseInt(st.nextToken());
            stars.add(starNum);
        }
        macDijkstra();
        starDijkstra();
        long result=INF_NUM;
        for(int i=1;i<=N;i++){
            if(macDist[i]<=maxMac && starDist[i]<=maxStar && macDist[i]!=0 && starDist[i]!=0){
                result = Math.min(result, macDist[i]+starDist[i]);
            }
        }
        if(result==INF_NUM){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }
}
