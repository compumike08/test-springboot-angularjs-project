(function(angular){
    var ItemFactory = function($resource){
        resource $resource('/items/:id', {
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
}(angular));
