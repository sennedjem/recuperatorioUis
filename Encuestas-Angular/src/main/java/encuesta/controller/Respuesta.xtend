package encuesta.controller

import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors
import encuesta.encuesta.Encuesta
import java.util.ArrayList
import encuesta.materia.Materia
import java.util.List

@Observable
@Accessors
class Respuesta {
	var String carreraNombre
	var String mail
	var List<Materia> materias = new ArrayList
	
	def generarEncuesta() {
		return new Encuesta()
	}
	
}
	
	