package aplicação;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Pedro Augusto Gaya Antunes e Jorge Francisco dos Santos Barbosa Lima
 */
public class Aplicação {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        //tamanhos da tabela para fator de carga 1, 2, 5 e 10
        int[] tamanhos = {100,50,20,10};
        for(int i=0;i<tamanhos.length;i++){
            SeparateChainingHashTable scht = new SeparateChainingHashTable(tamanhos[i]);
            try (BufferedReader br = new BufferedReader(new FileReader("./src/resource/entrada.CSV"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    scht.insert(new Aluno(values[0],values[1]));
                }
            }
            scht.printTable();
        }
    }
    
}
