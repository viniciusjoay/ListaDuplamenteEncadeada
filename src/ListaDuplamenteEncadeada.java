public class ListaDuplamenteEncadeada<T> {
    Node<T> topo;
    Node<T> base;
    int tamanho = 0;
    int capacidade;

    public ListaDuplamenteEncadeada(int capacidade){
        this.capacidade = capacidade;
    }

    public boolean vazia(){
        return this.tamanho == 0;
    }

    public boolean cheia(){
      return this.tamanho == this.capacidade;
    }

    public void insere(T informacao){

        Node<T> primeiro = new Node(informacao); // Criar um nó e atribuir ao dado o valor passado por parâmetro
        if(this.vazia()){
                this.base = primeiro; // Atribuir o nó criado a base
        }else{
                primeiro.setAnterior(this.topo); // Nó anterior aponta para o topo
                this.topo.setProximo(primeiro);// Próximo do topo aponta para o nó
        }
        this.topo = primeiro; // Atribuir o nó criado ao topo
        this.tamanho++; // Incrementar a variável tamanho em 1
    }

    public void insere(int pos, T informacao){
        if(!this.cheia()){
            if (pos == this.tamanho) { //Checa se a posição é igual ao tamanho da lista, se for, adiciona o valor ao final da lista.
                this.insere(informacao);
            }else{
                Node<T> no = new Node(informacao); //Cria uma variável no e atribui à ela um novo nó com o valor recebido por parâmetro.
                Node<T> proximo = this.getNode(pos); //Armazena em uma variável proximo o nó que está atualmente na posição que deseja inserir (getNode(pos)).
                Node<T> anterior = proximo.getAnterior(); //Armazena em uma variável anterior o nó anterior ao que está atualmente na posição que deseja inserir (proximo.anterior)

                if (anterior == null) { //Precisamos saber também se estamos inserindo na base. Para isso checamos se o nó anterior (anterior) é igual a null. Caso essa condição seja verdadeira, atribuímos o no à base.
                    no.setProximo(proximo); //Atribui ao anterior do no o anterior (no.anterior = anterior)
                    proximo.setAnterior(no); //Atribui ao próximo do no o proximo(no.proximo = proximo)
                    this.base = no;
                } else {
                    no.setAnterior(anterior); //Atribui ao anterior do no o anterior (no.anterior = anterior)
                    no.setProximo(proximo); //Atribui ao próximo do no o proximo(no.proximo = proximo)
                    anterior.setProximo(no); //Se não estivermos inserindo na base (como no caso do nosso exemplo), então o proximo do nó anterior vai ser igual ao no (proximo.anterior = no)
                    proximo.setAnterior(no);// Ao final da função definimos que o anterior do proximo é igual ao no (anterior.proximo = no)
                }
            }
        }
        this.tamanho++;// e incrementamos o tamanho em 1 (tamanho += 1)
    }
    public Node<T> getNode(int pos) {
        int meio = this.tamanho/2; //Encontra o meio da lista (tamanho/2)
        Node<T> aux;

        if (pos < meio){ //Caso a posição seja inferior ao meio
            aux = this.base; // Realiza a iteração a partir da base.
            for (int i = 0; i < pos; i++) { //(i = 0 até i < pos)
                aux = aux.getProximo();
            }
        } else { //Caso a posição seja superior ao meio, cria um novo nó e define ele para topo. (i = tamanho - 1 até i > pos)
            aux = this.topo;
            for (int i = this.tamanho; i > pos; i--){
                aux = aux.getAnterior();
            }
        }
        return aux; //Ao final, a função retorna o nó na correspondente posição recebida por parâmetro.
    }

    // Criamos dois métodos de remoção

    //um público, que recebe como parâmetro a posição (int) do nó que deve ser removido
    public T remover(int pos){
        Node<T> node = getNode(pos);//Encontra o nó a partir do método getNode(pos)
        return this.remover(node);//e chama o método privado passando o nó como referência.
    }

    //um privado, que recebe como parâmetro o nó que será removido
    private T remover(Node<T> node){
        Node<T> anterior = node.getAnterior(); //Atualiza as referências de anterior dos vizinhos
        Node<T> proximo = node.getProximo(); //Atualiza as referências de próximo dos vizinhos

        if(anterior == null){ //O nó da base possui o anterior nulo
            node.setProximo(null);
            proximo.setAnterior(null);
            this.base = proximo;
        }else if(proximo == null){//O nó do topo possui o próximo nulo.
            node.setAnterior(null);
            anterior.setProximo(null);
            this.topo = anterior;
        }else{
            anterior.setProximo(proximo);
            proximo.setAnterior(anterior);

            node.setProximo(null);
            node.setAnterior(null);
        }

        this.tamanho--;
        return node.getInformacao();
    }

    public T getInformacao(int pos){
        Node<T> node = this.getNode(pos);
        return node.informacao;
    }

    public void setInformacao(int pos, T informacao){
        Node<T> node = this.getNode(pos);
        node.setInformacao(informacao);
    }

    @Override
    public String toString() {
       var text = "[ ";
       for(Node<T> node = base; node != null; node = node.getProximo()){
           text += node.informacao + " ";
       }
       text += "]";
       return text;
    }

    public int getTamanho() {
        return tamanho;
    }

}
