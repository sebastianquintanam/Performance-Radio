/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.co.DAO;

//crud repository: para hacer un crud: crear, leer, update, delete 

import com.co.pojo.Oyente;
import org.springframework.data.repository.CrudRepository;

//Interface: es un medio de comunicacion que va a ver entre mi modelo y mi vista. Vista: guardar cliente, Modelo: Guardar, listar, update, 
//extends crudRepo: para que tome todo lo que tiene 
//>siguen los genericos, con los nombres de clase: Lciente, luego el tipo de datos de la llave primaria 
public interface OyenteDAO extends CrudRepository<Oyente, String>{
    
}
