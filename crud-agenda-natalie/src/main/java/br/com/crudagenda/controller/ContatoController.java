package br.com.crudagenda.controller;

import br.com.crudagenda.dao.ContatoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Contatos", urlPatterns = {"/ContatoController", "/main", "/insert"})
public class ContatoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContatoDAO dao;

    public ContatoController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        var action = request.getServletPath();
        System.out.println(action);

        if (action.equals("/main")) {
            contatos(request, response);
        } else if (action.equals("/insert")) {
           novoContato(request, response);
        }
    }

    protected void contatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    protected void novoContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("cadastro.jsp");
    }
}
