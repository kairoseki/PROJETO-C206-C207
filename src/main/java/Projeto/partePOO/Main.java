package Projeto.partePOO;

import ParteBD.FilmesBD;
import ParteBD.JogosBD;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        FilmesBD fBD= new FilmesBD();
        JogosBD jBD= new JogosBD();
        Filmes f1 = new Filmes();
        Jogos j1 = new Jogos();
        boolean flag = true;

        while(flag) {
            System.out.println("1 - Inserir Jogo");
            System.out.println("2 - Inserir Filme");
            System.out.println("3 - Deletar Jogo");
            System.out.println("4 - Deletar Filme");
            System.out.println("5 - Buscar Jogo");
            System.out.println("6 - Buscar Filme");
            System.out.println("7 - Atualizar Status Jogo");
            System.out.println("8 - Atualizar Status Filme");
            System.out.println("9 - Sair");
            System.out.println("Sua opçao: ");
            int op = sc.nextInt();

            switch (op){
                case 1:
                    sc.nextLine();
                    System.out.println("Digite o nome do Jogo: ");
                    j1.setNome(sc.nextLine());
                    System.out.println("Digite o genero do Jogo: ");
                    j1.setGenero(sc.nextLine());
                    System.out.println("Digite o ano de lancamento: ");
                    j1.setDataLancamento(sc.nextInt());
                    System.out.println("Digite o status do Jogo alugado(0)/disponivel(1): ");
                    j1.setStatus(sc.nextInt());
                    sc.nextLine();

                    if(jBD.inserirJogo(j1)){
                        System.out.println("Jogo inserido!");
                    }
                    else{
                        System.out.println("Erro na inserçao!");
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Digite o nome do Filme: ");
                    f1.setNome(sc.nextLine());
                    System.out.println("Digite o genero do filme: ");
                    f1.setGenero(sc.nextLine());
                    System.out.println("Digite o ano de lancamento: ");
                    f1.setDataLancamento(sc.nextInt());
                    System.out.println("Digite o status do Filme alugado(0)/disponivel(1): ");
                    f1.setStatus(sc.nextInt());
                    sc.nextLine();

                    if(fBD.inserirFilmes(f1)){
                        System.out.println("Filme inserido!");
                    }
                    else{
                        System.out.println("Erro na inserçao!");
                    }
                    break;
                case 3:
                    int id3;
                    sc.nextLine();
                    System.out.println("Digite o id do jogo a ser excluído: ");
                    id3 = sc.nextInt();
                    if(jBD.deletarJogo(id3)){
                        System.out.println("Jogo deletado!");
                    }
                    else{
                        System.out.println("Erro ao deletar!");
                    }
                    break;

                case 4:
                    int id4;
                    sc.nextLine();
                    System.out.println("Digite o id do Filme a ser excluído: ");
                    id4 = sc.nextInt();
                    System.out.println(id4);
                    if(fBD.deletarFilme(id4)){
                        System.out.println("Filme deletado!");
                    }
                    else{
                        System.out.println("Erro ao deletar!");
                    }
                    break;

                case 5:
                    ArrayList<Jogos> jogos = jBD.buscarJogos();
                    break;

                case 6:
                    ArrayList<Filmes> filmes = fBD.buscarFilmes();
                    break;
                case 7:
                    int id;
                    sc.nextLine();
                    System.out.println("Digite o id do jogo a ser atualizado: ");
                    id = sc.nextInt();
                    System.out.println("Digite novo status do Jogo: ");
                    System.out.println("Jogo alugado(0)/disponivel(1) ");
                    j1.setStatus(sc.nextInt());

                    if(jBD.atualizarStatusJogo(id, j1)){
                        System.out.println("Status alterado!");
                    }
                    else{
                        System.out.println("Erro na alteração!");
                    }
                    break;
                case 8:
                    int id2;
                    sc.nextLine();
                    System.out.println("Digite o id do filme a ser atualizado: ");
                    id2 = sc.nextInt();
                    System.out.println("Digite novo status do Filme: ");
                    System.out.println("Jogo alugado(0)/disponivel(1) ");
                    f1.setStatus(sc.nextInt());

                    if(fBD.atualizarStatusFilme(id2, f1)){
                        System.out.println("Status alterado!");
                    }
                    else{
                        System.out.println("Erro na alteração!");
                    }
                    break;
                case 9:
                    System.out.println("Voce saiu");
                    flag = false;
                    break;

                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }
}





