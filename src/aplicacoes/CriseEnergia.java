package aplicacoes;

import java.util.Scanner;

/**
 * Solução do problema 1031 do URI: https://www.urionlinejudge.com.br/judge/pt/problems/view/1031
 * utilizando lista encandeada circular.
 */
public class CriseEnergia {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numRegioes = entrada.nextInt();

        while(numRegioes != 0) {
            if(numRegioes == 13) {
                System.out.print("1\n");
            }
            else {
                Regioes regioes = new Regioes();
                int salto = 1;
                int valor = 0;

                while(valor != 13) {
                    salto++;
                    regioes.adicionar(numRegioes);
                    valor = regioes.percorrer(salto);
                }

                System.out.printf("%d\n", salto);
            }
            numRegioes = entrada.nextInt();
        }
    }
}

class Regioes {
    private Regiao inicial;
    private int numRegioes;

    public Regioes() {
        this.numRegioes = 0;
    }

    public void adicionar(int numRegioes) {
        for (int i = 1; i <= numRegioes; i++) {
            Regiao nova = new Regiao();
            nova.setValor(i);
            if (this.numRegioes == 0) {
                this.inicial = nova;
            } else {
                Regiao atual = inicial.getProximo();
                Regiao ultimo = atual;

                while (atual != inicial) {
                    ultimo = atual;
                    atual = atual.getProximo();
                }

                ultimo.setProximo(nova);
            }
            nova.setProximo(inicial);
            this.numRegioes++;
        }
    }

    public int percorrer(int salto) {
        Regiao atual = inicial.getProximo();
        Regiao ultimo= atual;
        int cont = 1;

        while (numRegioes > 0) {
            while (atual != inicial && numRegioes > 0) {
                ultimo = atual;
                atual = atual.getProximo();
                cont++;
                if (atual.getProximo().getValor() == 1) {
                    atual.setProximo(atual.getProximo().getProximo());
                    numRegioes--;
                }
                if (cont == salto && numRegioes != 0) {
                    ultimo.setProximo(atual.getProximo());
                    cont = 0;
                    numRegioes--;
                }
            }
            atual = atual.getProximo();
        }
        return ultimo.getValor();
    }

    static class Regiao {
        private int valor;
        private Regiao proximo;

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public Regiao getProximo() {
            return proximo;
        }

        public void setProximo(Regiao proximo) {
            this.proximo = proximo;
        }
    }
}