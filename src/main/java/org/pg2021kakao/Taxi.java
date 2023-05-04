package org.pg2021kakao;
import java.util.*;

class Taxi {
    public static int INF = 204;
    public static int INF_NUM = 2000000009;
    public static ArrayList<Node>[] map = new ArrayList[INF];
    public static int[] aDist = new int[INF];
    public static int[] bDist = new int[INF];
    public static int[] tDist = new int[INF];

    void setMemory(){
        for(int i=0;i<INF;i++){
            aDist[i]=INF_NUM;
            bDist[i]=INF_NUM;
            tDist[i]=INF_NUM;
            map[i]=new ArrayList<>();
        }
    }
    public static void bDijkstra(int sNode){
        PriorityQueue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dist > o2.dist ? 1:-1;
            }
        });
        bDist[sNode]=0;
        qu.add(new Pair(sNode,0));
        while(!qu.isEmpty()){
            int node = qu.peek().node;
            int dist = qu.peek().dist;
            qu.remove();
            //System.out.println("dist "+dist+" node "+node);
            for(int i=0;i<map[node].size();i++){
                int nNode=map[node].get(i).node;
                int nDist=dist+map[node].get(i).cost;
                if(nDist<bDist[nNode]){
                    bDist[nNode]=nDist;
                    qu.add(new Pair(nNode,nDist));
                }
            }
        }
    }
    public static void aDijkstra(int sNode){
        PriorityQueue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dist > o2.dist ? 1:-1;
            }
        });
        aDist[sNode]=0;
        qu.add(new Pair(sNode,0));
        while(!qu.isEmpty()){
            int node = qu.peek().node;
            int dist = qu.peek().dist;
            qu.remove();
            //System.out.println("dist "+dist+" node "+node);
            for(int i=0;i<map[node].size();i++){
                int nNode=map[node].get(i).node;
                int nDist=dist+map[node].get(i).cost;
                if(nDist<aDist[nNode]){
                    aDist[nNode]=nDist;
                    qu.add(new Pair(nNode,nDist));
                }
            }
        }
    }

    public static void taxiDijkstra(int sNode){
        PriorityQueue<Pair> qu = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dist > o2.dist ? 1:-1;
            }
        });
        tDist[sNode]=0;
        qu.add(new Pair(sNode,0));
        while(!qu.isEmpty()){
            int node = qu.peek().node;
            int dist = qu.peek().dist;
            qu.remove();
            //System.out.println("dist "+dist+" node "+node);
            for(int i=0;i<map[node].size();i++){
                int nNode=map[node].get(i).node;
                int nDist=dist+map[node].get(i).cost;
                if(nDist<tDist[nNode]){
                    tDist[nNode]=nDist;
                    qu.add(new Pair(nNode,nDist));
                }
            }
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        setMemory();
        int answer = 0;
        for(int i=0;i<fares.length;i++){
            int start=fares[i][0];
            int end=fares[i][1];
            int cost=fares[i][2];
            map[start].add(new Node(end,cost));
            map[end].add(new Node(start,cost));
        }
        taxiDijkstra(s);
        aDijkstra(a);
        bDijkstra(b);
        int result=INF_NUM;
        for(int i=1;i<=n;i++){
            int tmp =aDist[i]+bDist[i]+tDist[i];
            if(tmp<result){
                result=tmp;
            }
        }
        return result;
    }


    public static class Pair{
        public int dist;
        public int node;
        public Pair(int node,int dist){
            this.dist=dist;
            this.node=node;
        }
    }
    public static class Node{
        public int node;
        public int cost;
        public Node(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
}


