(function(angular){
    var ItemFactory = function($resource){
        return $resource('/items/:id', {
            id: '@id'
        }, {
            update: {
                method: "PUT"
            },
            remove: {
                method: "DELETE"
            }
        });
    };

    var PersonFactory = function($resource){
        return $resource('/persons/:id', {
            id: '@id'
        }, {
            update: {
                method: "PUT"
            },
            remove: {
                method: "DELETE"
            }
        });
    };

    ItemFactory.$inject = ['$resource'];
    angular.module("myApp.services").factory("Item", ItemFactory);

    PersonFactory.$inject = ['$resource'];
    angular.module("myApp.services").factory("Person", PersonFactory);
}(angular));
