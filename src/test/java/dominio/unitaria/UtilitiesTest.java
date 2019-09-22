package dominio.unitaria;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import dominio.Producto;
import dominio.Vendedor;
import dominio.repositorio.RepositorioGarantiaExtendida;
import dominio.repositorio.RepositorioProducto;
import dominio.util.Utilities;
import testdatabuilder.ProductoTestDataBuilder;

public class UtilitiesTest {
	
	@Test
	public void codigoValido() {
		
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		
		Producto producto = productoTestDataBuilder.build(); 
		
		RepositorioGarantiaExtendida repositorioGarantia = mock(RepositorioGarantiaExtendida.class);
		RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
		
		Vendedor vendedor = new Vendedor(repositorioProducto, repositorioGarantia);
		
		// act 
		boolean verificacionCorrecta = Utilities.getInstance().verificarCodigoTresVocales(producto.getCodigo(), vendedor.MAXIMO_VOCALES, vendedor.EL_PRODUCTO_NO_TIENE_GARANTIA);
		
		assertTrue(verificacionCorrecta);
	}	
}
