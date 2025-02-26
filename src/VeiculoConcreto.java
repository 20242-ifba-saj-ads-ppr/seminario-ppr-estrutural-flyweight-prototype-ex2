public class VeiculoConcreto {
    private final String placa;
    private final String chassi;
    private final String cor;
    private final int quilometragem;
    private final int ano;
    private final ModeloFlyweight modeloFlyweight;


    public VeiculoConcreto(String placa, String chassi, String cor, int quilometragem, int ano ,ModeloFlyweight modeloFlyweight) {

        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.quilometragem = quilometragem;
        this.ano = ano;
        this.modeloFlyweight = modeloFlyweight;
    }
    
    // dados flyweight

    public String getMarca() {
        return modeloFlyweight.getMarca();
    }

    public String getModelo() {
        return modeloFlyweight.getModelo();
    }

    public String getDescricao() {
        return modeloFlyweight.getDescricao();
    }

    public float  getPrecoBase() {
        return modeloFlyweight.getPrecoBase();
    }
 
    // dados concretos

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

    public ModeloFlyweight getModeloFlyweight() {
        return modeloFlyweight;
    }


    public float getDiaria() {
    
        float d = modeloFlyweight.getDiaria(quilometragem, ano);
        return d;

    }
}


