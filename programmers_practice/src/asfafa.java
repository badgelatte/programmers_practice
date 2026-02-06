public class asfafa {
    
}
class Berry{
    protected String str;
    public void meth() {
        print();
    }
    public void print() {
        System.out.print(str);
    }
}

class Apple extends Berry {
    private String str;
    public void print() {
        str = "Apple";
        super.str = "Berry";
        super.print();
        System.out.println(str);
    }
}

class Soojebi{
    public static void main(String[] args) {
        Berry c = new Apple();
        c.meth();
    }
}