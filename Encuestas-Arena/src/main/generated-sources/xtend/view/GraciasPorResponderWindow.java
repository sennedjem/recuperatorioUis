package view;

import encuesta.applicationModel.EncuestaAppModel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class GraciasPorResponderWindow extends Dialog<EncuestaAppModel> {
  public GraciasPorResponderWindow(final WindowOwner parent) {
    super(parent, new EncuestaAppModel());
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    _label.setText("Gracias por responder!");
  }
}
