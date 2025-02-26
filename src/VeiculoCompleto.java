import java.time.Year;

public class VeiculoCompleto extends AbstractVeiculo {
    private final String marca;
    private final String modelo;
    private final String descricao;
    private final float precoBase;

    private final String placa;
    private final String chassi;
    private final String cor;
    private final int quilometragem;
    private final int ano;

    public VeiculoCompleto(String marca, String modelo, String descricao, float precoBase, String placa, String chassi, String cor, int quilometragem, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
        this.precoBase = precoBase;

        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.ano = ano;
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

    public String getPlaca() {
        return placa;
    }

    public String getChassi() {
        return chassi;
    }

    public String getCor() {
        return cor;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public int getAno() {
        return ano;
    }

    
    public float calculaPrecoDiaria() {
        int idade = ano - Year.now().getValue();
        float fatorDepreciacao = 1 - (idade / 100.0f);
        float fatorQuilometragem = 1 - (quilometragem / 100000.0f);
        float d = precoBase * fatorDepreciacao * fatorQuilometragem;
        return Math.max(d, precoBase * 0.5f);
    }
}