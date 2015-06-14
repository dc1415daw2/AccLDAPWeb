/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daw2
 */
public class ServConsLDAP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultat de la consulta</title>");            
            out.println("</head>");
            out.println("<body>");
            //
            String usuari=request.getParameter("uid");
            String unitatorg=request.getParameter("uo");
            //
            Properties connexio = new Properties();
            connexio.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
            connexio.put(Context.PROVIDER_URL,"ldap://www.fjeclot.net:389");
            try {
                DirContext context = new InitialDirContext(connexio);
                Attributes attrs = context.getAttributes("uid="+usuari+",ou="+unitatorg+",dc=fjeclot,dc=net");
                out.println("<h2>Resultat de la consulta:</h2>");
                out.println("<b>Usuari:</b> " + attrs.get("cn").get() + "<br>" );
                out.println("<b>Title:</b> " + attrs.get("title").get() + "<br>" );
                out.println("<b>Descripció:</b> " + attrs.get("description").get() + "<br>" );
                out.println("<b>telephone number:</b> " + attrs.get("telephoneNumber").get() + "<br><br>" ); 
                out.println("<b><a href=/AccLDAPWeb2/index.jsp>Retorn a la pàgina d'entrada de dades</a></b>");
            } 
            catch (NamingException e) {
                out.print("<h2>ERROR D'ACCÉS A LES DADES DE L'USUARI:</h2>");
                out.println("Nom d'usuari i/o unitat organitzativa incorrectes<br><br>");
                out.println("<b><a href=/AccLDAPWeb2/index.jsp>Retorn a la pàgina d'entrada de dades</a></b>");
            }             
            out.println("</body>");
            out.println("</html>");
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}