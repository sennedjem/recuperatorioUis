package encuesta.applicationModel;

import encuesta.carrera.Carrera;
import encuesta.encuesta.Encuesta;
import encuesta.materia.Materia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class RepoEncuestas {
  private List<Encuesta> encuestas = new ArrayList<Encuesta>();
  
  private List<Carrera> carreras = new ArrayList<Carrera>();
  
  public RepoEncuestas() {
    List<String> nombresDeCarreras = IterableExtensions.<String>toList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Sistemas-K", "Electronica-Q", "Industrial-Z")));
    ArrayList<Carrera> carrerasParaDevolver = new ArrayList<Carrera>();
    for (final String nombreMat : nombresDeCarreras) {
      {
        Carrera carrera = new Carrera(nombreMat);
        carrerasParaDevolver.add(carrera);
      }
    }
    Carrera carrera = new Carrera("Tpi");
    List<Materia> _materias = carrera.getMaterias();
    Materia _materia = new Materia("Interfaces De Usuario");
    _materias.add(_materia);
    carrerasParaDevolver.add(carrera);
    this.carreras = carrerasParaDevolver;
  }
  
  public boolean agregarRespuesta(final Encuesta encuesta) {
    return this.encuestas.add(encuesta);
  }
  
  public Carrera findCarrera(final String carreraNombre) {
    final Function1<Carrera, Boolean> _function = new Function1<Carrera, Boolean>() {
      public Boolean apply(final Carrera it) {
        String _nombre = it.getNombre();
        return Boolean.valueOf(_nombre.equals(carreraNombre));
      }
    };
    Iterable<Carrera> _filter = IterableExtensions.<Carrera>filter(this.carreras, _function);
    return ((Carrera[])Conversions.unwrapArray(_filter, Carrera.class))[0];
  }
  
  public boolean elMailYaEsta(final String mailP) {
    final Function1<Encuesta, Boolean> _function = new Function1<Encuesta, Boolean>() {
      public Boolean apply(final Encuesta it) {
        String _mail = it.getMail();
        return Boolean.valueOf(_mail.equals(mailP));
      }
    };
    Iterable<Encuesta> _filter = IterableExtensions.<Encuesta>filter(this.encuestas, _function);
    int _size = IterableExtensions.size(_filter);
    return (_size > 0);
  }
  
  @Pure
  public List<Encuesta> getEncuestas() {
    return this.encuestas;
  }
  
  public void setEncuestas(final List<Encuesta> encuestas) {
    this.encuestas = encuestas;
  }
  
  @Pure
  public List<Carrera> getCarreras() {
    return this.carreras;
  }
  
  public void setCarreras(final List<Carrera> carreras) {
    this.carreras = carreras;
  }
}
