/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicação;

import java.util.LinkedList;

/**
 *
 * @author Pedro Augusto Gaya Antunes e Jorge Francisco dos Santos Barbosa Lima
 */
public class SeparateChainingHashTable {
    
    private LinkedList<Hashable>[] listasencadeadas;
    private static final int DEFAULT_TABLE_SIZE = 101;
    
    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    
    public SeparateChainingHashTable(int tamanho){
        listasencadeadas = new LinkedList[nextPrime(tamanho)];
        for(int i=0;i<listasencadeadas.length;i++){
            listasencadeadas[i]=new LinkedList<Hashable>();
        }
    }
    
    public void makeEmpty(){
        for(int i=0;i<listasencadeadas.length;i++) listasencadeadas[i].clear();
    }
    
    public void insert(Hashable x){
        LinkedList<Hashable> listaencadeada = listasencadeadas[x.hash(listasencadeadas.length)];
        if(listaencadeada.indexOf(x)==-1) listaencadeada.add(0,x);
    }
    
    public Hashable find(Hashable x){
        LinkedList<Hashable> listaencadeada = listasencadeadas[x.hash(listasencadeadas.length)];
        if(listaencadeada.indexOf(x)==-1) return null;
        else return x;
    }
    
    public void remove(Hashable x){
        LinkedList<Hashable> listaencadeada = listasencadeadas[x.hash(listasencadeadas.length)];
        if(listaencadeada.indexOf(x)!=-1) listaencadeada.remove(x);
    }
    
    @SuppressWarnings("empty-statement")
    private static int nextPrime(int n){
        if(n%2==0) n++;
        for(;!isPrime(n);n+=2);
        return n;
    }
    
    private static boolean isPrime(int n){
        if(n==2||n==3) return true;
        if(n==1||n%2==0) return false;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
    
    public void printTable(){
        System.out.println("===== TABLE SIZE = " + listasencadeadas.length + " =====");
        System.out.println("Key | Matrícula | Nome");
        for(int i=0;i<listasencadeadas.length;i++){
            LinkedList<Hashable> listaencadeada = listasencadeadas[i];
            for (Hashable elemento : listaencadeada) {  
                System.out.println(elemento.hash(listasencadeadas.length) 
                        + " | " + elemento.getMatricula() 
                        + " | " + elemento.getNomeesobrenome());
            }
        }
        System.out.println("===========================");
    }
}
