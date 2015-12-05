package view;

import encuesta.applicationModel.EncuestaAppModel;
import encuesta.materia.Materia;
import encuesta.materia.Turno;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import view.GraciasPorResponderWindow;

@SuppressWarnings("all")
public class EncuestaWindow extends SimpleWindow<EncuestaAppModel> {
  public EncuestaWindow(final WindowOwner parent) {
    super(parent, new EncuestaAppModel());
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("EnviarEncuesta");
        final Action _function = new Action() {
          public void execute() {
            GraciasPorResponderWindow _graciasPorResponderWindow = new GraciasPorResponderWindow(EncuestaWindow.this);
            _graciasPorResponderWindow.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    _label.setText("Intencióndecursada");
    this.crearInformacionParaPeso(mainPanel);
    this.crearInformacionParaCursadas(mainPanel);
  }
  
  public List<String> crearInformacionParaCursadas(final Panel mainPanel) {
    List<String> _xblockexpression = null;
    {
      final Panel columnPanel = new Panel(mainPanel);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      columnPanel.setLayout(_columnLayout);
      final Panel nuevaMateria = new Panel(columnPanel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      nuevaMateria.setLayout(_verticalLayout);
      Label _label = new Label(nuevaMateria);
      _label.setText("Materia que estas pensando cursar");
      Selector<Materia> _selector = new Selector<Materia>(nuevaMateria);
      final Procedure1<Selector<Materia>> _function = new Procedure1<Selector<Materia>>() {
        public void apply(final Selector<Materia> it) {
          it.bindItemsToProperty("materiasPosibles");
          it.<Object, ControlBuilder>bindValueToProperty("materiaSeleccionada");
        }
      };
      ObjectExtensions.<Selector<Materia>>operator_doubleArrow(_selector, _function);
      Label _label_1 = new Label(nuevaMateria);
      _label_1.setText("Turno");
      Selector<Turno> _selector_1 = new Selector<Turno>(nuevaMateria);
      final Procedure1<Selector<Turno>> _function_1 = new Procedure1<Selector<Turno>>() {
        public void apply(final Selector<Turno> it) {
          it.bindItemsToProperty("turnosPosibles");
          it.<Object, ControlBuilder>bindValueToProperty("turnoSeleccionado");
        }
      };
      ObjectExtensions.<Selector<Turno>>operator_doubleArrow(_selector_1, _function_1);
      Button _button = new Button(nuevaMateria);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Agregar");
          final Action _function = new Action() {
            public void execute() {
              EncuestaAppModel _modelObject = EncuestaWindow.this.getModelObject();
              _modelObject.agregarMateriaSeleccionada();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
      final Panel materiasAgregadas = new Panel(columnPanel);
      VerticalLayout _verticalLayout_1 = new VerticalLayout();
      materiasAgregadas.setLayout(_verticalLayout_1);
      List<String> _list = new List<String>(materiasAgregadas);
      final Procedure1<List<String>> _function_3 = new Procedure1<List<String>>() {
        public void apply(final List<String> it) {
          it.bindItemsToProperty("descripcionMaterias");
        }
      };
      _xblockexpression = ObjectExtensions.<List<String>>operator_doubleArrow(_list, _function_3);
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> crearInformacionParaPeso(final Panel panel) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(panel);
      _label.setText("Elegí la carrera que estudias");
      Selector<String> _selector = new Selector<String>(panel);
      final Procedure1<Selector<String>> _function = new Procedure1<Selector<String>>() {
        public void apply(final Selector<String> it) {
          it.bindItemsToProperty("carrerasPosibles");
          it.<Object, ControlBuilder>bindValueToProperty("encuesta.carrera");
        }
      };
      ObjectExtensions.<Selector<String>>operator_doubleArrow(_selector, _function);
      Label _label_1 = new Label(panel);
      _label_1.setText("Año en el que ingresaste a la facu:");
      TextBox _textBox = new TextBox(panel);
      _textBox.<Object, ControlBuilder>bindValueToProperty("encuesta.añoIngreso");
      Label _label_2 = new Label(panel);
      _label_2.setText("¿Cuantos finales aprobaste?");
      TextBox _textBox_1 = new TextBox(panel);
      _textBox_1.<Object, ControlBuilder>bindValueToProperty("encuesta.finalesAprobados");
      Label _label_3 = new Label(panel);
      _label_3.setText("¿Cuantos finales desaprobados?");
      TextBox _textBox_2 = new TextBox(panel);
      _textBox_2.<Object, ControlBuilder>bindValueToProperty("encuesta.finalesDesaprobados");
      Label _label_4 = new Label(panel);
      _label_4.setText("¿Cuantos cursadas aprobaste?");
      TextBox _textBox_3 = new TextBox(panel);
      _xblockexpression = _textBox_3.<Object, ControlBuilder>bindValueToProperty("encuesta.cursadasAprobadas");
    }
    return _xblockexpression;
  }
}
