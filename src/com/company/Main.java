package com.company;

import com.company.Hotel.Consumibles.Consumible;
import com.company.Hotel.Consumibles.Platillo;
import com.company.Persona.Administrador;

public class Main {

    public static void main(String[] args) {
        /*Menu menu = new Menu();

        menu.menuPrincipal();
        System.out.println("TODAS LAS BEBIDAS ");
        for(Platillo b : Platillo.values()){
            System.out.println(b.toString());
        }*/
        Administrador administrador = new Administrador("pedro","gallese","papitas","48478978",158000);
        System.out.println(administrador.toString());



    }
}
