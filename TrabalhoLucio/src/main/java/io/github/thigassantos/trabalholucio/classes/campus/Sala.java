/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.campus;

import io.github.thigassantos.trabalholucio.classes.reserva.Reserva;
import io.github.thigassantos.trabalholucio.classes.reserva.TipoReserva;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    
    public List<Reserva> getReservasPeriodo(List<LocalDate> periodo, List<LocalTime> horario){
        List<Reserva> reservasPeriodo = new ArrayList<>();
        for (Reserva reserva : this.reservas) {
               if (reserva.getPeriodo().get(0).isBefore(periodo.get(1)) && reserva.getPeriodo().get(1).isAfter(periodo.get(0))) {
                   if(reserva.getHorario().get(0).isBefore(horario.get(1)) && reserva.getHorario().get(1).isAfter(horario.get(0)))
                    reservasPeriodo.add(reserva);
                }       
        }
        return reservasPeriodo;
    }
    
    public List<Reserva> getReservasAula(List<LocalDate> diasAula, List<LocalTime> horario){
        List<Reserva> reservasPeriodo = new ArrayList<>();
        for (Reserva reserva : this.reservas) {
            for(int i=0;i<diasAula.size();i++)
            {
               if (reserva.getPeriodo().get(0).isBefore(diasAula.get(i)) && reserva.getPeriodo().get(1).isAfter(diasAula.get(i))) {
                   if(reserva.getHorario().get(0).isBefore(horario.get(1)) && reserva.getHorario().get(1).isAfter(horario.get(0)))
                       if(reserva.getTipoReserva() == TipoReserva.AULA)
                       reservasPeriodo.add(reserva);
                } 
            }
            
        }
        return reservasPeriodo;
    }
    
    public boolean isDisponivel(List<LocalDate> periodo, List<LocalTime> horario){
        return getReservasPeriodo(periodo, horario).isEmpty();
    }
    
    public boolean isDisponivelAula(List<LocalDate> periodo, List<LocalTime> horario){
        return getReservasAula(periodo, horario).isEmpty();
    }
    
}
