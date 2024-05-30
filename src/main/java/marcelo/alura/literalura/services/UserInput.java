package marcelo.alura.literalura.services;

import java.util.Scanner;

public class UserInput {

    private Scanner input;

    public UserInput() {
        input = new Scanner(System.in);
    }

    public void greetUser() {
        System.out.println("Bem vindo ao gutendex!");
    }

    public String getFilter(){
        input = new Scanner(System.in);
        System.out.println("Insira um filtro para fazer uma pesquisa:");
        return input.nextLine();
    }

    public int getUserChoice(){
        System.out.println("""
                Escolha a próxima operação:
                1 - Cadastrar livro.
                2 - Listar todos os livros.
                3 - Listar livro por autor.
                4 - Listar livro por língua.
                5 - Sair.""");

        while(true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor digite um valor inteiro.");
                input.next();
            }
        }
    }

    public int getUserSignChoiceNN(){
        System.out.println("""
                Escolha a próxima operação:
                1 - Escolher um dos livros para cadastro.
                2 - Escolher outro filtro.
                3 - Voltar para o menu.""");

        while(true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor digite um valor inteiro.");
                input.next();
            }
        }
    }

    public int getUserSignChoiceNP(){
        System.out.println("""
                Escolha a próxima operação:
                1 - Escolher um dos livros para cadastro.
                2 - Escolher outro filtro.
                3 - Voltar para a página anterior.
                4 - Voltar para o menu.""");

        while(true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor digite um valor inteiro.");
                input.next();
            }
        }
    }

    public int getUserSignChoicePN(){
        System.out.println("""
                Escolha a próxima operação:
                1 - Escolher um dos livros para cadastro.
                2 - Escolher outro filtro.
                3 - Ir para a página seguinte.
                4 - Voltar para o menu.""");

        while(true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor digite um valor inteiro.");
                input.next();
            }
        }
    }

    public int getUserSignChoicePP(){
        System.out.println("""
                Escolha a próxima operação:
                1 - Escolher um dos livros para cadastro.
                2 - Escolher outro filtro.
                3 - Ir para a página seguinte.
                4 - Voltar para a página anterior.
                5 - Voltar para o menu.""");

        while(true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor digite um valor inteiro.");
                input.next();
            }
        }
    }

    public int chooseBook(){
        System.out.println("Digite o número do livro que deseja cadastrar:");

        while(true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor digite um valor inteiro.");
                input.next();
            }
        }
    }

    public int chooseAuthor() {
        System.out.println("Digite o número do autor que deseja listar os livros:");

        while(true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor digite um valor inteiro.");
                input.next();
            }
        }
    }

    public int chooseLanguage() {
        System.out.println("Digite o número da língua que deseja listar os livros:");

        while(true) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor digite um valor inteiro.");
                input.next();
            }
        }
    }
}
