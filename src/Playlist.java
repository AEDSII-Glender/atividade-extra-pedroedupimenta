package sim;

public class Playlist {
    private NoMusica inicio;
    private NoMusica fim;
    
    
    public boolean estaVazia() {
    return inicio == null;
    }
    
    public void adicionar(Musica m) {
    NoMusica novo = new NoMusica(m);
    if (inicio == null) {
    inicio = fim = novo;
    } else {
    fim.prox = novo;
    novo.ant = fim;
    fim = novo;
    }
    }
    public boolean removerPorId(int id) {
    NoMusica atual = inicio;
    while (atual != null) {
    if (atual.musica.getId() == id) {
    if (atual.ant != null) atual.ant.prox = atual.prox;
    else inicio = atual.prox;
    
    
    if (atual.prox != null) atual.prox.ant = atual.ant;
    else fim = atual.ant;
    return true;
    }
    atual = atual.prox;
    }
    return false;
    }

    public NoMusica buscarPorNome(String nome) {
    NoMusica atual = inicio;
    while (atual != null) {
    if (atual.musica.getNome().equalsIgnoreCase(nome)) {
    return atual;
    }
    atual = atual.prox;
    }
    return null;
    }
    
    public void exibir() {
    if (estaVazia()) {
    System.out.println("Playlist vazia");
    return;
    }
    NoMusica atual = inicio;
    while (atual != null) {
    System.out.println(atual.musica);
    atual = atual.prox;
    }
    }
    }
