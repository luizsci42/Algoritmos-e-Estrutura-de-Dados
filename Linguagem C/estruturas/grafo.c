struct vertice {
    int valor;
    struct vertice *proximo;
};

struct aresta {
    struct vertice *a;
    struct vertice *b;
};

void adicionarVizinho(struct vertice v, struct vertice u);
void listaAdjacencia(struct vertice v);

int main() {
    struct vertice v;
    struct vertice w;
    struct vertice x;
    struct vertice y;
    struct vertice z;

    v.valor = 15;
    w.valor = 30;
    x.valor = 2;
    y.valor = 55;
    z.valor = 42;

    adicionarVizinho(v, w);
    adicionarVizinho(v, x);
    adicionarVizinho(x, y);
    adicionarVizinho(x, z);
    adicionarVizinho(y, v);

    listaAdjacencia(v);

    return 0;
}
