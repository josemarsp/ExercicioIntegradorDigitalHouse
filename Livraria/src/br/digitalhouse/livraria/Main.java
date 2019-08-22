package br.digitalhouse.livraria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Livro livro1 = new Livro(1, "A revolução dos Bichos", "George Orwell", 1945, 123456789, 10, 25.50);
        Livro livro2 = new Livro(2, "Animal Revotion", "George Orwell", 1945, 123456789, 11, 26.50);
        Livro livro3 = new Livro(3, "La revolucion de los animales", "George Orwell", 1945, 123456789, 0, 27.50);

        Sistema novoLivro = new Sistema();

        novoLivro.cadastrarLivro(livro1);
        novoLivro.cadastrarLivro(livro2);
        novoLivro.cadastrarLivro(livro3);

        novoLivro.imprimeCadastro();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        //Consulta de Livros
        Scanner codLivro = new Scanner(System.in);
        System.out.print("Digite o código do Livro para consulta: ");
        int cod = codLivro.nextInt();
        novoLivro.consultaLivro(cod);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        //Venda de Livro
        Scanner vendeLivro = new Scanner(System.in);
        System.out.print("Digite o código do Livro vendido: ");
        int vendCod = vendeLivro.nextInt();
        novoLivro.vendaLivro(vendCod);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        //Criando uma nova coleção
        Sistema novaColecao = new Sistema();
        novaColecao.cadastrarNaColecao("Coleção George", 17, livro1);
        novaColecao.cadastrarNaColecao("Coleção George", 17, livro2);
        novaColecao.cadastrarNaColecao("Coleção George", 17, livro3);

        novaColecao.setPreco(100.0);
        
        novaColecao.imprimeColecao();

    }


}






