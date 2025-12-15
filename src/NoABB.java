public class NoABB {
    private Musica musica;
    private NoABB esquerda;
    private NoABB direita;
    
    
    public NoABB(Musica musica) {
    this.musica = musica;
    this.esquerda = null;
    this.direita = null;
    }
    
    
    public Musica getMusica() {
    return musica;
    }
    
    
    public void setMusica(Musica musica) {
    this.musica = musica;
    }
    
    
    public NoABB getEsquerda() {
    return esquerda;
    }
    
    
    public void setEsquerda(NoABB esquerda) {
    this.esquerda = esquerda;
    }
    
    
    public NoABB getDireita() {
    return direita;
    }
    
    
    public void setDireita(NoABB direita) {
    this.direita = direita;
    }
    }
