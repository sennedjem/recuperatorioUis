package encuesta.materia

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Materia {
	
	String nombre
	
		
	new(String nom) {
		this.nombre = nom

	}
	
}