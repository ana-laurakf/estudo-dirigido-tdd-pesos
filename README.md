
Estudo dirigido da disciplina de Desenvolvimento de Software (UFRGS), feito com **Test-Driven Development (TDD)** em Java. O domínio é logístico: representar pesos em diferentes unidades, somá-los e convertê-los por meio de taxas configuráveis.

## O que foi implementado

| Classe | Responsabilidade |
|--------|------------------|
| `Peso` | Valor imutável (quantidade + unidade). Suporta `multiplicar`, `somar` e `equals`/`hashCode`. |
| `Soma` | Representa a soma de dois pesos, ainda sem convertê-los para uma unidade. |
| `Balanca` | Guarda as taxas de conversão e converte um `Peso` ou uma `Soma` para a unidade desejada. Usa a taxa inversa quando só a direta foi cadastrada. |

### Exemplo de uso

```java
Balanca balanca = new Balanca();
balanca.adicionarTaxaDeConversao("kg", "g", 1000);

Peso umQuilo = new Peso(1, "kg");
Peso meioQuilo = new Peso(500, "g");

Soma total = umQuilo.somar(meioQuilo);
Peso resultado = balanca.converter(total, "g"); // 1500 g
```

## Testes

Os 13 testes em `LogisticaTest` seguem o padrão `given_when_then` e cobrem:

- multiplicação de pesos (`kg` e `g`);
- igualdade entre pesos (mesma unidade, valores diferentes e unidades diferentes);
- conversão entre unidades (`kg` → `g` e `lb` → `g`);
- soma de pesos na mesma unidade e em unidades diferentes.

## Como executar

**Pré-requisitos:** JDK 25 e Maven 3.9+.

```bash
git clone https://github.com/<seu-usuario>/<nome-do-repositorio>.git
cd <nome-do-repositorio>
mvn test
```

## Estrutura

```
src/
├── main/java/br/ufrgs/logistica/
│   ├── Balanca.java
│   ├── Peso.java
│   └── Soma.java
└── test/java/br/ufrgs/logistica/
    └── LogisticaTest.java
```

## Tecnologias

Java 25 · Maven · JUnit 5 (5.10.2)

## Autoria

Ana Laura Koefender Führ - Engenharia da Computação UFRGS
