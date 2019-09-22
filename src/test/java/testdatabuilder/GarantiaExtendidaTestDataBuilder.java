package testdatabuilder;

import java.util.Date;

import dominio.GarantiaExtendida;
import dominio.Producto;

public class GarantiaExtendidaTestDataBuilder {
	
	private static final String CODIGO= "F01TSA0150";
	private static final String NOMBRE = "Computador Lenovo";
	private static final double PRECIO = 780000;
	private static final Producto PRODUCTO = new Producto(CODIGO, NOMBRE, PRECIO);
    private static final Date FECHA_SOLICITUD_GARANTIA = new Date();
    private static final Date FECHA_FIN_GARANTIA = new Date();
    private static final double PRECIO_GARANTIA = 1000;
    private static final String NOMBRE_CLIENTE = "Pedro";
    
    private Producto producto;
    private Date fechaSolicitudGarantia;
    private Date fechaFinGarantia;
    private double precioGarantia;
    private String nombreCliente;
    
	public GarantiaExtendidaTestDataBuilder() {
		this.producto = PRODUCTO;
		this.fechaSolicitudGarantia = FECHA_SOLICITUD_GARANTIA;
		this.fechaFinGarantia = FECHA_FIN_GARANTIA;
		this.precioGarantia = PRECIO_GARANTIA;
		this.nombreCliente = NOMBRE_CLIENTE;
	}
	
	public GarantiaExtendidaTestDataBuilder conProducto (Producto producto){
		this.producto = producto;
		return this;
	}
	
	public GarantiaExtendidaTestDataBuilder conFechaSolicitudGarantia (Date fechaSolicitudGarantia){
		this.fechaSolicitudGarantia = fechaSolicitudGarantia;
		return this;
	}
	
	public GarantiaExtendidaTestDataBuilder conFechaFinGarantia (Date fechaFinGarantia){
		this.fechaFinGarantia = fechaFinGarantia;
		return this;
	}
	
	public GarantiaExtendidaTestDataBuilder conPrecioGarantia (Double precioGarantia){
		this.precioGarantia = precioGarantia;
		return this;
	}
	
	public GarantiaExtendidaTestDataBuilder conNombreCliente (String nombreCliente){
		this.nombreCliente = nombreCliente;
		return this;
	}
	
	public GarantiaExtendida build() {
		return new GarantiaExtendida(this.producto, this.nombreCliente);
	}
}
