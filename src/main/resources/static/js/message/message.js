angular.module('message', [])

    .controller('message', function($http) {
        var self = this;
        $http.get('/hello/').then(function(response) {
            self.greeting = response.data;
        });
    });
