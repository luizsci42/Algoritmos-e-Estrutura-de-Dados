package estruturas;

/**
 * Árvore binária de busca
 */
public class ArvoreBinariaBusca {
    // TODO: Implementar deleção
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
     * Método para buscar determinado valor na árvore binária de busca.
     *
     * @param valor o valor inteiro que se quer buscar.
     * @return Um NoDuplo, caso o valor exista e null caso contrário.
     */
    public NoDuplo buscar(int valor) {
        return buscarAux(this.raiz, valor);
    }

    /**
     * Função recursiva de busca. A verdadeira busca é feita neste método.
     *
     * @param raiz raiz da árvore, sendo alterada recursivamente.
     * @param valor valor que se busca.
     * @return NoDuplo, caso o valor exista, null caso contrário.
     */
    private NoDuplo buscarAux(NoDuplo raiz, int valor) {
        // Se chegarmos em um nó nulo, é porque o elemento não existe
        if(raiz == null) {
            return raiz;
        }
        else if(valor == (int) raiz.getValor()) {
            return raiz;
        }
        else if(valor < (int) raiz.getValor()) {
            // O retorno deste caso será um nó não nulo, se o valor for encontrado, e nulo caso contrário
            return buscarAux(raiz.getAnterior(), valor);
        }
        else if(valor > (int) raiz.getValor()) {
            return buscarAux(raiz.getProximo(), valor);
        }

        // Se não cair em nenhum desses casos, a árvore está vazia ou o elemento não foi encontrado
        return raiz;
    }

    /**
     * Visita a raiz, a sub-árvore da esquerda e, enfim, a subárvore da direita
     */
    public void preOrdem() {
        preOrdemAux(this.raiz);
    }

    /**
     * Método recursivo de pré-ordem. A árvore é verdadeiramente percorrida neste método
     *
     * @param raiz A raiz da árvore ou da sub-árvore, quando em recursão.
     */
    private void preOrdemAux(NoDuplo raiz) {
        if(raiz != null) {
            System.out.print(raiz.getValor() + " ");
            preOrdemAux(raiz.getAnterior());
            preOrdemAux(raiz.getProximo());
        }
    }

    /**
     * Percorre a sub-árvore da esquerda, a raiz e então a sub-árvore direita.
     * No caso de uma árvore binária de busca, os itens são percorridos em ordem cescente
     */
    public void inOrdem() {
        inOrdemAux(this.raiz);
    }

    private void inOrdemAux(NoDuplo raiz) {
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

    private void posOrdemAux(NoDuplo raiz) {
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

        NoDuplo quinzePresente = arvore.buscar(15);
        NoDuplo onzePresente = arvore.buscar(11);

        if(quinzePresente != null) {
            System.out.println("O número 15 está na árvore");
        }
        else {
            System.out.println("Não encontrado o valor 15");
        }

        if(onzePresente != null) {
            System.out.println("O número " + onzePresente.getValor() + " está na árvore");
        }
        else {
            System.out.println("Não encontrado o valor 11");
        }

        System.out.println("\nPré-ordem");
        arvore.preOrdem();
        System.out.println("\nIn-ordem");
        arvore.inOrdem();
        System.out.println("\nPós-ordem");
        arvore.posOrdem();
    }
}
