package encuesta.applicationModel;

import com.google.common.base.Objects;
import encuesta.applicationModel.RepoEncuestas;
import encuesta.carrera.Carrera;
import encuesta.carrera.Curso;
import encuesta.encuesta.Encuesta;
import encuesta.materia.Materia;
import encuesta.materia.Turno;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class EncuestaAppModel {
  private Turno turnoSeleccionado;
  
  private Materia materiaSeleccionada;
  
  private Encuesta encuesta = new Encuesta();
  
  private List<Encuesta> encuestas = new ArrayList<Encuesta>();
  
  public void validar() {
    boolean _and = false;
    boolean _estaCompleta = this.encuesta.estaCompleta();
    if (!_estaCompleta) {
      _and = false;
    } else {
      boolean _elMailYaEsta = this.elMailYaEsta();
      boolean _not = (!_elMailYaEsta);
      _and = _not;
    }
    if (_and) {
      this.encuestas.add(this.encuesta);
      Encuesta _encuesta = new Encuesta();
      this.encuesta = _encuesta;
      ObservableUtils.firePropertyChanged(this, "descripcionMaterias");
      ObservableUtils.firePropertyChanged(this, "materiasPosibles");
      ObservableUtils.firePropertyChanged(this, "carrerasPosibles");
      ObservableUtils.firePropertyChanged(this, "turnosPosibles");
    } else {
      boolean _estaCompleta_1 = this.encuesta.estaCompleta();
      boolean _not_1 = (!_estaCompleta_1);
      if (_not_1) {
        throw new UserException("Faltan campos!");
      } else {
        boolean _elMailYaEsta_1 = this.elMailYaEsta();
        if (_elMailYaEsta_1) {
          throw new UserException("El mail esta registrado");
        }
      }
    }
  }
  
  public boolean elMailYaEsta() {
    final Function1<Encuesta, Boolean> _function = new Function1<Encuesta, Boolean>() {
      public Boolean apply(final Encuesta it) {
        String _mail = it.getMail();
        String _mail_1 = EncuestaAppModel.this.encuesta.getMail();
        return Boolean.valueOf(_mail.equals(_mail_1));
      }
    };
    Iterable<Encuesta> _filter = IterableExtensions.<Encuesta>filter(this.encuestas, _function);
    int _size = IterableExtensions.size(_filter);
    return (_size > 0);
  }
  
  public void agregarMateriaSeleccionada() {
    boolean _estaMateria = this.encuesta.estaMateria(this.materiaSeleccionada);
    if (_estaMateria) {
      throw new UserException("Ya ingresaste esa materia");
    } else {
      Curso cursoNuevo = new Curso(this.materiaSeleccionada, this.turnoSeleccionado);
      this.encuesta.agregarMateria(cursoNuevo);
      ObservableUtils.firePropertyChanged(this, "descripcionMaterias");
    }
  }
  
  public List<Materia> getMateriasPosibles() {
    List<Materia> _xifexpression = null;
    Carrera _carrera = this.encuesta.getCarrera();
    boolean _equals = Objects.equal(_carrera, null);
    if (_equals) {
      Carrera _carrera_1 = new Carrera("Sistemas-K");
      _xifexpression = _carrera_1.getMaterias();
    } else {
      Carrera _carrera_2 = this.encuesta.getCarrera();
      _xifexpression = _carrera_2.getMaterias();
    }
    return _xifexpression;
  }
  
  public void setCarrera(final Carrera c) {
    this.encuesta.setCarrera(c);
    ObservableUtils.firePropertyChanged(this, "materiasPosibles");
  }
  
  public List<Carrera> getCarrerasPosibles() {
    RepoEncuestas _repoEncuestas = new RepoEncuestas();
    return _repoEncuestas.getCarrerasPosibles();
  }
  
  public List<Turno> getTurnosPosibles() {
    Turno[] _values = Turno.values();
    return IterableExtensions.<Turno>toList(((Iterable<Turno>)Conversions.doWrapArray(_values)));
  }
  
  public List<String> getDescripcionMaterias() {
    List<Curso> _cursos = this.encuesta.getCursos();
    final Function1<Curso, String> _function = new Function1<Curso, String>() {
      public String apply(final Curso it) {
        StringConcatenation _builder = new StringConcatenation();
        Materia _materia = it.getMateria();
        String _nombre = _materia.getNombre();
        _builder.append(_nombre, "");
        _builder.append("(");
        Turno _turno = it.getTurno();
        String _name = _turno.name();
        _builder.append(_name, "");
        _builder.append(")");
        return _builder.toString();
      }
    };
    List<String> _map = ListExtensions.<Curso, String>map(_cursos, _function);
    return IterableExtensions.<String>toList(_map);
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
  
  @Pure
  public List<Encuesta> getEncuestas() {
    return this.encuestas;
  }
  
  public void setEncuestas(final List<Encuesta> encuestas) {
    this.encuestas = encuestas;
  }
}
