public class Node<T> {
    private Node<T> anterior;
    private Node<T> proximo;
    T informacao;

    public Node(T informacao) {
        this.informacao = informacao;
    }
    public T getInformacao() {
        return informacao;
    }

    public void setInformacao(T informacao) {
        this.informacao = informacao;
    }

    public Node<T> getProximo() {
        return proximo;
    }

    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }

    public Node<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Node<T> anterior) {
        this.anterior = anterior;
    }
}
