/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.funcionario;

import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Funcionario {
    private String nome;
    private String cpf;
    private String ramal;
    private List<Reserva> reservas;

    public Funcionario(String nome, String cpf, String ramal) {
        this.nome = nome;
        this.cpf = cpf;
        this.ramal = ramal;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRamal() {
        return ramal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    //to string
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", ramal=" + ramal + ", reservas=" + reservas + '}';
    }


    
}

