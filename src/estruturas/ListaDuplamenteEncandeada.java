package estruturas;

class NoDuplo extends No {
    NoDuplo anterior;
    NoDuplo proximo;

    public NoDuplo getAnterior() { return anterior; }

    public void setAnterior(NoDuplo anterior) { this.anterior = anterior; }

    @Override
    public NoDuplo getProximo() { return proximo; }

    public void setProximo(NoDuplo proximo) { this.proximo = proximo; }
}

/**
 * Em uma lista duplamente encandeada, cada nó possui referência
 * tanto para o próximo nó da lista, quanto para o anterior.
 */
public class ListaDuplamenteEncandeada {
    private NoDuplo inicial;
    private NoDuplo ultimo;
    private int numElementos;

    public ListaDuplamenteEncandeada() {
        this.numElementos = 0;
    }

    public void adicionar(Object valor) {
        NoDuplo novo = new NoDuplo();
        novo.setValor(valor);
        novo.setAnterior(null);
        novo.setProximo(null);

        if(numElementos == 0) {
            this.inicial = novo;
        }
        else {
            NoDuplo atual = inicial;
            this.ultimo = atual;

            while (atual != null) {
                ultimo = atual;
                atual = atual.getProximo();
            }

            assert ultimo != null;
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
        }

        ultimo = novo;
        numElementos += 1;
    }

    public void percorrerParaFrente() {
        System.out.println("Percorrer para a frente");
        No atual = inicial;

        while(atual != null) {
            System.out.print(atual.getValor() + " -> ");
            atual = atual.getProximo();
        }

        System.out.println("fim");
    }

    public void percorrerParaTras() {
        System.out.println("Percorrer para trás");
        NoDuplo atual = ultimo;

        while(atual != null) {
            System.out.print(atual.getValor() + " -> ");
            atual = atual.getAnterior();
        }

        System.out.println("fim");
    }

    public static void main(String[] args) {
        ListaDuplamenteEncandeada lde = new ListaDuplamenteEncandeada();

        lde.adicionar(2);
        lde.adicionar(3);
        lde.adicionar(5);
        lde.adicionar(7);
        lde.adicionar(11);
        lde.adicionar(13);

        lde.percorrerParaFrente();
        lde.percorrerParaTras();
    }
}
