class Animal{
    void cry(){}
}

class Dog extends Animal{
    void cry(){
        System.out.println("汪汪");
    }
}

class Cat extends Animal{
    void cry(){
        System.out.println("喵喵");
    }
}

public class CryTest{
    public static void main(String[] agrs){
        Animal a;
        a = new Dog();
        a.cry();
        a = new Cat();
        a.cry();
    }
}