package estruturas;

/**
 * Árvore binária de busca
 */
public class ArvoreBinariaBusca {
    private NoDuplo raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    /**
     * Adiciona os elementos em ordem nível (acessa todos os
     * nós em um nível da esquerda para a direita)
     *
     * @param valor Valor a ser adicionado na árvore.
     */
    public void adicionar(int valor) {
        this.raiz = adicionarNo(this.raiz, valor);
    }

    private NoDuplo adicionarNo(NoDuplo raiz, int valor) {
        NoDuplo novo = new NoDuplo();
        novo.setValor(valor);

        if(raiz == null) {
            novo.setAnterior(null);
            novo.setProximo(null);
            raiz = novo;

            return raiz;
        }
        else if(valor < (int) raiz.getValor()) {
            novo = adicionarNo(raiz.getAnterior(), valor);
            raiz.setAnterior(novo);
        }
        else {
            novo = adicionarNo(raiz.getProximo(), valor);
            raiz.setProximo(novo);
        }

        return raiz;
    }

    /**
     * Visita a raiz, a sub-árvore da esquerda e, enfim, a subárvore da direita
     */
    public void preOrdem() {
        preOrdemAux(this.raiz);
    }

    private void preOrdemAux(NoDuplo raiz) {
        if(raiz != null) {
            System.out.print(raiz.getValor() + " ");
            preOrdemAux(raiz.getAnterior());
            preOrdemAux(raiz.getProximo());
        }
    }

    /**
     * Percorre a sub-árvore da esquerda, a raiz e então a sub-árvore direita
     */
    public void inOrdem() {
        inOrdemAux(this.raiz);
    }

    public void inOrdemAux(NoDuplo raiz) {
        if(raiz != null) {
            inOrdemAux(raiz.getAnterior());
            System.out.print(raiz.getValor() + " ");
            inOrdemAux(raiz.getProximo());
        }
    }

    /**
     * Percorre a sub-árvore esquerda, a direita e então a raíz
     */
    public void posOrdem() {
        posOrdemAux(this.raiz);
    }

    public void posOrdemAux(NoDuplo raiz) {
        if(raiz != null) {
            posOrdemAux(raiz.getAnterior());
            posOrdemAux(raiz.getProximo());
            System.out.print(raiz.getValor() + " ");
        }
    }

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.adicionar(5);
        arvore.adicionar(3);
        arvore.adicionar(2);
        arvore.adicionar(11);
        arvore.adicionar(7);
        arvore.adicionar(13);

        System.out.println("\nPré-ordem");
        arvore.preOrdem();
        System.out.println("\nIn-ordem");
        arvore.inOrdem();
        System.out.println("\nPós-ordem");
        arvore.posOrdem();
    }
}
