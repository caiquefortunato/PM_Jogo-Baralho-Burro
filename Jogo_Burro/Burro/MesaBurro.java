/*
 * A classe simula uma partida de Burro
 * Manipulacao de pilhas: https://www.caelum.com.br/apostila-java-estrutura-dados/pilhas/#6-7-api-do-java
 */
package Burro;

import Baralho.Carta;
import Baralho.JuizBaralho;
import Opcoes.CadastroUsuarios;
import Usuarios.*;
import java.util.LinkedList;
import java.util.Stack;
import Util.*;
import java.util.ArrayList;
import java.util.Scanner;

public final class MesaBurro {
    // Cria uma pilha de descarte
    protected Stack<Carta> pilhaDeDescarte;
    // Cria um juiz para o jogo
    private final JuizBurro juizBurro;
    // Cria um novo baralho
    protected JuizBaralho baralho;
    // Cria uma lista de rodada
    private final ArrayList<Rodada> listaRodada = new ArrayList<>();
    // Cria um novo objeto para rodada
    protected Rodada rodada;
    
    // Construtor publico para a mesa
    public MesaBurro(LinkedList<Jogador> listaJogadores) {
        this.baralho = new JuizBaralho();
        this.juizBurro = new JuizBurro();
        this.rodada = new Rodada();
        this.pilhaDeDescarte = new Stack<>();
        IniciaJogo(listaJogadores);
    }
    
    // Retorna a ultima carta da pilha de descarte
    protected void CartaPilhaDescarte() {
        System.out.println("\n" + "Carta da pilha de descarte: ");
        System.out.println(pilhaDeDescarte.lastElement().getValor() + " de " + pilhaDeDescarte.lastElement().getNaipe());
    }
    
    // Funcao que possibilita compra de cartas no baralho
    protected void CompraCartas(Jogador jogador) {
        Carta novaCarta = baralho.retornaCarta();
        jogador.AdicionaCarta(novaCarta);              
        baralho.removeCarta(novaCarta);    
    }
    
    // Jogada do sistema
    protected boolean JogadaSystem(Jogador system, LinkedList<Jogador> listaJogadores) {
        
        // Se eh a primeira jogada e/ou ele ganhou a partida
        if (listaJogadores.get(0).getId() == 1){
            Carta cartaEsc = system.MaiorCarta();
            pilhaDeDescarte.add(cartaEsc);
            Rodada novaRodada = new Rodada(system, cartaEsc);
            listaRodada.add(novaRodada);
            system.RemoveCarta(cartaEsc);            
            System.out.println("\n" + system.getNome() + " jogou uma carta: "
                    + cartaEsc.getValor() + " de " +cartaEsc.getNaipe());
        }
        // Se ele simplesmente vai jogar
        else {
            if(!baralho.verificaBaralho())
            {
                while(!system.VerificaNaipe(pilhaDeDescarte.lastElement())) {
                    CompraCartas(system);
                    System.out.println(system.getNome() + " comprou uma carta");
                }
                
                Carta cartaEsc = system.EscolherCartaNaipe(pilhaDeDescarte.lastElement());
                JogaCartaOperacoes(cartaEsc, system);
                System.out.println("\n" + system.getNome() + " jogou uma carta: "
                        + cartaEsc.getValor() + " de " +cartaEsc.getNaipe());  
                
            }
            else {
                Carta cartaEsc = system.EscolherCartaNaipe(pilhaDeDescarte.lastElement());

                if(cartaEsc == null){
                    System.out.println("\n" + system.getNome() + " nao jogou");
                }
                else {
                    JogaCartaOperacoes(cartaEsc, system);
                    System.out.println("\n" + system.getNome() + " jogou uma carta: "
                        + cartaEsc.getValor() + " de " +cartaEsc.getNaipe());  
                
                }
            }
           
        }
 
        return system.VerificaMao();
    }
    
    // Metodo completa a jogada do jogador ou do sistema
    protected void JogaCartaOperacoes(Carta cartaEsc, Jogador jogador) {        
        pilhaDeDescarte.add(cartaEsc);
        Rodada novaRodada = new Rodada(jogador, cartaEsc);
        listaRodada.add(novaRodada);
        
        jogador.RemoveCarta(cartaEsc);  
    }
    
