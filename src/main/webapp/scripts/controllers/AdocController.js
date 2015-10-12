

angular.module('moijecodemadoc').controller('AdocController', function($scope, $http) {

    $scope.code = "";
    $scope.result = "";
    
    $scope.performSearch = function() {
    	if ($scope.code && $scope.code.length>0) {
	        $http.post("/moijecodemadoc/rest/adoc", {code: $scope.code})
	        	.then(function(res) {
	        		$scope.result = res.data.result;
	        	});
    	}
    };
    
});