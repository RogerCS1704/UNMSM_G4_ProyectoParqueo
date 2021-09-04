/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4.proyectoparqueadero;

import java.io.Serializable;

/**
 *
 * @author Roger Cabrera
 */
public class Parqueo implements Serializable{
    private int id;
    private String nombres;
    private String apellidos;
    private String placa;
    private String modelo;
    private String hora_entrada;
    private String minuto_entrada;
    private String hora_salida;
    private String minuto_salida;

    public Parqueo(int id, String nombres, String apellidos, String placa, String modelo, String hora_entrada, String minuto_entrada, String hora_salida, String minuto_salida) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.placa = placa;
        this.modelo = modelo;
        this.hora_entrada = hora_entrada;
        this.minuto_entrada = minuto_entrada;
        this.hora_salida = hora_salida;
        this.minuto_salida = minuto_salida;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getMinuto_entrada() {
        return minuto_entrada;
    }

    public void setMinuto_entrada(String minuto_entrada) {
        this.minuto_entrada = minuto_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getMinuto_salida() {
        return minuto_salida;
    }

    public void setMinuto_salida(String minuto_salida) {
        this.minuto_salida = minuto_salida;
    }

    

    
    
}
