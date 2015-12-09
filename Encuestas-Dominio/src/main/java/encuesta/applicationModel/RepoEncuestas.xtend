package encuesta.applicationModel

import java.util.List
import encuesta.carrera.Carrera
import java.util.ArrayList
import encuesta.materia.Materia
import encuesta.encuesta.Encuesta
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Observable
@Accessors
class RepoEncuestas {
	
	List<Encuesta> encuestas = new ArrayList
	List<Carrera> carreras = new ArrayList
	
	new(){
		var nombresDeCarreras = #["Sistemas-K","Electronica-Q","Industrial-Z"].toList
		var carrerasParaDevolver = new ArrayList()
		for(String nombreMat: nombresDeCarreras){
			var carrera= new Carrera(nombreMat)
			carrerasParaDevolver.add(carrera)
		}
		var carrera = new Carrera("Tpi")
		carrera.materias.add(new Materia("Interfaces De Usuario"))
		carrerasParaDevolver.add(carrera)
		carreras = carrerasParaDevolver
	}
	

	
	def agregarRespuesta(Encuesta encuesta) {
		encuestas.add(encuesta)
	}
	
	def findCarrera(String carreraNombre) {
		this.carreras.filter[nombre.equals(carreraNombre)].get(0)
	}
	
	public def elMailYaEsta(String mailP) {
		encuestas.filter[mail.equals(mailP)].size>0
	}
	

	
}