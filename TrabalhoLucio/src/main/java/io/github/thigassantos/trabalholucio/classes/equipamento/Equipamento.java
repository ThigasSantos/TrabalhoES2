/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.equipamento;

/**
 *
 * @author Tygsv
 */
public class Equipamento {  

    private String nome;
    private int patrimonio;

    //construtor
    public Equipamento(String nome, int patrimonio) {
        this.nome = nome;
        this.patrimonio = patrimonio;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPatrimonio() {
        return patrimonio;
    }
    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    //toString
    @Override
    public String toString() {
        return "Equipamento [nome=" + nome + ", patrimonio=" + patrimonio + "]";
    }

}
