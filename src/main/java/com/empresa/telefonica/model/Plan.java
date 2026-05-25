package com.empresa.telefonica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plan {

    //Inicalizamos los atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private double precio;
    private double datosGB;
    private double minutos;
    private String descripcion;

    //Creamos un constructor vacío
    public Plan(){
    }

    //Creamos el metodo constructor
    public Plan(String nombre, double precio, double datosGB, double minutos, String descripcion){
        this.nombre = nombre;
        this.precio = precio;
        this.datosGB = datosGB;
        this.minutos = minutos;
        this.descripcion = descripcion;
    }

    //Creamos los getters y setters de cada atributo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public double getDatosGB(){
        return datosGB;
    }

    public void setDatosGB(double datosGB){
        this.datosGB = datosGB;
    }

    public double getMinutos(){
        return minutos;
    }

    public void setMinutos(double minutos){
        this.minutos = minutos;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
