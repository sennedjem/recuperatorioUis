package encuesta.applicationModel

import encuesta.carrera.Carrera
import encuesta.carrera.Curso
import encuesta.encuesta.Encuesta
import encuesta.materia.Materia
import encuesta.materia.Turno
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.utils.Observable

@Observable
@Accessors
class EncuestaAppModel {
	
	Turno turnoSeleccionado
	Materia materiaSeleccionada
	Encuesta encuesta = new Encuesta()
	List<Encuesta> encuestas = new ArrayList
	
	
	def void validar() {
      if (encuesta.estaCompleta &&
      	 	(!elMailYaEsta())) {
      	 		encuestas.add(encuesta)
      	 		encuesta = new Encuesta()
      	 		ObservableUtils.firePropertyChanged(this,"descripcionMaterias")
      	 		ObservableUtils.firePropertyChanged(this,"materiasPosibles")
      	 		ObservableUtils.firePropertyChanged(this,"carrerasPosibles")
      	 		ObservableUtils.firePropertyChanged(this,"turnosPosibles")
      	 	}
      else {
      	if(!encuesta.estaCompleta)
      		throw new UserException("Faltan campos!")
      	else {
      		if(elMailYaEsta())
      		throw new UserException("El mail esta registrado")
      	}
      }
	  
}

	public def elMailYaEsta() {
		encuestas.filter[mail.equals(encuesta.mail)].size>0
	}
	
	public def elMailYaEsta(String mailP) {
		encuestas.filter[mail.equals(mailP)].size>0
	}
	
	def agregarMateriaSeleccionada(){
		if(encuesta.estaMateria(materiaSeleccionada)){throw new UserException("Ya ingresaste esa materia")}
		else{
			var cursoNuevo = new Curso(materiaSeleccionada, turnoSeleccionado) 
			encuesta.agregarMateria(cursoNuevo)
			ObservableUtils.firePropertyChanged(this,"descripcionMaterias")
			}
	}
	
	def List<Materia> getMateriasPosibles(){
		if(encuesta.carrera == null){
			new Carrera("Sistemas-K").materias	
		}
		else {
		encuesta.carrera.materias
		}
		
	}
	
	def void setCarrera(Carrera c){
		this.encuesta.carrera = c
		ObservableUtils.firePropertyChanged(this,"materiasPosibles")
	}
	
	def List<Carrera> getCarrerasPosibles(){
		new RepoEncuestas().carreras
	}
	
	
	def List<Turno> getTurnosPosibles(){
		Turno.values.toList
	}
	
	def List<String> getDescripcionMaterias(){
		encuesta.cursos.map['''«it.materia.nombre»(«it.turno.name»)'''].toList
	}
}