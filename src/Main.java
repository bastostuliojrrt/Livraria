import entities.Biblioteca;
import entities.Livro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Sistema de Gerenciamento de Biblioteca ---");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Remover livro");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("5. Pesquisar livros disponíveis");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Adicionar Livro ---");
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();

                    Livro livro = new Livro(titulo, autor, isbn);
                    biblioteca.adicionarLivro(livro);
                    break;
                case 2:
                    System.out.println("\n--- Remover Livro ---");
                    System.out.println("Digite o título do livro a ser removido:");
                    titulo = scanner.nextLine();

                    Livro livroRemovido = null;
                    for (Livro l : biblioteca.getLivros()) {
                        if (l.getTitulo().equalsIgnoreCase(titulo)) {
                            livroRemovido = l;
                            break;
                        }
                    }

                    if (livroRemovido != null) {
                        biblioteca.removerLivro(livroRemovido);
                    } else {
                        System.out.println("Livro não encontrado na biblioteca.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Emprestar Livro ---");
                    System.out.println("Digite o título do livro a ser emprestado:");
                    titulo = scanner.nextLine();

                    Livro livroEmprestado = null;
                    for (Livro l : biblioteca.getLivros()) {
                        if (l.getTitulo().equalsIgnoreCase(titulo)) {
                            livroEmprestado = l;
                            break;
                        }
                    }

                    if (livroEmprestado != null) {
                        biblioteca.emprestarLivro(livroEmprestado);
                    } else {
                        System.out.println("Livro não encontrado na biblioteca.");
                    }
                    break;
                case 4:
                    System.out.println("\n--- Devolver Livro ---");
                    System.out.println("Digite o título do livro a ser devolvido:");
                    titulo = scanner.nextLine();

                    Livro livroDevolvido = null;
                    for (Livro l : biblioteca.getLivros()) {
                        if (l.getTitulo().equalsIgnoreCase(titulo)) {
                            livroDevolvido = l;
                            break;
                        }
                    }

                    if (livroDevolvido != null) {
                        biblioteca.devolverLivro(livroDevolvido);
                    } else {
                        System.out.println("Livro não encontrado na biblioteca.");
                    }
                    break;
                case 5:
                    System.out.println("\n--- Pesquisar Livros Disponíveis ---");
                    biblioteca.pesquisarLivrosDisponiveis();
                    break;
                case 6:
                    executando = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}