package encuesta.carrera

import java.util.List
import encuesta.materia.Materia
import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import org.eclipse.xtend.lib.annotations.Accessors

@Observable
@Accessors
class CarreraDeCyt {
	
	var List<Materia> materias = new ArrayList()
	var String nombre
	
	new(String nom){
		var lista = #["Discreta","Algebra","Ingenieria y Sociedad","Matematica Superior",
		"Paradigmas de Programacion","Algoritmos","Sintaxis","Resistencias de Materiales"].toList
		for(String ls: lista){
			var materia= new Materia(ls)
			materias.add(materia)
		}
		nombre = nom
	}
	
	
}