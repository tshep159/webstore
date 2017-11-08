/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///CustomersController.$inject = ['$http'];

        
var app = angular.module('CustomersController',[]).controller('CustomersController',function ($http,$scope,$location,$rootScope){
          
         $scope.user = localStorage.getItem("user");
        // alert($scope.user +" zzzzz");
         $rootScope.cname = angular.fromJson(localStorage.getItem("user"));
         if($rootScope.cname !== null){
             $rootScope.cname = $rootScope.cname.name;
         }
         
         $scope.register = function(){
            var url = "test/register";
           // alert("dsgfsdgfsd");
            var customer = $scope.cus;
       var customerProcess = $http.post(url,customer).then(function(response){
                
                alert("Welcome " +  response.data.cust.email); 
               // $rootScope.status = response.data.status;
               //$rootScope.cname = response.data.userL.name;
               alert("Succesfully registered");
                
            });
            
            $scope.direct();
             
        };
        
        $scope.login = function (){
            var url = "test/login";
            
            var customer = $scope.cus;
           
             alert(customer.password);
            
            var customerProcess = $http.post(url,customer).then(function(response){ 
                
             localStorage.setItem("user",JSON.stringify(response.data.userL));
             alert("loginSuccessful"); 
             // $scope.dd = response;
             alert("Welcome " +  response.data.userL.firstName);
             
              alert($scope.check);
             
             $scope.user = localStorage.getItem(("user"));
             localStorage.setItem("status",response.data.status);
            
               //$rootScope.status = localStorage.getItem("status");
               $rootScope.lastName = angular.fromJson(localStorage.getItem("user")).name;
               alert( $rootScope.lastName);
               alert(localStorage.getItem("user"));
               alert($scope.user);
                $scope.direct();  
              
            });
            
               
        };
        
        $scope.direct = function(){
            //alert("customer.name");
            $location.path('/');
        };
        
        $scope.reg = function(){
            $location.path('/register');
        };
        
        $scope.log = function (){
            $location.path('/login'); 
        };
          
       $scope.logout = function (){
           var url = "test/logout";
           var customerProcess = $http.post(url).then(function(response){ 
               
             localStorage.removeItem("user");
             $rootScope.status = localStorage.getItem("status"); 
             $location.path('/');
            });
            
       };
        
        
        
    });
    
    app.controller('ProductController',function ($http,$scope,$location,$rootScope){
   
    
    //var productList = [];
   
    $scope.user = localStorage.getItem("user");
    
    $scope.init = function(){
     $scope.listProduct(); 
    };
    var prod;
    $scope.listProduct = function(){
        var url = "admin/listproduct";
        
       var productProcess =$http.get(url).then(function(response){    
       
            $rootScope.product = response.data; 
            
           // alret($rootScope.product.name);
            prod = response.data; 
        });  
        
        $scope.admin();
       
    };
    
    $scope.listForCust = function( )
    {
       var url = "admin/listproduct";
        
       var productProcess =$http.get(url).then(function(response){    
       
            $rootScope.product = response.data; 
            prod = response.data; 
           // alert(JSON.stringify(response.data.url) );
        }); 
        
       
    };
     
     
    
    
    $scope.admin = function (){
         $location.path('/admin');
    };
    
     $scope.addProduct = function(){
            var url = "admin/addproduct";
            var product = $scope.pro;
            
             var productProcess = $http.post(url,product).then(function(response){
               
                //$rootScope.status = response.data.status;
                $rootScope.pname = response.data.item.productName;
               // productList = response.data.item;
                alert($rootScope.pname + " has been added" );
              
            });
            
             
        }; 
        
      
        
      $scope.deleteProduct = function(proId){
        
        var url = "admin/deleteProduct/" + proId;  
        var deleting = $http.post(url).then(function (response){
          
             $scope.listProduct();
        });
       
    }; 
    $scope.cart = [];
    var qnty = 0;
    $scope.itemCount = 0;
    $scope.total = 0;
    $scope.order;
    
    $scope.addToCart = function (id,name,price,quntity) {
      
	if($scope.user !== null ){
        var found = false;
        var x = 0;
        for( x ; x < $scope.cart.length; x++){
            
            if($scope.cart[x].productId === id && quntity > 0){
               
                
                found = true;
                 $scope.itemCount++;
                 $scope.cart[x].quantity++;
                
                 $scope.total += $scope.cart[x].productPrice; 
                 quntity--;
                 
//                $location.path('/picknpay');
            }
        }

        if (!found && quntity > 0) {
           
            var item = {
                productId:id,
                productName:name,
                productPrice:price,
                quantity: qnty
            };
           
            $scope.cart.push(item);
            quntity--;
            $scope.itemCount++;
            $scope.cart[x].quantity++;
            $scope.total += $scope.cart[x].productPrice; 
            
            
           // found = false;
	}
        }
        else{

            $location.path('/login');
        }
        
        
        };
        
        $scope.removeQ = function (id,quntity){
           
            //alert( "item hhhh" + $scope.cart[x].ID);
            for( var x = 0 ; x < $scope.cart.length; x++){
            
            if($scope.cart[x].productId === id && $scope.cart[x].quantity > 0){
                
                 $scope.itemCount--;
                 $scope.cart[x].quantity--;
                 
                 quntity--;
                  $scope.total -= $scope.cart[x].productPrice; 
                 if($scope.cart[x].quantity === 0){
                     $scope.cart.splice(x,1) ;
                 }
                 
//                $location.path('/picknpay');
            }
        }
            
        };
        
        
        $scope.checkOut = function (){
     
            
           
            var url = "admin/checkOut"; 
             alert("it it is it");
            $http.post(url,$scope.cart).then(function (response) {
                alert("olaaaaa7777");
                
                
	});
               
               $scope.createOrder();
               
            
        };
        
        $scope.createOrder = function (){
            $scope.id = angular.fromJson(localStorage.getItem("user")).customerId;
            alert($scope.id);
            var url = "order/createOrder/" + $scope.id;
            alert($scope.user);
            $http.post(url,$scope.cart).then(function (response) {
            alert("olaaaaa3");
            $rootScope.order = response.data;
            alert($rootScope.order);
	});
            
        };
        
        $scope.createOrderDetails = function (){
             alert($rootScope.order);
            var url = "order/createOrderDetails";
            alert("oder D created rellllly");
            $http.post(url,$scope.cart).then(function (response) {
                alert("oder D created");
               
               
	});
        };
              
    
});
app.controller('ShoppingChart',function ($http,$scope,$location,$rootScope){
    
    $scope.cart = [];
    
    $http.get('product.json').success(function (response) {
            $scope.products = response.product;
	});
    
    $scope.addToCart = function (product) {
	var found = false;
	$scope.cart.forEach(function (item) {
	if (item.id === product.id) {
            item.quantity++;
            found = true;
            
                //alert( item.quantity);
	}
        });
        if (!found) {
            $scope.cart.push(angular.extend({quantity: 1}, product));
           // alert( "item pushed");
	}
        };
        
        $scope.getCartPrice = function () {
			var total = 0;
			$scope.cart.forEach(function (product) {
				total += product.price * product.quantity;
			});
			return total;
		};
        
    
});



  