/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.controladores;

import io.github.thigassantos.trabalholucio.classes.campus.Campus;
import io.github.thigassantos.trabalholucio.classes.campus.Sala;
import io.github.thigassantos.trabalholucio.classes.equipamento.Equipamento;
import java.util.List;

/**
 *
 * @author Tygsv
 */
public class LugarControler {
    
     public static Sala buscarSala(List<Sala> salas, int numero) {
    for (Sala sala : salas) {
        if (sala.getNumero() == numero) {
            return sala;
        }
    }
    return null;
    }
    
    public static Equipamento buscarEquipamento(List<Equipamento> equipamentos, String nome) {
    for (Equipamento equipamento : equipamentos) {
        if (equipamento.getNome().equalsIgnoreCase(nome)) {
            return equipamento;
        }
    }
    return null;
    }
    
    public static Campus buscarCampus(List<Campus> campusTD, String nome) {
    for (Campus campus : campusTD) {
        if (campus.getNome().equalsIgnoreCase(nome)) {
            return campus;
        }
    }
    return null;
    }
}
