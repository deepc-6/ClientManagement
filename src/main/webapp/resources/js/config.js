/**
 * The configuration for routes using angular ui-router
 */

clientManagementApp
	.config(function($urlRouterProvider, $stateProvider) {
		
		$urlRouterProvider.otherwise('/');
	  
		$stateProvider
			.state("home", {
				url: "/",
				templateUrl: 'resources/views/Home.html'
			})
			.state("clients", {
				url: "/ClientManagement",
				templateUrl: 'resources/views/ClientManagement.html',			
				controller: 'ClientManagementController'
			});
	  
	});