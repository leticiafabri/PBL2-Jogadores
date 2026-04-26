import javax.swing.*;
import java.awt.*;

public class TelaArvore extends JPanel {

    private ArvoreBinariaBusca arvore;

    public TelaArvore(ArvoreBinariaBusca arvore) {
        this.arvore = arvore;
    }
//test
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenhar(g, arvore.raiz, getWidth() / 2, 40, getWidth() / 4);
    }

    private void desenhar(Graphics g, No no, int x, int y, int espacamento) {

        if (no == null) return;

        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(no.jogador.getNickname(), x - 20, y + 5);

        if (no.esquerda != null) {
            g.drawLine(x, y, x - espacamento, y + 80);
            desenhar(g, no.esquerda, x - espacamento, y + 80, espacamento / 2);
        }

        if (no.direita != null) {
            g.drawLine(x, y, x + espacamento, y + 80);
            desenhar(g, no.direita, x + espacamento, y + 80, espacamento / 2);
        }
    }
}