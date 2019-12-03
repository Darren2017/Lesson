public class TryCatchFinallyExample{ 
    public static void main(String[] args){
        try{
            int[] a=null;
            System.out.println("整型数组创建完毕！！");
            a[4] = 9;
            System.out.println("整型数组中第四个元素的数值为"+a[3]);
        
        }
        catch(ArrayIndexOutOfBoundsException aiobe){
            System.out.println("这里出现的错误类型是：数组下标越界！！");
        }
        catch(NullPointerException npe){
            System.out.println("这里出现的错误类型是：空引用！！");
        }
        finally{
            System.out.println("这里是 finally 块，无论是否抛出异常，这里总能执行！");
        }

        System.out.println("主程序正常结束！！！");
    }
}