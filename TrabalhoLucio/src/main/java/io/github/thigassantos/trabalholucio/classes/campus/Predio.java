/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.campus;

import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Predio {   
    
    private String nome;
    private int andares;
    private List<Sala> salas;

    //construtor
    public Predio(String nome, int andares) {
        this.nome = nome;
        this.andares = andares;
    }
    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAndares() {
        return andares;
    }
    public void setAndares(int andares) {
        this.andares = andares;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
    
    //toString
    @Override
    public String toString() {
        return "Predio [nome=" + nome + ", andares=" + andares + "]";
    }
}
