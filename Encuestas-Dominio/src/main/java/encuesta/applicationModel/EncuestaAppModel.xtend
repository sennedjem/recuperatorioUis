package encuesta.applicationModel


import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable
import encuesta.materia.Turno
import encuesta.materia.Materia
import encuesta.encuesta.Encuesta
import encuesta.carrera.Curso
import java.util.List
import encuesta.carrera.Carrera
import java.util.ArrayList

@Observable
@Accessors
class EncuestaAppModel {
	
	Turno turnoSeleccionado
	Materia materiaSeleccionada
	Encuesta encuesta = new Encuesta()
	
	
	def agregarMateriaSeleccionada(){
		var cursoNuevo = new Curso(materiaSeleccionada, turnoSeleccionado) 
		encuesta.agregarMateria(cursoNuevo)
	}
	
	def List<Materia> getMateriasPosibles(){
		encuesta.carrera.materias
	}
	
	def List<Carrera> getCarrerasPosibles(){
		var nombresDeCarreras = #["Sistemas-K","Electronica-Q","Industrial-Z"].toList
		var carrerasParaDevolver = new ArrayList()
		for(String nombreMat: nombresDeCarreras){
			var carrera= new Carrera(nombreMat)
			carrerasParaDevolver.add(carrera)
		}
		carrerasParaDevolver
	}
	
	def List<Turno> getTurnosPosibles(){
		Turno.values.toList
	}
}