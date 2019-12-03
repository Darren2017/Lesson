import java.io.*;
import java.util.*;

public class Dictionary {
    public static void main(String[] args){
        Map<String, String> dic = new HashMap<String, String>();
        File efile = new File("english.txt");
        File cfile = new File("chinese.txt");
        BufferedReader ereader = null;
        BufferedReader creader = null;
        try{
            ereader = new BufferedReader(new FileReader(efile));
            creader = new BufferedReader(new FileReader(cfile));
            String eString = null;
            String cString = null;
            while ((eString = ereader.readLine()) != null && (cString = creader.readLine()) != null) {
                dic.put(eString, cString);
            }
            ereader.close();
            creader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ereader != null) {
                try {
                    ereader.close();
                } catch (IOException e1) {
                }
            }
            if (creader != null) {
                try {
                    creader.close();
                } catch (IOException e1) {
                }
            }
        }

        while(true){
            String ch, search;
            Scanner in = new Scanner(System.in);
            System.out.print("英译汉：1\n汉译英：2\n");
            ch = in.next();
            if(ch.equals("1")){
                System.out.print("输入要查询的英文：");
                search = in.next();
                String ans = dic.get(search);
                if(ans != ""){
                    System.out.print("中文:" + ans + "\n");
                }else{
                    System.out.print("没有结果\n");
                }
            }else if(ch.equals("2")){
                System.out.print("输入要查询的中文：");
                search = in.next();
                boolean flag = true;
                Iterator<String> iterator = dic.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    String value = dic.get(key);
                    if((value.indexOf(search)) != -1){
                        System.out.print("英文：" + key + "\n");
                        flag = false;
                    }
                }
                if(flag){
                    System.out.print("没有结果\n");
                }
            }else{
                System.out.print("选择错误，请重新选择功能\n");
            }
        }
    }
}