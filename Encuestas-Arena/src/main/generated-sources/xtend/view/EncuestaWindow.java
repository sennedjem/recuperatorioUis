package view;

import encuesta.applicationModel.EncuestaAppModel;
import encuesta.carrera.Carrera;
import encuesta.materia.Materia;
import encuesta.materia.Turno;
import org.apache.commons.lang.StringUtils;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

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
            EncuestaAppModel _modelObject = EncuestaWindow.this.getModelObject();
            _modelObject.validar();
            EncuestaWindow.this.showInfo("Gracias por responder!");
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    _label.setText("Intención de cursada");
    this.crearInformacionParaPeso(mainPanel);
    this.crearInformacionParaCursadas(mainPanel);
  }
  
  public List<Materia> crearInformacionParaCursadas(final Panel mainPanel) {
    List<Materia> _xblockexpression = null;
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
          it.allowNull(false);
          it.<Object, ControlBuilder>bindValueToProperty("materiaSeleccionada");
          EncuestaAppModel _modelObject = EncuestaWindow.this.getModelObject();
          ObservableProperty<Object> _observableProperty = new ObservableProperty<Object>(_modelObject, "materiasPosibles");
          Binding<Object, Selector<Materia>, ListBuilder<Materia>> propiedadModelos = it.<Object>bindItems(_observableProperty);
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Materia.class, "nombre");
          propiedadModelos.setAdapter(_propertyAdapter);
        }
      };
      ObjectExtensions.<Selector<Materia>>operator_doubleArrow(_selector, _function);
      Label _label_1 = new Label(nuevaMateria);
      _label_1.setText("Turno");
      Selector<Turno> _selector_1 = new Selector<Turno>(nuevaMateria);
      final Procedure1<Selector<Turno>> _function_1 = new Procedure1<Selector<Turno>>() {
        public void apply(final Selector<Turno> it) {
          it.allowNull(false);
          it.<Object, ControlBuilder>bindValueToProperty("turnoSeleccionado");
          EncuestaAppModel _modelObject = EncuestaWindow.this.getModelObject();
          ObservableProperty<Object> _observableProperty = new ObservableProperty<Object>(_modelObject, "turnosPosibles");
          it.<Object>bindItems(_observableProperty);
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
      List<Materia> _list = new List<Materia>(materiasAgregadas);
      final Procedure1<List<Materia>> _function_3 = new Procedure1<List<Materia>>() {
        public void apply(final List<Materia> it) {
          EncuestaAppModel _modelObject = EncuestaWindow.this.getModelObject();
          ObservableProperty<Object> _observableProperty = new ObservableProperty<Object>(_modelObject, "descripcionMaterias");
          it.<Object>bindItems(_observableProperty);
          it.setWidth(200);
          it.setHeight(100);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Materia>>operator_doubleArrow(_list, _function_3);
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> crearInformacionParaPeso(final Panel panel) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(panel);
      _label.setText("Elegí la carrera que estudias");
      Selector<Carrera> _selector = new Selector<Carrera>(panel);
      final Procedure1<Selector<Carrera>> _function = new Procedure1<Selector<Carrera>>() {
        public void apply(final Selector<Carrera> it) {
          it.allowNull(false);
          it.<Object, ControlBuilder>bindValueToProperty("carrera");
          EncuestaAppModel _modelObject = EncuestaWindow.this.getModelObject();
          ObservableProperty<Object> _observableProperty = new ObservableProperty<Object>(_modelObject, "carrerasPosibles");
          Binding<Object, Selector<Carrera>, ListBuilder<Carrera>> propiedadModelos = it.<Object>bindItems(_observableProperty);
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Carrera.class, "nombre");
          propiedadModelos.setAdapter(_propertyAdapter);
        }
      };
      ObjectExtensions.<Selector<Carrera>>operator_doubleArrow(_selector, _function);
      Label _label_1 = new Label(panel);
      _label_1.setText("Año en el que ingresaste a la facu:");
      this.crearTextBoxSoloParaNumeros("encuesta.añoIngreso", panel);
      Label _label_2 = new Label(panel);
      _label_2.setText("¿Cuantos finales aprobaste?");
      this.crearTextBoxSoloParaNumeros("encuesta.finalesAprobados", panel);
      Label _label_3 = new Label(panel);
      _label_3.setText("¿Cuantos finales desaprobados?");
      this.crearTextBoxSoloParaNumeros("encuesta.finalesDesaprobados", panel);
      Label _label_4 = new Label(panel);
      _label_4.setText("¿Cuantos cursadas aprobaste?");
      this.crearTextBoxSoloParaNumeros("encuesta.cursadasAprobadas", panel);
      Label _label_5 = new Label(panel);
      _label_5.setText("¿Cual es tu mail?");
      TextBox _textBox = new TextBox(panel);
      _xblockexpression = _textBox.<Object, ControlBuilder>bindValueToProperty("encuesta.mail");
    }
    return _xblockexpression;
  }
  
  public void crearTextBoxSoloParaNumeros(final String propertyASetear, final Panel container) {
    TextBox _textBox = new TextBox(container);
    TextBox _withFilter = _textBox.withFilter(new TextFilter() {
      public boolean accept(final TextInputEvent event) {
        String _potentialTextResult = event.getPotentialTextResult();
        return StringUtils.isNumeric(_potentialTextResult);
      }
    });
    _withFilter.<Object, ControlBuilder>bindValueToProperty(propertyASetear);
  }
}
