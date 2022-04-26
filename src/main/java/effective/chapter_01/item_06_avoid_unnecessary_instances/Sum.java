package effective.chapter_01.item_06_avoid_unnecessary_instances;

// Hideously slow program! Can you spot the object creation? (Page 24)
public class Sum {
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}