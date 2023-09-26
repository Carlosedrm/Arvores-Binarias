public class Corte {

    public static Node insercao(Node raiz, int numero){
        if(raiz == null){
            return new Node(numero);
        } else if(numero >= raiz.getInfo()){
            raiz.setDireita(insercao(raiz.getDireita(), numero));
        } else{
            raiz.setEsquerda(insercao(raiz.getEsquerda(), numero));
        }
        return raiz;
    }

    public static void imprecao(Node raiz){
        if(raiz != null){
            System.out.println(raiz.getInfo());
            imprecao(raiz.getEsquerda());
            imprecao(raiz.getDireita());
        }
    }


    public static void main(String[] args) {
        int[] vetor = {14, 15, 4, 9, 7, 18, 3, 5, 16, 4, 20, 17, 9, 14, 5};

        Arvore_Binaria arvore = new Arvore_Binaria();

        // Para inserir os números
        for(int numero : vetor){
            arvore.setRaiz(insercao(arvore.getRaiz(), numero));
        }

        // Para imprimir os números
        imprecao(arvore.getRaiz());
    }
}
