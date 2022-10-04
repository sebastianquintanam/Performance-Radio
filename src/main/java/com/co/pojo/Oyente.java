/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.co.pojo;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.Data;


//Data: nos sirve para tomar los atributos de la clase y genera set y get y to string para estos en la clase
@Data
//Eentity: para decir que es una entidad que va a hacer el mape objeto trelacional a una entidad, o a una tabla 
@Entity
@Table(name="oyente")// para indicar como se llama la tabla 

//Para conectarnos a la base de datos usamos SErializable
public class Oyente implements Serializable{
    @Id    
    private String username;
    private String contrasena;
    private String nombre_oyente;
    private String apellido_oyente;
    private String email_oyente; 
    private String pais_oyente; 
}
