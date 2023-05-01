/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.campus;

import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Sala {   
    private int numero;
    private int capacidade;
    private boolean disponivel;
    private List<Reserva> reservas;

    public Sala(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        reservas = new ArrayList<>();
    }

    public Sala(int numero) {
        this.numero = numero;
    }
    
    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void removeReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    
    public List<Reserva> getReservasPeriodo(LocalDateTime inicio, LocalDateTime fim) {
    List<Reserva> reservasPeriodo = new ArrayList<>();
    for (Reserva reserva : this.reservas) {
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
