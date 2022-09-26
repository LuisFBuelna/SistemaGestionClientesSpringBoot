package com.prueba.ControlClientesSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indicamos la forma de generar esta llave primaria
    private long idPersona;
    
    @NotEmpty(message = "Debe ingresar su nombre")
    private String nombre;
    
    @NotEmpty(message = "Debe ingresar su apellido")
    private String apellido;
    
    @NotEmpty(message = "Debe ingresar su email")
    @Email
    private String email;
    
    @NotEmpty(message = "Debe ingresar su telefono")
    private String telefono;
    
}
