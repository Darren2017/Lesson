class Mbank{
    static int sum = 2000;
    static void take(int k){
        int temp = sum;
        temp -= k;
        try{
            Thread.sleep((long) (1000 * Math.random()));
        }
        catch(InterruptedException e){

        }
        sum = temp;
        System.out.println("sum="+sum);
    }
}

class Customer extends Thread{
    public void run(){
        for(int i = 0; i < 4; i++){
            Mbank.take(100);
        }
    }
}

public class Ex15{
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        c1.start();
        c2.start();
    }
}