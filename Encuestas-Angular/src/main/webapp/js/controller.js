var app=angular.module('encuestaApp',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider.when('/', { templateUrl : 'pages/login.html', controller: 'LoginCtrl'})
		.when('/responder/:mail', {templateUrl : 'pages/responder.html',controller :
	'ResponderCtrl'})
		.when('/gracias', {templateUrl : 'pages/gracias.html'})
		.otherwise({redirectTo: '/'});
});

app.service('EncuestaService',function($http){
	return{
		verificarMail:function(mail,callback){
			$http.get('/responder/'+mail).success(callback);
		},
		responderEncuesta:function(respuesta,callback){
			$http({
			method:'POST',
			url:'/mandarRespuesta',
			data: respuesta}).then(function successCallback(){callback()},function(){})
		},
		getCarreras:function(callback){
			$http.get('/carreras').success(callback);
		},
		getTurnos:function(callback){
			$http.get('/turnos').success(callback);
		}
	}
});

app.controller('LoginCtrl',function($scope,$location,EncuestaService){

	$scope.mail=""
	$scope.autenticar=function(){

	EncuestaService.verificarMail($scope.mail,function(elMailEsta){
		if(elMailEsta){alert("Ya utilizaste el mail")}
		else{$location.path('/responder/'+$scope.mail);}})
	}

});

app.controller('ResponderCtrl',function($scope,$location,$routeParams,EncuestaService){

	EncuestaService.getTurnos(function(data){
	$scope.turnos=data;
});

EncuestaService.getCarreras(function(data){
	$scope.carreras=data;
});

$scope.respuesta={mail:$routeParams.mail,materias:[]};
	contains = function(listElement,element) {
	    
	    for (var i = 0; i < listElement.length; i++) {
		if (listElement[i].nombre == element.nombre) {
		    return true;
		}
	    }
	    return false;
	}

	$scope.agregarMateria=function(){

		
		if(!$scope.materiaSeleccionada){
			alert('No seleccionaste ninguna materia');
			return;
		}
		if(!$scope.turnoSeleccionado){
			alert('No seleccionaste ningun turno');
			return;
		}
		if(contains($scope.respuesta.materias,$scope.materiaSeleccionada)){
			alert('Ya ingresaste esa materia');
			return;
		}
		else {
		$scope.respuesta.materias.push({materia:$scope.materiaSeleccionada,turno:$scope.turnoSeleccionado});
		$scope.materiaSeleccionada=null;
		$scope.turnoSeleccionado=null;
		}
	}
	
	
	$scope.contestar=function(){
		//Checkeamos los campos obligatorios
		if($scope.respuesta.materias.length<=0){
			alert('Debe ingresar materias para continuar');
			return;
		}
		if(!$scope.carreraSeleccionada){
			alert('Debe seleccionar una carrera');
			return;
		}
		if(!$scope.respuesta.anioIngreso){
			alert('Debe indicar el año de ingreso a la facultad');
			return;
		}
		if(!$scope.respuesta.finalesAprobados){
			alert('Debe indicar la cantidad de finalesAprobados');
			return;
		}
		if(!$scope.respuesta.finalesDesaprobados){
			alert('Debe indicar la cantidad de finalesDesaprobados');
			return;
		}
		if(!$scope.respuesta.cursadasAprobadas){
			alert('Debe indicar la cantidad de cursadasAprobadas');
			return;
		}
		//TodoOK,impactamosenelserver
		$scope.respuesta.carreraNombre=$scope.carreraSeleccionada.nombre;
		EncuestaService.responderEncuesta($scope.respuesta,function(){
		$location.path('gracias');
		
		});
	
	}
});
