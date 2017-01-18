package Baralho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
* A classe cria e manipula um novo baralho com 52 cartas (sem coringa)
* Referencia: https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
 */

public class JuizBaralho {
    
    // Criacao do monte de cartas
    private final ArrayList<Carta> monteBaralho;
    
    // Construtor publico para criar o juiz
    public JuizBaralho(){
        this.monteBaralho = new ArrayList<>();
        
        for(int i = 0; i < 13; i++) {
            Valor valorCarta = Valor.values()[i];
            
            for(int j = 0; j < 4; j++) {
                Carta carta = new Carta(Naipe.values()[j], valorCarta);
                this.monteBaralho.add(carta);
            }
        }
    }
    
    // Metodo que verifica se tem cartas no baralho
    public boolean verificaBaralho() {
        return monteBaralho.isEmpty();
    }
    
    // Retorna a primeira carta do baralho
    public Carta retornaCarta() {
        return monteBaralho.get(monteBaralho.size() - 1);
    }
    
    // Remove determinada carta do baralho
    public void removeCarta(Carta carta) {
        for(int i = 0; i < monteBaralho.size(); i++) {
            if(carta == monteBaralho.get(i))
                monteBaralho.remove(i);  
        } 
    }
    
    // Metodo que embaralha as cartas
    public void embaralhaCartas() {
        Collections.shuffle(monteBaralho);
    }
    
    // Metodo que imprime as cartas do baralho    
    public void imprimirMonteBaralho() {
        for(int i = 0; i < monteBaralho.size(); i++) {
            System.out.println(monteBaralho.get(i).getValor() + " de " + monteBaralho.get(i).getNaipe());
        }
    }
        
}