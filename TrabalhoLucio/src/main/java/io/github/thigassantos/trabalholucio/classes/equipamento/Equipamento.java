/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.equipamento;

import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Equipamento {  

    private static int ultimoId = 0;
    private int id;
    private String nome;
    private String patrimonio;
    private List<Reserva> reservas;

    public Equipamento(String nome) {
        this.nome = nome;
        this.id = ++ultimoId;
        this.patrimonio = "EQP" + String.format("%04d", id);
        this.reservas = new ArrayList<>();
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }
    
    public void addReserva(Reserva res){
        reservas.add(res);
    }
    
    public List<Reserva> getReservasPeriodo(LocalDateTime inicio, LocalDateTime fim) {
    List<Reserva> reservasPeriodo = new ArrayList<>();
    for (Reserva reserva : reservas) {
        if (reserva.getDataHoraInicio().isBefore(fim) && reserva.getDataHoraFim().isAfter(inicio)) {
            reservasPeriodo.add(reserva);
        }
    }
    return reservasPeriodo;
    }
    
    public boolean isDisponivel(LocalDateTime inicio, LocalDateTime fim){
        return getReservasPeriodo(inicio, fim).isEmpty();
    }
}
