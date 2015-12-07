package encuesta.encuesta;

import com.google.common.base.Objects;
import encuesta.carrera.Carrera;
import encuesta.carrera.Curso;
import encuesta.materia.Materia;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class Encuesta {
  private List<Curso> cursos = new ArrayList<Curso>();
  
  private Carrera carrera;
  
  private Integer añoIngreso;
  
  private Integer finalesAprobados;
  
  private Integer finalesDesaprobados;
  
  private Integer cursadasAprobadas;
  
  private String mail;
  
  public boolean agregarMateria(final Curso mat) {
    return this.cursos.add(mat);
  }
  
  public boolean estaMateria(final Materia mat) {
    final Function1<Curso, Boolean> _function = new Function1<Curso, Boolean>() {
      public Boolean apply(final Curso it) {
        Materia _materia = it.getMateria();
        String _nombre = _materia.getNombre();
        String _nombre_1 = mat.getNombre();
        return Boolean.valueOf(_nombre.equals(_nombre_1));
      }
    };
    Iterable<Curso> _filter = IterableExtensions.<Curso>filter(this.cursos, _function);
    int _size = IterableExtensions.size(_filter);
    return (_size > 0);
  }
  
  public boolean estaCompleta() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _and_3 = false;
    boolean _and_4 = false;
    boolean _and_5 = false;
    boolean _and_6 = false;
    int _size = this.cursos.size();
    boolean _greaterThan = (_size > 0);
    if (!_greaterThan) {
      _and_6 = false;
    } else {
      boolean _notEquals = (!Objects.equal(this.carrera, null));
      _and_6 = _notEquals;
    }
    if (!_and_6) {
      _and_5 = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.carrera, null));
      _and_5 = _notEquals_1;
    }
    if (!_and_5) {
      _and_4 = false;
    } else {
      boolean _notEquals_2 = (!Objects.equal(this.añoIngreso, null));
      _and_4 = _notEquals_2;
    }
    if (!_and_4) {
      _and_3 = false;
    } else {
      boolean _notEquals_3 = (!Objects.equal(this.finalesAprobados, null));
      _and_3 = _notEquals_3;
    }
    if (!_and_3) {
      _and_2 = false;
    } else {
      boolean _notEquals_4 = (!Objects.equal(this.finalesDesaprobados, null));
      _and_2 = _notEquals_4;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _notEquals_5 = (!Objects.equal(this.cursadasAprobadas, null));
      _and_1 = _notEquals_5;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _notEquals_6 = (!Objects.equal(this.mail, null));
      _and = _notEquals_6;
    }
    return _and;
  }
  
  @Pure
  public List<Curso> getCursos() {
    return this.cursos;
  }
  
  public void setCursos(final List<Curso> cursos) {
    this.cursos = cursos;
  }
  
  @Pure
  public Carrera getCarrera() {
    return this.carrera;
  }
  
  public void setCarrera(final Carrera carrera) {
    this.carrera = carrera;
  }
  
  @Pure
  public Integer getAñoIngreso() {
    return this.añoIngreso;
  }
  
  public void setAñoIngreso(final Integer añoIngreso) {
    this.añoIngreso = añoIngreso;
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
  
  @Pure
  public String getMail() {
    return this.mail;
  }
  
  public void setMail(final String mail) {
    this.mail = mail;
  }
}
