package com.company.Sistema;

import com.company.Hotel.Habitacion;
import com.company.Hotel.Hotel;
import com.company.Hotel.Reserva;
import com.company.Persona.Administrador;
import com.company.Persona.Pasajero;
import com.company.Persona.Persona;
import com.company.Persona.Recepcion;
import com.company.Hotel.Reserva;
import com.company.Persona.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;


public class ManejoArchivo {

                            ////-----GUARDAR-----////
    public static boolean guardarReservas(ArrayList<Reserva> reservas) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("reservas"));

        try {
            Gson gson = new Gson();
            gson.toJson(reservas, new TypeToken<ArrayList<Reserva>>() {}.getType(), bufferedWriter);
        } finally {
            bufferedWriter.close();
        }

        return true;
    }

    public static boolean guardarPersonas(ArrayList<Persona> personas) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("personas"));

        try {
            Gson gson = new Gson();
            gson.toJson(personas, new TypeToken<ArrayList<Persona>>() {}.getType(), bufferedWriter);
        } finally {
            bufferedWriter.close();
        }

        return true;
    }

    public static boolean guardarHabitaciones(ArrayList<Habitacion> habitaciones) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("habitaciones"));

        try {
            Gson gson = new Gson();
            gson.toJson(habitaciones, new TypeToken<ArrayList<Habitacion>>() {}.getType(), bufferedWriter);
        } finally {
            bufferedWriter.close();
        }

        return true;
    }

    public static boolean guardarBackup(Backup backup) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("backup"));
        try {
            Gson gson = new Gson();
            gson.toJson(backup, new TypeToken<Backup>() {}.getType(), bufferedWriter);
        } finally {
            bufferedWriter.close();
        }
        return true;
    }

                        ////-----LECTURAS-----////
    public static ArrayList<Reserva> leerReservas() throws IOException {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("reservas"));

        try {
            Gson gson = new Gson();
            reservas = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Reserva>>(){}.getType());
        } finally {
            bufferedReader.close();
        }

        return reservas;
    }

    public static ArrayList<Persona> leerPersonas() throws IOException {

         ArrayList<Persona> personas = new ArrayList<Persona>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("personas"));

        PersonaDeserializer deserializer = new PersonaDeserializer("className");
        deserializer.registerBarnType("Pasajero", Pasajero.class);
        deserializer.registerBarnType("Recepcion", Recepcion.class);
        deserializer.registerBarnType("Administrador", Administrador.class);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Persona.class, deserializer)
                .create();

        personas = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Persona>>(){}.getType());


        /*ArrayList<Persona> personas = new ArrayList<Persona>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("personas"));

        try {
            Gson gson = new Gson();
            personas = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Persona>>(){}.getType());
        } finally {
            bufferedReader.close();
        }

        return personas;*/

        return personas;
    }

    public static ArrayList<Habitacion> leerHabitaciones() throws IOException {
        ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("habitaciones"));

        try {
            Gson gson = new Gson();
            habitaciones = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Habitacion>>(){}.getType());
        } finally {
            bufferedReader.close();
        }

        return habitaciones ;
    }

    public static Backup leerBackup() throws IOException {
        Backup backup = new Backup();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("backup"));

        try {
            Gson gson = new Gson();
            backup = gson.fromJson(bufferedReader,Backup.class);
        } finally {
            bufferedReader.close();
        }

        return backup ;
    }




/*
    public static ArrayList<Habitacion> leerHabitaciones() throws IOException {
        ArrayList<Habitacion> listHabitacion = null;

        try {

            Gson gson = new Gson();

            BufferedReader bufferedReader = new BufferedReader(new FileReader("habitaciones"));

            String habitacion= gson.fromJson(bufferedReader, new TypeToken<String>(){}.getType());
            System.out.println("hola");

            listHabitacion = gson.fromJson(habitacion, new TypeToken<ArrayList<Habitacion>>() {}.getType());

        } catch (JsonSyntaxException e) {
            System.err.println("JsonSyntaxException: " + e.getMessage());
        }
        return listHabitacion;
    }*/
}