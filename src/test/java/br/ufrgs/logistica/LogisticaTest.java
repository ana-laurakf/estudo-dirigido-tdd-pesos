package br.ufrgs.logistica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class LogisticaTest{
    @Test
    void given5kg_WhenMultiplicadoPor2_ThenRetorna10kg() {
        Peso cinco = new Peso(5, "kg");
        assertEquals(new Peso(10, "kg"), cinco.multiplicar(2));
    }
    @Test
    void given5g_WhenMultiplicadoPor2_ThenRetorna10g() {
        Peso cinco = new Peso(5, "g");
        assertEquals(new Peso(10, "g"), cinco.multiplicar(2));
    }
    @Test
    void given5kg_WhenEqualsComOutros5kg_ThenRetornaVerdadeiro() {
        assertTrue(new Peso(5, "kg").equals(new Peso(5, "kg")));
    }
    @Test
    void given5kg_WhenEqualsCom6kg_ThenRetornaFalso() {
        assertFalse(new Peso(5, "kg").equals(new Peso(6, "kg")));
    }
    @Test
    void given5g_WhenEqualsComOutros5g_ThenRetornaVerdadeiro() {
        assertTrue(new Peso(5, "g").equals(new Peso(5, "g")));
    }
    @Test
    void given5g_WhenEqualsCom6g_ThenRetornaFalso() {
        assertFalse(new Peso(5, "g").equals(new Peso(6, "g")));
    }
    @Test
    void given5kg_WhenEqualsCom5g_ThenRetornaFalso() {
        assertFalse(new Peso(5, "kg").equals(new Peso(5, "g")));
    }
    @Test
    void givenKgEG_WhenGetUnidade_ThenRetornaUnidadeCorreta() {
        assertEquals("kg", new Peso(1, "kg").getUnidade());
        assertEquals("g", new Peso(1, "g").getUnidade());
    }
    @Test
    void given1kg_WhenConverteParaGramas_ThenRetorna1000g() {
        Peso umQuilo = new Peso(1, "kg");
        Balanca balanca = new Balanca();
        balanca.adicionarTaxaDeConversao("kg", "g", 1000);

        Peso convertido = balanca.converter(umQuilo, "g");

        assertEquals(new Peso(1000, "g"), convertido);
    }
    @Test
    void given1lb_WhenConverteParaGramas_ThenRetorna453ponto592g() {
        Peso umaLibra = new Peso(1, "lb");
        Balanca balanca = new Balanca();
        balanca.adicionarTaxaDeConversao("lb", "g", 453.592);

        Peso convertido = balanca.converter(umaLibra, "g");

        assertEquals(453.592, convertido.getQuantidade(), 0.001);
        assertEquals("g", convertido.getUnidade());
    }
    @Test
    void given1kg_WhenSoma1kg_ThenRetorna2kg() {
        Peso umQuilo = new Peso(1, "kg");
        Peso outroQuilo = new Peso(1, "kg");
        Balanca balanca = new Balanca();

        Soma total = umQuilo.somar(outroQuilo);
        Peso convertido = balanca.converter(total, "kg");

        assertEquals(new Peso(2, "kg"), convertido);
    }
    @Test
    void given1g_WhenSoma1g_ThenRetorna2g() {
        Peso umGrama = new Peso(1, "g");
        Peso outroGrama = new Peso(1, "g");
        Balanca balanca = new Balanca();

        Soma total = umGrama.somar(outroGrama);
        Peso convertido = balanca.converter(total, "g");

        assertEquals(new Peso(2, "g"), convertido);
    }
    @Test
    void given1kg_WhenSoma500g_ThenRetorna1500g() {
        Peso umQuilo = new Peso(1, "kg");
        Peso quinhentosGramas = new Peso(500, "g");
        Balanca balanca = new Balanca();
        balanca.adicionarTaxaDeConversao("kg", "g", 1000);

        Soma total = umQuilo.somar(quinhentosGramas);
        Peso convertido = balanca.converter(total, "g");

        assertEquals(new Peso(1500, "g"), convertido);
    }
}