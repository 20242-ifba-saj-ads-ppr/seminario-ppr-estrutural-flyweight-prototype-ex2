public class FlyweightPatternDemo {
    private static final String[] sizes = {"Brotinho", "Media", "Familia"};

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            Pizza pizza = PizzaFactory.getPizza(getRandomSize());
            pizza.preparar();
        }
    }

    private static String getRandomSize() {
        return sizes[(int) (Math.random() * sizes.length)];
    }
}
