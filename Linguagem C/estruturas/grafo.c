struct vertice {
    char id[3];
    int valor;
    struct vertice *proximo;
};

struct aresta {
    struct vertice *a;
    struct vertice *b;
};

