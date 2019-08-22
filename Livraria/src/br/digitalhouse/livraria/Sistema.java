package br.digitalhouse.livraria;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    private List<Livro> lista = new ArrayList<>();
    private List<Livro> colecao = new ArrayList<>();
    private String nomeColecao;
    private int codColecao;
    private double preco;

    public void cadastrarLivro(Livro livro) {
        lista.add(livro);
    }

    public void cadastrarNaColecao(String nomeColecao, int codColecao, Livro livro) {
        colecao.add(livro);
        this.nomeColecao = nomeColecao;
        this.codColecao = codColecao;
    }

    public void imprimeCadastro() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());

        }
    }

    public void imprimeColecao() {
        System.out.println("Nome da Coleção: " + nomeColecao);
        System.out.println("Código da coleção: " + getCodColecao());
        for (int i = 0; i < colecao.size(); i++) {
            System.out.println("  " + colecao.get(i).getAutor() + " - " + colecao.get(i).getTitulo());
        }
        System.out.println("Valor da Coleção: " + getPreco());
    }

    public int getCodColecao() {
        return codColecao;
    }

    public void setCodColecao(int codColecao) {
        this.codColecao = codColecao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void consultaLivro(int cod) {
        String resultado = "Livro não encontrado";
        for (int i = 0; i < lista.size(); i++) {
            if (cod == lista.get(i).getCodigo()) {
                System.out.println(lista.get(i).toString());
                resultado = "Livro encontrado!";
            }

        }
        System.out.println(resultado);
    }

    public void vendaLivro(int vendCod) {

        for (int i = 0; i < lista.size(); i++) {
            if ((vendCod == lista.get(i).getCodigo()) && (lista.get(i).getEstoque() <= 0)) {
                System.out.println("Livro Esgotado!!");
            } else if (vendCod == lista.get(i).getCodigo() && lista.get(i).getEstoque() > 0) {
                System.out.println(lista.get(i).getCodigo() + " - " + lista.get(i).getTitulo() + " - " + lista.get(i).getEstoque());//Checa o estoque anterior
                int estoque = lista.get(i).getEstoque();
                lista.get(i).setEstoque(estoque - 1);
                System.out.println("Vendido com sucesso!");
                System.out.println(lista.get(i).getCodigo() + " - " + lista.get(i).getTitulo() + " - " + lista.get(i).getEstoque()); //Verifica o novo estoque
            }
        }
    }
}


