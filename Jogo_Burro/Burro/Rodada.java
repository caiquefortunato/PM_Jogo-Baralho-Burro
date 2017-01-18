/*
 * A classe guarda cada rodada e define qual sera o proximo jogador
 */
package Burro;

import Baralho.Carta;
import Usuarios.Jogador;
import java.util.ArrayList;
import java.util.LinkedList;

public class Rodada {
    private Jogador jogador;
    private Carta carta;

    public Rodada(Jogador jogador, Carta carta) {
        this.jogador = jogador;
        this.carta = carta;
    }

    Rodada() {
        
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }
}
