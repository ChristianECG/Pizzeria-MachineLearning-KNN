/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.christianecg.dato.pizzeriaknn;

/**
 *
 * @author christianecg
 */
public class Persona {
    private int edad;
    private int sexo;
    private String pizza;

    public Persona() {
    }

    public Persona(int edad, int sexo, String pizza) {
        this.edad = edad;
        this.sexo = sexo;
        this.pizza = pizza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) throws Exception{
        if(pizza.equals(""))
            throw new Exception("Todos los campos deben ser llenados");
        this.pizza = pizza;
    }
    
}
