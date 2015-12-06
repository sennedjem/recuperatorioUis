package encuesta.controller;

import encuesta.encuesta.Encuesta;
import encuesta.materia.Materia;
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
  
  private List<Materia> materias = new ArrayList<Materia>();
  
  public Encuesta generarEncuesta() {
    return new Encuesta();
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
  public List<Materia> getMaterias() {
    return this.materias;
  }
  
  public void setMaterias(final List<Materia> materias) {
    this.materias = materias;
  }
}
