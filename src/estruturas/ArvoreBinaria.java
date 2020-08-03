package estruturas;

import java.util.prefs.NodeChangeEvent;

/**
 * Em uma árvore geral (general tree), cada nó pode ter um
 * número árbitrário de descendentes. A representação de tal
 * árvore é feitua tutilizando a estrutura de grafos, que
 * será abordada posteriormente. No entanto, a implementação
 * em grafos trazem prejuízos quanto aos processos de uma
 * árvore, sendo mais vantajoso converter árevores gerais
 * em árvores binárias, em que cada nó pode ter no máximo
 * dois descendentes.
 *
 * Aqui estamos implementando uma árvore binária.
 * Por definição, uma árvore binária é uma estrutura
 * recursiva em que cada nó contém uma sub-ávore à
 * esquerda e outra à direita.
 */
public class ArvoreBinaria {
    private NoDuplo raiz;
    // Uma árvore-2 de altura h tem no mínimo h elementos e no máximo 2^h - 1
    private int numElementos;
    // A altura com n nós é de no mínimo log(n+1) (base 2) e no máximo n
    private int altura;

    /**
     * Adiciona os elementos em ordem nível (acessa todos os
     * nós em um nível da esquerda para a direita)
     *
     * @param valor Valor a ser adicionado na árvore.
     */
    public void adicionar(Object valor) {
        NoDuplo novo = new NoDuplo();
        novo.setValor(valor);

        // A árvore está vazia,então adicionamos o novo nó como raiz
        if(this.numElementos == 0) {
            novo.setAnterior(null);
            novo.setProximo(null);
            this.raiz = novo;
        }
        // Neste caso, a raiz não tem filhos à esquerda, então adicionamos
        else if(raiz.getAnterior() == null) {
            raiz.setAnterior(novo);
        }
        // Não tem filhos à direita, adicionamos
        else if(raiz.getProximo() == null) {
            raiz.setProximo(novo);
        }
        else {
            adicionarNo(novo);
        }

        this.numElementos += 1;
    }

    private void adicionarNo(NoDuplo novoNo) {
        // Etapa básica
        if(novoNo == this.raiz) {
            System.out.println("Nó adicionado");
        }
        // Etapa de recursão
        else {
            adicionarNo(novoNo.getAnterior());
            adicionarNo(novoNo.getProximo());
        }
    }

    /**
     * Visita a raiz, a sub-árvore da esquerda e, enfim, a subárvore da direita
     */
    public void preOrdem(NoDuplo raiz) {
        if(raiz != null) {
            System.out.println(raiz.getValor());
            preOrdem(raiz.getAnterior());
            preOrdem(raiz.getProximo());
        }
    }

    /**
     * Percorre a sub-árvore da esquerda, a raiz e então a sub-árvore direita
     */
    public void inOrdem(NoDuplo raiz) {
        if(raiz != null) {
            preOrdem(raiz.getAnterior());
            System.out.println(raiz.getValor());
            preOrdem(raiz.getProximo());
        }
    }

    /**
     * Percorre a sub-árvore esquerda, a direita e então a raíz
     */
    public void posOrdem(NoDuplo raiz){
        if(raiz != null) {
            posOrdem(raiz.getAnterior());
            posOrdem(raiz.getProximo());
            System.out.println(raiz.getValor());
        }
    }

    public NoDuplo getRaiz() { return raiz; }

    public void setRaiz(Object valor) { this.raiz.setValor(valor); }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        NoDuplo raiz = new NoDuplo();
        NoDuplo primeiro = new NoDuplo();
        NoDuplo segundo = new NoDuplo();
        NoDuplo terceiro = new NoDuplo();
        NoDuplo quarto = new NoDuplo();
        NoDuplo quinto = new NoDuplo();
        NoDuplo sexto = new NoDuplo();

        raiz.setValor(2);
        primeiro.setValor(3);
        segundo.setValor(5);
        terceiro.setValor(7);
        quarto.setValor(11);
        quinto.setValor(13);
        sexto.setValor(17);

        raiz.setAnterior(primeiro);
        raiz.setProximo(segundo);

        primeiro.setAnterior(terceiro);
        primeiro.setProximo(quarto);

        segundo.setAnterior(quinto);
        segundo.setProximo(sexto);

        System.out.println("Pré-ordem");
        arvore.preOrdem(raiz);
        System.out.println("\n");
        System.out.println("In-ordem");
        arvore.inOrdem(raiz);
        System.out.println('\n');
        System.out.println("Pós-ordem");
        arvore.posOrdem(raiz);
        System.out.println('\n');
    }
}
