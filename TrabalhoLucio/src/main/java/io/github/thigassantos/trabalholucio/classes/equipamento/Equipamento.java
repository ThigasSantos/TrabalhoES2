/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.equipamento;

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
    
    public List<Reserva> getReservasPeriodo(List<LocalDate> periodo, List<LocalTime> horario){
        List<Reserva> reservasPeriodo = new ArrayList<>();
        for (Reserva reserva : this.reservas) {
               if (reserva.getPeriodo().get(0).isBefore(periodo.get(0)) && reserva.getPeriodo().get(1).isAfter(periodo.get(1))) {
                   if(reserva.getHorario().get(0).isBefore(horario.get(0)) && reserva.getHorario().get(1).isAfter(horario.get(1)))
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
                   if(reserva.getHorario().get(0).isBefore(horario.get(0)) && reserva.getHorario().get(1).isAfter(horario.get(1)))
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
