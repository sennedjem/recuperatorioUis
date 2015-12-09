package encuesta.carrera;

import encuesta.materia.Materia;
import encuesta.materia.Turno;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class Curso {
  private Materia materia;
  
  private Turno turno;
  
  public Curso() {
  }
  
  public Curso(final Materia mat, final Turno turn) {
    this.materia = mat;
    this.turno = turn;
  }
  
  @Pure
  public Materia getMateria() {
    return this.materia;
  }
  
  public void setMateria(final Materia materia) {
    this.materia = materia;
  }
  
  @Pure
  public Turno getTurno() {
    return this.turno;
  }
  
  public void setTurno(final Turno turno) {
    this.turno = turno;
  }
}
