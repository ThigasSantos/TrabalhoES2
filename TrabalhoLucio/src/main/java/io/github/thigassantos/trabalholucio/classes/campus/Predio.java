/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.campus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Predio {   
    
    private String nome;
    private List<Sala> salas;

    public Predio(String nome) {
        this.nome = nome;
        this.salas = new ArrayList<>();
    }

    public void adicionarSala(Sala sala) {
        this.salas.add(sala);
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
}
