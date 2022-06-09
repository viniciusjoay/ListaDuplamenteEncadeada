public class Main {

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada(100);

        //Add
        lista.insere(1);
        lista.insere(2);
        lista.insere(3);
        lista.insere(1,4);
        lista.imprimir();
    }

}
