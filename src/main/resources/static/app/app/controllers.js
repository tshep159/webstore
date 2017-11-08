
var app = angular.module('myapp',['ngRoute']);
    app.config(function($routeProvider,$locationProvider) {
    
        $routeProvider
        .when("/", {
            templateUrl : '/register.html',
            controller : 'userController'
        }).when("/list",{
            templateUrl : '/list.html',
            controller: 'userController'
        }).when("/register", {
            templateUrl : '/register.html'
            
        }).when("/login",{
            templateUrl : '/login.html',
            controller : 'userController'
        }).when("/admin",{
            templateUrl : '/Admin.html',
            controller : 'userController'
        }).when("partner/addProduct",{
            templateUrl : '/addProduct.html',
            controller : "userController"
       }).when("/cart",{
             templateUrl : '/cart.html',
             controller : 'userController'
        }).when("/rest/addrest",{
            templateUrl:'addrest.html',
            controller: 'userController'
        }).when("rest/list",{
            templateUrl:'listrest.html'
            , controller:'userController'
        }).when("admin/list",{
            templateUrl:'/ViewUsers.html',
            controller: 'userController'
        }).when("admin/listproduct")
                .when("rest/addrest",{
            templateUrl:'/addrest',
            controller: 'userController'
        }).otherwise({
            redirectTo : ("/")
        });
        
      $locationProvider.html5Mode(false);
     
 
    });
app.controller('userController',function($http,$scope,$location,$rootScope){
     alert("user controller active");
    $scope.register = function(){
        var url = "user/register";
        var webUser = $scope.cus;
        var vbv = $http.post(url,webUser).then(function(response){
//      document.write("Welcome " +  response.data.userObject.firstName); 
//        $rootScope.status = response.data.status;
//        $rootScope.cname = response.data.userObject.firstName;
        alert("success");
        $location.url("/login");
        });
//          $http.get('/list').then(function(response){
//        $scope.users = response.data;
//    });
       
    };
    
   $scope.login = function(){
//        alert("login Controller active");
        $http({
            url: '/login',
            method: 'GET',
            params: {username: $scope.username , password: $scope.password}
        }).then(successCallback, errorCallback);
            function successCallback(respose){
                
                var customer = respose.data;
                console.log(respose);
                if(customer.username==="admin" ){
                    alert("Successfully Logged In");
                    $location.url('/admin');
                }else{
                    if($scope.username === customer.username){
                        alert("Successfully Logged In");
                        $location.url('/products');
                    }else{
                        alert("Invalid Credentials,Please try again");
                        $location.url('/login');
                    }
                } 
            }; 
            function errorCallback(response){
                console.log(response);
                alert("Invalid Credentials,Please try again");
                $location.url('/login');
            };
      };
      
      
      
                /**************************************************/
    $scope.image = null;
   $http.defaults.headers.post["Content-Type"] = "application/json";
   var url = 'partner/addproduct';
   var imageCopy = null;
   var image = null;
   var handleImageSelect = function (evt)
   {
       var files = evt.target.files;
       var file = files[0];
       if (files && file){
           var reader = new FileReader();
           reader.onload = function (readerEvt) {
               var binaryString = readerEvt.target.result;
               imageCopy = btoa(binaryString);
               image = 'data:image/octet-stream;base64,' + imageCopy;
               $scope.image = image;
               console.log($scope.image);
           };
       reader.readAsBinaryString(file);
//       if (window.File && window.FileReader && window.FileList && window.Blob) {
//           document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
//        } else {
//           alert('The File APIs are not fully supported in this browser.');
//       }
       }
 };

   $scope.addproduct = function(){
        var url = "partner/addproduct";
        var product = $scope.pro;
        var customerProcess = $http.post(url,product).then(function(response){
            alert("Product Added "); 
        
 });
 };

        //retrieving product list
      $http.get('partner/listproduct').then(function(response){
        $scope.products = response.data;
});

  /*handling logout*/
$scope.logout = function (){
        var url = "test/logout";
        var userProcess = $http.post(url).then(function(response){ 

        localStorage.removeItem("user");//removing user from localstorage
        $rootScope.status = localStorage.getItem("status"); 
        $location.path('/login');
        });
            
};
        /***************RESTAURANT********** */
   
   /*ADDING RESTAURANT*/
   $scope.addres = function(){
            var url = "rest/addrest";
         
            var restaurant = $scope.res;
            var vbv = $http.post(url,restaurant).then(function(response){
       });
            document.write(" Restaurant Succesfully Added ,\n\
              \n Please login to your email to get your Login details");
            $scope.direct();
            };
        $http.get('rest/list').then(function(response){
        $scope.res = response.data;
    });
 

   $scope.saveProd = function (){
       $http.post(url, {
           name:  $scope.name,
           description: $scope.description,
           price: $scope.price,
           image: $scope.image
         

       }).then(successCallback, errorCallback);
          function successCallback(response) {
               alert("Product Added Successfully");
               console.log(response.data);
               $location.url('/admin');
           }
           function errorCallback(response) {
               console.log(response);
               alert("failed to add Product");
           };        
   };
     
    
    $scope.cart = [];
    $scope.total = 0;
   
    var prodAdded = false;
    $scope.addToCart = function(prod){
        if($scope.cart.length >= 0){
           $scope.cart.push(prod);
           console.log($scope.cart);
        }else{
            if($scope.cart.length !== 0){
                alert("Product Available in cart cart");
                for(var i = 0 ; i < $scope.cart.length;i++){
                    alert("Checking existing product ");
                    if($scope.cart[i].id === prod.id){
                      prodAdded = true;
                      $scope.quantity +=1;
                    }else{
                        $scope.cart.push(prod);
                    }
                }
            }
           
        }
    
        $scope.total +=parseFloat(prod.price);
    };

        function getItemIndex(item){
            for(var i=0; i< $scope.cart.length; i++){
                if($scope.cart[i].id === item.id){
                    return i;
                }
            }

            return -1;
              var count =$scope.cart.length();
        }

        $scope.decrease = function(item){
            var index = getItemIndex(index);
            if(item.quantity -1 === 0){
                $scope.cartItems.splice(index,1);
            }
        };

        $scope.cartSum = function(){
            var sum =0;
           
            $scope.cart.forEach(function(item){
                sum += item.quantity * item.price;
            });

            return sum;
        };

        $scope.increase = function(item){
            item.quantity++;
        } ;
    
    
});
