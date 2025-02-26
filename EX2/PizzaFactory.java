import java.util.HashMap;
import java.util.Map;

public class PizzaFactory {
    private static final Map<String, Pizza> pizzaMap = new HashMap<>();

    public static Pizza getPizza(String size) {
        return pizzaMap.computeIfAbsent(size, s -> {
            System.out.println("criando pizza de margherita  " + s);
            return new MargheritaPizza(s);
        });
    }
}
