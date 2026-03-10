# Relatório de Cobertura de Testes

## Visão Geral

Este projeto contém uma implementação de Lista Encadeada simples em Java, com testes automatizados utilizando JUnit 5. Os testes cobrem a classe [`List`](src/main/java/List.java) que implementa uma lista dinâmica de nós.

---

## Arquivos de Teste

| Arquivo                                                                | Tipo    | Descrição                                          |
| ---------------------------------------------------------------------- | ------- | -------------------------------------------------- |
| [`src/test/java/ListJUnitTest.java`](src/test/java/ListJUnitTest.java) | JUnit 5 | Suite completa de testes automatizados (34 testes) |
| [`src/main/java/ListTest.java`](src/main/java/ListTest.java)           | Manual  | Testes manuais executados via console              |

---

## Cobertura de Testes - ListJUnitTest.java

### Total de Testes: 34

---

### 1. Testes do Construtor (2 testes)

| #   | Teste                                                                 | Descrição                                                      |
| --- | --------------------------------------------------------------------- | -------------------------------------------------------------- |
| 1   | [`construtorPadraoListaVazia()`](src/test/java/ListJUnitTest.java:28) | Verifica que o construtor padrão cria lista vazia com length 0 |
| 2   | [`construtorComValor()`](src/test/java/ListJUnitTest.java:37)         | Verifica que o construtor com valor cria lista com 1 elemento  |

---

### 2. Testes do Método `getLength()` (3 testes)

| #   | Teste                                                           | Descrição                              |
| --- | --------------------------------------------------------------- | -------------------------------------- |
| 1   | [`listaVaziaLengthZero()`](src/test/java/ListJUnitTest.java:50) | Lista vazia retorna length 0           |
| 2   | [`listaComElementos()`](src/test/java/ListJUnitTest.java:56)    | Lista com 3 elementos retorna length 3 |
| 3   | [`listaComUmElemento()`](src/test/java/ListJUnitTest.java:65)   | Lista com 1 elemento retorna length 1  |

---

### 3. Testes do Método `getIndex()` (5 testes)

| #   | Teste                                                               | Descrição                                     |
| --- | ------------------------------------------------------------------- | --------------------------------------------- |
| 1   | [`listaVaziaRetornaMenosUm()`](src/test/java/ListJUnitTest.java:77) | Lista vazia retorna -1                        |
| 2   | [`primeiroElemento()`](src/test/java/ListJUnitTest.java:83)         | Retorna índice 0 para o primeiro elemento     |
| 3   | [`ultimoElemento()`](src/test/java/ListJUnitTest.java:91)           | Retorna índice correto para o último elemento |
| 4   | [`elementoInexistente()`](src/test/java/ListJUnitTest.java:99)      | Retorna -1 para elemento que não existe       |
| 5   | [`elementoNoMeio()`](src/test/java/ListJUnitTest.java:108)          | Retorna índice correto para elemento no meio  |

---

### 4. Testes do Método `getByIndex()` (6 testes)

| #   | Teste                                                             | Descrição                              |
| --- | ----------------------------------------------------------------- | -------------------------------------- |
| 1   | [`listaVaziaRetornaNull()`](src/test/java/ListJUnitTest.java:122) | Lista vazia retorna null               |
| 2   | [`primeiroElemento()`](src/test/java/ListJUnitTest.java:128)      | Retorna primeiro elemento corretamente |
| 3   | [`ultimoElemento()`](src/test/java/ListJUnitTest.java:137)        | Retorna último elemento corretamente   |
| 4   | [`indiceNegativo()`](src/test/java/ListJUnitTest.java:147)        | Índice negativo retorna null           |
| 5   | [`indiceMaiorQueTamanho()`](src/test/java/ListJUnitTest.java:154) | Índice maior que tamanho retorna null  |
| 6   | [`elementoDoMeio()`](src/test/java/ListJUnitTest.java:161)        | Retorna elemento do meio corretamente  |

---

### 5. Testes do Método `push()` (3 testes)

| #   | Teste                                                           | Descrição                                    |
| --- | --------------------------------------------------------------- | -------------------------------------------- |
| 1   | [`pushListaVazia()`](src/test/java/ListJUnitTest.java:176)      | Push em lista vazia adiciona elemento        |
| 2   | [`pushAdicionaNoFinal()`](src/test/java/ListJUnitTest.java:184) | Push adiciona no final da lista              |
| 3   | [`pushMultiplos()`](src/test/java/ListJUnitTest.java:194)       | Múltiplos pushes alteram length corretamente |

---

### 6. Testes do Método `unshift()` (3 testes)

