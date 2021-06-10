package br.com.crudagenda.dao;

import br.com.crudagenda.model.Contato;

import java.util.List;
import java.util.Optional;

public interface IContatoDAO {
    Contato save(Contato contato);
    Contato update(long id, Contato contato);
    void delete(long id);
    List<Contato> findAll();
    Optional<Contato> findById(long id);
}
