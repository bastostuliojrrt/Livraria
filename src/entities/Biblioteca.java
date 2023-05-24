package entities;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado à biblioteca: " + livro.getTitulo());
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
        System.out.println("Livro removido da biblioteca: " + livro.getTitulo());
    }

    public void emprestarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livro.setDisponibilidade(false);
            System.out.println("Livro emprestado: " + livro.getTitulo());
        } else {
            System.out.println("Livro não disponível para empréstimo: " + livro.getTitulo());
        }
    }

    public void devolverLivro(Livro livro) {
        if (!livro.isDisponivel()) {
            livro.setDisponibilidade(true);
            System.out.println("Livro devolvido: " + livro.getTitulo());
        } else {
            System.out.println("Livro já está disponível: " + livro.getTitulo());
        }
    }

    public void pesquisarLivrosDisponiveis() {
        System.out.println("Livros disponíveis na biblioteca:");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro.getTitulo() + " - " + livro.getAutor());
            }
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
