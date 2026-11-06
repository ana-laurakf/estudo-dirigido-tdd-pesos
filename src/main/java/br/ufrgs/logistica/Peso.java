package br.ufrgs.logistica;
import java.util.Objects;

public class Peso {
    private final double quantidade;
    private final String unidade;

    public Peso(double quantidade, String unidade) {
        this.quantidade = quantidade;
        this.unidade = unidade;
    }
    public double getQuantidade() {
        return quantidade;
    }
    public String getUnidade() {
        return unidade;
    }
    public Peso multiplicar(double multiplicador) {
        return new Peso(quantidade * multiplicador, unidade);
    }
    public Soma somar(Peso outro) {
        return new Soma(this, outro);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Peso outro = (Peso) obj;
        return Double.compare(quantidade, outro.quantidade) == 0
                && unidade.equals(outro.unidade);
    }
    @Override
    public int hashCode() {
        return Objects.hash(quantidade, unidade);
    }
}