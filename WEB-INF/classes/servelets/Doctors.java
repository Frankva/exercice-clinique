package servelets;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.Doctor;
import beans.Specialty;

import dao.DaoFactory;
import dao.DoctorDao;
import dao.SpecialtyDao;

import java.util.List;

public class Doctors extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DoctorDao doctorDao;
    private SpecialtyDao specialtyDao;
       
    public Doctors() {
        super();
    }

    public void init() throws ServletException {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            this.doctorDao = daoFactory.getDoctorDao();
            this.specialtyDao = daoFactory.getSpecialtyDao();
        } catch (Exception e) {
            System.out.println(e);
            throw new ServletException();
        }
    }


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            List<Specialty> specialties = specialtyDao.findAll();
            request.setAttribute("specialties", specialties);
            this.getServletContext()
                .getRequestDispatcher("/WEB-INF/doctors.jsp")
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
            Doctor doctor = new Doctor();
            doctor.setFirstname(request.getParameter("firstname"));
            doctor.setLastname(request.getParameter("lastname"));
            doctor.setAddress(request.getParameter("address"));
            doctor.setPhone(request.getParameter("phone"));
            doctor.setSpecialtyId(request.getParameter("specialtyId"));
            this.doctorDao.add(doctor);
            List<Specialty> specialties = specialtyDao.findAll();
            request.setAttribute("specialties", specialties);
            this.getServletContext()
                .getRequestDispatcher("/WEB-INF/doctors.jsp")
                .forward(request, response);
        }
        catch (Exception e) {
            System.out.println(e);
            request.setAttribute("erreur", e.getMessage());
            throw new ServletException();
        }
    }

}
