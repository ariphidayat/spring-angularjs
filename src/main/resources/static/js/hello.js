angular.module('hello', []).controller('home', function($http) {
    var self = this;
    $http.get('hello/').then(function(response) {
        self.greeting = response.data;
    })
});