import java.util.*;

public class Read{
    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }

    public static void read() throws BombException{
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s = scan.next();
        if(appearNumber(s, "b") >=2 && appearNumber(s, "o") >=1 && appearNumber(s, "m") >= 1){
            throw new BombException("Bomb!!!!");
        }
    }
}