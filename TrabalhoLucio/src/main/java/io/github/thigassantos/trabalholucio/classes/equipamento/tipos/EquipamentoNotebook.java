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
public class EquipamentoNotebook extends Equipamento {

    private String marca;
    private String modelo;
    private double tamanhoTela;
    private int memoriaRam;

    public EquipamentoNotebook(String nome, String marca, String modelo, double tamanhoTela, int memoriaRam) {
        super(nome);
        this.marca = marca;
        this.modelo = modelo;
        this.tamanhoTela = tamanhoTela;
        this.memoriaRam = memoriaRam;
    }

    // Getters e Setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getTamanhoTela() {
        return tamanhoTela;
    }

    public void setTamanhoTela(double tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }
}
