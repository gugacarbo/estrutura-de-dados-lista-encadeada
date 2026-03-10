
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe List")
public class ListJUnitTest {

    private List lista;

    @BeforeEach
    public void setUp() {
        lista = new List();
    }

    @Nested
    @DisplayName("Testes do Construtor")
    @SuppressWarnings("unused")
    class ConstructorTest {

        @Test
        @DisplayName("Construtor padrão cria lista vazia")
        void construtorPadraoListaVazia() {
            List lista = new List();
            assertEquals(0, lista.getLength());
            assertEquals("", lista.toString());
        }

        @Test
        @DisplayName("Construtor com valor cria lista com 1 elemento")
        void construtorComValor() {
            List lista = new List(10);
            assertEquals(1, lista.getLength());
            assertEquals("[ 10 ]", lista.toString());
        }
    }

    @Nested
    @DisplayName("Testes do método getLength()")
    @SuppressWarnings("unused")
    class GetLengthTest {

        @Test
        @DisplayName("Lista vazia tem length 0")
        void listaVaziaLengthZero() {
            assertEquals(0, lista.getLength());
        }

        @Test
        @DisplayName("Lista com 1 elemento tem length 1")
        void listaComUmElemento() {
            lista.push(new Node(5));
            assertEquals(1, lista.getLength());
        }

