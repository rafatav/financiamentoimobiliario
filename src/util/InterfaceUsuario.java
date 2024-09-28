package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    public double pedirValorImovel() {
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("||| Insira o valor do imóvel: ");
                double valorImovel = scanner.nextDouble();
                if (valorImovel < 0 || valorImovel > 20000000) {
                    System.out.println("||| Valor do imóvel não pode ser negativo ou maior do que 20 milhões de reais." +
                            "\n||| Insira os dados novamente.\n|||");
                } else {
                    return valorImovel;
                }
            } catch (InputMismatchException e) {
                System.out.println("||| Valor inválido. Insira os dados novamente.\n|||");
            }
        } while (true);
    }

    public int pedirPrazoFinanciamento() {
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("||| Insira o prazo de financiamento em anos: ");
                int prazoFinanciamento = scanner.nextInt();
                if (prazoFinanciamento < 0 || prazoFinanciamento > 40) {
                    System.out.println("||| Prazo de financiamento não pode ser negativo ou maior do que 40 anos." +
                            "\n||| Insira os dados novamente.\n|||");
                } else {
                    return prazoFinanciamento;
                }
            } catch (InputMismatchException e) {
                System.out.println("||| Valor inválido. Insira os dados novamente.\n|||");
            }
        } while (true);
    }

    public double pedirTaxaJuros() {
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("||| Insira a taxa de juros desejada: ");
                double taxaJuros = scanner.nextDouble();
                if (taxaJuros < 0 || taxaJuros > 20) {
                    System.out.println("||| Taxa de juros não pode ser negativa ou maior do que 20%." +
                            "\n||| Insira os dados novamente.\n|||");
                } else {
                    return taxaJuros;
                }
            } catch (InputMismatchException e) {
                System.out.println("||| Valor inválido. Insira os dados novamente.\n|||");
            }
        } while (true);
    }

    public int pedirAreaConstruida() {
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("||| Insira a área construída: ");
                int areaConstruida = scanner.nextInt();
                if (areaConstruida < 0 || areaConstruida > 1000) {
                    System.out.println("||| Área construída não pode ser menor do que 0 ou maior do que 1000." +
                            "\n||| Insira os dados novamente.\n|||");
                } else {
                    return areaConstruida;
                }
            } catch (InputMismatchException e) {
                System.out.println("||| Valor inválido. Insira os dados novamente.\n|||");
            }
        } while (true);
    }

    public int pedirAreaTotal() {
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("||| Insira a área total: ");
                int areaTotal = scanner.nextInt();
                if (areaTotal < 0 || areaTotal > 1000) {
                    System.out.println("||| Área total não pode ser menor do que 0 ou maior do que 1000." +
                            "\n||| Insira os dados novamente.\n|||");
                } else {
                    return areaTotal;
                }
            } catch (InputMismatchException e) {
                System.out.println("||| Valor inválido. Insira os dados novamente.\n|||");
            }
        } while (true);
    }
}
