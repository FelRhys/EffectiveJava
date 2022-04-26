package effective.chapter_02.item_02_builder.hierarchicalbuilder;

import java.util.Objects;

public class NewYorkPizza extends Pizza{

    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private Size size;

        public Builder withSize(Size size){
            this.size = Objects.requireNonNull(size);
            return this;
        }

        @Override
        public NewYorkPizza build(){
            return new NewYorkPizza(this);
        }

        @Override
        protected Builder self(){
            return this;
        }
    }

    private NewYorkPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("NewYorkPizza with size %s and toppings %s", getSize(), toppings);
    }
}