        @Test
        @DisplayName("Lista com elementos retorna length correto")
        void listaComElementos() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));
            assertEquals(3, lista.getLength());
        }
    }

    @Nested
    @DisplayName("Testes do método getIndex()")
    class GetIndexTest {

        @Test
        @DisplayName("getIndex em lista vazia retorna -1")
        void listaVaziaRetornaMenosUm() {
            assertEquals(-1, lista.getIndex(10));
        }

        @Test
        @DisplayName("getIndex retorna índice correto do primeiro elemento")
        void primeiroElemento() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            assertEquals(0, lista.getIndex(10));
        }

        @Test
        @DisplayName("getIndex retorna índice correto do último elemento")
        void ultimoElemento() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));
            assertEquals(2, lista.getIndex(30));
        }

        @Test
        @DisplayName("getIndex retorna -1 para elemento inexistente")
        void elementoInexistente() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            assertEquals(-1, lista.getIndex(100));
        }

        @Test
        @DisplayName("getIndex retorna índice do elemento do meio")
        void elementoNoMeio() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));
            assertEquals(1, lista.getIndex(20));
        }

        @Test
        @DisplayName("getIndex retorna primeiro índice para valores duplicados")
        void elementoDuplicadoRetornaPrimeiroIndice() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(10));
            lista.push(new Node(30));
            assertEquals(0, lista.getIndex(10)); // Retorna o primeiro índice
        }
    }

    @Nested
    @DisplayName("Testes do método getByIndex()")
    class GetByIndexTest {

        @Test
        @DisplayName("getByIndex retorna null para lista vazia")
        void listaVaziaRetornaNull() {
            assertNull(lista.getByIndex(0));
        }

        @Test
        @DisplayName("getByIndex retorna primeiro elemento")
        void primeiroElemento() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            assertNotNull(lista.getByIndex(0));
            assertEquals(10, lista.getByIndex(0).getValue());
        }

        @Test
        @DisplayName("getByIndex retorna último elemento")
        void ultimoElemento() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));
            assertNotNull(lista.getByIndex(2));
            assertEquals(30, lista.getByIndex(2).getValue());
        }

        @Test
        @DisplayName("getByIndex retorna null para índice negativo")
        void indiceNegativo() {
            lista.push(new Node(10));
            assertNull(lista.getByIndex(-1));
        }

        @Test
        @DisplayName("getByIndex retorna null para índice maior que tamanho")
        void indiceMaiorQueTamanho() {
            lista.push(new Node(10));
            assertNull(lista.getByIndex(5));
        }

        @Test
        @DisplayName("getByIndex retorna elemento do meio")
        void elementoDoMeio() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));
            assertNotNull(lista.getByIndex(1));
            assertEquals(20, lista.getByIndex(1).getValue());
        }
    }

    @Nested
    @DisplayName("Testes do método push()")
    class PushTest {

        @Test
        @DisplayName("push adiciona elemento em lista vazia")
        void pushListaVazia() {
            lista.push(new Node(10));
            assertEquals(1, lista.getLength());
            assertEquals("[ 10 ]", lista.toString());
        }

        @Test
        @DisplayName("push adiciona elemento no final da lista")
        void pushAdicionaNoFinal() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));
            assertEquals(3, lista.getLength());
            assertEquals("[ 10 ] > [ 20 ] > [ 30 ]", lista.toString());
        }

        @Test
        @DisplayName("push múltiplos elementos altera length corretamente")
        void pushMultiplos() {
            for (int i = 1; i <= 5; i++) {
                lista.push(new Node(i * 10));
            }
            assertEquals(5, lista.getLength());
        }
    }

    @Nested
    @DisplayName("Testes do método unshift()")
    class UnshiftTest {

        @Test
        @DisplayName("unshift adiciona elemento em lista vazia")
        void unshiftListaVazia() {
            lista.unshift(new Node(10));
            assertEquals(1, lista.getLength());
            assertEquals("[ 10 ]", lista.toString());
        }

        @Test
        @DisplayName("unshift adiciona elemento no início da lista")
        void unshiftAdicionaNoInicio() {
            lista.push(new Node(20));
            lista.push(new Node(30));
            lista.unshift(new Node(10));
            assertEquals(3, lista.getLength());
            assertEquals("[ 10 ] > [ 20 ] > [ 30 ]", lista.toString());
            assertEquals(10, lista.getByIndex(0).getValue());
        }

        @Test
        @DisplayName("unshift em lista com 1 elemento")
        void unshiftListaUmElemento() {
            lista.push(new Node(20));
            lista.unshift(new Node(10));
            assertEquals(2, lista.getLength());
            assertEquals("[ 10 ] > [ 20 ]", lista.toString());
        }
    }

    @Nested
    @DisplayName("Testes do método pop()")
    class PopTest {

        @Test
        @DisplayName("pop retorna null em lista vazia")
        void popListaVazia() {
            assertNull(lista.pop());
        }

        @Test
        @DisplayName("pop remove e retorna último elemento")
        void popRemoveUltimo() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));

            Node removido = lista.pop();

            assertNotNull(removido);
            assertEquals(30, removido.getValue());
            assertEquals(2, lista.getLength());
            assertEquals("[ 10 ] > [ 20 ]", lista.toString());
        }

        @Test
        @DisplayName("pop em lista com 1 elemento")
        void popListaUmElemento() {
            lista.push(new Node(10));

            Node removido = lista.pop();

            assertNotNull(removido);
            assertEquals(10, removido.getValue());
            assertEquals(0, lista.getLength());
            assertEquals("", lista.toString());
        }

        @Test
        @DisplayName("pop reduz length corretamente")
        void popReduceLength() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));

            assertEquals(3, lista.getLength());
            lista.pop();
            assertEquals(2, lista.getLength());
            lista.pop();
            assertEquals(1, lista.getLength());
        }
    }

    @Nested
    @DisplayName("Testes do método shift()")
    class ShiftTest {

        @Test
        @DisplayName("shift retorna null em lista vazia")
        void shiftListaVazia() {
            assertNull(lista.shift());
        }

        @Test
        @DisplayName("shift remove e retorna primeiro elemento")
        void shiftRemovePrimeiro() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));

            Node removido = lista.shift();

            assertNotNull(removido);
            assertEquals(10, removido.getValue());
            assertEquals(2, lista.getLength());
            assertEquals("[ 20 ] > [ 30 ]", lista.toString());
        }

        @Test
        @DisplayName("shift em lista com 1 elemento")
        void shiftListaUmElemento() {
            lista.push(new Node(10));

            Node removido = lista.shift();

            assertNotNull(removido);
            assertEquals(10, removido.getValue());
            assertEquals(0, lista.getLength());
            assertEquals("", lista.toString());
        }

        @Test
        @DisplayName("shift reduz length corretamente")
        void shiftReduceLength() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));

            assertEquals(3, lista.getLength());
            lista.shift();
            assertEquals(2, lista.getLength());
            lista.shift();
            assertEquals(1, lista.getLength());
        }
    }

    @Nested
    @DisplayName("Testes do método toString()")
    class ToStringTest {

        @Test
        @DisplayName("toString retorna string vazia para lista vazia")
        void listaVazia() {
            assertEquals("", lista.toString());
        }

        @Test
        @DisplayName("toString retorna representação correta com 1 elemento")
        void umElemento() {
            lista.push(new Node(10));
            assertEquals("[ 10 ]", lista.toString());
        }

        @Test
        @DisplayName("toString retorna representação correta com múltiplos elementos")
        void multiplosElementos() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));
            assertEquals("[ 10 ] > [ 20 ] > [ 30 ]", lista.toString());
        }
    }

    @Nested
    @DisplayName("Testes de integração - Operações combinadas")
    class IntegracaoTest {

        @Test
        @DisplayName("Operações combinadas: push, unshift, pop, shift")
        void operacoesCombinadas() {
            // Lista vazia
            assertEquals(0, lista.getLength());

            // Push de 3 elementos
            lista.push(new Node(1));
            lista.push(new Node(2));
            lista.push(new Node(3));
            assertEquals(3, lista.getLength());
            assertEquals("[ 1 ] > [ 2 ] > [ 3 ]", lista.toString());

            // Unshift no início
            lista.unshift(new Node(0));
            assertEquals(4, lista.getLength());
            assertEquals("[ 0 ] > [ 1 ] > [ 2 ] > [ 3 ]", lista.toString());

            // Shift remove primeiro
            Node shifted = lista.shift();
            assertEquals(0, shifted.getValue());
            assertEquals(3, lista.getLength());

            // Pop remove último
            Node popped = lista.pop();
            assertEquals(3, popped.getValue());
            assertEquals(2, lista.getLength());
            assertEquals("[ 1 ] > [ 2 ]", lista.toString());
        }

        @Test
        @DisplayName("Buscar índice após modificações na lista")
        void buscarIndexAposModificacoes() {
            lista.push(new Node(10));
            lista.push(new Node(20));
            lista.push(new Node(30));

            assertEquals(1, lista.getIndex(20));

            lista.unshift(new Node(5));
            assertEquals(2, lista.getIndex(20)); // Agora está na posição 2

            lista.pop();
            assertEquals(-1, lista.getIndex(30)); // Não existe mais
        }
    }

    @Nested
    @DisplayName("Testes para a classe Node")
    class NodeTest {

        @Nested
        @DisplayName("Testes do Construtor Node")
        class NodeConstructorTest {

            @Test
            @DisplayName("Construtor cria nó com valor correto")
            void construtorComValor() {
                Node node = new Node(42);
                assertEquals(42, node.getValue());
            }

            @Test
            @DisplayName("Construtor cria nó com próximo null")
            void construtorProximoNull() {
                Node node = new Node(10);
                assertNull(node.next());
            }
        }

        @Nested
        @DisplayName("Testes do método getValue()")
        class GetValueTest {

            @Test
            @DisplayName("getValue retorna valor correto")
            void getValueRetornaValor() {
                Node node = new Node(100);
                assertEquals(100, node.getValue());
            }

            @Test
            @DisplayName("getValue retorna valor negativo")
            void getValueValorNegativo() {
                Node node = new Node(-50);
                assertEquals(-50, node.getValue());
            }

            @Test
            @DisplayName("getValue retorna zero")
            void getValueZero() {
                Node node = new Node(0);
                assertEquals(0, node.getValue());
            }
        }

        @Nested
        @DisplayName("Testes do método setValue()")
        class SetValueTest {

            @Test
            @DisplayName("setValue altera o valor do nó")
            void setValueAlteraValor() {
                Node node = new Node(10);
                node.setValue(20);
                assertEquals(20, node.getValue());
            }

            @Test
            @DisplayName("setValue altera para valor negativo")
            void setValueNegativo() {
                Node node = new Node(50);
                node.setValue(-100);
                assertEquals(-100, node.getValue());
            }
        }

        @Nested
        @DisplayName("Testes do método setNext() e next()")
        class NextTest {

            @Test
            @DisplayName("next() retorna null inicialmente")
            void nextInicialmenteNull() {
                Node node = new Node(10);
                assertNull(node.next());
            }

            @Test
            @DisplayName("setNext() define o próximo nó")
            void setNextDefineProximo() {
                Node node1 = new Node(10);
                Node node2 = new Node(20);
                node1.setNext(node2);
                assertNotNull(node1.next());
                assertEquals(20, node1.next().getValue());
            }

            @Test
            @DisplayName("next() retorna nó encadeado corretamente")
            void nextRetornaNoEncadeado() {
                Node node1 = new Node(1);
                Node node2 = new Node(2);
                Node node3 = new Node(3);
                node1.setNext(node2);
                node2.setNext(node3);

                assertNotNull(node1.next());
                assertEquals(2, node1.next().getValue());
                assertNotNull(node1.next().next());
                assertEquals(3, node1.next().next().getValue());
            }

            @Test
            @DisplayName("setNext(null) remove o próximo nó")
            void setNextNull() {
                Node node1 = new Node(10);
                Node node2 = new Node(20);
                node1.setNext(node2);
                node1.setNext(null);
                assertNull(node1.next());
            }
        }

        @Nested
        @DisplayName("Testes do método toString()")
        class NodeToStringTest {

            @Test
            @DisplayName("toString retorna formato correto")
            void toStringFormatoCorreto() {
                Node node = new Node(42);
                assertEquals("[ 42 ]", node.toString());
            }

            @Test
            @DisplayName("toString retorna formato correto para valor negativo")
            void toStringValorNegativo() {
                Node node = new Node(-10);
                assertEquals("[ -10 ]", node.toString());
            }

            @Test
            @DisplayName("toString retorna formato correto para zero")
            void toStringZero() {
                Node node = new Node(0);
                assertEquals("[ 0 ]", node.toString());
            }
        }
    }
}
