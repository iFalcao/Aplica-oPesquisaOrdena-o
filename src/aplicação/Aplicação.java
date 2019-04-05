package aplicação;

/**
 *
 * @author Pedro Augusto Gaya Antunes e Jorge Francisco dos Santos Barbosa Lima
 */
public class Aplicação {


    public static void main(String[] args) {
        //tamanhos da tabela para fator de carga 1, 2, 5 e 10
        int[] tamanhos = {100,50,20,10};
        for(int i=0;i<tamanhos.length;i++){
            SeparateChainingHashTable ht = new SeparateChainingHashTable(tamanhos[i]);
            
        }
    }
    
}
