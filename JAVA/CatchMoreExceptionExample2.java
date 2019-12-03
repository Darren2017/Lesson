public class CatchMoreExceptionExample2 {
    public static void main(String[] args){
        try{
            int[] a=null;
            a[4] = 9;
        }
        catch(NullPointerException npe){
            System.out.println("产生空引用异常："+npe.toString());
        }
        catch(Exception e){
            System.out.println("产生异常："+e.toString());
        }
    }
}