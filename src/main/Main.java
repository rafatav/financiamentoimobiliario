package main;

import modelo.Casa;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double valorImovelTotal = 0;
        double valorFinanciamentoTotal = 0;
        List<modelo.Financiamento> financiamentos = new ArrayList<>();

        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||      SIMULADOR DE FINANCIAMENTO IMOBILIÁRIO      |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||");


        System.out.println("|||\n||| Financiamento 1 - Casa: ");
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.pedirTaxaJuros();
        int areaConstruida = interfaceUsuario.pedirAreaConstruida();
        int areaTotal = interfaceUsuario.pedirAreaTotal();
        financiamentos.add(new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida, areaTotal));

        financiamentos.add(new modelo.Casa(500000, 10, 10, 125, 250));
        financiamentos.add(new modelo.Apartamento(100000, 10, 10, 1, 5));
        financiamentos.add(new modelo.Apartamento(1000000, 10, 10, 2, 20));
        financiamentos.add(new modelo.Terreno(50000, 10, 10, "Residencial"));

        for (int i = 0; i < financiamentos.size(); i++) {
            System.out.println("|||\n||| Financiamento " + (i + 1) + ":");
            valorImovelTotal += financiamentos.get(i).getValorImovel();
            valorFinanciamentoTotal += financiamentos.get(i).totalPagamento();
            financiamentos.get(i).mostrarDados();
            FileWriter escritor = null;
            try {
                escritor = new FileWriter("arquivoFinanciamento.txt", true);
                escritor.write(financiamentos.get(i).toString());
                escritor.flush();
                escritor.close();
            } catch (FileNotFoundException e) {
                System.out.println("||| Arquivo não encontrado.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileReader leitor = null;
            try {
                leitor = new FileReader("arquivoFinanciamento.txt");
                leitor.close();
            } catch (FileNotFoundException e) {
                System.out.println("|||\n||| Arquivo de dados do financiamento não encontrado!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            ObjectOutputStream outputstream = null;
            try {
                outputstream = new ObjectOutputStream(new FileOutputStream("objetosFinanciamento.test"));
                outputstream.writeObject(financiamentos.get(i));
                outputstream.flush();
                outputstream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ObjectInputStream inputstream = null;
            try {
                inputstream = new ObjectInputStream(new FileInputStream("objetosFinanciamento.test"));
                inputstream.close();
            } catch (FileNotFoundException e) {
                System.out.println("|||\n||| Arquivo de objetos não encontrado!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("|||\n||| Valor total de todos os imóveis: %.2f R$", valorImovelTotal);
        System.out.printf("\n||| Valor total de todos os financiamentos: %.2f R$\n", valorFinanciamentoTotal);

        System.out.println("|||\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.print("|||                 FIM DO SIMULADOR                 |||" +
                "\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
}
//package main;
//public class Main {
//    public static void main(String[] args) {
//        System.out.println(9%2);
//    }
//}
