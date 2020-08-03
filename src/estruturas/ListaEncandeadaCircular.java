package estruturas;

/**
 * Uma lista encandeada circular é quase igual à lista encandeada simples,
 * com a diferença de que o último nó aponta para o primeiro da lista.
 * Sendo assim, uma lista circular não possui nem começo, nem fim, podendo ser
 * percorrida a partir de qualquer nó que se escolha. Mas quando parar
 * de percorrer? Para isso gravamos o endereço do primeiro nó e paramos
 * quando algum nó apontar novamente para aquele endereço.
 *
 * Métodos a implementar: Inserir no começo, inserir no fim, buscar, retornar e percorrer
 *
 */
public class ListaEncandeadaCircular {
    private No inicial;
    private int numElementos;

    public ListaEncandeadaCircular() { this.numElementos = 0; }

    public No getInicial() { return inicial; }

    public void setInicial(No inicial) { this.inicial = inicial; }

    public int getNumElementos() { return numElementos; }

    public void setNumElementos(int numElementos) { this.numElementos = numElementos; }

    public void adicionar(Object valor) {
        No novo = new No();
        novo.setValor(valor);

        if(numElementos == 0) {
            this.inicial = novo;
        }
        else {
            No atual = inicial.getProximo();
            No ultimo = atual;

            while(atual != inicial) {
                ultimo = atual;
                atual = atual.getProximo();
            }

            ultimo.setProximo(novo);
        }

        novo.setProximo(inicial);

        numElementos += 1;
    }

    public void percorrer() {
        No atual = inicial.getProximo();
        System.out.println("Circulando...");
        System.out.print(inicial.getValor() + " -> ");

        while (atual != inicial) {
            atual = atual.getProximo();
            System.out.print(atual.getValor().toString() + " -> ");
        }

        System.out.println("...");
    }

    public static void main(String[] args) {
        ListaEncandeadaCircular lec = new ListaEncandeadaCircular();

        lec.adicionar(2);
        lec.adicionar(3);
        lec.adicionar(5);
        lec.adicionar(7);
        lec.adicionar(11);
        lec.adicionar(13);
        lec.adicionar("Já pensei em tudo");

        lec.percorrer();
    }
}