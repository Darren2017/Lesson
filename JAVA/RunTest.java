interface Runable{
    void run();
}
class Cat implements Runable{
    public void run(){
        System.out.println("猫急上树..");
    }
}

class Dog implements Runable{
    public void run(){
        System.out.println("狗急跳墙..");
    }
}
public class RunTest{
    public static void main(String[] args){
        Runable r;
        r = new Cat();
        r.run();
        r = new Dog();
        r.run();
        System.out.println("-----------");
    }
}
