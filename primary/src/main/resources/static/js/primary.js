angular.module('primary', [])

    .controller('home', function($http) {
        console.log('Loading');
        var self = this;
        $http.get('user').then(function(response) {
            var data = response.data;
            if (data.name) {
                self.authenticated = true;
                self.user = data.name
                $http.get('/resource/message')
                    .then(function(response) {
                        self.greeting = response.data;
                    })
            } else {
                self.authenticated = false;
            }
        }, function() {
            self.authenticated = false;
        });
    });
