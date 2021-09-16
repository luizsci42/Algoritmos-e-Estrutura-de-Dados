package estruturas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
class Vertice {
    private String id;
    // O valor é utilizado em grafos rotulados
    private Object valor;
    private List<Aresta> arestas;
    private List<Vertice> vizinhos;
    private int grau = 0;

    /**
     * Permite criar um vértice isolado, sem ligação com outros.
     * @param valor O valor armazenado no vértice
     */
    public Vertice(String nome, Object valor) {
        this.id = nome;
        this.valor = valor;
    }

    public Vertice(Object valor, Aresta aresta) {
        this.valor = valor;
        this.arestas = new ArrayList<>();
        this.arestas.add(aresta);
        this.grau += 1;
    }

    public void adicionarVizinho(Vertice vertice) {
        Aresta aresta = new Aresta(this, vertice);

        if (arestas == null) {
            List<Aresta> arestas1 = new ArrayList<>();
            vizinhos = new ArrayList<>();

            arestas1.add(aresta);
            this.arestas = arestas1;
        }
        else {
            this.arestas.add(aresta);
        }

        vizinhos.add(vertice);
        // O grau deste nó é incrementado
        this.grau += 1;
        // O grau do vértice ao qual este se conecta também é incrementado
        vertice.setGrau();
        // O vértice ao qual se conecta também ganha uma nova aresta
        aresta = new Aresta(vertice, this);
        vertice.adicionarAresta(aresta);
    }

    private void adicionarAresta(Aresta aresta) {
        List<Aresta> conjArestas = this.arestas;

        if (conjArestas == null) {
            conjArestas = new ArrayList<>();
            this.arestas = conjArestas;
        }
        this.arestas.add(aresta);
    }

    public void mostrarArestas() {
        for(Aresta aresta : arestas) {
            System.out.println(aresta);
        }
    }

    @Override
    public String toString() {
        return this.id;
    }

    public String getNome() {
        return id;
    }

