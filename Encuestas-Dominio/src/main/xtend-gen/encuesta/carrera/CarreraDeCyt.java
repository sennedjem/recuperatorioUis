package encuesta.carrera;

import encuesta.materia.Materia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class CarreraDeCyt {
  private List<Materia> materias = new ArrayList<Materia>();
  
  private String nombre;
  
  public CarreraDeCyt(final String nom) {
    List<String> lista = IterableExtensions.<String>toList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("Discreta", "Algebra", "IngenieriaySociedad", "MatematicaSuperior", "ParadigmasdeProgramacion", "Algoritmos", "Sintaxis", "ResistenciasdeMateriales")));
    for (final String ls : lista) {
      {
        Materia materia = new Materia(ls);
        this.materias.add(materia);
      }
    }
    this.nombre = nom;
  }
  
  @Pure
  public List<Materia> getMaterias() {
    return this.materias;
  }
  
  public void setMaterias(final List<Materia> materias) {
    this.materias = materias;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
}
