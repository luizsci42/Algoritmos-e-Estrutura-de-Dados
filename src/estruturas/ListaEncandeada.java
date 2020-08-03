package estruturas;

class No {
    private Object valor;
    private No proximo;

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}

public class ListaEncandeada {
    private No inicial;
    private int numElementos;

    public ListaEncandeada() {
        this.numElementos = 0;
    }

    public void adicionar(Object valor) {
        No novo = new No();
        novo.setValor(valor);
        novo.setProximo(null);

        if(numElementos == 0) {
            this.inicial = novo;
        }
        else {
            No ultimo = inicial;
            No atual = inicial;

            while(atual != null) {
                ultimo = atual;
                atual = atual.getProximo();
            }

            assert ultimo != null;
            ultimo.setProximo(novo);
        }
        this.numElementos += 1;
    }

    public void percorrer() {
        No atual = this.inicial;

        System.out.println("Percorrer lista");

        while(atual != null) {
            System.out.print(atual.getValor().toString() + " -> ");
            atual = atual.getProximo();
        }

        System.out.println("fim");
    }

    public int buscar(Object valor) {
        No atual = this.inicial;
        int posicao = 0;

        System.out.println("Buscar");

        try {
            while(atual.getValor() != valor) {
                atual = atual.getProximo();
                posicao++;
            }
        } catch (NullPointerException npe) {
            return -1;
        }

        return posicao;
    }

    public Object recuperarElemento(int posicao) {
        No atual = this.inicial;
        int pos_atual = 0;

        while(pos_atual < posicao) {
            atual = atual.getProximo();
            pos_atual++;
        }

        return atual.getValor();
    }

    public void removerElemento(Object valor) {
        // Percorremos a lista até encontrarmos o elemento
        // Pegamos o nó anterior a ele e o próximo
        // Então fazemos o anterior apontar ao proximo
        No anterior, atual, proximo;
        atual = this.inicial;
        anterior = new No();
        proximo = new No();

        while(atual.getValor() != valor) {
            anterior = atual;
            atual = atual.getProximo();
            proximo = atual.getProximo();
        }

        anterior.setProximo(proximo);
        this.numElementos -= 1;
    }

    public static void main(String[] args) {
        ListaEncandeada lista = new ListaEncandeada();

        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(5);
        lista.adicionar(7);
        lista.adicionar(11);
        lista.adicionar(13);
        lista.adicionar(17);
        lista.adicionar("Brabo");

        lista.percorrer();

        int posicao = lista.buscar("Teste");
        if(posicao == -1) {
            System.out.println("Não encontrado");
        }
        else {
            System.out.println("Posição: " + posicao);

            Object valorRecuperado = lista.recuperarElemento(posicao);
            System.out.println("Recuperado: " + valorRecuperado.toString());
        }

        lista.removerElemento(7);
        lista.percorrer();
    }
}