| #   | Teste                                                               | Descrição                                |
| --- | ------------------------------------------------------------------- | ---------------------------------------- |
| 1   | [`unshiftListaVazia()`](src/test/java/ListJUnitTest.java:208)       | Unshift em lista vazia adiciona elemento |
| 2   | [`unshiftAdicionaNoInicio()`](src/test/java/ListJUnitTest.java:216) | Unshift adiciona no início da lista      |
| 3   | [`unshiftListaUmElemento()`](src/test/java/ListJUnitTest.java:227)  | Unshift em lista com 1 elemento funciona |

---

### 7. Testes do Método `pop()` (4 testes)

| #   | Teste                                                          | Descrição                                   |
| --- | -------------------------------------------------------------- | ------------------------------------------- |
| 1   | [`popListaVazia()`](src/test/java/ListJUnitTest.java:241)      | Pop em lista vazia retorna null             |
| 2   | [`popRemoveUltimo()`](src/test/java/ListJUnitTest.java:247)    | Pop remove e retorna último elemento        |
| 3   | [`popListaUmElemento()`](src/test/java/ListJUnitTest.java:262) | Pop em lista com 1 elemento esvazia a lista |
| 4   | [`popReduceLength()`](src/test/java/ListJUnitTest.java:275)    | Pop reduz o length corretamente             |

---

### 8. Testes do Método `shift()` (4 testes)

| #   | Teste                                                            | Descrição                                     |
| --- | ---------------------------------------------------------------- | --------------------------------------------- |
| 1   | [`shiftListaVazia()`](src/test/java/ListJUnitTest.java:294)      | Shift em lista vazia retorna null             |
| 2   | [`shiftRemovePrimeiro()`](src/test/java/ListJUnitTest.java:300)  | Shift remove e retorna primeiro elemento      |
| 3   | [`shiftListaUmElemento()`](src/test/java/ListJUnitTest.java:315) | Shift em lista com 1 elemento esvazia a lista |
| 4   | [`shiftReduceLength()`](src/test/java/ListJUnitTest.java:328)    | Shift reduz o length corretamente             |

---

### 9. Testes do Método `toString()` (3 testes)

| #   | Teste                                                          | Descrição                                          |
| --- | -------------------------------------------------------------- | -------------------------------------------------- |
| 1   | [`listaVazia()`](src/test/java/ListJUnitTest.java:347)         | Lista vazia retorna string vazia                   |
| 2   | [`umElemento()`](src/test/java/ListJUnitTest.java:353)         | Retorna formatação correta com 1 elemento          |
| 3   | [`multiplosElementos()`](src/test/java/ListJUnitTest.java:360) | Retorna formatação correta com múltiplos elementos |

---

### 10. Testes de Integração (2 testes)

| #   | Teste                                                                   | Descrição                                      |
| --- | ----------------------------------------------------------------------- | ---------------------------------------------- |
| 1   | [`operacoesCombinadas()`](src/test/java/ListJUnitTest.java:374)         | Combina push, unshift, pop, shift em sequência |
| 2   | [`buscarIndexAposModificacoes()`](src/test/java/ListJUnitTest.java:404) | Busca índice após modificações na lista        |

---

## Métodos da Classe List Testados

| Método                                 | Status     | Qtd Testes |
| -------------------------------------- | ---------- | ---------- |
| `List()` (construtor padrão)           | ✅ Testado | 2          |
| `List(int val)` (construtor com valor) | ✅ Testado | 2          |
| `getLength()`                          | ✅ Testado | 3          |
| `getIndex(int value)`                  | ✅ Testado | 5          |
| `getByIndex(int index)`                | ✅ Testado | 6          |
| `push(Node newNode)`                   | ✅ Testado | 3          |
| `unshift(Node newNode)`                | ✅ Testado | 3          |
| `pop()`                                | ✅ Testado | 4          |
| `shift()`                              | ✅ Testado | 4          |
| `toString()`                           | ✅ Testado | 3          |

---

## Casos de Borda Covered

- Lista vazia (0 elementos)
- Lista com 1 elemento
- Lista com múltiplos elementos
- Índice negativo
- Índice maior que o tamanho
- Elemento inexistente
- Primeiro elemento
- Último elemento
- Elemento no meio
- Operações combinadas

---

## Conclusão

A suíte de testes JUnit 5 ([`ListJUnitTest.java`](src/test/java/ListJUnitTest.java)) oferece **cobertura abrangente** de todos os métodos públicos da classe [`List`](src/main/java/List.java), incluindo casos de borda e testes de integração. Os testes verificam tanto o comportamento de retorno dos métodos quanto a manipulação correta do estado interno da lista (como o length e a ordenação dos elementos).
