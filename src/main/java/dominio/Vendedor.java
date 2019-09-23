package dominio;

import dominio.repositorio.RepositorioProducto;
import dominio.util.Utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioGarantiaExtendida;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String EL_PRODUCTO_NO_TIENE_GARANTIA = "Este producto no cuenta con garantía extendida";
    public static final int MAXIMO_VOCALES = 3;
    public static final double PRECIO = 500000;
    public static final double PORCENTAJE_BASE_CIEN = 0.20;

    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;

    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;
    }

    
    public void generarGarantia(String codigo, String nombreCliente){
    	
    	Utilities.getInstance().verificarCodigoTresVocales(codigo, MAXIMO_VOCALES, EL_PRODUCTO_NO_TIENE_GARANTIA);
    	Producto producto = new Producto(codigo, "Impresora", 550000);
    	repositorioProducto.agregar(producto);
    	if(tieneGarantia(codigo)){
    		throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_GARANTIA);
    	}
    	
    	if (producto.getPrecio() < PRECIO){
    		
			GarantiaExtendida garantia = new GarantiaExtendida(producto, nombreCliente);
			repositorioGarantia.agregar(garantia);
    	}
    	
    	else {
    		
    		double precioGarantia = producto.getPrecio() * PORCENTAJE_BASE_CIEN;
    		Date fechaSolicitudGarantia = new Date();
    		
    		Calendar  calendar = Calendar.getInstance();
    		calendar.setTime(fechaSolicitudGarantia);
    		int contadorDias= 0;
    		
    		for (int i = 0; i<200; i++){
    			
    			if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY  || calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
    				calendar.add(Calendar.DAY_OF_YEAR, 1);
    			}
    			contadorDias++;
    		}
    		
    		Date fechaFinGarantia = calendar.getTime();
    		
    		GarantiaExtendida garantia = new GarantiaExtendida(producto, fechaSolicitudGarantia, fechaFinGarantia, precioGarantia,nombreCliente);
			repositorioGarantia.agregar(garantia);
    	}
    }
 
    
    
	public boolean tieneGarantia(String codigo) {
    	
    	Producto producto = repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo);
    	return producto != null;
    }

}
