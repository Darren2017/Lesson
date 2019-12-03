public class CatchMoreExceptionExample {
    public static void main(String[] args){
        try{
            int[] a = new int[4];
            a[4]=9;
        }
        catch(Exception e){
            System.out.println("异常种类及消息为："+e.toString()+"。");
        }
    }
}