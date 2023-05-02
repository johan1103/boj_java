package org.bj5002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ps5002 {
    public static void main(String[] args) throws IOException {
        Queue<Character> qu = new LinkedList<>();
        int male,female;
        int C=0;
        String line;
        male=0;
        female=0;
        int totalMale=0,totalFemale=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C=Integer.parseInt(br.readLine());
        line=br.readLine();
        for(int i=0;i<line.length();i++){
            qu.add(line.charAt(i));
        }
        char gender = qu.peek();
        if(gender=='M')
            male+=1;
        else
            female+=1;
        qu.remove();
        while (!qu.isEmpty()){
            gender = qu.peek();
            if(gender=='W')
                female+=1;
            else
                male+=1;
            //System.out.println(female + " fm, "+male+" m, total(fm,m) "+totalFemale+" "+totalMale);
            qu.remove();
            if(male==1&&female==1){
                if(totalMale<totalFemale){
                    male=0;
                    totalMale+=1;
                }else{
                    female=0;
                    totalFemale+=1;
                }
            }
            else if(male==2){
                totalMale+=1;
                male=1;
                if(Math.abs(totalMale-totalFemale)>C){
                    totalMale-=1;
                    break;
                }
            }
            else{
                totalFemale+=1;
                female=1;
                if(Math.abs(totalMale-totalFemale)>C){
                    totalFemale-=1;
                    break;
                }
            }
        }
        if(Math.abs((totalMale+male)-(totalFemale+female))<=C){
            totalMale+=male;
            totalFemale+=female;
            male=0;
            female=0;
        }
        System.out.println(totalFemale+totalMale);
    }
}
