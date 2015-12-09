package encuesta.controller;

import encuesta.applicationModel.RepoEncuestas;
import encuesta.carrera.Carrera;
import encuesta.carrera.Curso;
import encuesta.encuesta.Encuesta;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class Respuesta {
  private String carreraNombre;
  
  private String mail;
  
  private List<Curso> materias = new ArrayList<Curso>();
  
  private Integer anioIngreso;
  
  private Integer finalesAprobados;
  
  private Integer finalesDesaprobados;
  
  private Integer cursadasAprobadas;
  
  public Encuesta generarEncuesta(final RepoEncuestas repo) {
    Encuesta _xblockexpression = null;
    {
      Encuesta encuesta = new Encuesta();
      encuesta.setCursos(this.materias);
      Carrera _findCarrera = repo.findCarrera(this.carreraNombre);
      encuesta.setCarrera(_findCarrera);
      encuesta.setMail(this.mail);
      encuesta.setAñoIngreso(this.anioIngreso);
      encuesta.setFinalesAprobados(this.finalesAprobados);
      encuesta.setFinalesDesaprobados(this.finalesDesaprobados);
      encuesta.setCursadasAprobadas(this.cursadasAprobadas);
      _xblockexpression = encuesta;
    }
    return _xblockexpression;
  }
  
  @Pure
  public String getCarreraNombre() {
    return this.carreraNombre;
  }
  
  public void setCarreraNombre(final String carreraNombre) {
    this.carreraNombre = carreraNombre;
  }
  
  @Pure
  public String getMail() {
    return this.mail;
  }
  
  public void setMail(final String mail) {
    this.mail = mail;
  }
  
  @Pure
  public List<Curso> getMaterias() {
    return this.materias;
  }
  
  public void setMaterias(final List<Curso> materias) {
    this.materias = materias;
  }
  
  @Pure
  public Integer getAnioIngreso() {
    return this.anioIngreso;
  }
  
  public void setAnioIngreso(final Integer anioIngreso) {
    this.anioIngreso = anioIngreso;
  }
  
  @Pure
  public Integer getFinalesAprobados() {
    return this.finalesAprobados;
  }
  
  public void setFinalesAprobados(final Integer finalesAprobados) {
    this.finalesAprobados = finalesAprobados;
  }
  
  @Pure
  public Integer getFinalesDesaprobados() {
    return this.finalesDesaprobados;
  }
  
  public void setFinalesDesaprobados(final Integer finalesDesaprobados) {
    this.finalesDesaprobados = finalesDesaprobados;
  }
  
  @Pure
  public Integer getCursadasAprobadas() {
    return this.cursadasAprobadas;
  }
  
  public void setCursadasAprobadas(final Integer cursadasAprobadas) {
    this.cursadasAprobadas = cursadasAprobadas;
  }
}
