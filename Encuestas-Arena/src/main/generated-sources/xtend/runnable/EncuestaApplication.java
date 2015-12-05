package runnable;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import view.EncuestaWindow;

@SuppressWarnings("all")
public class EncuestaApplication extends Application {
  protected Window<?> createMainWindow() {
    return new EncuestaWindow(this);
  }
  
  public static void main(final String[] args) {
    EncuestaApplication _encuestaApplication = new EncuestaApplication();
    _encuestaApplication.start();
  }
}
