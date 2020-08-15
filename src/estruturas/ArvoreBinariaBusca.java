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
     * nós em um nível da esquerda para a direita).
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
     * Método para a remoção de nós da árvore
     * @param valor O valor que se deseja remover
     */
    public void remover(int valor) {
        if(this.raiz == null) {
            System.out.println("A árvore está vazia. Não é possível remover");
        }
        else {
            System.out.println("Remover: " + valor);
            NoDuplo atual = this.raiz;
            NoDuplo ascendente = atual;

            // Primeiro percorremos a árvore até encontrar o valor,
            // guardando o nó pai e o que queremos remover
            while((int) atual.getValor() != valor) {
                ascendente = atual;
                if((int) atual.getValor() > valor) {
                    atual = atual.getAnterior();
                }
                else {
                    atual = atual.getProximo();
                }
            }
            // Verificamos quantos filhos o nó contém e eecutamos as ações para cada caso
            if(atual.getAnterior() == null && atual.getProximo() == null) {
                System.out.println("Removendo folha");
                // Caso em que o nó é uma folha, basta remover o nó da estrutura
                if((int) ascendente.getValor() > valor) {
                    ascendente.setAnterior(null);
                }
                else {
                    ascendente.setProximo(null);
                }
            }
            // Caso em que o nó possui apenas um descendente.
            // Verificamos se o descendente possui valor menor ou maior que o
            // ascendente do nó removido e o realocamos.
            if(atual.getAnterior() == null && atual.getProximo() != null) {
                System.out.println("Removendo nó com um descendente");
                ascendente.setAnterior(atual.getProximo());
                atual.setProximo(null);
            }
            else if(atual.getAnterior() != null && atual.getProximo() == null) {
                System.out.println("Removendo nó com um descendente");
                ascendente.setAnterior(atual.getAnterior());
                atual.setAnterior(null);
            }
            // Caso em que o nó possui dois descendentes
            if(atual.getAnterior() != null && atual.getProximo() != null) {
                System.out.println("Removendo nó com dois descendentes");
                /* Neste caso, iremos substituir o valor do nó pelo seu antecessr ou sucessor in-order
                 * (arvore esquerda, raiz, direita) e remover este predecessor ou sucessor da estrutura.
                 *
                 * O sucessor in-ordem é o menor valor da sub árvore direita do nó atual. Já o antecessor
                 * é o maior alor da sub árvore esquerda.
                 */
                NoDuplo sucessor = buscarMenor(atual.getProximo());

                remover((int) sucessor.getValor());
                sucessor.setAnterior(atual.getAnterior());
                sucessor.setProximo(atual.getProximo());

                if((int) ascendente.getValor() > (int) sucessor.getValor()) {
                    ascendente.setAnterior(sucessor);
                }
                else {
                    ascendente.setProximo(sucessor);
                }
            }
        }
    }

    /**
     * Método para buscar determinado valor na árvore binária de busca.
     *
     * @param valor o valor inteiro que se quer buscar.
     * @return Um NoDuplo, caso o valor exista e null caso contrário.
     */
    public NoDuplo buscar(int valor) {
        // Implementamos um método auxiliar para abstrair a recursão.
        // Assim, quando a busca é chamada, só é preciso passar o valor como argumento.
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

        return raiz;
    }

    public NoDuplo buscarMaior(NoDuplo raiz) {
        NoDuplo maior = raiz;

        while (raiz != null) {
            maior = raiz;
            raiz = raiz.getProximo();
        }

        return maior;
    }

    public NoDuplo buscarMenor(NoDuplo raiz) {
        NoDuplo menor = raiz;

        while(raiz != null) {
            menor = raiz;
            raiz = raiz.getAnterior();
        }

        return menor;
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
        if (raiz != null) {
            posOrdemAux(raiz.getAnterior());
            posOrdemAux(raiz.getProximo());
            System.out.print(raiz.getValor() + " ");
        }
    }

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.adicionar(45);
        arvore.adicionar(39);
        arvore.adicionar(56);
        arvore.adicionar(54);
        arvore.adicionar(78);
        arvore.adicionar(55);
        arvore.adicionar(80);

        NoDuplo valor = arvore.buscar(55);
        NoDuplo outroValor = arvore.buscar(11);

        if(valor != null) {
            System.out.println("O número " + valor.getValor() + " está na árvore");
        }
        else {
            System.out.println("Valor não encontrado");
        }

        if(outroValor != null) {
            System.out.println("O número " + outroValor.getValor() + " está na árvore");
        }
        else {
            System.out.println("Valor não encontrado");
        }

        System.out.println("\nPré-ordem");
        arvore.preOrdem();
        System.out.println("\nIn-ordem");
        arvore.inOrdem();
        System.out.println("\nPós-ordem");
        arvore.posOrdem();
        System.out.print("\n\n");

        arvore.remover(80);
        arvore.remover(54);
        arvore.remover(56);
        System.out.println("\nPré-ordem");
        arvore.preOrdem();
        System.out.println("\nIn-ordem");
        arvore.inOrdem();
        System.out.println("\nPós-ordem");
        arvore.posOrdem();
    }
}
