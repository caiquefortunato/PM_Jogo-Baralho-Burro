package Baralho;

/**
* A classe cria os valores existentes em um jogo de baralho (A, 2, .., J, Q, K)
* A classe eh� de tipo enum, ou seja, um conjunto de contantes (static final) 
    com uma lista de valores pre definidos
* Link: http://www.devmedia.com.br/tipos-enum-no-java/25729
* Link: http://docs.oracle.com/javase/6/docs/api/java/lang/Enum.html
 */

public enum Valor {
    A(1), DOIS(2), TRES(3), QUATRO(4), 
    CINCO(5), SEIS(6), SETE(7), OITO(8), 
    NOVE(9), DEZ(10), J(11), Q(12), K(13);
    
    private final int valorCarta;
    
    private Valor(int valor) {
        this.valorCarta = valor;
    }
    
    public int getCartasEnum() {
        return valorCarta;
    }
}