package view

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import encuesta.applicationModel.EncuestaAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.List
import encuesta.materia.Materia
import encuesta.materia.Turno
import encuesta.carrera.Carrera
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.bindings.PropertyAdapter

class EncuestaWindow extends SimpleWindow<EncuestaAppModel>{
	
	new(WindowOwner parent) {
		super(parent, new EncuestaAppModel)
	}
	
	override protected addActions(Panel actionsPanel) {
		
		new Button(actionsPanel) =>[ 
			caption="EnviarEncuesta"
			onClick[| new GraciasPorResponderWindow(this).open]]
		
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel).text = "Intención de cursada"
		this.crearInformacionParaPeso(mainPanel)
		this.crearInformacionParaCursadas(mainPanel)
	}
	
	def crearInformacionParaCursadas(Panel mainPanel) {
		val columnPanel = new Panel(mainPanel)
		columnPanel.layout=new ColumnLayout(2)
		
		val nuevaMateria = new Panel(columnPanel)
		nuevaMateria.layout = new VerticalLayout
		
		new Label(nuevaMateria).text="Materia que estas pensando cursar"
		new Selector<Materia>(nuevaMateria)=>[
					allowNull(false)
					bindValueToProperty("materiaSeleccionada")
					var propiedadModelos = bindItems(new ObservableProperty(modelObject, "materiasPosibles"))
					propiedadModelos.adapter = new PropertyAdapter(typeof(Materia), "nombre")
			]
		
		new Label(nuevaMateria).text="Turno"
		new Selector<Turno>(nuevaMateria)=>[
					allowNull(false)			
					bindItemsToProperty("turnosPosibles")
					bindValueToProperty("turnoSeleccionado")
					
			]
			
		new Button(nuevaMateria) =>[
				caption = "Agregar"
				onClick[ |
						modelObject.agregarMateriaSeleccionada()
				]
		]
		
		val materiasAgregadas = new Panel(columnPanel)
		materiasAgregadas.layout = new VerticalLayout
		
		new List<String>(materiasAgregadas) => [
					bindItemsToProperty("descripcionMaterias")
			]
	}
	
	def crearInformacionParaPeso(Panel panel) {
		new Label(panel).text="Elegí la carrera que estudias"
			
		new Selector<Carrera>(panel)=> [
					allowNull(false)
					bindValueToProperty("encuesta.carrera")
					var propiedadModelos = bindItems(new ObservableProperty(modelObject, "carrerasPosibles"))
					propiedadModelos.adapter = new PropertyAdapter(typeof(Carrera), "nombre")
			]	
			
		new Label(panel).text="Año en el que ingresaste a la facu:"
		new TextBox(panel).bindValueToProperty("encuesta.añoIngreso")
		
		new Label(panel).text="¿Cuantos finales aprobaste?"
		new TextBox(panel).bindValueToProperty("encuesta.finalesAprobados")
		
		new Label(panel).text="¿Cuantos finales desaprobados?"
		new TextBox(panel).bindValueToProperty("encuesta.finalesDesaprobados")
		
		new Label(panel).text="¿Cuantos cursadas aprobaste?"
		new TextBox(panel).bindValueToProperty("encuesta.cursadasAprobadas")
	}
	
}