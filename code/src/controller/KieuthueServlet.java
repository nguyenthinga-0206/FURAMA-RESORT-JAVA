package controller;

import model.Diachi;
import model.Kieuthue;
import service.KieuthuService;
import service.KieuthuServicelmpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "KieuthueServlet", urlPatterns = "/kieuthue")
public class KieuthueServlet extends HttpServlet {
    public KieuthuService service = new KieuthuServicelmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                CreateKieuthue(request, response);
                break;
            case "edit":
                EditKieuthue(request, response);
                break;
            case "delete":
                DeleteKieuthue(request, response);
                break;

            default:
                ListKieuthue(request, response);
        }
    }

    private void CreateKieuthue(HttpServletRequest request, HttpServletResponse response) {
    }

    private void EditKieuthue(HttpServletRequest request, HttpServletResponse response) {
    }

    private void DeleteKieuthue(HttpServletRequest request, HttpServletResponse response) {
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateKieuthue(request, response);
                break;
            case "edit":
                showEditKieuthue(request, response);
                break;
            case "delete":
                showDeleteKieuthue(request, response);
                break;

            default:
                ListKieuthue(request, response);
        }
    }

    private void showDeleteKieuthue(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditKieuthue(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateKieuthue(HttpServletRequest request, HttpServletResponse response) {
    }
    private void ListKieuthue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_kieuthue=request.getParameter("id");
        List<Kieuthue> kieuthue = service.finAll();
        request.setAttribute("kieuthue",kieuthue);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/kieuthue/list.jsp");
        dispatcher.forward(request,response);
    }
}
