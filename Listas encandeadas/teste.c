int main() {
    int valor = 10;
    int *ptr;
    int **pptr;

    ptr = &valor;
    pptr = ptr;

    printf("Endereco da variavel: %d\n", &valor);
    printf("Ponteiro: %d\n", ptr);
    printf("Valor do ponteiro: %d\n", *ptr);
    
    printf("Endereco do ponteiro: %d\n", &ptr);
    printf("Segundo ponteiro: %d\n", pptr);
    *pptr = 15;

    printf("Valor da variavel: %d\n", valor);
    printf("Valor do ponteiro: %d\n", *ptr);

    return 0;
}