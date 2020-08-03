package estruturas;

public class Pilha {
    private No topo;
    private int numElementos = 0;

    /**
     * Insere um novo elemento na pilha
     * @param valor O novo valor a ser adicionado
     */
    public void push(Object valor) {
        No novo = new No();
        novo.setValor(valor);
        novo.setProximo(topo);

        if(numElementos != 0) {
            topo.setProximo(novo);
        }

        this.topo = novo;
        this.numElementos += 1;
    }

    /**
     * Remove e retorna o valor do elemento no topo da pilha
     * @return Valor do topo da pilha
     */
    public Object pop() {
        Object saida;
        if (numElementos == 0) {
            System.out.println("A pilha está vazia");
            saida = -1;
        }
        else {
            saida = this.topo.getValor();
            this.topo = topo.getProximo();

            this.numElementos -= 1;
        }

        return saida;
    }

    /**
     * Retorna o valor do elemento no topo da pilha
     * @return Valor do topo da pilha
     */
    public Object peek(){ return this.topo.getValor(); }

    public void percorrer() {
        System.out.println("Mostrar pilha");
        No atual = topo;

        while (atual != null) {
            System.out.println(atual.getValor().toString());
            System.out.println("---");
            atual = atual.getProximo();
        }

        System.out.println("Fim\n");
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push(2);
        pilha.push(3);
        pilha.push(5);
        pilha.push(8);

        pilha.percorrer();
        System.out.println("Saiu: " + pilha.pop().toString() + '\n');
        pilha.percorrer();

        System.out.println("Topo: " + pilha.peek());
    }
}