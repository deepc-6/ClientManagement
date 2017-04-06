/**
 * The AngularJS controller for the clients view
 */
clientManagementApp
	.controller('ClientManagementController', function($scope, $http) {
		/**
		 * Hide all alerts
		 */
	    $scope.nameEmpty = false;
	    $scope.addSuccess = false;
	    $scope.saveSuccess = false;
	    $scope.deleteSuccess = false;
	    
	    /**
	     * Initialize search variable
	     */
	    $scope.searchText = '';
	    
	    /**
		 * Make a get request to the service to get data from client database
		 * and store in $scope.clients
		 */		
		$http.get("/Clients/user/")
	    .then(function(response) {
	    	$scope.clients = response.data;
	    });
		
		/**
		 * @function searchFilter [ This function is called when the add
		 *           client button is clicked. It adds a new client to the
		 *           database ]
		 */
		$scope.searchFilter = function (item) {
	        var re = new RegExp($scope.searchText, 'i');
	        return !$scope.searchText || re.test(item.businessName) || re.test(item.interlocuter) || re.test(item.address) || 
	        		re.test(item.zipCode) || re.test(item.city) || re.test(item.phone) || re.test(item.email) || re.test(item.comment);
	    };
	
		/**
		 * @function addClientDetails [ This function is called when the add
		 *           client button is clicked. It adds a new client to the
		 *           database ]
		 */
	    $scope.addClientDetails = function () {	 
	    	/**
			 * Check if business name is not empty
			 */
	        if (typeof $scope.businessName == 'undefined' || $scope.businessName == '') {
	        	$scope.addSuccess = false;
	    	    $scope.saveSuccess = false;
	    	    $scope.deleteSuccess = false;
	            $scope.nameEmpty = true;
	        } else {
	            var newClient = {
            		'businessName': $scope.businessName,
		            'interlocuter': $scope.interlocuter,
		            'address': $scope.address,
		            'zipCode': $scope.zipCode,
		            'city': $scope.city,
		            'phone': $scope.phone,
		            'email': $scope.clientEmail,
		            'comment': $scope.comment	
	            };
	            
	        	/**
				 * Make a post request to the service to insert a new client to
				 * the database
				 */
	            $http.post("/Clients/user/", newClient)
			    .then(function(response) {			    	
			    	/**
					 * Set the id of the client from the response from the
					 * service
					 */
			    	newClient.id = response.data;	
			    	
			    	/**
					 * Push the new client to the $scope.clients array
					 */
		        	$scope.clients.push(newClient);	
		        	
		        	/**
					 * Hide other alerts and show add success alert
					 */
		        	$scope.nameEmpty = false;
		    	    $scope.saveSuccess = false;
		    	    $scope.deleteSuccess = false;	            
		        	$scope.addSuccess = true;
			    });
	        }

	        /**
			 * Reset the input fields
			 */
            $scope.businessName = '';
            $scope.interlocuter = '';
            $scope.address = '';
            $scope.zipCode = '';
            $scope.city = '';
            $scope.phone = '';
            $scope.clientEmail = '';
            $scope.comment = '';
	    };
	    
	    /**
		 * @function modifyClientDetails [ This function is called when the
		 *           modify button is clicked. It opens a modal where the user
		 *           can modify the information about the selected client ]
		 * @param {Client}
		 *            _client [The client to be updated ]
		 */
	    $scope.modifyClientDetails = function (_client) {	    	
	    	/**
			 * Hide all alerts
			 */
	    	$scope.nameEmpty = false;
	    	$scope.addSuccess = false;
	    	$scope.saveSuccess = false;
		    $scope.deleteSuccess = false;
	        
		    /**
			 * Store the client data in a scope variable $scope.client
			 */
	        $scope.client = {
		            'id': _client.id,
		            'businessName': _client.businessName,
		            'interlocuter': _client.interlocuter,
		            'address': _client.address,
		            'zipCode': _client.zipCode,
		            'city': _client.city,
		            'phone': _client.phone,
		            'email': _client.email,
		            'comment': _client.comment
		        };
	    };
	    
	    /**
		 * @function saveClientDetails [ This function is called when the save
		 *           button is clicked. It updates the information about the
		 *           client in the database ]
		 */
		$scope.saveClientDetails = function() {
			/**
			 * Make a put request to the service to update client data in the
			 * database
			 */
			$http.put("/Clients/user/" + $scope.client.id,
					$scope.client).then(function(response) {
				/**
				 * Loop through $scope.clients array and update the data of the
				 * selected client
				 */
				angular.forEach($scope.clients, function(value, key) {
					if (value.id == $scope.client.id) {
						value.businessName = $scope.client.businessName;
						value.interlocuter = $scope.client.interlocuter;
						value.address = $scope.client.address;
						value.zipCode = $scope.client.zipCode;
						value.city = $scope.client.city;
						value.phone = $scope.client.phone;
						value.email = $scope.client.email;
						value.comment = $scope.client.comment;
					}
				});
				/**
				 * Hide other alerts and show save success alert
				 */
				$scope.nameEmpty = false;
				$scope.addSuccess = false;
				$scope.deleteSuccess = false;
				$scope.saveSuccess = true;
			});
		};
	
	    /**
		 * @function deleteClientDetails [ This function is called when the
		 *           delete button is clicked. It deletes the selected client
		 *           from the database ]
		 * @param {int}
		 *            _clientId [The id of the client to be deleted ]
		 */
	    $scope.deleteClientDetails = function (_clientId) {	 
	    	/**
			 * Make a delete request to the service to delete client data in the
			 * database
			 */	
	    	$http.delete("/Clients/user/" + _clientId)
		    .then(function(response) {
		    	/**
				 * Loop through $scope.clients array and delete the selected
				 * client
				 */
		    	angular.forEach($scope.clients, function (value, key) {
		    		if (value.id == _clientId) {
		    			$scope.clients.splice(key, 1);
		    		}
		    	});
		    	/**
				 * Hide other alerts and show delete success alert
				 */
		    	$scope.nameEmpty = false;
		    	$scope.addSuccess = false;
		        $scope.saveSuccess = false;
				$scope.deleteSuccess = true;
		    });
	    };
	    
	    /**
		 * @function closeAlert [ This function hides an alert based on the
		 *           input string ]
		 * @param {String}
		 *            _alert [The alert to be hidden]
		 */
	    $scope.closeAlert = function (_alert) {
	    	if (_alert == 'name') {
	    		$scope.nameEmpty = false;
	    	} else if (_alert == 'add') {
	    		$scope.addSuccess = false;
	    	} else if (_alert == 'save') {
	    		$scope.saveSuccess = false;
	    	} else if (_alert == 'delete') {
	    		$scope.deleteSuccess = false;
	    	}
	    };
	
	});