import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.lang.String;

class Receipt{
    String Day;
    String Time;
    double Money;

    Scanner read = new Scanner(System.in);
    void readDay(){
        Day = read.next();
    }

    void readTime(){
        Time = read.next();
    }

    void readMoney(){
        Money = read.nextDouble();
    }

    String showDay(){
        return Day;
    }

    double showMoney(){
        return Money;
    }
}

class DateTools{
    public static int dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }
        return w;
    }
}

public class Buy{
    public static void main(String[] args){
        Receipt[] receipts = new Receipt[Integer.parseInt(args[0])];
        double[] sum = new double[7];
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

        for(int i = 0; i < Integer.parseInt(args[0]); i++){
            System.out.println("输入购物小票" + (i + 1));
            receipts[i] = new Receipt();
            receipts[i].readDay();
            receipts[i].readTime();
            receipts[i].readMoney();
        }
        for(Receipt i : receipts){
            sum[DateTools.dateToWeek(i.showDay())] += i.showMoney();
        }
        for(int i = 0; i < 7; i++){
            System.out.println(weekDays[i] + " " + sum[i] + " 元");
        }
    }
}