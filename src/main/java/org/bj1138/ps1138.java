package org.bj1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ps1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] checking = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            int left=Integer.parseInt(st.nextToken());
            arr[i]=left;
        }
        for(int i=0;i<n;i++){
            int ptr = 0;
            while (checking[ptr] != 0) {
                ptr += 1;
            }
            for(int j=0;j<arr[i];j++) {
                ptr+=1;
                while (checking[ptr] != 0) {
                    ptr += 1;
                }
            }
            checking[ptr]=i+1;
        }

        for(int i=0;i<n;i++){
            System.out.print(checking[i] + " ");
        }
    }
}
