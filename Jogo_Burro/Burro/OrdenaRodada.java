package Burro;

import java.util.Comparator;

public class OrdenaRodada implements Comparator {

    @Override
    public int compare(Object obj1, Object obj2) {
        int retorno = 0;
        if(obj1 == null || obj2 == null)
            return 0;        
        
        Rodada objeto1 = (Rodada) obj1;
        Rodada objeto2 = (Rodada) obj2;
        
        if(objeto1.getCarta().getValor().getCartasEnum() < objeto2.getCarta().getValor().getCartasEnum())
            retorno = 1;
        
        else 
            retorno = -1;
        
        return retorno;
    }
    
}
