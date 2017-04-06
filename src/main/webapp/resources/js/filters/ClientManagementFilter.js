/**
 * The AngularJS filter for the clients view
 */
clientManagementApp.filter('ClientManagementFilter', function() {
    
	return function(items, searchText) {
    	
    	var filtered = [];
    	var itemMatch = new RegExp(searchText, 'i');
    	
    	angular.forEach(items, function (value, key) {
    		if (!searchText || itemMatch.test(value.businessName) || itemMatch.test(value.interlocuter) || itemMatch.test(value.address) || itemMatch.test(value.zipCode) ||
    				itemMatch.test(value.city) || itemMatch.test(value.phone) || itemMatch.test(value.email) || itemMatch.test(value.comment)) {
		        	
    			filtered.push(value);
	        }
    	});
    	
        return filtered;
    };
});