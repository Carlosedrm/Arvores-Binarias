public class Binarias {
    public static int calcular_filho_esquerdo(int posicao){
        return(2 * posicao) + 1;
    }

    public static int calcular_filho_direito(int posicao){
        return(2 * posicao) + 2;
    }

    public static void main(String[] args){
        // Criamos a árvore
        Arvore_Binaria arvore = new Arvore_Binaria();
        arvore.setRaiz(new Node(0));

        // Só para teste vamos setar o A e B que são os primeiros
        arvore.getRaiz().setEsquerda(new Node(1));
        arvore.getRaiz().setDireita(new Node(2));
        // Criamos a lista

        Node[] lista = new Node[15];
        int i = 0;
        // Agora inserimos os numeros e nodes
        lista[0] = arvore.getRaiz();
        lista[1] = arvore.getRaiz().getEsquerda();
        lista[2] = arvore.getRaiz().getDireita();


        // Inserindo um filho à esquerda do nó 1 (posição 3 na lista)
        int posicao = calcular_filho_esquerdo(lista[1].getInfo());
        Node novoNo = new Node(posicao);
        lista[3] = novoNo;

        // Imprimi aqui alguns elementos aleatorios
        System.out.println(lista[0].getInfo());
        System.out.println("Nó 1 (esquerda do raiz): " + lista[1].getInfo());
        System.out.println("Nó 2 (direita do raiz): " + lista[2].getInfo());
        System.out.println("Nó 3 (filho à esquerda do nó 1): " + lista[3].getInfo());
    }

}
