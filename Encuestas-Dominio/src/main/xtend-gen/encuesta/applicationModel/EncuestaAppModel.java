package encuesta.applicationModel;

import encuesta.carrera.Carrera;
import encuesta.carrera.Curso;
import encuesta.encuesta.Encuesta;
import encuesta.materia.Materia;
import encuesta.materia.Turno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class EncuestaAppModel {
  private Turno turnoSeleccionado;
  
  private Materia materiaSeleccionada;
  
  private Encuesta encuesta = new Encuesta();
  
  public boolean agregarMateriaSeleccionada() {
    boolean _xblockexpression = false;
    {
      Curso cursoNuevo = new Curso(this.materiaSeleccionada, this.turnoSeleccionado);
      _xblockexpression = this.encuesta.agregarMateria(cursoNuevo);
    }
    return _xblockexpression;
  }
  
  public List<Materia> getMateriasPosibles() {
    Carrera _carrera = this.encuesta.getCarrera();
    return _carrera.getMaterias();
  }
  
  public List<Carrera> getCarrerasPosibles() {
    ArrayList<Carrera> _xblockexpression = null;
    {
      List<String> nombresDeCarreras = IterableExtensions.<String>toList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Sistemas-K", "Electronica-Q", "Industrial-Z")));
      ArrayList<Carrera> carrerasParaDevolver = new ArrayList<Carrera>();
      for (final String nombreMat : nombresDeCarreras) {
        {
          Carrera carrera = new Carrera(nombreMat);
          carrerasParaDevolver.add(carrera);
        }
      }
      _xblockexpression = carrerasParaDevolver;
    }
    return _xblockexpression;
  }
  
  public List<Turno> getTurnosPosibles() {
    Turno[] _values = Turno.values();
    return IterableExtensions.<Turno>toList(((Iterable<Turno>)Conversions.doWrapArray(_values)));
  }
  
  @Pure
  public Turno getTurnoSeleccionado() {
    return this.turnoSeleccionado;
  }
  
  public void setTurnoSeleccionado(final Turno turnoSeleccionado) {
    this.turnoSeleccionado = turnoSeleccionado;
  }
  
  @Pure
  public Materia getMateriaSeleccionada() {
    return this.materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this.materiaSeleccionada = materiaSeleccionada;
  }
  
  @Pure
  public Encuesta getEncuesta() {
    return this.encuesta;
  }
  
  public void setEncuesta(final Encuesta encuesta) {
    this.encuesta = encuesta;
  }
}
