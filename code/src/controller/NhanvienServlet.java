package controller;

import common.validate;
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

@WebServlet(name = "NhanvienServlet",urlPatterns = "/nhanvien")
public class NhanvienServlet extends HttpServlet {
    private NhanvienService service = new NhanvienServicelmpl();
    private VitriService vitriService = new VitriServicelmpl();
    private BophanService bophanService = new BophanServicelmpl();
    private  TrinhdoService trinhdoService = new TrinhdoServicelmpl();
    private  UserService userService = new UserServicelmpl();
    private  DiachiService diachiService = new DiachiServicelmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null)
        {
            action="";
        }
        switch (action)
        {
            case "create":
                CreateNhanvien(request,response);
                break;
            case "edit":
                EditNhanvien(request,response);
                break;
            case "search":
                SearchNhanvien(request,response);
                break;
            case "delete":
                DeleteNhanvien(request,response);
                break;
            default:
                ListNhanvien(request,response);
        }
    }

    private void DeleteNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_nhanvien = request.getParameter("id");
        service.remove(id_nhanvien);
        System.out.println("đã xóa nhan viên  " + id_nhanvien);
        ListNhanvien(request,response);
    }

    private void SearchNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        System.out.println("đang tìm kiếm ten111 : " +name);
        request.setAttribute("nhanviens",service.finByName(name));
        request.setAttribute("value_key", name);
        System.out.println("tim kiem duoc:" + service.finByName(name));

        RequestDispatcher dispatcher= request.getRequestDispatcher("/nhanvien/list.jsp");
        dispatcher.forward(request,response);
    }

    private void EditNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_nhanvien = request.getParameter("id");
        System.out.println("id nhan vien la :" + id_nhanvien);
        String ten_nhanvien = request.getParameter("ten");
        String ngaysinh =request.getParameter("ngaysinh");
      int socmnd =Integer.parseInt(request.getParameter("socmnd"));
        int sdt = Integer.parseInt(request.getParameter("sdt"));
        String email = request.getParameter("email");
        float luong =Float.parseFloat(request.getParameter("luong"));
        String id_diachi = request.getParameter("id_diachi");
        String id_trinhdo = request.getParameter("id_trinhdo");
        String id_bophan = request.getParameter("id_bophan");
        String id_vitri = request.getParameter("id_vitri");
        String ten_user = request.getParameter("ten_user");
        Nhanvien nhanvien = new Nhanvien(id_nhanvien,ten_nhanvien,ngaysinh,socmnd,sdt,email, new Trinhdo(id_trinhdo),new Vitri(id_vitri), new Bophan(id_bophan), luong,new Diachi(id_diachi), new User(ten_user));
        service.update(id_nhanvien,nhanvien);
        ListNhanvien(request,response);
    }
    private void CreateNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id= request.getParameter("id");
        String id_nhanvien = request.getParameter("id");
        String ten_nhanvien = request.getParameter("ten");
        String ngaysinh = request.getParameter("ngaysinh");
        int socmnd =Integer.parseInt(request.getParameter("socmnd"));
        int sdt = Integer.parseInt(request.getParameter("sdt"));
        String email = request.getParameter("email");
        float luong =Float.parseFloat(request.getParameter("luong"));
        String id_diachi = request.getParameter("id_diachi");
        String id_trinhdo = request.getParameter("id_trinhdo");
        String id_bophan = request.getParameter("id_bophan");
        String id_vitri = request.getParameter("id_vitri");
        String ten_user = request.getParameter("ten_user");
        System.out.println("date01" +validate.validateID_NV(id_nhanvien));
        String nhu = null;
        if(nhu == null) {
            if (validate.validateID_NV(id_nhanvien) != null) {
                System.out.println("giá trị date" + validate.validateID_NV(id_nhanvien));
                request.setAttribute("message_id", "Vui lòng nhập lại cho đúng định dạng 'NV-XXXX'");
                nhu = "nhu";
            }
            if (validate.validate_Socmnd(String.valueOf(socmnd)) != null) {
                System.out.println("giá trị date" + validate.validate_Socmnd(String.valueOf(socmnd)));
                request.setAttribute("message_socmnd", "Vui lòng nhập lại somcnd có 9 hoặc 15 số'");
                nhu = "nhu";

            }
            if (validate.validate_email(email) != null) {
                request.setAttribute("message_email", "Vui lòng nhập lại email'");
                nhu = "nhu";
            }
            if(nhu == "nhu")
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/nhanvien/create.jsp");
                dispatcher.forward(request, response);
            }
            else {
                nhu = "oke";
            }
            System.out.println("nhu bang :" + nhu);
        }
         if(nhu =="oke")
         {
             Nhanvien nhanvien = new Nhanvien(id_nhanvien,ten_nhanvien,ngaysinh,socmnd,sdt,email, new Trinhdo(id_trinhdo),new Vitri(id_vitri), new Bophan(id_bophan), luong,new Diachi(id_diachi), new User(ten_user));
             System.out.println("nhan vien duoc them la:" + nhanvien);
             System.out.println("cac id " +id_diachi+ id_trinhdo +id_bophan);
             service.save(nhanvien);
             ListNhanvien(request,response);
         }

