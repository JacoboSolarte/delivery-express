package com.example.coleciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.modelo.Pedido;

public class Ejercicios {

    public static void ejecutar() {

        List<Pedido> pedidosArray = new ArrayList<>();
        pedidosArray.add(new Pedido("Hamburguesa", 30, "Juan"));
        pedidosArray.add(new Pedido("Pizza", 45, "Ana"));
        pedidosArray.add(new Pedido("Sushi", 60, "Luis"));
        pedidosArray.add(new Pedido("Ensalada", 25, "Marta"));
        pedidosArray.add(new Pedido("Pizza", 50, "Carlos"));

        System.out.println("ArrayList original:");
        System.out.println(pedidosArray);

        pedidosArray.add(0, new Pedido("Tacos", 20, "Pedro"));
        pedidosArray.add(0, new Pedido("Arepa", 15, "Lucia"));
        System.out.println("\nArrayList con urgentes:");
        System.out.println(pedidosArray);

        LinkedList<Pedido> pedidosLinked = new LinkedList<>(pedidosArray);
        System.out.println("\nLinkedList inicial:");
        System.out.println(pedidosLinked);
        pedidosLinked.addFirst(new Pedido("Perro caliente", 18, "Mario"));
        pedidosLinked.addFirst(new Pedido("Pollo", 28, "Paula"));
        System.out.println("\nLinkedList con urgentes:");
        System.out.println(pedidosLinked);

        System.out.println("\n Explicación: Si fueran 1000 pedidos urgentes, LinkedList es más eficiente " +
                "porque insertar al inicio es O(1), mientras que en ArrayList es O(n).");

        Set<Pedido> pedidosSet = new HashSet<>(pedidosArray);
        System.out.println("\nHashSet con duplicados eliminados:");
        System.out.println(pedidosSet);
        System.out.println("👉 Los duplicados no se permiten en HashSet.");

        Map<String, List<Pedido>> pedidosClientes = new HashMap<>();
        for (Pedido p : pedidosArray) {
            pedidosClientes.putIfAbsent(p.getCliente(), new ArrayList<>());
            pedidosClientes.get(p.getCliente()).add(p);
        }

        System.out.println("\nPedidos por cliente:");
        for (String cliente : pedidosClientes.keySet()) {
            System.out.println(cliente + " -> " + pedidosClientes.get(cliente));
        }

        System.out.println("\nPedidos de cliente específico (Ana):");
        System.out.println(pedidosClientes.get("Ana"));

        System.out.println("\nTotal gastado por cada cliente:");
        for (String cliente : pedidosClientes.keySet()) {
            double total = pedidosClientes.get(cliente).stream()
                    .mapToDouble(Pedido::getTotal)
                    .sum();
            System.out.println(cliente + " gastó $" + total);
        }

        System.out.println("\nPedidos filtrados: Producto Pizza");
        System.out.println(Utilidades.filtrar(pedidosArray, p -> p.getProducto().equals("Pizza")));

        System.out.println("\nPedidos filtrados: Total > 50");
        System.out.println(Utilidades.filtrar(pedidosArray, p -> p.getTotal() > 50));
    }
}