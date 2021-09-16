#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

struct node {
    char vertice;
    struct node *proximo;
};

struct node *gnode;
void mostrarGrafo(struct node *adj[], int numDeNos);
void criarGrafo(struct node *adj[], int numDeGrafos);

int main() {
    struct node *Adj[10];
    int i, numDeNos;

    printf("Entre como o numero de nos do grafo: ");
    scanf("%d", &numDeNos);

    for(i = 0; i < numDeNos; i++) {
        Adj[i] = NULL;
    }

    criarGrafo(Adj, numDeNos);
    printf("O grafo é: ");
    mostrarGrafo(Adj, numDeNos);
    getch();

    return 0;
}

void criarGrafo(struct node *Adj[], int numDeNos) {
    struct node *novoNo, *ultimo;
    int i, j, n, val;

    for(i = 0; i < numDeNos; i++) {
        ultimo = NULL;
        printf("Entre com o numero de vizinhos de %d: ", i);
        scanf("%d", &n);
        for(j = i; j <= n; j++) {
            printf("Entre com o vizinho %d de %d: ", j, i);
            scanf("%d", &val);
            novoNo = (struct node *) malloc(sizeof(struct node));
            novoNo -> vertice = val;
            novoNo -> proximo = NULL;
            if(Adj[i] == NULL) {
                Adj[i] = novoNo;
            }
            else {
                ultimo -> proximo = novoNo;
            }
            ultimo = novoNo;
        }
    }
}

void mostrarGrafo(struct node *Adj[], int numDeNos) {
    struct node *ptr;
    int i;

    for(i = 0; i < numDeNos; i++) {
        ptr = Adj[i];
        printf("Os vizinhos de %d sao: ", i);
        while(ptr != NULL) {
            printf("\t%d", ptr -> vertice);
            ptr = ptr -> proximo;
        }
    }
}