var app = angular.module("hotelsApp", ["ui.router", "ngResource"]);

app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("home");

    $stateProvider
        .state('home', {
            url:'/home',
            templateUrl: URLS.partialsList,
            controller: 'HotelCtrl'
        }).state('edit', {
            url:'/edit/:hotelId',
            templateUrl: URLS.partialsEdit,
            controller: 'HotelEditCtrl'
        }).state('create', {
            url:'/create',
            templateUrl: URLS.partialsCreate,
            controller: 'HotelCtrl'
        }).state('endpoints', {
            url: '/endpoints',
            templateUrl: URLS.partialsMappings,
            controller: 'MappingsCtrl'
        });
});


app.factory("Hotel", function ($resource) {
    return $resource(URLS.hotels, {id: "@id"}, {
        update: {
            method: 'PUT'
        }
    });
});

app.factory("mappingsFactory", function($http) {
    var factory = {};
    factory.getMappings = function() {
        return $http.get(URLS.mappingsUrl);
    }
    return factory;
});

app.controller("HotelCtrl", function ($scope, Hotel, $state) {
    function init() {
        $scope.getHotels();
    }


    $scope.getHotels = function () {
        $scope.hotels = Hotel.query();
    };

    $scope.deleteHotel = function (hotel) {
        return hotel.$delete({}, function () {
            $scope.hotels.splice($scope.hotels.indexOf(hotel), 1);
        });
    };

    $scope.createHotel = function () {
        var hotel = new Hotel($scope.hotel);
        hotel.$save({}, function() {
            $state.transitionTo("home");
        });
    };

    init();
});

app.controller("HotelEditCtrl", function ($scope, Hotel, $state, $stateParams) {
    function init() {
        $scope.hotel = Hotel.get({id:$stateParams.hotelId})
    }

    $scope.updateHotel = function() {
       var hotel = new Hotel($scope.hotel);
       hotel.$update().then(function() {
           $state.transitionTo("home");
       }) ;
    }
    init();
});

app.controller("MappingsCtrl", function($scope, $state, mappingsFactory) {
    function init() {
        mappingsFactory.getMappings().success(function(data) {
           $scope.mappings = data;
        });
    }

    init();
});
