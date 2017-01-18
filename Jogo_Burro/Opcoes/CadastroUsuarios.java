package Opcoes;

import Usuarios.Jogador;
import java.util.LinkedList;
import java.util.Scanner;

public class CadastroUsuarios {

    public CadastroUsuarios(LinkedList<Jogador> listaJogadores) {
        CadastraJogadores(listaJogadores);
    }
    
    private int CadastraUsuario(String opcao, LinkedList<Jogador> listaJogadores) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int indice, retorno;
        String opcaoNome = null;
        String nome;
        Jogador system;
        
        if("s".equals(opcao) || "S".equals(opcao)) {
            do {
                System.out.println("Digite a quantidade de jogadores (sem incluir o sistema):");
                System.out.println("Maximo: 3 jogadores (sem incluir o sistema)"); 
                indice = input.nextInt();
            } while(indice > 4 || indice < 1);   
            retorno = indice;
            

                system = new Jogador("System", 1);    
                listaJogadores.add(system); 
        }
        else {
            do {
                System.out.println("Digite a quantidade de jogadores:");
                System.out.println("Maximo de jogadores permitido: 4"); 
                indice = input.nextInt();
            } while(indice > 4 || indice < 1);      
            retorno = indice;
        }
        
        return retorno;
    }
    
    // Metodo cadastra novos jogadores
    private void CadastraJogadores(LinkedList<Jogador> listaJogadores) {
        Scanner input = new Scanner(System.in);
        int indice;
        String opcao = null;
        
        while(true)
        {
            System.out.println("Deseja jogar contra o sistema? <s/n>");
            opcao = input.next();
            if("s".equals(opcao) || "n".equals(opcao)) break;
        }
        
        System.out.println();
        
        indice = CadastraUsuario(opcao, listaJogadores);

        for(int i = 1; i < indice + 1; i++) {
            int index = i + 1;
            System.out.println("Digite o nome do jogador :");
            String nome = input.next();
            Jogador j = new Jogador(nome, i + 1);
            listaJogadores.add(j);
        }
        System.out.println("\n" + "Jogadores cadastrados!" + "\n");
        
        for(int i = 0; i < listaJogadores.size(); i++)
            System.out.println("Nome: " + listaJogadores.get(i).getNome());
        System.out.println(); System.out.println();
    }    
    
}
