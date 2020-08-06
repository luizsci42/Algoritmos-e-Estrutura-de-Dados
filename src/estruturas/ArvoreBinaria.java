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
    /**
     * Visita a raiz, a sub-árvore da esquerda e, enfim, a subárvore da direita
     */
    public void preOrdem(NoDuplo raiz) {
        if(raiz != null) {
            System.out.print(raiz.getValor() + " ");
            preOrdem(raiz.getAnterior());
            preOrdem(raiz.getProximo());
        }
    }

    /**
     * Percorre a sub-árvore da esquerda, a raiz e então a sub-árvore direita
     */
    public void inOrdem(NoDuplo raiz) {
        if(raiz != null) {
            inOrdem(raiz.getAnterior());
            System.out.print(raiz.getValor() + " ");
            inOrdem(raiz.getProximo());
        }
    }

    /**
     * Percorre a sub-árvore esquerda, a direita e então a raíz
     */
    public void posOrdem(NoDuplo raiz) {
        if(raiz != null) {
            posOrdem(raiz.getAnterior());
            posOrdem(raiz.getProximo());
            System.out.print(raiz.getValor() + " ");
        }
    }

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
    }
}
