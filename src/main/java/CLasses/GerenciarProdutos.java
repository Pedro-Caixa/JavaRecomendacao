package CLasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarProdutos {
    private List<Produto> listaProdutos;

    public GerenciarProdutos(){
        this.listaProdutos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
        System.out.printf("Produto adicionado "+ produto.getNome() + " com sucesso!\n");
    }

    public void listarProdutos(){
        if (listaProdutos.isEmpty()){
            System.out.printf("Nenhum produto Cadastrado.");
        }else{
            System.out.printf("Lista De Produtos:\n");
            for (Produto produto : listaProdutos){
                System.out.printf("ID: %d | Nome: %s | Preco: %.2f | Quantidade: %d%n",
                        produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
            }
        }
    }

    public void adicionarProduto() {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            System.out.printf("Adicionando um novo produto\n");

            System.out.printf("Digite o ID do produto: ");
            long id = scanner.nextLong();
            scanner.nextLine();

            System.out.printf("Digite o nome do produto: ");
            String nome = scanner.nextLine();

            System.out.printf("Digite o preco do produto: ");
            double preco = scanner.nextDouble();

            System.out.printf("Digite o quantidade do produto: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            Produto produto = new Produto(id, nome, preco, quantidade);
            adicionarProduto(produto);

            System.out.print("Deseja adicionar outro produto? (S/N): ");
            continuar = scanner.nextLine().trim().toLowerCase();
        } while (continuar.equals("s"));

        System.out.println("Finalizando adição de produtos.");
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

}