    // Metodo simula a jogada de uma carta pelo jogador humano
    protected void JogadaReal(Jogador jogador) {
        Scanner input = new Scanner(System.in);
        int indice = 0;        
        
        // Informa o valor do indice da carta que deseja jogar
        System.out.println("\n" + "Digite o indice da carta que deseja jogar:");
        // Le e verifica se eh valido
        indice = juizBurro.VerificaValorIndice(indice, jogador);

        // Verifica se o naipe escolhido eh valido para a jogada
        if(!pilhaDeDescarte.empty() && !listaRodada.isEmpty()) {
            if (!juizBurro.VerificaJogadaValida(jogador.EscolheCarta(indice - 1), pilhaDeDescarte)) {
                while(!juizBurro.VerificaJogadaValida(jogador.EscolheCarta(indice - 1), pilhaDeDescarte))
                {
                    System.out.println("\n" + "Jogada invalida! "
                        + "O naipe nao corresponde ao naipe da ultima carta jogada."
                        + " Tente novamente");
                    indice = juizBurro.VerificaValorIndice(indice, jogador);
                }
            }
        }
        
        Carta cartaEsc = jogador.EscolheCarta(indice - 1);
        JogaCartaOperacoes(cartaEsc, jogador);        
    }
    
    // Metodo busca o que o jogador deseja fazer na jogada, comprar ou jogar carta
    protected boolean NovaJogada(Jogador jogador) {
        Scanner input = new Scanner(System.in);
        int indice;
        boolean dif = false;
        System.out.println("\n" + "Vez de: " + jogador.getNome() + "\n");
        System.out.println(jogador.getNome() + ", voce possui " + jogador.TamanhoMao() + " cartas:" + "\n");
        jogador.MostraMao();
        
        System.out.println("\n" + "O que voce deseja fazer?" + "\n"
                + "Comprar uma carta 'c' ou jogar uma da mao 'j'?" );
        
        String opcao, opcao2;
        
        while(true) {
            opcao = input.next();
            if("c".equals(opcao) || "j".equals(opcao)) 
                break;
            else
                 System.out.println("\n" + "Por favor, digite uma opcao valida");
        }
        if("j".equals(opcao)) {
            JogadaReal(jogador);
        }
        else if("c".equals(opcao)){
            while(true){
                if(baralho.verificaBaralho()) {
                    System.out.println("\n" + "Nao existem mais cartas na mesa.");
                    break;
                }
                else {
                    CompraCartas(jogador);
                    jogador.MostraMao(); 
                    System.out.println("\n" + "Digite 'c' para comprar outra carta ou 'j' para jogar");
                    opcao2 = input.next();
                    if("j".equals(opcao2)){
                        JogadaReal(jogador);
                        break;
                    }
                }
            }
        }

        return jogador.VerificaMao();
    }
    
    // Metodo que simula o Jogo de Burro
    protected void IniciaJogo(LinkedList<Jogador> listaJogadores) {
        CadastroUsuarios cadastro = new CadastroUsuarios(listaJogadores);
        
        boolean verificaFim = false, fim = false;
        System.out.println("Embaralhando cartas..." + "\n");
        juizBurro.EmbaralhaCartas(baralho);
        System.out.println("Distribuindo as cartas entre os jogadores..." + "\n");
        juizBurro.DistribuiCartas(listaJogadores, baralho);
        System.out.println("Preparado(a)?" + "\n");
        System.out.println("JOGO BURRO V1" + "\n");
        System.out.println("******************* START *******************");
        System.out.println();
        
        // Enquanto a partida algum jogador tiver cartas na mao..
        while(true) {
            // Todos os jogadores da partida jogam
            for(int i = 0; i < listaJogadores.size(); i++) {
                if(i != 0) CartaPilhaDescarte();
                
                // Quem joga eh o sistema ou o jogador?
                if(listaJogadores.get(i).getId() != 1)
                    verificaFim = NovaJogada(listaJogadores.get(i));
                else {
                    verificaFim = JogadaSystem(listaJogadores.get(i), listaJogadores);
                }
                // Verifica se apos a jogada o jogador ficou sem cartas na mao
                if(verificaFim)
                    break;                       
            }
            
            System.out.println("\n" + "*********************" + "\n");
            
            // Se algum jogador ficou sem cartas na mao, imprime resultado
            if(verificaFim){
                juizBurro.resultadoFinal(listaJogadores);
                break;
            }
            
            // Define o ganhador da rodada e reorganiza a ordem de jogada
            juizBurro.DefineOrdemJogadores(listaRodada, listaJogadores);
            // Exibe quem ganhou a rodada
            System.out.println("\n" + listaRodada.get(0).getJogador().getNome()
                    + " ganhou a rodada.");
            listaRodada.clear();
        }

    }
}
