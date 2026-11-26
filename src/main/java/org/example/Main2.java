package org.example;

import org.example.models.Compra;
import org.example.models.Equipo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main2 {
    public static void main(String[] args) {
        var cfg = new Configuration().configure();
        SessionFactory sf =cfg.buildSessionFactory();
/*
        sf.inTransaction(session -> {
            Equipo e1 = session.find(Equipo.class, 11);
            Compra compra = new Compra();
            compra.setCantidad(5);
            compra.setFecha(LocalDate.now());
            compra.setResponsable("Francisco");
            compra.setEquipo(e1);
            session.persist(compra);
            System.out.println(compra);
        });

 */

//        sf.inTransaction(session -> {
//            Equipo equipo = new Equipo();
//            equipo.setNombre("Pepote2");
//            equipo.setCategoria("Pepo");
//            equipo.setDisponible(false);
//
//            Compra compra = new Compra();
//            compra.setCantidad(99);
//            compra.setFecha(LocalDate.now());
//            compra.setResponsable("Pepote");
//            compra.setEquipo(equipo);
//
//            //session.persist(equipo);, como puse cascade este no hace falta
//            session.persist(compra);
//
//        });

        sf.inSession(session -> {
            System.out.println(session.find(Compra.class, 1));
        });
    }
}
