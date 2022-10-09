/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.caelum.jdbc.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Kelvin Angelus
 */
public class Contato {
    private Long id;
    
    private String nome;
    
    private String email;
    
    private String endereco;
    
    private Calendar dataNascimento;
    
    //Contrutor
    public Contato(){}

    public Contato(Long id, String nome, String email, String endereco, Calendar dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getDataNascimentoFormatada()
	{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //Instancia uma formatação
                Date data = this.getDataNascimento().getTime(); //Armazena a data sem formatação
		return formato.format(data); //Retorna a data formatada
	}
    
}


