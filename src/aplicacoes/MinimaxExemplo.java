package aplicacoes;

import estruturas.ArvoreBinariaBusca;

public class MinimaxExemplo {
    ArvoreBinariaBusca jogo = new ArvoreBinariaBusca();

    public void iniciar() {
        jogo.adicionar(17);
        jogo.adicionar(15);
        jogo.adicionar(90);
        jogo.adicionar(1);
        jogo.adicionar(95);
        jogo.adicionar(55);
        jogo.adicionar(12);

        // Percorre a árvore em pré-ordem: raiz, sub-arvore esquerda e sub-arvore direita
        jogo.preOrdem();
    }

    public static void main(String[] args) {
        MinimaxExemplo minimax = new MinimaxExemplo();
        minimax.iniciar();
    }
}
