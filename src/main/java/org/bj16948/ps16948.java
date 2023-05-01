package org.bj16948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ps16948 {
    static int map[][] = new int[205][205];
    static int visit[][] = new int[205][205];
    static int dx[]=new int[]{-1,1,-2,2,-1,1};
    static int dy[]=new int[]{-2,-2,0,0,2,2};

    static int totalCnt=0;
    static int N,M;

    public static void setMemory(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visit[j][i]=-1;
            }
        }
    }

    public static void bfs(int sx,int sy){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx,sy,0));
        while (!queue.isEmpty()){
            int x = queue.peek().x;
            int y = queue.peek().y;
            int d = queue.peek().dist;
            queue.remove();
            for(int i=0;i<6;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M){
                    continue;
                }
                if(visit[nx][ny]==-1){
                    visit[nx][ny]=d+1;
                    queue.add(new Node(nx,ny,d+1));
                }
            }
        }
    }
    public static class Node{
        public int x;
        public int y;
        public int dist;
        public Node(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=N;
        setMemory();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int sy=Integer.parseInt(st.nextToken());
        int sx=Integer.parseInt(st.nextToken());
        int ey=Integer.parseInt(st.nextToken());
        int ex=Integer.parseInt(st.nextToken());
        bfs(sx,sy);
        System.out.println(visit[ex][ey]);
    }
}
