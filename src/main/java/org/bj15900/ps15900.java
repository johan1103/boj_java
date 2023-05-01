package org.bj15900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ps15900 {
    static int visit[] = new int[500004];
    static int totalCnt=0;
    static int N;
    static ArrayList<Integer>[] map = new ArrayList[500004];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        /**
         * ************중요****************
         * C++과 달리 전부 돌면서 배열을 ArrayList로 초기화해줘야 함.
         */
        for (int i = 1; i <= N; i++) {
            map[i]=new ArrayList<>();
        }
        /**
         * ***********************************
         */
        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
            map[firstNode].add(secondNode);
            map[secondNode].add(firstNode);
        }

        treeDepthDfs(0,1);
        if(totalCnt%2==0){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
    public static void treeDepthDfs(int depth,int node){
        boolean flag=false;
        visit[node]=1;
        for(int i=0;i<map[node].size();i++){
            int nextNode = map[node].get(i);
            if(visit[nextNode]==0){
                flag=true;
                treeDepthDfs(depth+1,nextNode);
            }
        }
        if(!flag){
            totalCnt+=depth;
        }
    }


}
