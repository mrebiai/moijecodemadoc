

angular.module('moijecodemadoc').controller('SearchMaDocController', function($scope, $http) {

    $scope.code = "";
    $scope.result = "";
    
    $scope.performSearch = function() {
        $http.get("/moijecodemadoc/rest/madocs/test")
        	.then(function(data) {
        		console.log(data);
        		$scope.result = data;
        	});
    };
    
    $scope.performSearch();
});