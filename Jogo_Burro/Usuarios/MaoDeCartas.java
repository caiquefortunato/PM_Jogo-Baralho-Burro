/**
* A classe Carta cria uma mao de cartas que sera utilizada pelos jogadores
* A mao de cartas tambem possui operacoes que serao utilizadas de acordo com
*   a jogada de cada jogador.
* Referencias: https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
 */

package Usuarios;

import Baralho.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MaoDeCartas {
    
    private final ArrayList<Carta> mao;

    // O construtor da Mao de Cartas cria uma nova colecao de cartas
    public MaoDeCartas() {
        this.mao = new ArrayList<>();
    }
    
    // Adiciona uma nova carta na mao de cartas
    protected void AdicionaCarta(Carta carta) {
        mao.add(carta);
    }
    
    // Verifica se existem cartas na mao de cartas
    protected boolean VerificaMao() {
        return mao.isEmpty();
    }
    
    // Mostra para o jogador as cartas que existem na mao
    protected void MostraMao() {
        Iterator<Carta> cartaIt = mao.iterator();
        int cont = 1;
        
        while(cartaIt.hasNext()) {
            Carta cartaTemp = cartaIt.next();
            System.out.println("Carta " + cont + " ==> " + cartaTemp.getValor() + " de " + cartaTemp.getNaipe());
            cont++;
        }
    }
    
    // Verifica se o jogador possui carta do mesmo naipe
    protected boolean VerificaNaipe(Carta carta) {
        boolean result = false;
        for(int i = 0; i < mao.size(); i++) {
            if(mao.get(i).getNaipe() == carta.getNaipe()) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    // Verifica o tamanho da mao de cartas
    protected int TamanhoMao() {
        return mao.size();
    }
    
    // Ve uma carta em especifico
    protected Carta VeCarta(int indice) {
        return mao.get(indice);
    }
    
    // Funcao que remove carta da mao de cartas
    protected void RemoveCarta(Carta carta) {
        
        for(int i = 0; i < mao.size(); i++) {
            if(carta == mao.get(i)) {
                mao.remove(carta);
                break;
            }
        }
    }

    // Retorna a maior carta que possui na mao
    protected Carta MaiorCarta() {
        Carta maiorCarta = mao.get(0);
        
        for(int i = 0; i < mao.size(); i++) {
            if(mao.get(i).getValor().getCartasEnum() > maiorCarta.getValor().getCartasEnum()) {
                maiorCarta = mao.get(i);
            }
        }
        return maiorCarta;
    }
       
    // Retoma a menor maior carta de um naipe
    protected Carta EscolherCartaNaipe(Carta carta) {
        
        Carta escolherCartaNaipe = null;
        
        for(int i = 0; i < mao.size(); i++) {
            if(mao.get(i).getNaipe() == carta.getNaipe()) {
                if(carta.getValor().getCartasEnum() > mao.get(i).getValor().getCartasEnum())
                    escolherCartaNaipe = mao.get(i);
            }
        }
        
        if(escolherCartaNaipe.getValor().getCartasEnum() > carta.getValor().getCartasEnum()) {
            for(int i = 0; i < mao.size(); i++) {
                if(mao.get(i).getNaipe() == carta.getNaipe()) {
                    if(mao.get(i).getValor().getCartasEnum() > carta.getValor().getCartasEnum()) {
                        if(mao.get(i).getValor().getCartasEnum() < escolherCartaNaipe.getValor().getCartasEnum()) {
                            escolherCartaNaipe = mao.get(i);
                        }
                    }
                }
            }
        }
        else{
            for(int i = 0; i < mao.size(); i++) {
                if(mao.get(i).getNaipe() == carta.getNaipe()) {
                    if(mao.get(i).getValor().getCartasEnum() < escolherCartaNaipe.getValor().getCartasEnum())
                        escolherCartaNaipe = mao.get(i);
                }
            }            
        }
        
        return escolherCartaNaipe;        
    }
    
}
