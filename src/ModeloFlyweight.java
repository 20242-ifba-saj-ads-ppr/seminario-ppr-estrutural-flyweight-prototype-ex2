
import java.time.Year;


public class ModeloFlyweight {

    private final String marca;
    private final String modelo;
    private final String descricao;
    private final float precoBase;

    public ModeloFlyweight(String marca, String modelo, String descricao, float precoBase) {
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
        this.precoBase = precoBase;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPrecoBase() {
        return precoBase;
    }


    public float getDiaria(int quilometragem, int ano) {
        
        int idade = ano - Year.now().getValue();

        float fatorDepreciacao = 1 - (idade / 100.0f);

        float fatorQuilometragem = 1 - (quilometragem / 100000.0f);

        float d = precoBase * fatorDepreciacao * fatorQuilometragem;

        return Math.max(d, precoBase * 0.5f);

    }

}
