(function(angular){
    var AppController = function($scope, Item) {
        Item.query(function(response) {
            if(response){
                $scope.items = response;
            }else{
                $scope.items = [];
            }
        });

        $scope.addItem = function(item){
            new Item({
                description: item.description,
                ownedBy: item.ownedBy,
                checked: false
            }).$save(function(item) {
                $scope.items.push(item);
            });
            $scope.newItem.ownedBy = "";
            $scope.newItem.description = "";
        };

        $scope.updateItem = function(item){
            item.$update();
        };

        $scope.deleteItem = function(item){
            item.$remove(function(){
                $scope.items.splice($scope.items.indexOf(item), 1);
            });
        };
    };


    var PersonController = function($scope, Person){
        Person.query(function(response){
            if(response){
                $scope.persons = response;
            }else{
                $scope.persons = [];
            }
        });

        $scope.addPerson = function(person){
            new Person({
                firstName: person.firstName,
                lastName: person.lastName
            }).$save(function(person){
                $scope.persons.push(person);
            });
            $scope.newPerson.firstName = "";
            $scope.newPerson.lastName = "";
        };

        $scope.updatePerson = function(person){
            person.$update();
        };

        $scope.deletePerson = function(person){
            person.$remove(function(){
                $scope.persons.splice($scope.persons.indexOf(person), 1);
            });
        };
    };


    AppController.$inject = ['$scope', 'Item'];
    angular.module("myApp.controllers").controller("AppController", AppController);

    PersonController.$inject = ['$scope', 'Person'];
    angular.module("myApp.controllers").controller("PersonController", PersonController);
}(angular));