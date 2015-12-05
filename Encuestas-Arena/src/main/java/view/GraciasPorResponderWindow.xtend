package view

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.windows.WindowOwner
import encuesta.applicationModel.EncuestaAppModel

class GraciasPorResponderWindow extends SimpleWindow<EncuestaAppModel>{
	
	new(WindowOwner parent) {
		super(parent, new EncuestaAppModel)
	}
	
	override protected addActions(Panel actionsPanel) {
		//nada 
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel).text="Graciasporresponder!"
	}
	
}