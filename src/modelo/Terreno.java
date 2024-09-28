package modelo;

public class Terreno extends Financiamento {
    private String zona;
    //Construtor:
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12)) * 1.02;
    }
    @Override
    public void mostrarDados() {
        System.out.println("||| Tipo de zona: " + this.zona);
        super.mostrarDados();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de zona: ").append(this.zona).append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
