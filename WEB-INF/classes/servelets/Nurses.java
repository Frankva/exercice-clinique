package servelets;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dao.DaoFactory;

import java.util.List;

import beans.Service;
import beans.Nurse;

import dao.ServiceDao;
import dao.NurseDao;

public class Nurses extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServiceDao serviceDao;
    private NurseDao nurseDao;
       
    public Nurses() {
        super();
    }

    public void init() throws ServletException {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            this.serviceDao = daoFactory.getServiceDao();
            this.nurseDao = daoFactory.getNurseDao();
        } catch (Exception e) {
            System.out.println(e);
            throw new ServletException();
        }
    }


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            List<Service> services = serviceDao.findAll();
            request.setAttribute("services", services);
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/nurses.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            throw new ServletException();
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        try {
            Nurse nurse = new Nurse(request);
            nurseDao.add(nurse);
            List<Service> services = serviceDao.findAll();
            request.setAttribute("services", services);
            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/nurses.jsp")
                    .forward(request, response);
        } catch (Exception e) {
            System.out.println("servelets Nurses doPost " + e);
            request.setAttribute("erreur", e.getMessage());
            throw new ServletException();
        }
    }


}
