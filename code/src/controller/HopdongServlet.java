package controller;

import model.*;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HopdongServlet",urlPatterns = "/hopdong")
public class HopdongServlet extends HttpServlet {
    private HopdongService service = new HopdongServicelmpl();
    private DichvuService dichvuService = new DichvuServicelmpl();
    private KhachhangService khachhangService = new KhachhangServicelpml();
    private  NhanvienService nhanvienService = new NhanvienServicelmpl();
    private  KieuthuService kieuthuService =new KieuthuServicelmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null)
        {
            action = "";
        }
        switch (action)
        {
            case "create":
                CreateHopdong(request,response);
                break;
            case "search":
                SearchHopdong(request,response);
                break;
            case "edit":
                EditHopdong(request,response);
                break;
            case "view":
                ViewHopdong(request,response);
                break;
            default:
                ListHopdong(request,response);
        }
    }

    private void ViewHopdong(HttpServletRequest request, HttpServletResponse response) {
    }

    private void EditHopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id_hopdong");
        System.out.println("id_kg:" + id);
        String ngaybatdau = request.getParameter("ngaybatdau");
        String ngayketthuc =  request.getParameter("ngayketthuc");
        float sotiendatcoc = request.getDateHeader("sotiendatcoc");
        float tongsotienthanhtoan = request.getDateHeader("tongsotienthanhtoan");
        String id_nhanvien = request.getParameter("id_nhanvien");
        String id_khachhang = request.getParameter("id_khachhang");
        String id_dichvu= request.getParameter("id_dichvu");
        Hopdong hopdong = new Hopdong(id,ngaybatdau,ngayketthuc,sotiendatcoc,tongsotienthanhtoan, new Nhanvien(id_nhanvien),new Khachhang(id_khachhang),new Dichvu(id_dichvu));
        service.update(id,hopdong);
        ListHopdong(request,response);

    }

    private void SearchHopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("hopdong", service.finByName(name));
        request.setAttribute("value_key", name);
        System.out.println("đang tim kiem ten trong hop dong " + name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hopdong/list.jsp");
        dispatcher.forward(request,response);
    }

    private void CreateHopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id_hopdong");
        System.out.println("id_kg:" + id);
        String ngaybatdau = request.getParameter("ngaybatdau");
        String ngayketthuc =  request.getParameter("ngayketthuc");
        float sotiendatcoc = request.getDateHeader("sotiendatcoc");
        float tongsotienthanhtoan = request.getDateHeader("tongsotienthanhtoan");
        String id_nhanvien = request.getParameter("id_nhanvien");
        String id_khachhang = request.getParameter("id_khachhang");
        String id_dichvu= request.getParameter("id_dichvu");
        Hopdong hopdong = new Hopdong(id,ngaybatdau,ngayketthuc,sotiendatcoc,tongsotienthanhtoan, new Nhanvien(id_nhanvien),new Khachhang(id_khachhang),new Dichvu(id_dichvu));
        service.save(hopdong);
        ListHopdong(request,response);

    }

    private void ListHopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("hopdong",service.finAll());
        System.out.println("ds hp ding:" +service.finAll());
        request.setAttribute("timkiem","hopdong");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hopdong/list.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null)
        {
            action = "";
        }
        switch (action)
        {
            case "create":
                showCreateHopdong(request,response);
                break;
            case "search":
                showSearchHopdong(request,response);
                break;
            case "edit":
                showEditHopdong(request,response);
                break;
            case "view":
                showViewHopdong(request,response);
                break;
            case "delete":
                showDeleteHopdong(request,response);
                break;
            default:
                ListHopdong(request,response);
        }
    }

    private void showEditHopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_khachhang =  request.getParameter("id_khachhang");
        String id =  request.getParameter("id");
        System.out.println("id dang tim kiem la" + id + service.finById1(id));
        List<Kieuthue> kieuthues = kieuthuService.finAll();
        List<Khachhang> khachhangs = khachhangService.finAll();
        List<Nhanvien> nhanviens = nhanvienService.finAll();
        List<Dichvu> dichvus= dichvuService.finAll();
        Hopdong hopdong = service.finById1(id);
        request.setAttribute("hopdong",hopdong);
        request.setAttribute("id_khachhang",id_khachhang);
        request.setAttribute("kieuthues",kieuthues);
        request.setAttribute("khachhangs",khachhangs);
        request.setAttribute("nhanviens",nhanviens);
        request.setAttribute("dichvus",dichvus);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/hopdong/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void showViewHopdong(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showDeleteHopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        service.remove(id);
        System.out.println("hop dong co id bi xoa la:" +id);
        request.setAttribute("hopdong",service.finAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hopdong/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showSearchHopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hopdong/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreateHopdong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_khachhang =  request.getParameter("id_khachhang");
        List<Kieuthue> kieuthues = kieuthuService.finAll();
        List<Khachhang> khachhangs = khachhangService.finAll();
        List<Nhanvien> nhanviens = nhanvienService.finAll();
        List<Dichvu> dichvus= dichvuService.finAll();
        request.setAttribute("id_khachhang",id_khachhang);
        request.setAttribute("kieuthues",kieuthues);
        request.setAttribute("khachhangs",khachhangs);
        request.setAttribute("nhanviens",nhanviens);
        request.setAttribute("dichvus",dichvus);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/hopdong/create.jsp");
        dispatcher.forward(request,response);
    }
}

