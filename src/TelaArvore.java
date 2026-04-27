import javax.swing.*;
import java.awt.*;

public class TelaArvore extends JPanel {

    private ArvoreBinariaBusca arvore;

    public TelaArvore(ArvoreBinariaBusca arvore) {
        this.arvore = arvore;


        setPreferredSize(new Dimension(2000, 1200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.PLAIN, 10));

        desenhar(g, arvore.raiz, getWidth() / 2, 40, getWidth() / 4);
    }

    private void desenhar(Graphics g, No no, int x, int y, double espacamento) {

        if (no == null) return;


        if (espacamento < 30) {
            espacamento = 30;
        }

        g.drawOval(x - 15, y - 15, 30, 30);

        FontMetrics fm = g.getFontMetrics();
        String nome = no.jogador.getNickname();

        if (nome.length() > 8) {

            String parte1 = nome.substring(0, nome.length() / 2);
            String parte2 = nome.substring(nome.length() / 2);

            int largura1 = fm.stringWidth(parte1);
            int largura2 = fm.stringWidth(parte2);

            g.drawString(parte1, x - largura1 / 2, y - 5);
            g.drawString(parte2, x - largura2 / 2, y + 10);

        } else {

            int largura = fm.stringWidth(nome);
            g.drawString(nome, x - largura / 2, y + 5);
        }

        if (no.esquerda != null) {
            g.drawLine(x, y, (int)(x - espacamento), y + 80);
            desenhar(g, no.esquerda, (int)(x - espacamento), y + 80, espacamento / 2);
        }

        if (no.direita != null) {
            g.drawLine(x, y, (int)(x + espacamento), y + 80);
            desenhar(g, no.direita, (int)(x + espacamento), y + 80, espacamento / 2);
        }
    }
}