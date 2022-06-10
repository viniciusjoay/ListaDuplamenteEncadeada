public class Main {

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada(1000);

        System.out.println("Inserção");
        lista.insere(1);
        lista.insere(2);
        lista.insere(3);
        lista.insere(4);
        lista.insere(5);
        System.out.println(lista);

        System.out.println("Inserção por índice");
        lista.insere(0, 0);
        lista.insere(6, 6);
        System.out.println(lista);

        System.out.println("Subtituição de valores via índice");
        lista.setInformacao(8, 7);
        System.out.println(lista);

        System.out.println("Verificação de um valor em um determindo índice");
        System.out.println("[ " + lista.getInformacao(0) + " ]");

        System.out.println("Remoção por índice");
        lista.remover(0);
        System.out.println(lista);

        System.out.println("Remoção do último valor");
        lista.remover(lista.getTamanho());
        System.out.println(lista);

    }

}
