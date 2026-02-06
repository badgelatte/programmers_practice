public class cardGame {

}
class A{
    A() {
        this.fn();
        System.out.println("make A");
    }
    public void fn() {
        System.out.println("A");
    }

    public void fn(int a) {
        System.out.println("A" + a);
    }
}

class C extends A{
    public void fn() {
        System.out.println("C");
    }
}
class B extends A{
    B(){
        System.out.println("make B");
    }
    public void fn(){
        System.out.println("B");
    }

    public void fn(int a) {
        System.out.println("B" + a);
    }
}

class S{
    public static void main(String[] args) {
        B a = new B();
//        a.fn();
        System.out.println();
        a.fn();
    }
}