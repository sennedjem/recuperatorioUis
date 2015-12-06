package encuesta.controller;

import encuesta.applicationModel.RepoEncuestas;
import encuesta.carrera.Carrera;
import encuesta.controller.Respuesta;
import encuesta.encuesta.Encuesta;
import encuesta.materia.Materia;
import encuesta.materia.Turno;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.UserException;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.XTRest;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.http.ContentType;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;

@Controller
@SuppressWarnings("all")
public class EncuestaController extends ResultFactory {
  private RepoEncuestas repo = new RepoEncuestas();
  
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  @Get("/carreras")
  public Result carreras(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      List<Carrera> _carrerasPosibles = this.repo.getCarrerasPosibles();
      String _json = this._jSONUtils.toJson(_carrerasPosibles);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Get("/turnos")
  public Result turnos(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Turno[] _values = Turno.values();
      String _json = this._jSONUtils.toJson(_values);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Post("/responder")
  public Result responder(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      Respuesta respuesta = this._jSONUtils.<Respuesta>fromJson(body, Respuesta.class);
      String _carreraNombre = respuesta.getCarreraNombre();
      final Carrera carrera = this.findCarrera(_carreraNombre);
      List<Materia> _materias = respuesta.getMaterias();
      final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
        public Boolean apply(final Materia materia) {
          return Boolean.valueOf(carrera.tieneEnPlanDeEstudio(materia));
        }
      };
      boolean _forall = IterableExtensions.<Materia>forall(_materias, _function);
      boolean _not = (!_forall);
      if (_not) {
        throw new UserException("No puede mezclar materias de distintas carreras");
      }
      Encuesta encuesta = respuesta.generarEncuesta();
      String _mail = respuesta.getMail();
      this.repo.agregarRespuesta(_mail, encuesta);
      _xblockexpression = ResultFactory.ok();
    }
    return _xblockexpression;
  }
  
  public Carrera findCarrera(final String nombreCarrera) {
    Carrera _xblockexpression = null;
    {
      List<Carrera> _carrerasPosibles = this.repo.getCarrerasPosibles();
      final Function1<Carrera, Boolean> _function = new Function1<Carrera, Boolean>() {
        public Boolean apply(final Carrera it) {
          String _nombre = it.getNombre();
          return Boolean.valueOf(_nombre.equals(nombreCarrera));
        }
      };
      Iterable<Carrera> _filter = IterableExtensions.<Carrera>filter(_carrerasPosibles, _function);
      Carrera carrera = ((Carrera[])Conversions.unwrapArray(_filter, Carrera.class))[0];
      _xblockexpression = carrera;
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    XTRest.start(EncuestaController.class, 9000);
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/carreras").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = carreras(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/turnos").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = turnos(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/responder").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = responder(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    this.pageNotFound(baseRequest, request, response);
  }
  
  public void pageNotFound(final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    response.getWriter().write(
    	"<html><head><title>XtRest - Page Not Found!</title></head>" 
    	+ "<body>"
    	+ "	<h1>Page Not Found !</h1>"
    	+ "	Supported resources:"
    	+ "	<table>"
    	+ "		<thead><tr><th>Verb</th><th>URL</th><th>Parameters</th></tr></thead>"
    	+ "		<tbody>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/carreras</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/turnos</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/responder</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "		</tbody>"
    	+ "	</table>"
    	+ "</body>"
    );
    response.setStatus(404);
    baseRequest.setHandled(true);
  }
}
