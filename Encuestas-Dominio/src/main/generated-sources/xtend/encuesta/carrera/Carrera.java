package encuesta.carrera;

import encuesta.carrera.CarreraDeCyt;
import encuesta.materia.Materia;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Carrera extends CarreraDeCyt {
  public Carrera(final String string) {
    super(string);
  }
  
  public boolean tieneEnPlanDeEstudio(final Materia mat) {
    List<Materia> _materias = this.getMaterias();
    final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
      public Boolean apply(final Materia it) {
        String _nombre = it.getNombre();
        String _nombre_1 = mat.getNombre();
        return Boolean.valueOf(_nombre.equals(_nombre_1));
      }
    };
    Iterable<Materia> _filter = IterableExtensions.<Materia>filter(_materias, _function);
    int _size = IterableExtensions.size(_filter);
    return (_size > 0);
  }
}
