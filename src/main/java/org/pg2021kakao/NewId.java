package org.pg2021kakao;

import java.util.*;

class NewId {
    public static ArrayList<Character> sen = new ArrayList<>();
    public static void lv1(){
        for(int i=0;i<sen.size();i++){
            if((int)sen.get(i)>='A'&&(int)sen.get(i)<='Z'){
                sen.set(i,(char)((int)sen.get(i)-(int)'A'+(int)'a'));;
            }
        }
    }
    public static void lv2(){
        for(int i=0;i<sen.size();i++){
            char tmp = sen.get(i);
            if((int)tmp<='z'&&(int)tmp>='a')
                continue;
            if(tmp=='.'||tmp=='-'||tmp=='_')
                continue;
            if((int)tmp>='0'&&(int)tmp<='9')
                continue;
            sen.set(i,'!');
        }
        ArrayList<Character> tmp = new ArrayList<>();
        for(int i=0;i<sen.size();i++){
            if(sen.get(i)!='!'){
                tmp.add(sen.get(i));
            }
        }
        sen=tmp;
    }
    public static void lv3(){
        ArrayList<Character> arr = new ArrayList<>();
        int cnt=0;
        for(int i=0;i<sen.size();i++){
            char tmp = sen.get(i);
            if(tmp=='.'){
                if(cnt!=0)
                    sen.set(i,'!');
                cnt+=1;
            }else{
                cnt=0;
            }
        }
        for(int i=0;i<sen.size();i++){
            if(sen.get(i)!='!'){
                arr.add(sen.get(i));
            }
        }
        sen=arr;
    }
    public static void lv4(){
        if(sen.size()==0)
            return;
        if(sen.get(0)=='.'){
            sen.set(0,'!');
        }
        if(sen.get(sen.size()-1)=='.'){
            sen.set(sen.size()-1,'!');
        }
        ArrayList<Character> arr = new ArrayList<>();
        for(int i=0;i<sen.size();i++){
            if(sen.get(i)!='!'){
                arr.add(sen.get(i));
            }
        }
        sen=arr;
    }
    public static void lv5(){
        if(sen.size()==0){
            sen.add('a');
        }
    }
    public static void lv6(){
        ArrayList<Character> arr = new ArrayList<>();
        for(int i=0;i<sen.size();i++){
            arr.add(sen.get(i));
            if(i>13)
                break;
        }
        if(arr.get(arr.size()-1)=='.'){
            arr.set(arr.size()-1,'!');
        }
        ArrayList<Character> arr2 = new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!='!'){
                arr2.add(arr.get(i));
            }
        }
        sen=arr2;
    }
    public static void lv7(){
        while(sen.size()<3){
            sen.add(sen.get(sen.size()-1));
        }
    }
    public String solution(String new_id) {
        for(int i=0;i<new_id.length();i++){
            sen.add(new_id.charAt(i));
        }
        lv1();
        lv2();
        lv3();
        lv4();
        lv5();
        lv6();
        lv7();
        String result=new String();
        for(int i=0;i<sen.size();i++){
            result+=sen.get(i);
        }
        System.out.println(result);
        return result;

    }
}