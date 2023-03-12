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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Reserva {
    private static int ultimoId =0;
    private int id;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String assunto;
    private Sala sala;
    private List<Equipamento> equipamentos;
    private Funcionario responsavel;
    private boolean ativa;


    public Reserva(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String assunto, Sala sala, List<Equipamento> equipamentos , Funcionario responsavel) {
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.assunto = assunto;
        this.sala = sala;
        this.equipamentos = equipamentos;
        this.responsavel = responsavel;
        this.ativa = true;
        ultimoId++;
        id = ultimoId;
    }
    
    public boolean isAtiva() {
    return ativa;
    }

    public int getId() {
        return id;
    }

    public void cancelar() {
        this.ativa = false;
    }

    public Periodo getPeriodo() {
        return new Periodo(dataHoraInicio, dataHoraFim);
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        this.equipamentos.add(equipamento);
    }

// Getters e Setters
    
    //Getters e Setters
    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
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
    
}
    
