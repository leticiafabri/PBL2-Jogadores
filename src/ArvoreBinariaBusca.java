public class ArvoreBinariaBusca {

    No raiz;

    public void inserir(Jogador j) {
        raiz = inserir(raiz, j);
    }

    private No inserir(No atual, Jogador j) {

        if (atual == null) {
            return new No(j);
        }

        if (j.getRanking() < atual.jogador.getRanking()) {
            atual.esquerda = inserir(atual.esquerda, j);
        } else {
            atual.direita = inserir(atual.direita, j);
        }

        return atual;
    }

    public boolean buscar(String nome) {
        return buscar(raiz, nome) != null;
    }

    private No buscar(No atual, String nome) {

        if (atual == null) return null;

        if (atual.jogador.getNickname().equals(nome)) {
            return atual;
        }

        No esquerda = buscar(atual.esquerda, nome);
        if (esquerda != null) return esquerda;

        return buscar(atual.direita, nome);
    }

    public Jogador remover(String nome) {

        No encontrado = buscar(raiz, nome);

        if (encontrado == null) return null;

        Jogador removido = encontrado.jogador;
        raiz = remover(raiz, encontrado.jogador.getRanking());

        return removido;
    }

    private No remover(No atual, int ranking) {

        if (atual == null) return null;

        if (ranking < atual.jogador.getRanking()) {
            atual.esquerda = remover(atual.esquerda, ranking);
        } else if (ranking > atual.jogador.getRanking()) {
            atual.direita = remover(atual.direita, ranking);
        } else {

            if (atual.esquerda == null) return atual.direita;
            if (atual.direita == null) return atual.esquerda;

            No menor = encontrarMenor(atual.direita);
            atual.jogador = menor.jogador;
            atual.direita = remover(atual.direita, menor.jogador.getRanking());
        }

        return atual;
    }

    private No encontrarMenor(No no) {
        if (no.esquerda == null) return no;
        return encontrarMenor(no.esquerda);
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.println(no.jogador.getNickname() + " - " + no.jogador.getRanking());
            emOrdem(no.direita);
        }
    }
}