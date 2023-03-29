/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.ejb.FacultadManagerLocal;
import com.udea.modelo.Calendario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author saxss
 */
public class CalendarioMBean implements Serializable {
 //enchufo la vista con la logca de negocios
    //controlador enlazdo con la logica de negocio
    
    
    @EJB
    private FacultadManagerLocal facultadManager;
    
    @EJB
    private com.udea.ejb.CalendarioManagmentLocal calendarioManagment;
   
    //propiedades del modelo
    //actualizar datos
    private Calendario calendario;
    //visualizar la tabla
    private List<Calendario> calendarios;
    
    
    

    /**
     * Creates a new instance of CalendarioMBean
     */
    public CalendarioMBean() {
    }
    
    //metodo para retornar la lista de calendarios
    public List<Calendario> getCalendarios(){
        //evaluo lista vacia
        if ((calendarios==null)||(calendarios.isEmpty())){
            //funcion para actualizar la base de datos
            refresh();
        }
        return calendarios;
    }
    
    //metodo para retornanar los detalles de casa calendario
    public Calendario getCalendario(){
        return calendario;
    }
    
    //ACTION HANDLER
    
    //capturar eventos  desde la vista (acciones con lo sbotones o click en el id del objeto en la tabla)
    
    //click en el id
    public String ShowDetails(Calendario calendario){
        this.calendario=calendario;
        //etiqueta en faces-config.xml
        return "DETAILS";
    }
    
    //click en boton actualizar--> actualizo DB
    public String update(){
        calendario=calendarioManagment.update(calendario);
        //acction Saved en faces-config.xml
        return "SAVED";
    }
    
    
    //click en back--> vuelvo al la lista principal 
    
    public String list(){
        return "LIST";
    }
    
    
    //para que se actualice la lista
    public void refresh(){
        calendarios=calendarioManagment.getAllCalendarios();
    }
    
}
