int main() {
    float area, raio;
    const float pi = 3.14;

    printf("Digite o valor do raio: ");
    scanf("%f", &raio);

    area = pi * (raio*raio);

    printf("Área: %.2f", area);
    return 0;
}