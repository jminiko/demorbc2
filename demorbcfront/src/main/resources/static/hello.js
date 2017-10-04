angular.module("demoRBC", [])
.controller("robotCtl", function($scope, $http) {
    $http.get("http://localhost:8090/list").
        then(function(response) {
            $scope.data = response.data;
            console.log($scope.data);
        });
});