/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.reserva;

import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Reserva {
    private static int ultimoId =0;
    private int id;
    private List<LocalDate> periodo;
    private List<LocalTime> horario;
    private String assunto;
    private Sala sala;
    private List<Equipamento> equipamentos;
    private Funcionario responsavel;
    private boolean ativa;
    private TipoReserva tipoReserva;


    public Reserva(List<LocalDate> periodo, List<LocalTime> horario, String assunto, Sala sala, List<Equipamento> equipamentos , Funcionario responsavel, TipoReserva tipoReserva) {
        this.periodo = periodo;
        this.horario = horario;
        this.assunto = assunto;
        this.sala = sala;
        this.equipamentos = equipamentos;
        this.responsavel = responsavel;
        this.ativa = true;
        this.tipoReserva = tipoReserva;
        ultimoId++;
        id = ultimoId;
    }
    
    public boolean verificaEquipamento(Equipamento equipamento) {
        return equipamentos.contains(equipamento);
    }
    
    public boolean isAtiva() {
        return ativa;
    }

    public int getId() {
        return id;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public void cancelar() {
        this.ativa = false;
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        this.equipamentos.add(equipamento);
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public List<LocalDate> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List<LocalDate> periodo) {
        this.periodo = periodo;
    }

    public List<LocalTime> getHorario() {
        return horario;
    }

    public void setHorario(List<LocalTime> horario) {
        this.horario = horario;
    }
    
    
}
    
