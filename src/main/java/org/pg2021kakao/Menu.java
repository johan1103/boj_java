package org.pg2021kakao;

import java.util.*;

class Menu {
    public static int[] menuPick = new int[30];
    public static int[] maxMenu = new int[20];

    public static void setMemory(){
        for(int i=0;i<30;i++){
            menuPick[i]=0;
        }
    }
    public static String menus;
    public static ArrayList<String> menuList = new ArrayList<>();
    public static ArrayList<String>[] result = new ArrayList[12];
    public static String buildString(){
        String sen = new String();
        for(int i=0;i<28;i++){
            if(menuPick[i]==1){
                sen+=(char)(i+(int)'A');
            }
        }
        return sen;
    }
    public static void checkMenus(int threshold){
        int menuCnt=0;
        for(int i=0;i<menuList.size();i++){
            String m = menuList.get(i);
            int cnt=0;
            for(int j=0;j<m.length();j++){
                int idx=(int)m.charAt(j)-(int)'A';
                if(menuPick[idx]==1){
                    cnt+=1;
                }
            }
            if(cnt==threshold){
                menuCnt+=1;
            }
        }
        if(menuCnt>=2 && menuCnt>maxMenu[threshold]){
            result[threshold] = new ArrayList<>();
            String sen = buildString();
            result[threshold].add(sen);
            maxMenu[threshold]=menuCnt;
        }else if(menuCnt>=2 && menuCnt==maxMenu[threshold]){
            String sen = buildString();
            result[threshold].add(sen);
        }
        //System.out.println("th "+threshold+" build "+buildString()+" cnt "+menuCnt);
    }
    public static void bruteMenu(int depth,int idx,int threshold){
        if(depth==threshold){
            checkMenus(threshold);
        }
        for(int i=idx;i<menus.length();i++){
            int alphaIndex = (int)menus.charAt(i)-(int)'A';
            menuPick[alphaIndex]=1;
            bruteMenu(depth+1,i+1,threshold);
            menuPick[alphaIndex]=0;
        }
    }

    public static void initialize(){
        for(int i=0;i<12;i++){
            result[i] = new ArrayList<>();
        }
    }
    public String[] solution(String[] orders, int[] course) {
        initialize();
        for(int i=0;i<orders.length;i++){
            menuList.add(orders[i]);
        }
        for(int i=0;i<course.length;i++){
            for(int j=0;j<menuList.size();j++){
                menus=menuList.get(j);
                setMemory();
                bruteMenu(0,0,course[i]);
            }
        }
        for(int i=0;i<12;i++){
            /*
            System.out.print(i+" : ");
            for(int j=0;j<result[i].size();j++){
                System.out.print(result[i].get(j)+" ");
            }
            System.out.print(" max "+maxMenu[i]);
            System.out.print("\n");
            */
        }
        //System.out.print(course.length);
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<12;i++){
            for(int j=0;j<result[i].size();j++){
                String tmp = result[i].get(j);
                boolean flag = false;
                for(int z=0;z<res.size();z++){
                    if(res.get(z).equals(tmp)){
                        flag=true;
                        break;
                    }
                }
                if(flag==false){
                    res.add(tmp);
                }
            }
        }
        Collections.sort(res);
        /*
        System.out.print("\n");
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i)+" ");
        }
        */
        String[] answer = new String[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i]=res.get(i);
        }
        return answer;
    }
}
