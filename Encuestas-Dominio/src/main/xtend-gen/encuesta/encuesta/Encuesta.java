package encuesta.encuesta;

import encuesta.carrera.Carrera;
import encuesta.carrera.Curso;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class Encuesta {
  private List<Curso> materias = new ArrayList<Curso>();
  
  private Carrera carrera;
  
  private String añoIngreso;
  
  private String finalesAprobados;
  
  private String finalesDesaprobados;
  
  private String cursadasAprobadas;
  
  public boolean agregarMateria(final Curso mat) {
    return this.materias.add(mat);
  }
  
  @Pure
  public List<Curso> getMaterias() {
    return this.materias;
  }
  
  public void setMaterias(final List<Curso> materias) {
    this.materias = materias;
  }
  
  @Pure
  public Carrera getCarrera() {
    return this.carrera;
  }
  
  public void setCarrera(final Carrera carrera) {
    this.carrera = carrera;
  }
  
  @Pure
  public String getAñoIngreso() {
    return this.añoIngreso;
  }
  
  public void setAñoIngreso(final String añoIngreso) {
    this.añoIngreso = añoIngreso;
  }
  
  @Pure
  public String getFinalesAprobados() {
    return this.finalesAprobados;
  }
  
  public void setFinalesAprobados(final String finalesAprobados) {
    this.finalesAprobados = finalesAprobados;
  }
  
  @Pure
  public String getFinalesDesaprobados() {
    return this.finalesDesaprobados;
  }
  
  public void setFinalesDesaprobados(final String finalesDesaprobados) {
    this.finalesDesaprobados = finalesDesaprobados;
  }
  
  @Pure
  public String getCursadasAprobadas() {
    return this.cursadasAprobadas;
  }
  
  public void setCursadasAprobadas(final String cursadasAprobadas) {
    this.cursadasAprobadas = cursadasAprobadas;
  }
}
