(function(angular){
    angular.module("myApp.controllers", []);
    angular.module("myApp.services", []);
    angular.module("myApp", ["ngResource", "restmod", "myApp.controllers", "myApp.services"]);
}(angular));
