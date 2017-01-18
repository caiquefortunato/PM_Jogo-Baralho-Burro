/*
 * A classe guarda as notas conquistadas pelos jogagores nas partidas.
 */
package Burro;

import Usuarios.Jogador;

public class NotasPartida {
    
    private String nomeJogador;
    private int cartasMao;

    public NotasPartida(String nomeJogador, int partidasGanhas) {
        this.nomeJogador = nomeJogador;
        this.cartasMao = partidasGanhas;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getCartasMao() {
        return cartasMao;
    }

    public void setCartasMao(int cartasMao) {
        this.cartasMao = cartasMao;
    }

    
    
    
    
}
