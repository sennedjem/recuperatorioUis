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
import encuesta.applicationModel.EncuestaAppModel

@Controller
class EncuestaController {
	
	var RepoEncuestas repo = new RepoEncuestas
	
	extension JSONUtils = new JSONUtils 
		@Get('/carreras')
		def Result carreras(){
			response.contentType = ContentType.APPLICATION_JSON
			ok(repo.carreras.toJson)
		}
		
		@Get('/turnos')
		def Result turnos(){
			response.contentType = ContentType.APPLICATION_JSON
			ok(Turno.values.toJson)
		}	
		
		@Get("/responder/:mail")
		def Result responderSiElMailFueUtilizado(){
		val elMailYaFueUtilizado = repo.elMailYaEsta(mail)
		response.contentType = ContentType.APPLICATION_JSON
		ok(elMailYaFueUtilizado.toJson)
		}
		
		@Post('/mandarRespuesta')
		def Result responder(@Body String body){
			var Respuesta respuesta = body.fromJson(Respuesta)
			var Encuesta encuesta = respuesta.generarEncuesta(repo);
			repo.agregarRespuesta(encuesta)ok();
		}
	
		
		def static void main(String[]args){
			XTRest.start(EncuestaController,9800)
		}
}
