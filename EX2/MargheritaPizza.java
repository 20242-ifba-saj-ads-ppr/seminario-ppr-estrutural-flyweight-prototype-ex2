public class MargheritaPizza implements Pizza {
    private final String size;

    public MargheritaPizza(String size) {
        this.size = size;
    }

    @Override
    public void preparar() {
        System.out.println("Preparando pizza margherita: " + size);
    }
}
