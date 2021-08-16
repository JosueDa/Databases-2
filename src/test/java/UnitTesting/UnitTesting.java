package UnitTesting;

import Config.Conexion;
import Modelo.*;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class UnitTesting {
/*
    @Test(groups="unitTest",description = "Prueba conexion a base de datos")
    public void conexion(){
        Conexion conexion = new Conexion();
        Connection con;
        con = conexion.conexion();
        Assert.assertNotEquals(con,null,"Error de conexión a BD");
    }

    @Test(dependsOnMethods = {"conexion"},description = "Prueba búsqueda de cliente por ID")
    @Parameters({"cliente1"})
    public void buscarCliente(int cliente1){
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente = clienteDAO.buscar(cliente1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(cliente.getNombre(),null);
        softAssert.assertNotEquals(cliente.getCelular(),null);
        softAssert.assertNotEquals(cliente.getCorreo(),null);
        softAssert.assertNotEquals(cliente.getNit(),null);
        softAssert.assertNotEquals(cliente.getRango(),null);
        softAssert.assertNotEquals(cliente.getDescuento(),null);
        softAssert.assertNotEquals(cliente.getPatente(),null);
        softAssert.assertNotEquals(cliente.getSuscripcion(),null);
        softAssert.assertAll("Error búsqueda de cliente por Id");
    }

    @Test(dependsOnMethods = {"conexion"},description = "Prueba metodo para obetener el id de la última venta")
    public void maxIdVenta(){
        VentaDAO ventaDAO = new VentaDAO();
        Assert.assertNotEquals(ventaDAO.Idventas(),0,"Error máximo id Ventas");
    }

    @Test(dependsOnMethods = {"conexion"}, description = "Prueba Metodo para obtener las marcas de terminales registradas")
    public void listarMarcas(){
        MarcaDAO marcaDAO = new MarcaDAO();
        List<Marca> lista=new ArrayList<>();
        lista = marcaDAO.listar();
        Assert.assertNotEquals(lista.size(),0,"Error lista de marcas");

    }

    @Test(dependsOnMethods = {"buscarCliente"}, description = "Prueba actualización de un cliente")
    @Parameters({"cliente1"})
    public void actualizarCliente(int cliente1){
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        cliente = clienteDAO.buscar(cliente1);
        cliente.setId(1);
        Assert.assertEquals(clienteDAO.actualizar(cliente),1,"Error actualizar cliente");
    }
*/
    @Test(groups="unitTest",description = "Prueba agregar nuevo Cliente")
    public void agregarCliente(){
        ClienteDAO mockClienteDAO = Mockito.mock(ClienteDAO.class);
        Cliente cliente = new Cliente();

        cliente.setId(200);
        cliente.setNombre("Josue");
        cliente.setNit(546554);
        cliente.setCelular(52653254);
        cliente.setCorreo("josue@gmail.com");
        cliente.setSuscripcion(1);
        cliente.setPatente("patente.com");

        Assert.assertEquals(mockClienteDAO.agregar(cliente),0,"Error al añadir registro");
    }
/*
    @Test(dependsOnMethods = {"conexion"},description = "Prueba buscar Inventario por ID")
    @Parameters({"inventario1"})
    public void buscarInventario(int inventario1){
        InventarioDAO inventarioDAO = new InventarioDAO();
        Inventario inventario = new Inventario();
        inventario = inventarioDAO.buscar(inventario1);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(inventario.getId(),null);
        softAssert.assertNotEquals(inventario.getIdProducto(),null);
        softAssert.assertNotEquals(inventario.getCantidad(),null);
        softAssert.assertAll("Error búsqueda de inventario por Id"); asd
    }
*/
    @Test(groups="unitTest",description = "Prueba métodos getter y setter de Inventario")
    public void gettersYsettersInventario(){
        Inventario inventario = new Inventario();
        inventario.setId(20);
        inventario.setCantidad(200);
        inventario.setIdProducto(30);
        inventario.setNombreProducto("Samsung galaxy 7");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(inventario.getId(),20);
        softAssert.assertEquals(inventario.getCantidad(),200);
        softAssert.assertEquals(inventario.getIdProducto(),30);
        softAssert.assertEquals(inventario.getNombreProducto(),"Samsung galaxy 7");
        softAssert.assertAll("Error getters y setter Inventario");
    }

    @Test(groups="unitTest",description = "Prueba métodos getter y setter de Pedidos")
    public void gettersYsettersPedidos(){
        Pedido pedido = new Pedido();
        pedido.setIdpedido(1);
        pedido.setIdproducto(20);
        pedido.setFechaentrega("01/02/21");
        pedido.setFechapedido("01/01/21");
        pedido.setCantidad(20);
        pedido.setEstado("Recibido");


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(pedido.getIdpedido(),1);
        softAssert.assertEquals(pedido.getIdproducto(),20);
        softAssert.assertEquals(pedido.getFechaentrega(),"01/02/21");
        softAssert.assertEquals(pedido.getFechapedido(),"01/01/21");
        softAssert.assertEquals(pedido.getCantidad(),20);
        softAssert.assertEquals(pedido.getEstado(),"Recibido");
        softAssert.assertAll("Error getters y setter Pedidos");
    }
/*
    @Test(dependsOnMethods = {"conexion"},description = "Prueba método para validar empleados")
    @Parameters({"usser","pass","expected"})
    public void validarEmpleado(String usser, String pass, int expected){
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        Empleado empleado = new Empleado();
        empleado= empleadoDAO.validar(usser,pass);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(empleado.getId(),expected);
        softAssert.assertEquals(empleado.getTipo(),expected);
        softAssert.assertAll("Error en validación de empleado");

    }
*/
}
