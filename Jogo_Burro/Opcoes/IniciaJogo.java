package Opcoes;

import Burro.MesaBurro;
import Usuarios.Jogador;
import java.util.LinkedList;

public class IniciaJogo {
   
    // Cria uma nova lista de jogadores 
    private final LinkedList<Jogador> listaJogadores = new LinkedList<>(); 

    public IniciaJogo() {
        System.out.println("Seja bem vindo(a) ao Jogo Burro!" + "\n");
        System.out.println("Antes de iniciar, cadastre-se: " + "\n");
        MesaBurro mesa = new MesaBurro(listaJogadores);
    }
  
}
