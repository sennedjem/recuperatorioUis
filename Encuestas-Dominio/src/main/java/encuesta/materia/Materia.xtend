package encuesta.materia

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Observable
@Accessors
class Materia {
	
	String nombre
	
		
	new(String nom) {
		this.nombre = nom

	}
	
}