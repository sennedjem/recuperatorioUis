package encuesta.carrera

import encuesta.carrera.CarreraDeCyt
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.utils.Observable

@Accessors
@Observable
class Carrera extends CarreraDeCyt{
	
	new(String string) {
		super(string)
	}
	
}