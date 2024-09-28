package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int andar;
    //Construtor:
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int andar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.andar = andar;
    }
    @Override
    public double calcularPagamentoMensal() {
        // A seguinte fórmula fornecida no enunciado não está correta, por isso os valores elevados
        return this.valorImovel * Math.pow(1 + this.taxaJurosAnual / 12, this.prazoFinanciamento * 12) /
                Math.pow(1 + this.taxaJurosAnual / 12, this.prazoFinanciamento * 12 - 1);
    }
    @Override
    public void mostrarDados() {
        System.out.printf("||| Vagas de garagem: %d\n", this.vagasGaragem);
        System.out.printf("||| Número do andar: %d\n", this.andar);
        super.mostrarDados();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vagas de garagem: ").append(this.vagasGaragem).append("\n");
        sb.append("Número do andar: ").append(this.andar).append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
