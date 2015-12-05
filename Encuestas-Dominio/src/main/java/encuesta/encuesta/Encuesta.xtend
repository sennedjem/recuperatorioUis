package encuesta.encuesta

import java.util.List

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import encuesta.carrera.Carrera
import encuesta.carrera.Curso

@Observable
@Accessors
class Encuesta {
	var List<Curso> materias = new ArrayList()
	var Carrera carrera
	var String añoIngreso
	var String finalesAprobados
	var String finalesDesaprobados 
	var String cursadasAprobadas
	
	def agregarMateria(Curso mat){
		materias.add(mat)
	}

}