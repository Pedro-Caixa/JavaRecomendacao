package CLasses;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario(1L, "João Silva", "joao@gmail.com", "senha123");
        Usuario usuario2 = new Usuario(2L, "Maria Oliveira", "maria@gmail.com", "senha456");

        GerenciarProdutos gerenciar = new GerenciarProdutos();

        Produto produto1 = new Produto(1L, "Laptop", 500.0, 10);
        Produto produto2 = new Produto(2L, "Mouse", 100.0, 30);
        Produto produto3 = new Produto(3L, "Teclado", 400.0, 20);
        Produto produto4 = new Produto(4L, "Monitor", 800.0, 15);
        Produto produto5 = new Produto(5L, "Remote Play", 1000.0, 10);
        Produto produto6 = new Produto(6L, "Memoria ram", 300.0, 30);
        Produto produto7 = new Produto(7L, "Placa de video", 800.0, 5);

        gerenciar.adicionarProduto(produto1);
        gerenciar.adicionarProduto(produto2);
        gerenciar.adicionarProduto(produto3);
        gerenciar.adicionarProduto(produto4);
        gerenciar.adicionarProduto(produto5);
        gerenciar.adicionarProduto(produto6);
        gerenciar.adicionarProduto(produto7);

        List<Produto> todosProdutos = gerenciar.getListaProdutos();

        List<Produto> comprasUsuario1 = Arrays.asList(produto1, produto2, produto3, produto4);
        Historico historico1 = new Historico(1L, usuario1, comprasUsuario1, LocalDateTime.now().minusDays(10));

        List<Produto> comprasUsuario2 = Arrays.asList(produto2, produto3);
        Historico historico2 = new Historico(2L, usuario2, comprasUsuario2, LocalDateTime.now().minusDays(5));

        List<Historico> todosHistoricos = Arrays.asList(historico1, historico2);

        SistemaRecomendacao sistema = new SistemaRecomendacao(todosHistoricos, todosProdutos);

        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.print("\nEscolha uma opcao:");
            System.out.print("\n1 - Adicionar Produto");
            System.out.print("\n2 - Listar Produto");
            System.out.print("\n3 - Ver Recomendacoes");
            System.out.print("\n4 - Sair");
            System.out.print("\nOpcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciar.adicionarProduto();
                    break;
                case 2:
                    gerenciar.listarProdutos();
                    break;
                case 3:
                    System.out.println("Produtos comprados anteriormente por " + usuario1.getNome() + ":");
                    for (Historico historico : todosHistoricos) {
                        if (historico.getnome().getid() == usuario1.getid()) {
                            historico.getProdutos().forEach(produto ->
                                    System.out.println("- " + produto.getNome() + " | Preço: " + produto.getPreco())
                            );
                        }
                    }
                    List<Produto> recomendacoes = sistema.gerarRecomendacoes(usuario1, 2);
                    System.out.println("Recomendações para " + usuario1.getNome() + ":");
                    recomendacoes.forEach(produto -> System.out.println("- " + produto.getNome() + " | Preço: " + produto.getPreco()));
                    break;
                case 4:
                    System.out.print("Saindo..");
                    break;
                default:
                    System.out.print("Opacao invalida");
                    break;
            }
        } while (opcao != 4);
    }
}
