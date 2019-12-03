import java.awt.Menu;
import java.util.*;

public class Example 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select = 0;
        select = sc.nextInt();
        menu(select);
        while(select == 0 || select == 2){
            menu(select);
        }
    }
    static void menu (int select){
        System.out.println("---------------------------------");
        System.out.println("*                               *");
        System.out.println("*    欢迎进入学生成绩管理系统   *");
        System.out.println("*                               *");
        System.out.println("---------------------------------");
        System.out.println("请选择您的操作：");
        System.out.println("            1. 录入学生成绩信息;");
        System.out.println("            2. 显示学生成绩信息;");
        System.out.println("            0. 退出;");
        System.out.println("请选择按键（0-2）");
        switch (select) {
            case 0: {
                System.out.println("退出");
                break;
            }
            case 1:{
                System.out.println("录入学生成绩信息");
                break;
            }
            case 2:{
                System.out.println("显示学生成绩信息");
                break;
            }
        }
        if(select != 0 && select != 2 && select != 1){
            System.out.println("输入错误，请重新输入");
        }
    }
}