import java.util.*;

public class Dollor{
    public static void main(String[] args){
        double sum;
        Scanner in = new Scanner(System.in);
        sum = in.nextDouble();
        int d, q, di, n, p;
        d = (int)sum;
        sum -= d;
        q = (int)(sum / 0.25);
        sum -= q * 0.25;
        di = (int)(sum / 0.1);
        sum -= di * 0.1;
        n = (int)(sum / 0.05);
        sum -= n * 0.05;
        p = (int)(sum / 0.01);
        System.out.print(d + " " + q + " " + di + " " + n + " " + p);
    }
}