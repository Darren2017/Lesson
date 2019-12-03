import java.util.*;

public class Bomb{
    public static void main(String[] args){
         while(true){
            try{
                Read.read();
            }catch(BombException e){
                System.out.println(e);
                continue;
            }
            System.out.println("输入无误");
        }
    }
}