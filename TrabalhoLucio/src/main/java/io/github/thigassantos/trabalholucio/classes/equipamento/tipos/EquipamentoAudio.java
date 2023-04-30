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
public class EquipamentoAudio extends Equipamento{
    private int potencia;
    
    public EquipamentoAudio(String nome, int potencia) {
        super(nome);
        this.potencia = potencia;
    }

    // getters e setters
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
}
