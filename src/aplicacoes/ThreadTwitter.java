package aplicacoes;

import estruturas.ListaEncandeada;
import java.util.Scanner;

/**
 * Exemplo de aplicação de uma lista encandeada.
 * Simula uma thread do twitter.
 * Uma thread do twitter possui um tweet inicial, que vem seguido dos demais tweets.
 */
public class ThreadTwitter {
    ListaEncandeada fio;

    ThreadTwitter() {
        System.out.println("Criar thread");
        fio = new ListaEncandeada();
    }

    public void adicionarMensagem(String texto) {
        Mensagem mensagem = new Mensagem(texto);
        fio.adicionar(mensagem.getMensagem());
    }

    public void mostrarThread() {
        fio.percorrer();
    }
}

class Mensagem {
    private String mensagem;

    Mensagem(String texto) {
        int LIMITE_CARACTERES = 280;
        if(texto.length() > LIMITE_CARACTERES) {
            System.out.println("A mensagem deve ter até 280 caracteres");
        }
        else {
            this.setMensagem(texto);
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThreadTwitter tt = new ThreadTwitter();
        boolean continuar = true;

        while(continuar) {
            System.out.println("Digite um texto de até 280 caracteres: ");
            String texto = scanner.nextLine();

            tt.adicionarMensagem(texto);

            System.out.println("Adicionar novo texto? s/n");
            String resposta = scanner.nextLine();

            if(!resposta.equals("s")) {
                continuar = false;
            }
        }

        tt.mostrarThread();
    }
}
