import java.util.HashMap;
import java.util.Map;

public class CatalogoFactory {
    
    private static final Map<String, ModeloFlyweight> modelos = new HashMap<>();

    public static ModeloFlyweight getModelo(String marca, String modelo, float precoBase, String descricao) {
        String chave = marca + "-" + modelo + "-" + descricao + "-" + precoBase;
        if (!modelos.containsKey(chave)) {
            modelos.put(chave, new ModeloFlyweight(marca, modelo, descricao, precoBase));
        }
        return modelos.get(chave);
    }

}
