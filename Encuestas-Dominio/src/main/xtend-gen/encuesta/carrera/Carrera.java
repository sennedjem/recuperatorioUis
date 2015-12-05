package encuesta.carrera;

import encuesta.carrera.CarreraDeCyt;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.uqbar.commons.utils.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Carrera extends CarreraDeCyt {
  public Carrera(final String string) {
    super(string);
  }
}
