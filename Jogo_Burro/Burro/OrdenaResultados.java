package Burro;

import java.util.Comparator;

public class OrdenaResultados implements Comparator {

    @Override
    public int compare(Object obj1, Object obj2) {
        int retorno = 0;
        if(obj1 == null || obj2 == null)
            return 0;        
        
        NotasPartida objeto1 = (NotasPartida) obj1;
        NotasPartida objeto2 = (NotasPartida) obj2;
        
        if(objeto1.getCartasMao() > objeto2.getCartasMao())
            retorno = 1;
        
        else if(objeto1.getCartasMao() < objeto2.getCartasMao())
            retorno = -1;
        
        // Se as notas forem iguais:
        else {
            if(objeto1.getNomeJogador().compareTo(objeto2.getNomeJogador()) == - 1)
                retorno = 1;
            else
                retorno = - 1;
        }
            
            return retorno;
    }
    
}
