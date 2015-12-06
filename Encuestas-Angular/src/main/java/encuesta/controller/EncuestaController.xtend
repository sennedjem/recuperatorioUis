package encuesta.controller

import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import java.util.List
import org.uqbar.xtrest.api.annotation.Controller
import encuesta.applicationModel.RepoEncuestas
import encuesta.materia.Turno
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Post
import encuesta.carrera.Carrera
import org.uqbar.commons.model.UserException
import encuesta.encuesta.Encuesta

@Controller
class EncuestaController {
	
	var RepoEncuestas repo = new RepoEncuestas
	
	extension JSONUtils = new JSONUtils 
		@Get('/carreras')
		def Result carreras(){
			response.contentType = ContentType.APPLICATION_JSON
			ok(repo.carrerasPosibles.toJson)
		}
		
		@Get('/turnos')
		def Result turnos(){
			response.contentType = ContentType.APPLICATION_JSON
			ok(Turno.values.toJson)
		}	
		
		@Post('/responder')
		def Result responder(@Body String body){
			var Respuesta respuesta = body.fromJson(Respuesta)
			val Carrera carrera = findCarrera(respuesta.carreraNombre)
			if (! respuesta.materias.forall[materia | carrera.tieneEnPlanDeEstudio(materia)] ){
				throw new UserException("No puede mezclar materias de distintas carreras")
			}
			var Encuesta encuesta = respuesta.generarEncuesta();
			repo.agregarRespuesta(respuesta.mail,encuesta)ok();
		}
	
		def Carrera findCarrera(String nombreCarrera) {
			var Carrera carrera = repo.carrerasPosibles.filter[nombre.equals(nombreCarrera)].get(0)
			carrera
		}
		
		def static void main(String[]args){
			XTRest.start(EncuestaController,9000)
		}
}
