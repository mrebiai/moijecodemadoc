

angular.module('moijecodemadoc').controller('PumlController', function($scope, $http) {

    $scope.code = "";
    $scope.result = "";
    
    $scope.render = function() {
    	if ($scope.code && $scope.code.length>0) {
	        $http.post("/moijecodemadoc/rest/puml", {code: $scope.code})
	        	.then(function(res) {
	        		$scope.result = res.data.result;
	        	});
    	}
    };
    
});