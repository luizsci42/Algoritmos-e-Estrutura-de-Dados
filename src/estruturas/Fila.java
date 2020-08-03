package estruturas;

public class Fila {
    private No frente;
    private No fim;
    private int numElementos = 0;

    /**
     * Insere um novo elelmento na fila
     * @param valor Valor a ser inserido
     */
    public void inserir(Object valor) {
        No novo = new No();
        novo.setValor(valor);

        if(numElementos == 0) {
            novo.setProximo(null);
            frente = novo;
            fim = novo;
        }
        else {
            fim.setProximo(novo);
            fim = novo;
        }
        numElementos += 1;
    }

    public void remover(){
        if(numElementos == 0){
            System.out.println("A fila está vazia. Não é possivel remover");
        }
        else {
            System.out.println(frente.getValor().toString() + " saiu");
            frente = frente.getProximo();
            numElementos -= 1;
        }
    }

    public Object peek(){
        return (this.numElementos) > 0 ? this.frente.getValor() : -1;
    }

    public static void main(String[] args){
        Fila fila = new Fila();

        fila.inserir(2);
        fila.inserir(3);
        fila.inserir(5);
        fila.inserir(7);
        fila.inserir(11);
        fila.inserir(13);

        System.out.println("O primeiro da fila é: " + fila.peek());
        fila.remover();
        fila.remover();
        System.out.println("O primeiro da fila é: " + fila.peek());
        fila.remover();
        System.out.println("O primeiro da fila é: " + fila.peek());
        fila.remover();
        fila.inserir(41);
        fila.remover();
        fila.remover();
        fila.remover();
        fila.remover();
        fila.inserir(1);
        System.out.println("O primeiro da fila é: " + fila.peek());
    }
}
