package effective.chapter_02.item_04_non_instantiability;

public class NonInstantiableUtilityClass {

    //the private constructor automatically prevents subclasses
    private NonInstantiableUtilityClass(){
        //non-instantiable because it is a utility-class
        throw new AssertionError("in case the class is instantiated from within");
    }

    public static void doUtilityStuff(){
        //utility method
    }
}
