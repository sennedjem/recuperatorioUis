package encuesta.applicationModel;

import encuesta.carrera.Carrera;
import encuesta.encuesta.Encuesta;
import encuesta.materia.Materia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RepoEncuestas {
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
      Carrera carrera = new Carrera("Tpi");
      List<Materia> _materias = carrera.getMaterias();
      Materia _materia = new Materia("Interfaces De Usuario");
      _materias.add(_materia);
      carrerasParaDevolver.add(carrera);
      _xblockexpression = carrerasParaDevolver;
    }
    return _xblockexpression;
  }
  
  public Object agregarRespuesta(final String string, final Encuesta encuesta) {
    return null;
  }
}
