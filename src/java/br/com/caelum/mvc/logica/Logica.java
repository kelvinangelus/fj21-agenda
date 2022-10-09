/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.caelum.mvc.logica;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Kelvin Angelus
 */

public interface Logica {
    
    //Métodos abstratos de uma interface não podem ter corpo
    String executa(HttpServletRequest req, HttpServletResponse res)  throws Exception;
            
}
