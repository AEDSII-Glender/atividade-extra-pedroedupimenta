public class Buscador {
    private NoABB raiz;
    
    
    public void inserir(Musica m) {
    raiz = inserirRec(raiz, m);
    }
    
    
    private NoABB inserirRec(NoABB atual, Musica m) {
    if (atual == null) {
    return new NoABB(m);
    }
    if (m.getId() < atual.getMusica().getId()) {
    atual.setEsquerda(inserirRec(atual.getEsquerda(), m));
    } else {
    atual.setDireita(inserirRec(atual.getDireita(), m));
    }
    return atual;
    }
    
    
    public Musica buscar(int id) {
    NoABB atual = raiz;
    while (atual != null) {
    if (id == atual.getMusica().getId()) {
    return atual.getMusica();
    }
    if (id < atual.getMusica().getId()) {
    atual = atual.getEsquerda();
    } else {
    atual = atual.getDireita();
    }
    }
    return null;
    }
    }
