package runnable

import org.uqbar.arena.Application
import view.EncuestaWindow

class EncuestaApplication extends Application{
	override protected createMainWindow() {
		new EncuestaWindow(this)
	}
	
	def static void main(String[] args){ 
		new EncuestaApplication().start()
	}
}