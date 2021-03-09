
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body> 
        <div class="d-flex">
            <div class="col-lg-5 col-sm-12">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                    <div class="card-body">
                        <div class="form-group mb-2"> 
                            <label> Datos del cliente</label>
                        </div>
                        <div class="form-group d-flex"> 
                            <div class="col-4">
                                <input type="text" name="codigocliente" value="${c.getId()}" class="form-control" placeholder="codigo">
                            </div>
                            <div class="col-2">
                                <input type="submit" name="accion" value="BuscarC" class="btn btn-outline-info">
                            </div>
                            <div class="col-6">
                                <input type="text" name="nombrescliente" value="${c.getNombre()}" class="form-control col-4">
                            </div>
                        </div>
                        
                        <div class="form-group mt-4 mb-2"> 
                            <label>Datos Producto </label>
                        </div>
                        <div class="form-group d-flex"> 
                             <div class="col-4">
                                <input type="text" name="codigoproducto" class="form-control" placeholder="codigo">
                            </div>
                            <div class="col-2">
                                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info">
                            </div>
                            <div class="col-6">
                                <input type="text" name="nombresproducto" placeholder="Datos Producto" class="form-control col-4">
                            </div>
                        </div>

                        <div class="form-group mt-4 mb-4"> 
                                <div class="col-6">
                                    <label>Precio </label>
                                    <input type="text" name="precio" class="form-control" placeholder="Q 0.00">
                                </div>
                            
                                <div class="col-6">
                                    <label>Cantidad </label>
                                    <input type="number" name="cantidad" class="form-control">
                                </div>
                                <div class="col-6">
                                    <label>Inventario </label>
                                    <input type="text" name="stock" class="form-control">
                                </div>
                        </div>
                        <div>
                            <input type="submit" name="accion" valor="Agregar" class="btn btn-lg btn-outline-info">
                        </div>
                    </div>
                </form>
                </div>
            </div>
            <div class="col-7 col-sm-12">   
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-lg-4 col-sm-4">
                            <label>Numero de Factura</label>
                            <input type="text" name="NroSerie" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                                <thead>
                                <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripcion</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>subtotal</th>
                                        <th>acciones</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                        <td> </td>
                                        <td> </td>
                                        <td> </td>
                                        <td> </td>
                                        <td> </td>
                                        <td> </td>
                                        <td> </td>
                                       
                                </tr>
                                </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div>
                            <input type="submit" name="accion" value="Generar venta" class="btn btn-sucess">
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
    </body>
</html>
