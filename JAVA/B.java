class B extends A{
    void speak(int i){
        System.out.println("B.speak.i");
    }

    public static void main(String[] args) {
        A a = new B();
        a.speak(3);
    }
}