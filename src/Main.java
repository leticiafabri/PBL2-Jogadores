import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        try {
            BufferedReader br = new BufferedReader(new FileReader("players.csv"));
            String linha;

            br.readLine();

            while ((linha = br.readLine()) != null) {

                String[] partes = linha.split(",");
                String nome = partes[0];
                int ranking = Integer.parseInt(partes[1]);

                arvore.inserir(new Jogador(nome, ranking));
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo");
        }

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Inserir");
            System.out.println("2 - Buscar");
            System.out.println("3 - Remover");
            System.out.println("4 - Mostrar em ordem");
            System.out.println("5 - Visualizar árvore");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Ranking: ");
                int ranking = sc.nextInt();

                arvore.inserir(new Jogador(nome, ranking));
            }

            if (opcao == 2) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.println(arvore.buscar(nome));
            }

            if (opcao == 3) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                Jogador j = arvore.remover(nome);
                System.out.println(j != null ? "Removido" : "Não encontrado");
            }

            if (opcao == 4) {
                arvore.emOrdem();
            }

            if (opcao == 5) {
                JFrame tela = new JFrame("Árvore Binária");
                tela.setSize(800, 600);
                tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                TelaArvore painel = new TelaArvore(arvore);
                tela.add(painel);

                tela.setVisible(true);
            }

        } while (opcao != 0);

        sc.close();
    }
}