#include <stdlib.h>
#include <stdio.h>

typedef struct node {
    /* Este nó armazena valores do tipo inteiro.
     * Se quisermos criar uma lista de tipos genéricos,
     * podemos usar um ponteiro do tipo void. */
    void *valor;
    struct node *proximo;
} node;

void percorrer(node *inicial) {
    node *no_atual = inicial;
    node *ultimo;

    // Atribuimos ao nó atual o próximo nó da lista
    // Até que o próximo seja NULL
    while(no_atual != NULL) {
        printf("%d -> ", no_atual->valor);
        ultimo = no_atual;
        no_atual = no_atual->proximo; 
    }

    printf("fim\n");
}

// O parâmetro **ptr_inicial é um ponteiro que aponta para outro ponteiro, por isso dois ** 
void adicionar(int valor, node **ptr_inicial) {
    node *novo_no = malloc(sizeof(node));

    novo_no->valor = valor;
    novo_no->proximo = NULL;

    // Se o valor de inicial for nulo, não há nada na lista
    if(*ptr_inicial == NULL) {
        // O valor de inicial é o endereço do novo nó
        // Porém, o ponteiro inicial continua alocado no mesmo lugar na memória
        *ptr_inicial = novo_no;
    }
    // Se não é nulo, existe pelo menos um item na lista
    else {
        node **ultimo = ptr_inicial;
        // Encontre o último nó da lista, aponte o último para o novo nó e o novo para null
        while(*ultimo != NULL) {
            // &(*inicial) se refere ao endereço do próximo nó na memória
            ultimo = &((*ultimo)->proximo);
        }
        *ultimo = novo_no;
    }
}

void buscar(void *valor, node **inicial) {
    node **atual = inicial;
    int posicao;

    while(*atual != valor) {
        atual = &((*atual)->proximo);
        posicao = &atual;
    }

    printf("pos: %d", posicao);
}

int main() {
    node *inicial = NULL;

    // Estou passando o enderço na memória alocado para o ponteiro inicial
    adicionar(2, &inicial);
    // Quando chego aqui, inicial = novo_no, sendo que novo_no->valor = 2 e novo_no->proximo=NULL
    adicionar(3, &inicial);
    adicionar(5, &inicial);
    adicionar(7, &inicial);
    adicionar(11, &inicial);
    adicionar(13, &inicial);
    adicionar(17, &inicial);
    // Aqui passamos o valor de inicial. Ou seja, o primeiro nó da lista
    // Estamos passando o valor ao invés do endereço, porque esta função não
    // altera o valor de inicial. Ou seja, não altera para onde inicial está apontando
    mostrar_lista(inicial);

    // buscar(11, &inicial);

    return 0;
}