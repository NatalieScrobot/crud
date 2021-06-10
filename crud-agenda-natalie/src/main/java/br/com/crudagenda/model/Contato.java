package br.com.crudagenda.model;

import java.time.LocalDate;
import java.util.Date;

public class Contato {
    private long id;
    private String nome;
    private String sobrenome;
    private LocalDate datadenascimento;
    private String telefone;
    private Categoria parentesco;


    public Contato(long id, String nome, String sobrenome, LocalDate datadenascimento, String telefone, Categoria parentesco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.datadenascimento = datadenascimento;
        this.telefone = telefone;
        this.parentesco = parentesco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataDeNascimento() {
        return datadenascimento;
    }

    public void setDataDeNascimento(LocalDate datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Categoria getParentesco() {
        return parentesco;
    }

    public void setParentesco(Categoria parentesco) {
        this.parentesco = parentesco;
    }
}
