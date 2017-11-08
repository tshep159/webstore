
var app = angular.module('myApp',['ngRoute']);

app.config(["$routeProvider",function($routeProvider) {
        alert("Routing Activated");
            $routeProvider

            .when("/", {
                templateUrl : "/mrd.html"
//                controller :"UsersController"
            })
            .when("/register", {
                templateUrl : "register.html"
//                controller :"UsersController"
            }).otherwise({
                redirectTo:"/"
            })
             .when("/login", {
                templateUrl : "login.html"
//                controller :"UsersController"
            })
             .when("/customer", {
                templateUrl : "customer.html"
//                controller :"UsersController"
            }).when("/driver", {
                templateUrl : "driver.html"
//                controller :"UsersController"
            })
                .when("/partner", {
                templateUrl : "partner.html"
//                controller :"UsersController"
            }).when("/listproduct",{
              templateUrl : "productList.ktml",
              controller :"UsersCotnroller"
            }).when("/delete",{
                templateUrl : "register.html",
                controller : "UserController"
            }).when("admin/addrest",{
                templateUrl:"addrest.html",
                cintroller : "UsersController"
            }). when("/Admin", {
                templateUrl : "Admin.html",
                controller :"UsersController"
            }).when("admin/listproduct",{
                templateUrl: "products",
                controller : "UsersController"
                }).when("/user",{
                templateUrl: "user",
                controller : "UsersController"
                
            }).otherwise("/");
           // $locationProvider.html5Mode(false);

        }]);

