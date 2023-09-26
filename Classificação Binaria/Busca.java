import java.util.Scanner;

public class Busca {
    public static Node inserir(Node raiz, int numero) {
        if (raiz == null) {
            return new Node(numero);
        }
        if (numero >= raiz.getInfo()) {
            raiz.setDireita(inserir(raiz.getDireita(), numero));
        } else {
            raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
        }
        return raiz;
    }

    public static void imprimirIn(Node raiz){
        // Forma inordem
        if (raiz != null) {
            imprimirIn(raiz.getEsquerda());
            System.out.print(raiz.getInfo() + " ");
            imprimirIn(raiz.getDireita());
        }
    }

    public static void imprimirPre(Node raiz){
        // Forma préordem
        if (raiz != null) {
            System.out.print(raiz.getInfo() + " ");
            imprimirPre(raiz.getEsquerda());
            imprimirPre(raiz.getDireita());
        }
    }

    public static void imprimirPos(Node raiz){
        // Forma préordem
        if (raiz != null) {
            imprimirPos(raiz.getEsquerda());
            imprimirPos(raiz.getDireita());
            System.out.print(raiz.getInfo() + " ");
        }
    }


    public static Node encontrarMaior(Node raiz) {
        if (raiz == null) {
            return null;
        }

        while (raiz.getDireita() != null) {
            raiz = raiz.getDireita();
        }

        return raiz;
    }

    public static Node encontrarMenor(Node raiz) {
        if (raiz == null) {
            return null;
        }

        while (raiz.getEsquerda() != null) {
            raiz = raiz.getEsquerda();
        }

        return raiz;
    }

    public static int calcularAltura(Node raiz) {
        if (raiz == null) {
            return 0;
        } else {
            int alturaEsquerda = calcularAltura(raiz.getEsquerda());
            int alturaDireita = calcularAltura(raiz.getDireita());

            if (alturaEsquerda > alturaDireita) {
                return 1 + alturaEsquerda;
            } else {
                return 1 + alturaDireita;
            }
        }
    }

    public static Node removerElemento(Node raiz, int elemento){
        if(raiz != null){
            if(raiz.getInfo() == elemento){
                System.out.println("Encontramos o número!");
                // Encontramos o número certo

                // Verificamos se o node não possui filhos
                if(raiz.getEsquerda() == null && raiz.getDireita() == null){
                    return null;
                }

                // Aqui verificamos se ele tem um filho em alguma de suas raizes
                if (raiz.getEsquerda() == null) {
                    return raiz.getDireita();
                } else if (raiz.getDireita() == null) {
                    return raiz.getEsquerda();
                }

                // Calcule as alturas das subárvores esquerda e direita para ver qual lado da árvore estamos
                int alturaEsquerda = calcularAltura(raiz.getEsquerda());
                int alturaDireita = calcularAltura(raiz.getDireita());

                // Escolha o elemento substituto com base na altura das subárvores
                if (alturaEsquerda > alturaDireita) {
                    // Substituir pelo maior elemento da subárvore esquerda
                    Node maiorEsquerda = encontrarMaior(raiz.getEsquerda());
                    raiz.setInfo(maiorEsquerda.getInfo());
                    raiz.setEsquerda(removerElemento(raiz.getEsquerda(), maiorEsquerda.getInfo()));
                } else {
                    // Substituir pelo menor elemento da subárvore direita
                    Node menorDireita = encontrarMenor(raiz.getDireita());
                    raiz.setInfo(menorDireita.getInfo());
                    raiz.setDireita(removerElemento(raiz.getDireita(), menorDireita.getInfo()));
                }
            }
            else if (elemento < raiz.getInfo()) {
                // O elemento a ser removido está na subárvore esquerda já que e menor
                raiz.setEsquerda(removerElemento(raiz.getEsquerda(), elemento));
            } else {
                // O elemento a ser removido está na subárvore direita já que e maior
                raiz.setDireita(removerElemento(raiz.getDireita(), elemento));
            }
        }
        return raiz;
    }

    public static void main(String[] args) {
        // O teclado
        Scanner teclado = new Scanner(System.in);

        // Criando um vetor de inteiros com os elementos fornecidos
        //int[] vetor = {14, 15, 4, 9, 7, 18, 3, 5, 16, 4, 20, 17, 9, 14, 5};
        int[] vetor = {8,3,11,1,5,6,7,9,10,14,12,13,15};

        Arvore_Binaria arvore = new Arvore_Binaria();

        for(int numero: vetor){
            arvore.setRaiz(inserir(arvore.getRaiz(), numero));
        }

        System.out.println("Imprimindo a árvore na forma de In ordem: ");
        imprimirIn(arvore.getRaiz());

        System.out.println("\nImprimindo a árvore na forma de Pré ordem: ");
        imprimirPre(arvore.getRaiz());

        System.out.println("\nImprimindo a árvore na forma de Pós ordem: ");
        imprimirPos(arvore.getRaiz());

        // Primeiro encontramos o maior número na árvore e removemos ele
        System.out.println("\nEncontrando o maior elemento: ");
        Node elementoMaior = encontrarMaior(arvore.getRaiz());
        System.out.println("O elemento maior é: " + elementoMaior.getInfo() + " então será removido agora.");
        //arvore.setRaiz(removerElemento(arvore.getRaiz(),elementoMaior.getInfo()));

        // Depois encontramos o menor número na árvore e removemos ele
        System.out.println("\nEncontrando o menor elemento: ");
        Node elementoMenor = encontrarMenor(arvore.getRaiz());
        System.out.println("O elemento menor é: " + elementoMenor.getInfo() + " então será removido agora.");
        //arvore.setRaiz(removerElemento(arvore.getRaiz(),elementoMenor.getInfo()));

        System.out.println("A árvore com o Maior e Menor número removido!");
        //Imprimir a arvore para ver se o menor e maior numeros foram retirados
        imprimirIn(arvore.getRaiz());

        // Aqui o usuário pode adicionar um número que quiser na árvore
        System.out.println("\nDigite um número para adicionar na árvore: ");
        int adicionarx = teclado.nextInt();
        arvore.setRaiz(inserir(arvore.getRaiz(), adicionarx));

        // Imprimimos a árvore com o número adicionado
        System.out.println("A árvore com o seu valor adicionado!");
        imprimirIn(arvore.getRaiz());

        // Aqui o usuario pode remover um numero que quiser na [arvore
        System.out.println("\nDigite um número para remover na árvore: ");
        int removerx = teclado.nextInt();
        arvore.setRaiz(removerElemento(arvore.getRaiz(), removerx));

        //Imprimir a árvore para ver se o valor do usuário foi removido
        imprimirIn(arvore.getRaiz());
    }
}
