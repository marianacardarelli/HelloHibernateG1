package org.example;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
      var cfg = new Configuration().configure();
      SessionFactory sf =cfg.buildSessionFactory();


    }
}
