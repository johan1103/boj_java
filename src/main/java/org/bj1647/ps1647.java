package org.bj1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ps1647 {

    public static int[] parent = new int[100004];
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int N,M;
    public static void setMemory(){
        for(int i=0;i<100004;i++){
            parent[i]=i;
        }
    }
    public static int findParent(int node){
        if(parent[node]!=node){
            return parent[node]=findParent(parent[node]);
        }else{
            return node;
        }
    }
    public static long spanningVillage(){
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2) {
                /**
                 * o1.cost == o2.cost 일때 0을 반환하지 않으면 RuntimeError발생함...
                 */
                if(o1.cost==o2.cost)
                    return 0;
                return o1.cost >= o2.cost ? 1:-1;
            }
        });
        long result=0;
        long recentCost=0;
        for(int i=0;i<edges.size();i++){
            int f=edges.get(i).n1;
            int s=edges.get(i).n2;
            int c=edges.get(i).cost;
            int pf=findParent(f);
            int ps=findParent(s);
            if(pf!=ps){
                parent[ps]=pf;
                result+=c;
                recentCost=c;
            }
        }
        return result-recentCost;
    }

    public static void main(String[] args) throws IOException {
        setMemory();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b,c));
        }
        System.out.println(spanningVillage());
    }


    public static class Edge{
        public int n1;
        public int n2;
        public int cost;

        public Edge(int n1,int n2,int cost){
            this.n1=n1;
            this.n2=n2;
            this.cost=cost;
        }
    }
}
