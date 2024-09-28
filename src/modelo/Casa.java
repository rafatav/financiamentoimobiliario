package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private double seguro;
    private double areaConstruida;
    private double tamanhoTerreno;
    //Construtor:
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida,
                double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.seguro = 80;
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
        }

    private void conferirJuros(double valorJuros, double seguro) throws DescontoMaiorDoQueJurosException {
        if (valorJuros < seguro) {
            throw  new DescontoMaiorDoQueJurosException("O seguro é maior do que o valor dos juros.");
        }
    }
    @Override
    public double calcularPagamentoMensal() {
        double valorJuros = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12)) -
                (this.valorImovel / (this.prazoFinanciamento * 12));
        try {
            conferirJuros(valorJuros, this.seguro);
        } catch (DescontoMaiorDoQueJurosException e) {
            this.seguro = valorJuros;
        }
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12)) + this.seguro;
    }
    @Override
    public void mostrarDados() {
        System.out.printf("||| Área construída: %.2f m2\n", this.areaConstruida);
        System.out.printf("||| Área do terreno: %.2f m2\n", this.tamanhoTerreno);
        super.mostrarDados();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Área construída: ").append(this.areaConstruida).append("\n");
        sb.append("Área do terreno: ").append(this.tamanhoTerreno).append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
