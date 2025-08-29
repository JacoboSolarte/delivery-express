package com.example.modelo;

public class Pedido {
    private String producto;
    private double total;
    private String cliente;

    public Pedido(String producto, double total, String cliente) {
        this.producto = producto;
        this.total = total;
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public double getTotal() {
        return total;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "producto='" + producto + '\'' +
                ", total=" + total +
                ", cliente='" + cliente + '\'' +
                '}';
    }
}