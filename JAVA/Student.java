import java.util.*;

public class Student{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String select;
        while(true){
            Student.print();
            select = in.next();
            switch(select){
                case "0":{
                    System.out.println("程序结束");
                    return;
                }
                case "1":{
                    System.out.println("\n****************\n录入学生成绩信息\n****************\n");
                    break;
                }
                case "2":{
                    System.out.println("\n****************\n显示学生成绩信息\n****************\n");
                    break;
                }
                default:{
                    System.out.println("\n*****************\n选择有误请重新输入\n****************\n");
                }
            }
        }
    }

        static void print(){
        System.out.println("    --------------------------------------");
        System.out.println("    *                                    *");
        System.out.println("    *     欢迎进入学生成绩管理系统       *");
        System.out.println("    *                                    *");
        System.out.println("    --------------------------------------");
        System.out.println("请选择您的操作：");
        System.out.println("            1. 录入学生成绩信息；");
        System.out.println("            2. 显示学生成绩信息；");
        System.out.println("            0. 退出；");
        System.out.println("请选择按键(0-2)；");
    }
}