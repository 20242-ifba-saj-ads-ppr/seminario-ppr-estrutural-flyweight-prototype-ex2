
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        int interacoes = 1000000;

        System.err.println(" Teste com " + interacoes + " veículos");

        ModeloFlyweight suv = CatalogoFactory.getModelo("Chevrolet", "Tracker", 120," 1 Lorem ipsum dolor sit amet. Hic galisum voluptate qui similique ratione At distinctio facere eum blanditiis quia aut tempore quod aut vero laudantium. Aut libero tempore est minus magni et iure voluptatem aut galisum corrupti et quia unde est eligendi galisum et deserunt velit. Ex animi galisum aut aspernatur dolor At quas cumque et eligendi ducimus qui perspiciatis aspernatur. Ut quam labore et voluptatem dignissimos sed delectus officiis aut quas cumque eum officia asperiores non libero doloremque. ");
        
        ModeloFlyweight sedan = CatalogoFactory.getModelo("Chevrolet", "Onix", 80, " 2 Lorem ipsum dolor sit amet. Hic galisum voluptate qui similique ratione At distinctio facere eum blanditiis quia aut tempore quod aut vero laudantium. Aut libero tempore est minus magni et iure voluptatem aut galisum corrupti et quia unde est eligendi galisum et deserunt velit. Ex animi galisum aut aspernatur dolor At quas cumque et eligendi ducimus qui perspiciatis aspernatur. Ut quam labore et voluptatem dignissimos sed delectus officiis aut quas cumque eum officia asperiores non libero doloremque. ");
        
        ModeloFlyweight hatch = CatalogoFactory.getModelo("VW", "Gol", 60, " 3 Lorem ipsum dolor sit amet. Hic galisum voluptate qui similique ratione At distinctio facere eum blanditiis quia aut tempore quod aut vero laudantium. Aut libero tempore est minus magni et iure voluptatem aut galisum corrupti et quia unde est eligendi galisum et deserunt velit. Ex animi galisum aut aspernatur dolor At quas cumque et eligendi ducimus qui perspiciatis aspernatur. Ut quam labore et voluptatem dignissimos sed delectus officiis aut quas cumque eum officia asperiores non libero doloremque. ");
        
        ModeloFlyweight pickup = CatalogoFactory.getModelo("Ford", "Ranger", 150, " 4 Lorem ipsum dolor sit amet. Hic galisum voluptate qui similique ratione At distinctio facere eum blanditiis quia aut tempore quod aut vero laudantium. Aut libero tempore est minus magni et iure voluptatem aut galisum corrupti et quia unde est eligendi galisum et deserunt velit. Ex animi galisum aut aspernatur dolor At quas cumque et eligendi ducimus qui perspiciatis aspernatur. Ut quam labore et voluptatem dignissimos sed delectus officiis aut quas cumque eum officia asperiores non libero doloremque. ");

        ModeloFlyweight ev = CatalogoFactory.getModelo("BYD", "Seal", 60, " 5 Lorem ipsum dolor sit amet. Hic galisum voluptate qui similique ratione At distinctio facere eum blanditiis quia aut tempore quod aut vero laudantium. Aut libero tempore est minus magni et iure voluptatem aut galisum corrupti et quia unde est eligendi galisum et deserunt velit. Ex animi galisum aut aspernatur dolor At quas cumque et eligendi ducimus qui perspiciatis aspernatur. Ut quam labore et voluptatem dignissimos sed delectus officiis aut quas cumque eum officia asperiores non libero doloremque. ");


        List<ModeloFlyweight> modelos = Arrays.asList(suv, sedan, hatch, pickup, ev);
        List<String> cores = Arrays.asList("Branco", "Preto", "Prata", "Vermelho", "Azul", "Verde", "Amarelo", "Rosa", "Roxo", "Laranja");
        

        List<VeiculoConcreto> veiculos = new ArrayList<>();

        System.gc();

        imprimirMemoria("Inicio");

        for (int i = 0; i < interacoes; i++) {
            VeiculoConcreto v =  new VeiculoConcreto(
                "ABC" + i,
                "100" + i,
                cores.get(i % cores.size()),
                i * 1000,
                2021 - (i % 4),
                modelos.get(i % modelos.size())
            );

            veiculos.add(v);

          
            imprimirProgresso(i, interacoes);

        }

        veiculos = null;

        System.gc();

        imprimirMemoria("Com Flyweight");

        System.err.println(" ================ ");
        System.out.println("Veiculos sem flyweight");


        List<VeiculoCompleto> veiculosCompletos = new ArrayList<>();


        for (int i = 0; i < interacoes; i++) {
            VeiculoCompleto v = new VeiculoCompleto(
                    "ABC" + i,                                  // Placa
                    "100" + i,                                  // Chassi
                    cores.get(i % cores.size()),                // Cor
                    1000 * (i % 80),                                   // Quilometragem
                    2025 - (i % 6),                             // Ano
                    "Marca" + (i % 5),                          // Marca
                    "Modelo" + (i % 5),                         // Modelo
                    // Descrição
                    "Descrição do veículo " + i + "Lorem ipsum dolor sit amet. Hic galisum voluptate qui similique ratione At distinctio facere eum blanditiis quia aut tempore quod aut vero laudantium. Aut libero tempore est minus magni et iure voluptatem aut galisum corrupti et quia unde est eligendi galisum et deserunt velit. Ex animi galisum aut aspernatur dolor At quas cumque et eligendi ducimus qui perspiciatis aspernatur. Ut quam labore et voluptatem dignissimos sed delectus officiis aut quas cumque eum officia asperiores non libero doloremque. ",
                    ThreadLocalRandom.current().nextFloat() * 100000 // Preço Base
            );

            veiculosCompletos.add(v);

            imprimirProgresso(i, interacoes);
        }

        imprimirMemoria("Sem Flyweight");


    }

    public static void imprimirMemoria(String mensagem) {
        // Obter informações de memória da JVM
        Runtime runtime = Runtime.getRuntime();
        long memoriaUsada = runtime.totalMemory() - runtime.freeMemory();
        long memoriaMaxima = runtime.maxMemory();

        // Exibir as informações
        System.out.println(mensagem);
        System.out.println("Memória total: " + runtime.totalMemory() / (1024 * 1024) + " MB");
        System.out.println("Memória livre: " + runtime.freeMemory() / (1024 * 1024) + " MB");
        System.out.println("Memória usada: " + memoriaUsada / (1024 * 1024) + " MB");
        System.out.println("Memória máxima disponível: " + memoriaMaxima / (1024 * 1024) + " MB");
        System.out.println();
    }

    public static void imprimirProgresso(int i, int interacoes) {
     
        // int progresso = (i * 100) / interacoes;

        // int progressoGranulado = (progresso / 5) * 5;

        // if (progressoGranulado % 5 == 0 && progressoGranulado != 0) {
        //     System.out.println("Progresso: " + progressoGranulado + "%");
        // }
    }
}
