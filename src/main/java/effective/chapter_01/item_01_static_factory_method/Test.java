package effective.chapter_01.item_01_static_factory_method;

import java.time.Instant;
import java.util.Date;

public class Test {

    //some examples for static factory methods
    public static void main(String[] args) {

        Instant instant = Instant.now();

        Date from = Date.from(instant);

        Boolean example = Boolean.valueOf(false);
    }
}
