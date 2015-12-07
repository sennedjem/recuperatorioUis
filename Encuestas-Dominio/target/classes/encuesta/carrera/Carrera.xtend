package encuesta.carrera

import encuesta.carrera.CarreraDeCyt
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import encuesta.materia.Materia

@Accessors
@Observable
class Carrera extends CarreraDeCyt{
	
	new(String string) {
		super(string)
	}
	
	def tieneEnPlanDeEstudio(Materia mat) {
		materias.filter[nombre.equals(mat.nombre)].size>0
	}
	
}