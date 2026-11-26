package org.example;


import org.example.models.Equipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
      Configuration cfg = new Configuration().configure();
      SessionFactory sf =cfg.buildSessionFactory();
/*
      //cada sesion se abre y se cierra en cada operación
      sf.inSession((session -> {
          session.createQuery("From Equipo", Equipo.class)
                  .getResultList()
                  .forEach(System.out::println);
      } ));
        //findById
      sf.inSession((session -> {
          Equipo e5= session.find(Equipo.class, 5L);
          Equipo e6= session.find(Equipo.class, 6L);
          System.out.println(e5);
          System.out.println(e6);
      }));
        sf.inSession((session -> {
            session.createQuery("From Equipo e where id>4 and id<8", Equipo.class)
                    .getResultList()
                    .forEach(System.out::println);
        } ));
*/
        //modo más sencillo
        Equipo e8;
        try(Session session = sf.openSession()) {
            //empiezo la transaccion
            session.beginTransaction();
            e8= session.find(Equipo.class, 8L);
            e8.setNombre(e8.getNombre().toUpperCase());
            //para que se actualice en la BD hay que hacer una transaccion
            session.getTransaction().commit();
        }
        System.out.println(e8);

        //modo pro, hay que controlar los nulls o te da exception
        //flush fuerza a que todo se escriba en la BD
        sf.inTransaction(session -> {
            /* añado logging  a la BD*/
            session.flush();
            Equipo e9= session.find(Equipo.class, 9L);
            if(e9==null){return;}
            e9.setNombre("-----"+e9.getNombre().toUpperCase()+"------");
            System.out.println(e9.getNombre());
        });

        Equipo e = new Equipo();
        e.setNombre("pepote");
        e.setCategoria("popi");
        e.setDisponible(true);
        //guardar un objeto nuevo, insert con persist
        sf.inTransaction(session -> {
            session.persist(e);
        });

        //Eliminar. Primero lo encuentro luego lo borro
        sf.inTransaction(session -> {
            Equipo e2 = session.find(Equipo.class, 2L);
            session.remove(e2);
        });


    }
}
