/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.funcionario;

import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Funcionario {
    private String nome;
    private String cargo;
    private String ramal;

    public Funcionario(String nome, String cargo, String ramal) {
        this.nome = nome;
        this.cargo = cargo;
        this.ramal = ramal;
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

}

