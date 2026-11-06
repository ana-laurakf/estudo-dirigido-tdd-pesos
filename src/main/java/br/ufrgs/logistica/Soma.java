package br.ufrgs.logistica;

public class Soma {
    private final Peso primeiro;
    private final Peso segundo;

    public Soma(Peso primeiro, Peso segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }
    Peso getPrimeiro() {
        return primeiro;
    }
    Peso getSegundo() {
        return segundo;
    }
}