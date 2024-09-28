package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
    //Construtor:
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double totalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
    public void mostrarDados() {
        System.out.printf("||| Valor do imóvel: %.2f R$\n", valorImovel);
        System.out.printf("||| Prazo de financiamento: %d anos\n", prazoFinanciamento);
        System.out.printf("||| Taxa de juros: %.2f %% a.a.\n", taxaJurosAnual);
        System.out.printf("||| Valor final do imóvel: %.2f R$\n", totalPagamento());
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Valor do imóvel: ").append(getValorImovel()).append("\n");
        sb.append("Prazo de financiamento: ").append(getPrazoFinanciamento()).append("\n");
        sb.append("Taxa de juros: ").append(getTaxaJurosAnual()).append("\n");
        sb.append("Valor final do imóvel: ").append(totalPagamento()).append("\n\n");
        return sb.toString();
    }
}
