/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicação;

/**
 *
 * @author Pedro Augusto Gaya Antunes e Jorge Francisco dos Santos Barbosa Lima
 */
public class Aluno implements Hashable {
    
    private String nomeesobrenome;
    private String matricula;
    
    public Aluno(){
    }
    
    public Aluno(String nomeesobrenome, String matricula){
        this.nomeesobrenome = nomeesobrenome;
        this.matricula = matricula;
    }
    
    /**
     *
     * @param tamanho
     * @return
     */
    @Override
    public int hash(int tamanho){
        int calculohash = matricula.hashCode()%tamanho;
        if(calculohash < 0) calculohash += tamanho;
        return calculohash;
    }
    
    @Override
    public boolean equals(Object o){
        return this.matricula.equals(((Aluno)o).matricula);
    }
    
    //Getters
    @Override
    public String getNomeesobrenome(){
        return nomeesobrenome;
    }
    
    @Override
    public String getMatricula(){
        return matricula;
    }
    
    //Setters
    public void setNomeesobrenome(String nomeesobrenome){
        this.nomeesobrenome = nomeesobrenome;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
}
