public class Node {
    Node esquerda;

    Node direita;

    int info;

    public Node(int info){
        this.esquerda = null;
        this.direita = null;
        this.info = info;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}
