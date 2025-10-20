/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipoproyecto;

import java.time.LocalDateTime;

/**
 *
 * @author paulasteller
 */
public class Chat {
    private String idMensaje;
    private String contenido;
    private String idRemitente;
    private LocalDateTime timestamp;

    public Chat(String idMensaje, String contenido, String idRemitente, LocalDateTime timestamp) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.idRemitente = idRemitente;
        this.timestamp = timestamp;
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(String idRemitente) {
        this.idRemitente = idRemitente;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
