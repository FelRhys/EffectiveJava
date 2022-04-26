package effective.chapter_02.item_03_singleton;

public class SingletonExamples {

    public static void main(String[] args) {
        SingletonA a = SingletonA.instance;
        SingletonB b = SingletonB.getInstance();
        SingletonC c = SingletonC.INSTANCE;

        a.importantMethod();
        b.importantMethod();
        c.importantMethod();
    }
}

//final member approach
class SingletonA{
    public static final SingletonA instance = new SingletonA();
    private SingletonA(){

    }

    public void importantMethod(){
        //example
    }
}

//static factory method approach
class SingletonB{
    private static final SingletonB instance = new SingletonB();
    private SingletonB(){}
    public static SingletonB getInstance(){
        return instance;
    }
    public void importantMethod(){
        //example
    }
}

//single element enum approach
enum SingletonC{
    INSTANCE;

    public void importantMethod(){
        //example
    }
}