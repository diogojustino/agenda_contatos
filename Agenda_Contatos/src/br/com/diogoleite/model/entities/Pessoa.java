/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diogoleite.model.entities;

/**
 *
 * @author diogo_leite
 */
public class Pessoa implements Comparable<Pessoa>{
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String url;
    private String telefoneFixo;
    private String telefoneCelular;
    
    public Pessoa(){}
    
    public Pessoa(String nome, String sobrenome, String email, String url, String telefoneFixo, String telefoneCelular) throws RuntimeException{
        validarNome(nome);
        validarTelefoneCelular(telefoneCelular);
        
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.url = url;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setNome(String nome)throws RuntimeException{
        validarNome(nome);
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }   
    
    public String getSobrenome(){
        return sobrenome;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setUrl(String url){
        this.url = url;
    }
    
    public String getUrl(){
        return url;
    }
    
    public void setTelefoneFixo(String telefoneFixo){
        this.telefoneFixo = telefoneFixo;
    }
    
    public String getTelefoneFixo(){
        return telefoneFixo;
    }
    
    public void setTelefoneCelular(String telefoneCelular) throws RuntimeException{
        validarTelefoneCelular(telefoneCelular);
        this.telefoneCelular = telefoneCelular;
    }
    
    public String getTelefoneCelular(){
        return telefoneCelular;
    }
    
    @Override
    public String toString(){
        return String.format("ID: #%d%nNome: %s %s%nEmail: %s%nURL: %s%nTelefone Fixo: %s%nTelefone Celular: %s", id, nome, sobrenome, email, url, telefoneFixo, telefoneCelular);
    }
    private void validarNome(String nome){
        if(nome.length() < 3 ){
            throw new RuntimeException("O nome do contato não pode ser vazio ou menor que 3 caracteres.");
        }
        
    }
    
    private void validarTelefoneCelular(String telefoneCelular){
        if(telefoneCelular.length() < 9){
            throw new RuntimeException("O Celular precisa ter no minimo 9 caracteres. ");
        }
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        return nome.compareTo(pessoa.getNome());
    }
}

