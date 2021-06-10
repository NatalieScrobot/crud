package br.com.crudagenda;

import br.com.crudagenda.dao.ContatoDAO;
import br.com.crudagenda.model.Categoria;
import br.com.crudagenda.model.Contato;

import java.time.LocalDate;
import java.time.Month;
public class Aplication {
    public static void main(String[] args) {

        var contatoBase = criarContatoBase(
                "Natalie",
                "Scrobot",
                LocalDate.of(2020, Month.JANUARY, 8),
                "41 99112 4672",
                Categoria.OUTRO);

        salvarContato(contatoBase);
        procurarContato(20L);
        listarContatos();

        var contatoDois = criarContatoBase(
                "Lynconl",
                "Assunção",
                LocalDate.of(2020, Month.JANUARY, 1),
                "41 99999 9999",
                Categoria.CONJUGE);

        update(20L, contatoDois);
        procurarContato(20L);
        deletar(20L);
    }

    public static Contato criarContatoBase(String nome, String sobrenome, LocalDate dataNascimento, String telefone, Categoria categoria) {
        return new Contato(0L, nome, sobrenome, dataNascimento, telefone, categoria);
    }

    public static void procurarContato(long id) {
        var dao = new ContatoDAO();

        var contato = dao.findById(id);

        contato.ifPresent(c -> listarContatoNoLog(c));
    }

    public static void salvarContato(Contato contato) {
        var dao = new ContatoDAO();

        dao.save(contato);

        System.out.println("Foi inserido com sucesso o contato com id: " +  contato.getId());
    }

    public static void listarContatos() {
        var dao = new ContatoDAO();

        var contatos = dao.findAll();

        contatos.forEach(c -> listarContatoNoLog(c));
    }

    public static void update(long id, Contato contato) {
        var dao = new ContatoDAO();

        dao.update(id, contato);

        System.out.println("Foi atualizado com sucesso o contato com id: " +  id);
    }

    public static void deletar(long id) {
        var dao = new ContatoDAO();

        dao.delete(id);

        System.out.println("Foi deletado com sucesso o contato com id: " +  id);
    }

    public static void listarContatoNoLog(Contato contato) {
        System.out.println("=======================================================");
        System.out.println("ID: " + contato.getId());
        System.out.println("Nome: " + contato.getNome());
        System.out.println("Sobrenome: " + contato.getSobrenome());
        System.out.println("Data de Nascimento:  " + contato.getDataDeNascimento());
        System.out.println("Telefone:  " + contato.getTelefone());
        System.out.println("Parentesco: " + contato.getParentesco());
        System.out.println("=======================================================");
    }
}
