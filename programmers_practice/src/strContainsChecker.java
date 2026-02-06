public class strContainsChecker {
    
    public static void main(String[] args) {
        System.out.println(solution("Banana", "ana"));
    }
        public static int solution(String my_string, String is_suffix) {
        int result = 0;
        for(int i = 0;i < my_string.length(); i++) {
            result = isEquals(my_string.substring(i), is_suffix);
        }

        return result;
    }

    public static int isEquals(String a, String b) {
        if(a.equals(b)) {
            return 1;
        }
        return 0;
    }
}

class Parent{
    static int total = 0;
    int v = 1;

    public Parent(){
        total += (++v);
        showValue();
    }
    public void showValue(){
        total += total;
    }
}
class Child extends Parent{
    int v = 10;

    public Child(){
        v += 2;
        total += (v++);
        showValue();
    }
    @Override
    public void showValue(){
        total += total * 2;
    }
}

class Main {
    public static void main(String[] args) {
        new Child();
        System.out.println(Parent.total);
    }
}