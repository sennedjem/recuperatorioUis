package encuesta.applicationModel

import java.util.List
import encuesta.carrera.Carrera
import java.util.ArrayList
import encuesta.materia.Materia
import encuesta.encuesta.Encuesta

class RepoEncuestas {
	def List<Carrera> getCarrerasPosibles(){
		var nombresDeCarreras = #["Sistemas-K","Electronica-Q","Industrial-Z"].toList
		var carrerasParaDevolver = new ArrayList()
		for(String nombreMat: nombresDeCarreras){
			var carrera= new Carrera(nombreMat)
			carrerasParaDevolver.add(carrera)
		}
		var carrera = new Carrera("Tpi")
		carrera.materias.add(new Materia("Interfaces De Usuario"))
		carrerasParaDevolver.add(carrera)
		carrerasParaDevolver
	}
	
	def agregarRespuesta(String string, Encuesta encuesta) {
		
	}
	

	
}