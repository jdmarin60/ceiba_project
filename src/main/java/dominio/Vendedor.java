package dominio;

import dominio.repositorio.RepositorioProducto;
import dominio.util.Utilities;
import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioGarantiaExtendida;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String EL_PRODUCTO_NO_TIENE_GARANTIA = "Este producto no cuenta con garantía extendida";
    public static final int MAXIMO_VOCALES = 3;

    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;

    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;
    }

    
    public void generarGarantia(String codigo, String nombreCliente){
    	
    	Utilities.getInstance().verificarCodigoTresVocales(codigo, MAXIMO_VOCALES, EL_PRODUCTO_NO_TIENE_GARANTIA);
    	Producto producto = new Producto(codigo, "Impresora", 200);
    	if(tieneGarantia(codigo)){
    		throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_GARANTIA);
    	}
    	
    	else {
    		nombreCliente = null;
    		GarantiaExtendida garantia = new GarantiaExtendida(producto, nombreCliente);
    		repositorioGarantia.agregar(garantia);
    	}
    }
    
    
	public boolean tieneGarantia(String codigo) {
    	
    	Producto producto = repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo);
    	return producto != null;
    }

}
