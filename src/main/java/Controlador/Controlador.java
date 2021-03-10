/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import java.io.IOException;
import java.util.ArrayList;
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
    Cliente cl=new Cliente();
    ClienteDAO cdao= new ClienteDAO();
    Producto pro= new Producto();
    ProductoDAO pdao= new ProductoDAO();
    Cliente c =new Cliente();
    int ide;
    int idp;
    int idc;
    Venta v=new Venta();
    List<Venta>lista=new ArrayList<>();
    int item;
    int cod;
    int cant;
    double precio;
    String descripc;
    double subtotal;
    double total;
    
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
            switch(accion){
                case "Listar":
                        List lista=cdao.listar();
                        request.setAttribute("clientes", lista);
                        break;
                 case "Agregar":
                        int id=Integer.parseInt(request.getParameter("id"));
                        String nombre=request.getParameter("nombre");
                        int nit=Integer.parseInt(request.getParameter("nit"));
                        String correo=request.getParameter("correo");
                        int celular=Integer.parseInt(request.getParameter("celular"));
                        String suscripcion=request.getParameter("suscripcion");
                        String patente=request.getParameter("patente");
                        int tipo=1;
                        switch(suscripcion){
                           case "Mayorista":
                             tipo=1;
                             break;
                           case "Distribuidor":
                             tipo=2;
                             break;
                          default:
                             tipo=1;
                         }
                        cl.setId(id);
                        cl.setNombre(nombre);
                        cl.setNit(nit);
                        cl.setCorreo(correo);
                        cl.setCelular(celular);
                        cl.setSuscripcion(tipo);
                        cl.setPatente(patente);
                        cdao.agregar(cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                        
                case "Editar":
                        idc=Integer.parseInt(request.getParameter("id"));
                        Cliente c=cdao.listarId(idc);
                        request.setAttribute("datosC", c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                case "Actualizar":
                        int id1=Integer.parseInt(request.getParameter("id"));
                        String nombre1=request.getParameter("nombre");
                        int nit1=Integer.parseInt(request.getParameter("nit"));
                        String correo1=request.getParameter("correo");
                        int celular1=Integer.parseInt(request.getParameter("celular"));
                        String suscripcion1=request.getParameter("suscripcion");
                        String patente1=request.getParameter("patente");
                        int tipo1=1;
                        switch(suscripcion1){
                           case "Mayorista":
                             tipo=1;
                             break;
                           case "Distribuidor":
                             tipo=2;
                             break;
                          default:
                             tipo=1;
                         }
                        cl.setId(id1);
                        cl.setNombre(nombre1);
                        cl.setNit(nit1);
                        cl.setCorreo(correo1);
                        cl.setCelular(celular1);
                        cl.setSuscripcion(tipo);
                        cl.setPatente(patente1);
                        cl.setId(idc);
                        cdao.actualizar(cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                case "Delete":
                        idc=Integer.parseInt(request.getParameter("id"));
                        cdao.delete(idc);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
            }
           request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        
        
        
        if(menu.equals("Producto")){
            switch(accion){
                    case "Listar":
                            List lista=pdao.listar();
                            request.setAttribute("productos", lista);
                        break;
                    case "Agregar":
                            int id=Integer.parseInt(request.getParameter("id"));
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
                            pro.setId(id);
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
                            pdao.agregarI(pro.getId());
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response); 
                        break;
                    case "Editar": 
                        idp=Integer.parseInt(request.getParameter("id"));
                        Producto p=pdao.listarId(idp);
                        request.setAttribute("datosP", p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                     case "Actualizar": 
                            int id1=Integer.parseInt(request.getParameter("id"));
                            String nombre1=request.getParameter("nombre");
                            int precioL1=Integer.parseInt(request.getParameter("precioL"));
                            int memoria1=Integer.parseInt(request.getParameter("memoria"));
                            int almacenamiento1=Integer.parseInt(request.getParameter("almacenamiento"));
                            String procesador1=request.getParameter("procesador");
                            int cores1=Integer.parseInt(request.getParameter("cores"));
                            String descripcion1=request.getParameter("descripcion");
                            String color1=request.getParameter("color");
                            int precioV1=Integer.parseInt(request.getParameter("precioV"));
                            String imagen11=request.getParameter("img1");
                            String imagen21=request.getParameter("img2");
                            String imagen31=request.getParameter("img3");
                            pro.setId(id1);
                            pro.setNombre(nombre1);
                            pro.setPrecioL(precioL1);
                            pro.setMemoria(memoria1);
                            pro.setAlmacenamiento(almacenamiento1);
                            pro.setProcesador(procesador1);
                            pro.setCores(cores1);
                            pro.setDescripcion(descripcion1);
                            pro.setColor(color1);
                            pro.setPrecioV(precioV1);
                            pro.setImagen1(imagen11);
                            pro.setImagen2(imagen21);
                            pro.setImagen3(imagen31);
                            pro.setId(idp);
                            pdao.actualizar(pro);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idp=Integer.parseInt(request.getParameter("id"));
                        pdao.delete(idp);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    default:
                       throw new AssertionError();
            }
            
           request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        
        
        
        if(menu.equals("NuevaVenta")){
            
            switch(accion){
                case"Buscar Cliente":
                    int id=Integer.parseInt(request.getParameter("codigocliente"));
                    cl.setId(id);
                    c =cdao.buscar(id);
                    request.setAttribute("c", c);
                    break;
                case"Buscar Producto":
                    int idP=Integer.parseInt(request.getParameter("codigoproducto"));
                    pro=pdao.listarId(idP);
                    request.setAttribute("c", c);
                    request.setAttribute("pro", pro);
                    request.setAttribute("lista", lista);
                    request.setAttribute("total", total);
                    break;
                case"Agregar":
                    total =0.0;
                    request.setAttribute("c", c);
                    item=item+1;
                    cod=pro.getId();
                    descripc= request.getParameter("nombreproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant= Integer.parseInt(request.getParameter("cantidad"));
                    subtotal=precio*cant;
                    v=new Venta();
                    v.setItem(item);
                    v.setIdProducto(cod);
                    v.setDescripción(descripc);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for(int i=0; i<lista.size();i++){
                        total=total+lista.get(i).getSubtotal();
                    }
                    request.setAttribute("total", total);
                    request.setAttribute("lista", lista);
                    
                    break;
                case"GenerarVenta":
                    
                    break;
                default:
                   
            }
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
