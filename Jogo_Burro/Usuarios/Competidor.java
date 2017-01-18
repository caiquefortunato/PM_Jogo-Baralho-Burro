package Usuarios;

import Baralho.*;

public abstract class Competidor {
    private int id;
    protected MaoDeCartas mao;

    // Competidor ja recebe uma mao de cartas
    public Competidor() {
        this.mao = new MaoDeCartas();
    }
    
    // Metodos get e set
    public MaoDeCartas getMao() {
        return mao;
    }

    public void setMao(MaoDeCartas mao) {
        this.mao = mao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Outros metodos de manipulacao
    public void AdicionaCarta(Carta carta) {
        mao.AdicionaCarta(carta);
    }
    
    public boolean VerificaMao() {
        return mao.VerificaMao();
    }
    
    public void MostraMao() {
        mao.MostraMao();
    }
    
    public void RemoveCarta(Carta carta) {
        mao.RemoveCarta(carta);
    }
    
    public Carta EscolheCarta(int indice) {
        return mao.VeCarta(indice);
    }
    
    public int TamanhoMao() {
        return mao.TamanhoMao();
    }
    
    public boolean VerificaNaipe(Carta cartaPilha) {
        return mao.VerificaNaipe(cartaPilha);
    }
  
    public Carta MaiorCarta(){
        return mao.MaiorCarta();
    }
 
    public Carta EscolherCartaNaipe(Carta carta) {
        return mao.EscolherCartaNaipe(carta);
    }
    
}
