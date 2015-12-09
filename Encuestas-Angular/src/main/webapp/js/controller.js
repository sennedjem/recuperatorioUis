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
		responderEncuesta:function(respuesta,callback){
			$http.get('/responder/'+respuesta).success(callback);
		},
		getCarreras:function(aEjecutar){
			$http.get('/carreras').success(aEjecutar);
		},
		getTurnos:function(aEjecutar){
			$http.get('/turnos').success(aEjecutar);
		}
	}
});

app.controller('LoginCtrl',function($scope,$location,EncuestaService){

	$scope.mail=""
	$scope.autenticar=function(){

	EncuestaService.responderEncuesta($scope.mail,function(elMailEsta){
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


	$scope.agregarMateria=function(){

		if(!$scope.materiaSeleccionada | !$scope.turnoSeleccionado){
		alert('Te falto elegir materia o turno');
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
			alert('Debe indicar la cantidad de finalesDesaprobados');
			return;
		}
		//TodoOK,impactamosenelserver
		$scope.respuesta.carreraId=$scope.carreraSeleccionada.id;
		EncuestaService.responderEncuesta($scope.respuesta,function(data){
		$location.path('gracias');
		});
	}
});
