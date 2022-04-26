package effective.chapter_01.item_02_builder.hierarchicalbuilder;

import static effective.chapter_01.item_02_builder.hierarchicalbuilder.NewYorkPizza.Size.SMALL;
import static effective.chapter_01.item_02_builder.hierarchicalbuilder.Pizza.Topping.HAM;
import static effective.chapter_01.item_02_builder.hierarchicalbuilder.Pizza.Topping.ONION;
import static effective.chapter_01.item_02_builder.hierarchicalbuilder.Pizza.Topping.PEPPER;
import static effective.chapter_01.item_02_builder.hierarchicalbuilder.Pizza.Topping.SAUSAGE;

public class PizzaTest {

    public static void main(String[] args) {
        NewYorkPizza newYorkPizza = new NewYorkPizza.Builder().withSize(SMALL).addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzonePizza = new Calzone.Builder().sauceInside().addTopping(HAM).addTopping(PEPPER).build();

        System.out.println(newYorkPizza);
        System.out.println(calzonePizza);
    }
}
