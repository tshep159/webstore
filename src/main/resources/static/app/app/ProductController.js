///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//var app = angular.module('ProductController',[]).controller('ProductController',function ($http,$scope,$location,$rootScope){
//   
//    
//    var productList = [];
//   
//    alert("dddddddddddd");
//    $scope.init = function(){
//     $scope.listProduct(); 
//    };
//    
//    $scope.listProduct = function(){
//        var url = "admin/listproduct";
//         alert("dddddddddddd   list");
//        var productProcess = $http.get(url);
//        productProcess.then(function(response){
//        productList = response.data;; 
//        });   
//    };
//    
//     $scope.addProduct = function(){
//            var url = "admin/addproduct";
//            var product = $scope.pro;
//             
//             var productProcess = $http.post(url,product).then(function(response){
//                 alert("dddddddddddd");  
//                alert("product has been added"); 
//                //$rootScope.status = response.data.status;
//                $rootScope.pname = response.data.item.productName;
//               // productList = response.data.item;
//                alert($rootScope.pname);
//               
//            });
//            
//             
//        }; 
//      $scope.deleteProduct = function(productId){
//        var url = "Admin/deleteProduct" + productId;
//        
//        $http.post(url).then(function (response){
//            
//            v.product = response.data;
//        });
//    };    
//              
//    
//});
