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
public class EquipamentoImpressora3D extends Equipamento{
    private String marca;
    private int resolucaoMaxima;

    public EquipamentoImpressora3D(String nome, String marca, int resolucaoMaxima) {
        super(nome);
        this.marca = marca;
        this.resolucaoMaxima = resolucaoMaxima;
    }

    // getters e setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getResolucaoMaxima() {
        return resolucaoMaxima;
    }

    public void setResolucaoMaxima(int resolucaoMaxima) {
        this.resolucaoMaxima = resolucaoMaxima;
    }
    
}
