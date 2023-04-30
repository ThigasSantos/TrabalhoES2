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
public class EquipamentoVideo extends Equipamento{
    private String marca;

    public EquipamentoVideo(String nome, String marca) {
        super(nome);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
