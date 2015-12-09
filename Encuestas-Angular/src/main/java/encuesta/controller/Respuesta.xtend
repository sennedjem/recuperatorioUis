package encuesta.controller

import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors
import encuesta.encuesta.Encuesta
import java.util.ArrayList
import encuesta.materia.Materia
import java.util.List
import encuesta.carrera.Curso
import encuesta.carrera.Carrera
import encuesta.applicationModel.RepoEncuestas

@Observable
@Accessors
class Respuesta {
	var String carreraNombre
	var String mail
	var List<Curso> materias = new ArrayList
	var Integer anioIngreso
	var Integer finalesAprobados
	var Integer finalesDesaprobados
	var Integer cursadasAprobadas
	
	
	def generarEncuesta(RepoEncuestas repo) {
		var Encuesta encuesta = new Encuesta()
		encuesta.setCursos(this.materias)
		encuesta.carrera = repo.findCarrera(carreraNombre)
		encuesta.mail = this.mail
		encuesta.añoIngreso = this.anioIngreso
		encuesta.finalesAprobados = this.finalesAprobados
		encuesta.finalesDesaprobados = this.finalesDesaprobados
		encuesta.cursadasAprobadas = this.cursadasAprobadas
		encuesta
		
	}
	

	
}
	
	