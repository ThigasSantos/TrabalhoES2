/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.thigassantos.trabalholucio.classes.reserva;

import java.time.LocalDateTime;

/**
 *
 * @author Tygsv
 */
public class Periodo {
    private LocalDateTime inicio;
    private LocalDateTime fim;
    
    public Periodo(LocalDateTime inicio, LocalDateTime fim) {
    this.inicio = inicio;
    this.fim = fim;
    }

    public boolean intersects(LocalDateTime inicioOutro, LocalDateTime fimOutro) {
        return (inicio.isBefore(fimOutro) || inicio.equals(fimOutro))
                && (fim.isAfter(inicioOutro) || fim.equals(inicioOutro));
    }

    // Getters e Setters

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
    
}
