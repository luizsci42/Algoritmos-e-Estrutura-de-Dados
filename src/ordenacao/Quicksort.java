package ordenacao;

import java.util.Arrays;
import java.util.ArrayList;

public class Quicksort {
    public ArrayList<Integer> sort(ArrayList<Integer> vetor) {
        int tamanho = vetor.size();

        if (tamanho == 0 || tamanho == 1) {
            return vetor;
        }
        else {
            int posicaoPivot = 0;
            int valorPivot = vetor.get(posicaoPivot);
            int valorAtual;
            ArrayList<Integer> vetorEsquerdo = new ArrayList<Integer>();
            ArrayList<Integer> vetorDireito = new ArrayList<Integer>();

            for (int i = 1; i < tamanho; i++) {
                valorAtual = vetor.get(i);

                if (valorAtual <= valorPivot) {
                    vetorEsquerdo.add(valorAtual);
                }
                else if (valorAtual > valorPivot) {
                    vetorDireito.add(valorAtual);
                }
            }
            ArrayList<Integer> resultado = new ArrayList<Integer>();
            resultado.addAll(sort(vetorEsquerdo));
            resultado.add(valorPivot);
            resultado.addAll(sort(vetorDireito));

            return resultado;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> valores = new ArrayList<Integer>(Arrays.asList(1,7,8,2,5,4,3));

        System.out.println(valores);

        Quicksort ordenar = new Quicksort();
        ArrayList<Integer> ordenado = ordenar.sort(valores);

        System.out.println(ordenado);
    }
}