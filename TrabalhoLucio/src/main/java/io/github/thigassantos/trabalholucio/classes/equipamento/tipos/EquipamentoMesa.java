/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.equipamento.tipos;

import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;

/**
 *
 * @author Tygsv
 */
public class EquipamentoMesa extends Equipamento {
    private int altura;

    public EquipamentoMesa(String nome, int altura) {
        super(nome);
        this.altura = altura;
    }

    // getters e setters

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
}
