package dominio.util;

import dominio.excepcion.GarantiaExtendidaException;

public class Utilities {
	
	private static Utilities instance;
	
	private Utilities(){
		
	}
	
	public static Utilities getInstance (){
		return instance != null ? instance : new Utilities();
	}
	
	
	
	public void verificarCodigoTresVocales(String codigo, int maximoVocales, String errorMessage) {
		// TODO Auto-generated method stub
    	int contador = 0;
    	
    	for(int x=0;x<codigo.length();x++) {
    		if ((codigo.charAt(x)=='A') || (codigo.charAt(x)=='E') || (codigo.charAt(x)=='I') || (codigo.charAt(x)=='O') || (codigo.charAt(x)=='U')){
			    contador++;
			    if (contador > maximoVocales){
			    	throw new GarantiaExtendidaException(errorMessage);
			    }
    		}
		}
	}
}
