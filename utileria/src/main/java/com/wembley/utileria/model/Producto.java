package com.wembley.utileria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Producto {
    private int id;
    private String nombre;
    private String talles;
    private String descripcion;
    private String marca;
    private double precio;

    @JsonProperty("id_categoria")
    private int id_categoria;

    @JsonProperty("imagen_url") // Fuerza el mapeo del JSON de Angular
    private String imagen_url;

    // Dentro de Producto.java
    public Producto() {
        // Constructor vacío para que funcione el new Producto()
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalles() {
        return talles;
    }

    public void setTalles(String talles) {
        this.talles = talles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getImagen_url() {
        return imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }

    // Constructores, Getters y Setters
    // (Tip: En IntelliJ, presiona Alt+Insert para generarlos rápido)
}