//        Nhanvien nhanvien = new Nhanvien(id_nhanvien,ten_nhanvien,ngaysinh,socmnd,sdt,email, new Trinhdo(id_trinhdo),new Vitri(id_vitri), new Bophan(id_bophan), luong,new Diachi(id_diachi), new User(ten_user));
//        System.out.println("nhan vien duoc them la:" + nhanvien);
//        System.out.println("cac id " +id_diachi+ id_trinhdo +id_bophan);
//        service.save(nhanvien);
//        ListNhanvien(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null)
        {
            action="";
        }
        switch (action)
        {
            case "create":
                showCreateNhanvien(request,response);
                break;
            case "edit":
                showEditNhanvien(request,response);
                break;
            case "search":
                showSearchNhanvien(request,response);
                break;
            case "delete":
                showDeleteNhanvien(request,response);
                break;
            case "view":
                showViewNhanvien(request,response);
                break;
            default:
                ListNhanvien(request,response);
        }

    }

    private void showViewNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_nhanvien =request.getParameter("id");
        request.setAttribute("nhanvien",service.finById1(id_nhanvien));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nhanvien/view.jsp");
        dispatcher.forward(request,response);
    }

    private void showDeleteNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_nhanvien = request.getParameter("id");
        service.remove(id_nhanvien);
        System.out.println("đã xóa nhan viên  " + id_nhanvien);
        ListNhanvien(request,response);
    }

    private void showEditNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_diachi =  request.getParameter("id_diachi");
        String id_nhanvien =  request.getParameter("id");
        System.out.println("đang list ra danh sách nhân viên");
        List<Trinhdo> trinhdos = trinhdoService.finAll();
        List<Vitri> vitris = vitriService.finAll();
        List<Bophan> bophans = bophanService.finAll();
        List<User> users = userService.finAll();
        List<Diachi> diachis = diachiService.finAll();
        Nhanvien nhanviens =  service.finById1(id_nhanvien);
        request.setAttribute("id_diachi",id_diachi);
        request.setAttribute("diachis",diachis);
        request.setAttribute("trinhdos",trinhdos);
        request.setAttribute("vitris",vitris);
        request.setAttribute("bophans",bophans);
        request.setAttribute("users",users);
        request.setAttribute("nhanvien",nhanviens);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nhanvien/edit.jsp");
        System.out.println("đang chinh sua nhan vien" +id_nhanvien);
        System.out.println("dia chi nhanv ein la:" + diachis);
        dispatcher.forward(request,response);
    }

    private void showSearchNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        System.out.println("đang tìm kiếm ten111 : " +name);
        request.setAttribute("nhanviens",service.finByName(name));
        System.out.println("tim kiem duoc:" + service.finByName(name));
        RequestDispatcher dispatcher= request.getRequestDispatcher("/nhanvien/list.jsp");
        dispatcher.forward(request,response);
    }

    private void ListNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("timkiem","nhanvien");
        System.out.println("đang list ds nhan viên");
        request.setAttribute("nhanviens",service.finAll());
//        request.setAttribute("users",);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nhanvien/list.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreateNhanvien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_diachi =  request.getParameter("id_diachi");
        System.out.println("đang list ra danh sách nhân viên");
        List<Trinhdo> trinhdos = trinhdoService.finAll();
        List<Vitri> vitris = vitriService.finAll();
        List<Bophan> bophans = bophanService.finAll();
        List<User> users = userService.finAll();
        List<Diachi> diachis = diachiService.finAll();
        List<Nhanvien> nhanviens =  service.finAll();
        request.setAttribute("id_diachi",id_diachi);
        request.setAttribute("diachis",diachis);
        request.setAttribute("trinhdos",trinhdos);
        request.setAttribute("vitris",vitris);
        request.setAttribute("bophans",bophans);
        request.setAttribute("users",users);
        request.setAttribute("nhanviens",nhanviens);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/nhanvien/create.jsp");
        dispatcher.forward(request,response);
    }
}
