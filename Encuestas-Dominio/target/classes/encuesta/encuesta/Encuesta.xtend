package encuesta.encuesta

import java.util.List

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import encuesta.carrera.Carrera
import encuesta.carrera.Curso
import java.util.Date
import org.uqbar.commons.model.UserException
import org.uqbar.commons.model.ObservableUtils
import encuesta.materia.Materia

@Observable
@Accessors
class Encuesta {
	var List<Curso> cursos = new ArrayList()
	var Carrera carrera
	var Integer añoIngreso
	var Integer finalesAprobados
	var Integer finalesDesaprobados 
	var Integer cursadasAprobadas
	var String mail
	
	def agregarMateria(Curso mat){
		cursos.add(mat)
	}
	
	def estaMateria(Materia mat){
		cursos.filter[materia.nombre.equals(mat.nombre)].size>0
	}
	
	def estaCompleta(){
		cursos.size()>0 && carrera != null && carrera != null 
      		&& añoIngreso != null && finalesAprobados != null 
      		&& finalesDesaprobados != null && cursadasAprobadas != null
      	 	&& mail != null
	}
	
	


}