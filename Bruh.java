import java.util.function.*;

public class Bruh {
    public static void stuff() {
        Function<Integer, String> fn = number -> {
            return "hello: " + number;
        };

        System.out.println(fn.apply(1));
    }

    public static void main(String[] args)
    {
        Bruh.stuff();
    }
}
