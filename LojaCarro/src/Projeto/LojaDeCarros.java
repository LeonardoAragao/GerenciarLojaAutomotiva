package Projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class LojaDeCarros {
    private ArrayList<Carro> carros;

    public LojaDeCarros() {
        carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
        System.out.println("Carro adicionado com sucesso!");
    }

    public void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            for (Carro carro : carros) {
                System.out.println(carro);
            }
        }
    }

    public void atualizarCarro(int indice, Carro carroAtualizado) {
        if (indice >= 0 && indice < carros.size()) {
            carros.set(indice, carroAtualizado);
            System.out.println("Carro atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void removerCarro(int indice) {
        if (indice >= 0 && indice < carros.size()) {
            carros.remove(indice);
            System.out.println("Carro removido com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void buscarCarrosPorMarca(String marca) {
        boolean encontrado = false;
        for (Carro carro : carros) {
            if (carro.getMarca().equalsIgnoreCase(marca)) {
                System.out.println(carro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum carro encontrado para a marca " + marca);
        }
    }

    public static void main(String[] args) {
        LojaDeCarros loja = new LojaDeCarros();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLoja de Carros - Menu:");
            System.out.println("1. Adicionar carro");
            System.out.println("2. Listar carros");
            System.out.println("3. Atualizar carro");
            System.out.println("4. Remover carro");
            System.out.println("5. Buscar carros por marca");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); 
                    Carro carro = new Carro(marca, modelo, ano, preco);
                    loja.adicionarCarro(carro);
                    break;
                case 2:
                    loja.listarCarros();
                    break;
                case 3:
                    System.out.print("Índice do carro a ser atualizado: ");
                    int indiceAtualizar = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nova Marca: ");
                    String novaMarca = scanner.nextLine();
                    System.out.print("Novo Modelo: ");
                    String novoModelo = scanner.nextLine();
                    System.out.print("Novo Ano: ");
                    int novoAno = scanner.nextInt();
                    System.out.print("Novo Preço: ");
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine(); 
                    Carro carroAtualizado = new Carro(novaMarca, novoModelo, novoAno, novoPreco);
                    loja.atualizarCarro(indiceAtualizar, carroAtualizado);
                    break;
                case 4:
                    System.out.print("Índice do carro a ser removido: ");
                    int indiceRemover = scanner.nextInt();
                    scanner.nextLine();
                    loja.removerCarro(indiceRemover);
                    break;
                case 5:
                    System.out.print("Marca para buscar: ");
                    String marcaBusca = scanner.nextLine();
                    loja.buscarCarrosPorMarca(marcaBusca);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
