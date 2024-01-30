package servelets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import beans.Email;
import dao.DaoFactory;
import dao.EmailDao;
import beans.Person;

public class Newsletters extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EmailDao emailDao;

    public Newsletters() {
        super();
    }
    public void init() throws ServletException {
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            this.emailDao = daoFactory.getEmailDao();
        } catch(Exception e) {
            System.out.println(e);
            throw new ServletException();
        }
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException
    {
        try {
            List<Email> emails = emailDao.findAll();
            request.setAttribute("emails", emails);
            this.getServletContext()
                .getRequestDispatcher("/WEB-INF/newsletter.jsp")
                .forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            throw new ServletException();
        }
    }
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException
    {
        try {
            Email email = new Email();
            email.setName(request.getParameter("email"));
            Person person = new Person();
            person.setFirstname(request.getParameter("firstname"));
            person.setLastname(request.getParameter("lastname"));
            emailDao.add(email, person);
            this.getServletContext()
                .getRequestDispatcher("/WEB-INF/newsletter.jsp")
                .forward(request, response);
        } catch(Exception e) {
            System.out.println(e);
            request.setAttribute("error",
                    "Demandez à votre supérieur de vous enregistrer.");
            // throw new ServletException();
            this.getServletContext()
                .getRequestDispatcher("/WEB-INF/newsletter.jsp")
                .forward(request, response);
        }
    }
}
