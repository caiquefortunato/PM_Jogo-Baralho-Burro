/*
 * Classe que simula uma mesa do burro, que funciona como um juiz do jogo
 */
package Burro;
import Baralho.*;
import Usuarios.*;
import Burro.OrdenaRodada.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import Util.*;

public class JuizBurro {
    
    private final LinkedList<Jogador> listaAuxiliar;
    private final ArrayList<NotasPartida> listaGanhadores;
    
    // Cria construtor para juiz, ele ja inicia com algumas pecas
    public JuizBurro() {
        this.listaAuxiliar = new LinkedList<>();
        this.listaGanhadores = new ArrayList<>();
    }
    
    // Retorna o primeiro jogador que vai iniciar a rodada
    protected Jogador DefineJogadorInicial (LinkedList<Jogador> listaJogadores){
        Random gerador = new Random();       
        int numGerado = gerador.nextInt(listaJogadores.size());
        
        return listaJogadores.get(numGerado);
    } 
    
    // Verifica se o jogador de fato pode realizar a jogada
    protected boolean VerificaJogadaValida (Carta carta, Stack<Carta> pilhaDeDescarte) {
        Carta cartaPilhaDescarte = pilhaDeDescarte.lastElement();
        
        return carta.getNaipe().equals(cartaPilhaDescarte.getNaipe());
    }
    
    // Distribui cinco cartas entre cada jogador
    protected void DistribuiCartas(LinkedList<Jogador> listaJogadores, JuizBaralho baralho){

        for(int j = 0; j < 5; j++)
        {
            for(int i = 0; i < listaJogadores.size(); i++) {
                Carta distCarta = baralho.retornaCarta();
                listaJogadores.get(i).AdicionaCarta(distCarta);
                baralho.removeCarta(distCarta);
            }            
        }
    }
    
    // Embaralha as cartas
    protected void EmbaralhaCartas(JuizBaralho baralho) {
        baralho.embaralhaCartas();
    }
    
    // Retorna o resultado final
    protected void resultadoFinal(LinkedList<Jogador> listaJogadores) {
        
        OrdenaResultados ordenaResultados = new OrdenaResultados();
        
        for(int i = 0; i < listaJogadores.size(); i++) {
            int tamanhoMao = listaJogadores.get(i).TamanhoMao();
            String nomeJogador = listaJogadores.get(i).getNome();
            NotasPartida notaFinal = new NotasPartida(nomeJogador, tamanhoMao);
            listaGanhadores.add(notaFinal);
        }
        
        Collections.sort(listaGanhadores, ordenaResultados);
        ImprimeResultado(listaGanhadores);
    }
    
    // Imprime o resutlado do jogo
    protected void ImprimeResultado(ArrayList<NotasPartida> listaGanhadores) {
        
        Util.limpaTela();
        System.out.println("Resultado final do Jogo Burro: " + "\n");
        int total;
        
        for(int i = 0; i < listaGanhadores.size(); i++){
            total = i + 1;
            System.out.println(total + "° lugar: " + 
                    listaGanhadores.get(i).getNomeJogador() + " Possui: " +
                    listaGanhadores.get(i).getCartasMao() + 
                    " anos de burro!");
        }
        
    }
    
    // Verifica se o valor do indice das cartas eh valido
    protected int VerificaValorIndice(int indice, Jogador jogador){
        Scanner input = new Scanner(System.in);
        indice = input.nextInt();
        while(indice <= 0 || indice > jogador.TamanhoMao()) {
            System.out.println("\n" + "Valor invalido! Tente novamente");
            indice = input.nextInt();
        }
        return indice;
    }
    
    // Define o proximo jogador
    protected void DefineOrdemJogadores(ArrayList<Rodada> listaRodada, LinkedList<Jogador> listaJogadores) {
        // Ordena a mao de cartas
        OrdenaRodada ordenaRodada = new OrdenaRodada();
        Collections.sort(listaRodada, ordenaRodada);
        
        listaJogadores.clear();
        
        for(int i = 0; i < listaRodada.size(); i++) {
            listaJogadores.add(i, listaRodada.get(i).getJogador());
        }
    }
    
}
