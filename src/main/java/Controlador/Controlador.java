/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josue
 */
public class Controlador extends HttpServlet {


    Empleado em= new Empleado();
    EmpleadoDAO edao= new EmpleadoDAO();
    int ide;
    int idp;
    Producto pro= new Producto();
    ProductoDAO pdao= new ProductoDAO();

      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");      
        
        
        if(menu.equals("Principal")){
           request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        
        
        if(menu.equals("Empleado")){
                switch(accion){
                    case "Listar":
                        List lista=edao.listar();
                        request.setAttribute("empleados", lista);
                        break;

                    case "Agregar":
                        String nombre=request.getParameter("nombre");
                        String correo=request.getParameter("correo");
                        String pass=request.getParameter("pass");
                        String rango=request.getParameter("tipo");
                        int tipo=1;
                        switch(rango){
                           case "Administrador":
                             tipo=2;
                             break;
                           case "Vendedor":
                             tipo=1;
                             break;
                          default:
                             tipo=1;
                         }
                        em.setNombre(nombre);
                        em.setCorreo(correo);
                        em.setPass(pass);
                        em.setTipo(tipo);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        ide=Integer.parseInt(request.getParameter("id"));
                        Empleado e=edao.listarId(ide);
                        request.setAttribute("datosE", e);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;

                     case "Actualizar":
                        String nombre1=request.getParameter("nombre");
                        String correo1=request.getParameter("correo");
                        String pass1=request.getParameter("pass");
                        String rango1=request.getParameter("tipo");
                        int tipo1=1;
                        switch(rango1){
                           case "Administrador":
                             tipo1=2;
                             break;
                           case "Vendedor":
                             tipo1=1;
                             break;
                          default:
                             tipo1=1;
                         }
                        em.setNombre(nombre1);
                        em.setCorreo(correo1);
                        em.setPass(pass1);
                        em.setTipo(tipo1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;

                    case "Delete":
                        ide=Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        
        
        
        if(menu.equals("Cliente")){
           request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        
        
        
        if(menu.equals("Producto")){
            switch(accion){
                    case "Listar":
                            List lista=pdao.listar();
                            request.setAttribute("productos", lista);
                        break;
                    case "Agregar":
                            String nombre=request.getParameter("nombre");
                            int precioL=Integer.parseInt(request.getParameter("precioL"));
                            int memoria=Integer.parseInt(request.getParameter("memoria"));
                            int almacenamiento=Integer.parseInt(request.getParameter("almacenamiento"));
                            String procesador=request.getParameter("procesador");
                            int cores=Integer.parseInt(request.getParameter("cores"));
                            String descripcion=request.getParameter("descripcion");
                            String color=request.getParameter("color");
                            int precioV=Integer.parseInt(request.getParameter("precioV"));
                            String imagen1=request.getParameter("img1");
                            String imagen2=request.getParameter("img2");
                            String imagen3=request.getParameter("img3");
                            pro.setNombre(nombre);
                            pro.setPrecioL(precioL);
                            pro.setMemoria(memoria);
                            pro.setAlmacenamiento(almacenamiento);
                            pro.setProcesador(procesador);
                            pro.setCores(cores);
                            pro.setDescripcion(descripcion);
                            pro.setColor(color);
                            pro.setPrecioV(precioV);
                            pro.setImagen1(imagen1);
                            pro.setImagen2(imagen2);
                            pro.setImagen3(imagen3);
                            pdao.agregar(pro);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response); 
                        break;
                    case "Editar": 
                        idp=Integer.parseInt(request.getParameter("id"));
                        Producto p=pdao.listarId(idp);
                        request.setAttribute("datosP", p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        break;
                    default:
                       throw new AssertionError();
            }
            
           request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        
        
        
        if(menu.equals("NuevaVenta")){
           request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
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
