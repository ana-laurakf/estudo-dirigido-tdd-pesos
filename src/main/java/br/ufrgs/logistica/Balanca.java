package br.ufrgs.logistica;

import java.util.HashMap;
import java.util.Map;

public class Balanca {
    private final Map<String, Double> taxas = new HashMap<>();

    public void adicionarTaxaDeConversao(String de, String para, double taxa) {
        taxas.put(chave(de, para), taxa);
    }
    public Peso converter(Peso peso, String unidadeDestino) {
        if (peso.getUnidade().equals(unidadeDestino)) {
            return peso;
        }
        double taxa = taxa(peso.getUnidade(), unidadeDestino);
        return new Peso(peso.getQuantidade() * taxa, unidadeDestino);
    }
    public Peso converter(Soma soma, String unidadeDestino) {
        Peso primeiro = converter(soma.getPrimeiro(), unidadeDestino);
        Peso segundo = converter(soma.getSegundo(), unidadeDestino);
        return new Peso(primeiro.getQuantidade() + segundo.getQuantidade(), unidadeDestino);
    }
    private double taxa(String de, String para) {
        Double direta = taxas.get(chave(de, para));
        if (direta != null) {
            return direta;
        }
        Double inversa = taxas.get(chave(para, de));
        if (inversa != null) {
            return 1.0 / inversa;
        }
        throw new IllegalArgumentException(
                "Sem taxa de conversão de " + de + " para " + para);
    }
    private String chave(String de, String para) {
        return de + "->" + para;
    }
}