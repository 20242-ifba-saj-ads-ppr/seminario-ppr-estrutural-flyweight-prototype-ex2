
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int interacoes = 1000000;

        List<String> marcas = Arrays.asList("Chevrolet", "Chevrolet", "VW", "Ford", "BYD");
        List<String> modelos = Arrays.asList("Tracker", "Onix", "Gol", "Ranger", "Seal");
        List<String> cores = Arrays.asList("Branco", "Preto", "Prata", "Vermelho", "Azul", "Verde", "Amarelo", "Rosa",
                "Roxo", "Laranja");
        String descricao = "Lorem ipsum dolor sit amet. Hic galisum voluptate qui similique ratione At distinctio facere eum blanditiis quia aut tempore quod aut vero laudantium. Aut libero tempore est minus magni et iure voluptatem aut galisum corrupti et quia unde est eligendi galisum et deserunt velit. Ex animi galisum aut aspernatur dolor At quas cumque et eligendi ducimus qui perspiciatis aspernatur. Ut quam labore et voluptatem dignissimos sed delectus officiis aut quas cumque eum officia asperiores non libero doloremque. ";

        System.out.println();
        System.out.println();
        System.out.println(" Teste com " + interacoes + " veículos");

        List<ModeloFlyweight> catalogo = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            ModeloFlyweight modelo = CatalogoFactory.getModelo(
                    marcas.get(i),
                    modelos.get(i),
                    60 + (10 * (i % 6)),
                    i + descricao);
            catalogo.add(modelo);
        }

        imprimirMemoria("Memoria antes testes: ");

        List<VeiculoConcreto> veiculos = new ArrayList<>();

        System.out.println("Instanciando "+ interacoes +" veículos com flyweight");

        for (int i = 0; i < interacoes; i++) {
            VeiculoConcreto v = new VeiculoConcreto(
                    "ABC" + i,
                    "100" + i,
                    cores.get(i % cores.size()),
                    1000 * (i % 80),
                    2025 - (i % 6),
                    catalogo.get(i % catalogo.size()));

            veiculos.add(v);

            imprimirProgresso(i, interacoes);

        }

        System.out.println();
        imprimirMemoria("Memoria com flyweight");


        veiculos = null;
        catalogo = null;
        System.gc();
        imprimirMemoria("Memoria após limpeza");


        System.out.println("Iniciando teste sem flyweight");

        List<VeiculoCompleto> veiculosCompletos = new ArrayList<>();

        for (int i = 0; i < interacoes; i++) {
            VeiculoCompleto v = new VeiculoCompleto(
                    "ABC" + i, // Placa
                    "100" + i, // Chassi
                    cores.get(i % cores.size()), // Cor
                    1000 * (i % 80), // Quilometragem
                    2025 - (i % 6), // Ano
                    marcas.get(i % marcas.size()), // Marca
                    modelos.get(i % modelos.size()), // Modelo
                    i + descricao,
                    60 + (10 * (i % 6)) // Preço Base
            );

            veiculosCompletos.add(v);

            imprimirProgresso(i, interacoes);
        }

        imprimirMemoria("Resultada sem flyweight");

    }

    public static void imprimirMemoria(String mensagem) {
        Runtime runtime = Runtime.getRuntime();
        long memoriaUsada = runtime.totalMemory() - runtime.freeMemory();
        long memoriaMaxima = runtime.maxMemory();

        System.out.println();
        System.gc();
        System.out.println(mensagem);
        System.out.println("Memória total: " + runtime.totalMemory() / (1024 * 1024) + " MB");
        System.out.println("Memória livre: " + runtime.freeMemory() / (1024 * 1024) + " MB");
        System.out.println("Memória usada: " + memoriaUsada / (1024 * 1024) + " MB");
        System.out.println("Memória máxima disponível: " + memoriaMaxima / (1024 * 1024) + " MB");
        System.out.println("==============================");
        System.out.println();
    }

    public static void imprimirProgresso(int i, int interacoes) {
        int progressoAtual = (int) ((i * 100.0) / interacoes);
        int progressoAnterior = (int) (((i - 1) * 100.0) / interacoes);

        if (progressoAtual / 5 > progressoAnterior / 5) {
            System.out.print(((progressoAtual / 5) * 5) + "%|");
        }
    }
}
