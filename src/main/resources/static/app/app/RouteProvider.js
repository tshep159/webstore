/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('app',['CustomersController','ngRoute']);

app.config(["$routeProvider",function($routeProvider) {
        
            $routeProvider
            .when("/", {
                templateUrl : "mrd.html",
                controller :"CustomersController"
        
        
                
            })
            .when("/register", {
                templateUrl : "register.html",
                controller :"CustomersController"
            }).otherwise({
                redirectTo:"/"
            })
             .when("/login", {
                templateUrl : "login.html",
                controller :"CustomersController"
            })
            .when("/Admin", {
                templateUrl : "Admin.html",
                controller :"ProductController"
            });

        }]);

