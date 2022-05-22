package com.example.concesionario;

public class Cotizacion {
    // Atributos
    private int numCotizacion;
    private String descripcion;
    private double precio;
    private double porcentajePagoInicial;
    private int plazo;

    // Constructores

    // Constructor Vacio
    public Cotizacion(){
        this.setNumCotizacion(0);
        this.setDescripcion("");
        this.setPrecio(0.0);
        this.setPorcentajePagoInicial(0.0);
        this.setPlazo(0);
    }

    // Constructor de Parametros
    public Cotizacion(int numCotizacion, String descripción, double precio, double porcentajePagoInicial, int plazo){
        this.setNumCotizacion(numCotizacion);
        this.setDescripcion(getDescripcion());
        this.setPrecio(precio);
        this.setPorcentajePagoInicial(porcentajePagoInicial);
        this.setPlazo(plazo);
    }

    // Constructor de Copia
    public Cotizacion(Cotizacion cotizacion){
        this.setNumCotizacion(cotizacion.getNumCotizacion());
        this.setDescripcion(cotizacion.getDescripcion());
        this.setPrecio(cotizacion.getPrecio());
        this.setPorcentajePagoInicial(cotizacion.getPorcentajePagoInicial());
        this.setPlazo(cotizacion.getPlazo());
    }

    public int getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPorcentajePagoInicial() {
        return porcentajePagoInicial;
    }

    public void setPorcentajePagoInicial(double porcentajePagoInicial) {
        this.porcentajePagoInicial = porcentajePagoInicial;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double calcularPagoInicial(){
        double pagoInicial;
        pagoInicial = (this.porcentajePagoInicial/100) * this.precio;
        return pagoInicial;
    }

    public double calcularTotalFinanciero(){
        double totalFin;
        totalFin = this.precio - this.calcularPagoInicial();
        return totalFin;
    }

    public double calcularPagoMensual(){
        double pagoMensual;
        pagoMensual = this.calcularTotalFinanciero() / this.plazo;
        return pagoMensual;
    }
}
