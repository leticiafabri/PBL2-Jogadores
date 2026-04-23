public class No {

    Jogador jogador;
    No esquerda;
    No direita;

    public No(Jogador jogador) {
        this.jogador = jogador;
        this.esquerda = null;
        this.direita = null;
    }
}