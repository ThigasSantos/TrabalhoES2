/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.reserva;

import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import io.github.thigassantos.trabalholucio.classes.funcionario.Funcionario;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class Reserva {
    //dataAlocaçao, hora inicio, hora fim, assunto, sala e funcionario
    private int id;
    private LocalDate dataAlocação;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private String assunto;
    private Sala sala;
    private Funcionario funcionario;
    private List<Equipamento> equipamentos;
    
    //contrutor
    public Reserva(int id, LocalDate dataAlocação, LocalTime horaInicio, LocalTime horaFim, String assunto, Sala sala, Funcionario funcionario, List<Equipamento> equipamentos) {
        this.id = id;
        this.dataAlocação = dataAlocação;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.assunto = assunto;
        this.sala = sala;
        this.funcionario = funcionario;
        this.equipamentos = equipamentos;
    }
    
    //getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDataAlocação() {
        return dataAlocação;
    }
    public void setDataAlocação(LocalDate dataAlocação) {
        this.dataAlocação = dataAlocação;
    }
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    public LocalTime getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
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
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }
    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    //toString
    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", dataAlocação=" + dataAlocação + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", assunto=" + assunto + ", sala=" + sala + ", funcionario=" + funcionario + ", equipamentos=" + equipamentos + '}';
    }
}
    