    public void setNome(String nome) {
        this.id = nome;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getGrau() {
        return grau;
    }

    private void setGrau() {
        this.grau += 1;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public List<Vertice> getVizinhos() {
        return this.vizinhos;
    }
}

/**
 * Uma aresta conecta dois Vértices
 */
class Aresta {
    private Vertice a;
    private final Vertice b;
    private Vertice proximo;

    public Aresta(Vertice a, Vertice b) {
        this.a = a;
        this.b = b;
    }

    public Aresta(Vertice a, Vertice b, boolean orientado) {
        if (orientado) {
            this.b = b;
            this.setProximo(b);
        }
        else {
            this.a = a;
            this.b = b;
        }
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

    public Vertice getProximo() {
        return proximo;
    }

    public void setProximo(Vertice proximo) {
        this.proximo = proximo;
    }

    public Vertice getA() {
        return a;
    }

    public Vertice getB() {
        return b;
    }
}

/**
 * Implementa um grafo não orientado. Para um grafo orientado, veja a classe DiGrafo.java
 * Um grafo G é uma estrutura definida como um par ordenado (V, A), em que
 * V(G) é o conjunto de vértices de G e A(G) o conjunto de arestas que conecta
 * cada vértice v pertencente a V.
 *
 * Algumas definições:
 * <b>Grafo regular</b> é aquele em uqe todos os vértices do grafo possuem o mesmo grau.
 * <b>Caminho</b> de u para v é a sequência de n+1 vértices, em que u = v0 e v = vn e vn-1 é
 * adjacente a vi (i pertencente aos inteiros).
 *
 * <b>Caminho fechado</b> é aquele que vn = v.
 *
 * <b>Caminho simples</b> o caminho em que todos os nós são distintos, exceto para o caso de vn = v0,
 * para o qual temos um caminho simples fechado.
 *
 * <b>Grafo completo</b> é aquele em que todos os grafos estão conectados; ou seja, há um caminho entre
 * quaisquer u e v pertencentes ao grafo. Um grafo completo possui n(n-1)/2 arestas, em que n é o número
 * de vértices do grafo.
 *
 * <b>Clique</b> em um grafo não direcionado, clique é um subconjunto do conjunto de vértices tal que
 * para cada dois vértices, há uma aresta que conecta dois vértices.
 *
 * <b>Arestas Múltiplas</b> é quando duas arestas diferentes conectam o mesmo par de vértices.
 *
 * <b>Loop</b> é uma aresta cujos pontos finais é o mesmo vértice.
 *
 * <b>Multi grafo</b> é um grafo com arestas múltiplas e loops.
 *
 * <b> Tamanho de um grafo</b> é o número de vértices.
 */
public class Grafo {
    // O conjunto de vértices do grafo
    private List<Vertice> vertices;
    // O conjunto de arestas do grafo
    private List<Aresta> arestas;
    // O tamanho do grafo é dado pelo número de vértices que contém
    private int tamanho;

    /**
     * Cria um grafo vazio, sem vértices.
     */
    public Grafo() {}

    public Grafo(Vertice vertice) {
        this.adicionarVertice(vertice);
    }

    public void adicionarVertice(Vertice vertice) {
        // É apenas dado um vértice inicial para que possam ser feitas as operações
        if(this.vertices == null) {
            this.vertices = new ArrayList<>();
            this.arestas = new ArrayList<>();
            this.vertices.add(vertice);
            this.arestas.addAll(vertice.getArestas());
        }
        // Para o caso de um grafo já ter um vértice,
        // pegamos todos os vizinhos dele e todos os vizinhos de vizinhos
        Vertice inicial = vertices.get(0);
        for(Aresta aresta : inicial.getArestas()) {
            Vertice vizinho = aresta.getB();
            this.vertices.add(vizinho);
            this.arestas.addAll(vizinho.getArestas());
        }
        this.tamanho = this.vertices.size();
    }

    /* Representações do grafo */

    /**
     * Mostra o grafo em uma lista de adjacência.
     * Exemplo:
     * v -> (w, 30) (x, 2) (y, 55)
     * w -> (v, 15)
     * x -> (v, 15) (y, 55) (z, 42)
     * y -> (x, 2) (v, 15)
     */
    public void listaDeAdjacencia() {
        assert this.vertices != null;
        System.out.println("Lista de adjacência (id, valor)");
        for(Vertice vertice : vertices) {
            System.out.print(vertice + " -> ");
            for(Aresta aresta : vertice.getArestas()) {
                Vertice vizinho = aresta.getB();
                System.out.print("(" + vizinho + ", " + vizinho.getValor() + ") ");
            }
            System.out.print('\n');
        }
    }

    public Object[][] matrizAdjacencia() {
        // TODO: Implementar função para gerar uma matriz de adjacência
        Object[][] matrizAdj = new Object[this.tamanho][this.tamanho];
        int indiceX = 0;
        int indiceY = 0;

        for(Vertice v1 : vertices) {
            ArrayList<Vertice> vizinhosV1 = (ArrayList<Vertice>) v1.getVizinhos();
            for(Vertice v2 : vertices) {
                if(vizinhosV1.contains(v2)) {
                    matrizAdj[indiceX][indiceY] = 1;
                }
                else {
                    matrizAdj[indiceX][indiceY] = 0;
                }
                indiceY++;
            }
            indiceX++;
        }
        return matrizAdj;
    }

    /* Algoritmos de transversão */
    // TODO: ver a seção de algoritmos de transversão de grafos e implementar
    public void buscaEmLargura() {
        // TODO: implementar busca em largura
    }

    public void buscaEmProfundidade() {
        // TODO: implementar busca em profundidade
    }

    /* Algoritmos de menor caminho */

    public void arvoreGeradoraMinima() {
        // TODO: implementar árvore geradora mínima
    }

    public void dijkistra() {
        // TODO: implementar algoritmo de Dijkstra
    }

    public void warshall() {
        // TODO: implementar algoritmo de Warshall
    }

    public void passeio(Vertice inicial, Vertice chegada) {}

    /* Getters e setters */

    public List<Aresta> getArestas() {
        return arestas;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public static void main(String[] args) {
        Vertice v = new Vertice("v", 15);
        Vertice w = new Vertice("w", 30);
        Vertice x = new Vertice("x", 2);
        Vertice y = new Vertice("y", 55);
        Vertice z = new Vertice("z", 42);

        v.adicionarVizinho(w);
        v.adicionarVizinho(x);
        x.adicionarVizinho(y);
        x.adicionarVizinho(z);
        y.adicionarVizinho(v);

        Grafo g = new Grafo(v);
        g.listaDeAdjacencia();
    }
}