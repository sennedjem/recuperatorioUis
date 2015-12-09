package encuesta.carrera

import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors
import encuesta.materia.Materia
import encuesta.materia.Turno

@Observable
@Accessors
class Curso {
	
	Materia materia
	Turno turno
	
	new(){
	}
	
	new(Materia mat, Turno turn){
		materia = mat
		turno = turn
	}
}