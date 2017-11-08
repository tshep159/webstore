
var app = angular.module('ctrl',['ngRoute']);
    app.config(function($routeProvider,$locationProvider) {
    
        $routeProvider
        .when("/", {
            /**
             * Free Routes
             **/
            templateUrl : '/home.html',
            controller:"registerController"
        }).when("/addrest", {
            /**
             * Free Routes
             **/
            templateUrl : '/addRest.html',
            controller:"resturantController"
        }).when("/register", {
            templateUrl : "/register.html",
            controller : "registerController"
        }).when("/user-list",{
             templateUrl:"user-list.html",
             controller:"adminController"
                     
        }).when("/login",{
            templateUrl : "/login.html",
            controller : "loginController"
        }).when("/list",{
            templateUrl:'userlist.html',
            controller: "registerController"
        }).when("/products",{
            templateUrl : "/products.html",
            controller : "productController"
            /**
             * Admin Routes
             */
        }).when("/rest",{
            templateUrl:'/rest.html',
            controller:'registerController'
        }).when("/admin",{
            templateUrl : "/admin.html",
            controller : "adminController"
        }).when("/addProduct",{
            templateUrl : "/addProduct.html",
            controller : "productController"
            
        }).when("/cart",{
             templateUrl : "/cart.html",
             controller : "productController"
        }).when("/driver",{
            templateUrl:"/driver.html",
            controller:"productController"
            
        }).when("/ ",{
            templateUrl : "/adminProducts.html",
            controller : "productsController"
            /**
             * User/ customer Routes
             */
        }).when("/payment",{
            templateUrl:"payment.html",
            controller:"productController"
        
        }).when("/request",{
            templateUrl: "request.html",
            controller : "requestController"
          
        }).when("/address",{
            templateUrl:"address.html",
            controller: "productController"
        }).when("/partners/login",{
            templateUrl:"logins.html",
            controller:"resturantController"
            
        }).when("/userproduct",{
            templateUrl:"uproduct.html",
            controller: "productController"
        }).otherwise({
            redirectTo : ("/")
        });
        
      $locationProvider.html5Mode(false);
     
 
    });
    /****
     * 
     * 
     * Payment
     */
    
//app.controller('paymentController', function($scope,$http,$location){
//  alert("paymentController here");
//  $scope.pay = function(){
//      var url="/add/payment";
//      var payment = $scope.payy;
//      var paymentProcess= $http.post(url,payment)
//              .then(function(response){
//                 
//      });
//       $location.url('/admin');
//      alert("payment saved")
//  };
//  
//  /* displaying *payment items*/
//  $http.get("/all/payments").then(function(response){
//      $scope.payments = response.data;
//  });
//});  
app.controller('registerController',function($scope,$http,$location,$rootScope){
   alert("register Accccc");
   
    $scope.register = function(){
            var url = "/register";
            $scope.msg="Succesfully Registered , \n Please login to your email to get your Login details";
            var webUser = $scope.cus;
            var vbv = $http.post(url,webUser).then(function(response){
           });
            console.log(webUser);
            alert("Succesfully Registered , \n Please login to your email to get your Login details");
     
            };
         $http.get('/role/partner').then(function(response){
        $scope.rests = response.data;
             });
                      $http.get('/role/driver').then(function(response){
        $scope.drivers = response.data;
             });
                      $http.get('/role/customer').then(function(response){
        $scope.custs = response.data;
             });
                      $http.get('/role/admin').then(function(response){
        $scope.admin = response.data;
             });
           
             
});   /*****
           * 
           * Request 
           */   
app.controller('requestController', function($scope,$http,$location){
    alert("jkjfdkjdkjfd");
     $scope.addme = function(){
            var url = "/request";

            var requests = $scope.req;
            var quest = $http.post(url,requests).then(function(response){
          });
            alert("Your Request Has been received please keep checking your emails for response");
            $location.url("/");
            };
      
//  $http.get("/all/request").then(function(response){
//      $scope.requests = response.data;
//  });
    
});          
             
   /*****
    * 
    * Login
    *******/  
   
   
   app.controller('loginController',function($http,$scope,$location){
    $scope.login = function(){
//        alert("login Controller active");
        $http({
            url: '/login/user',
            method: 'GET',
            params: {email: $scope.email , password: $scope.password}
        }).then(successCallback, errorCallback);
            function successCallback(respose){
                var user = respose.data;
                localStorage.setItem('id',JSON.stringify(user.email) );
                console.log(respose);
                if(user.role==="admin" ){
                    alert("Success");
                    $location.url('/admin');
                }
                else if(user.role==="partner"){
                    alert("partner")
                    $location.url("/addProduct")
                } else if (user.role==="driver"){
                    alert("driver");
                    $location.url("/driver");
                }
                else{
                    if($scope.email === user.email){
                        alert("Success");
                        $location.url('/cart');
                    }else{
                        alert("Invalid Username or password ");
                        $location.url('/login');
                    }
                } 
            }; 
            function errorCallback(response){
                console.log(response);
                alert("Invalid Credentials,");
                $location.url('/login');
            };
      };
      
   });
   /*
    * ***********************************************
    * ***********************************************
    * ADMIN Controller
    */
    app.controller('adminController',function($http,$scope,$location){
   
    /*
     * 
     * Adding user
     */
     alert("User Admin Active");
      $scope.image = null;
    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = "/register";
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
            };
        reader.readAsBinaryString(file);
        }
    };
//    if (window.File && window.FileReader && window.FileList && window.Blob) {
//       document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
//    } else {
//        alert('The File APIs are not fully supported in this browser.');
//    }
    $scope.dregister = function(){
            
            var msg="";
            var webUser = $scope.cus;
            var vbv = $http.post(url,webUser).then(function(response){
          
            });
            console.log(webUser);
            alert("Succesfully Registered , \n Please login to your email to get your Login details");
     
            };
            $scope.removeRow = function(name){	
                var url="/remove/{user_id}"
                var x = $http.delete(url).then(function(response){
                    
                });
		var index = -1;		
		var comArr = eval( $scope.users );
		for( var i = 0; i < comArr.length; i++ ) {
			if( comArr[i].name === name ) {
				index = i;
				break;
			}
		}
		if( index === -1 ) {
			alert( "Something gone wrong" );
		}
		$scope.users.splice( index, 1 );		
	};
            
            
//            $http.get('list/list').then(function(response){
//        $scope.users = response.data;
//             });
$scope.listCustomers = [];
	
	// selected customer
	$scope.selectedCustomer;

	// for update message
	$scope.error=false;
	$scope.putMessage;
	
	// get all customers from remote servers
	function getAllCustomer(){
		// get URL
		
		// do getting
		$http.get("list/list").then(function (response) {
			$scope.listCustomers = response.data;
			if($scope.listCustomers.length){ 
				$scope.selectedCustomer = $scope.listCustomers[0];
			}
		}, function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
		});
	};
	
	// load data at initial loading time
	getAllCustomer();
	
	// the function to select a customer
	$scope.selectCustomer = function(index){
		if($scope.listCustomers.length){
			$scope.selectedCustomer = $scope.listCustomers[index]; 	
		}
	}
	
	// using http PUT to update the changed customer info 
	$scope.updateCustomer = function(){
		if($scope.selectedCustomer){
			// put URL
			var url =  "/update/" + $scope.selectedCustomer.user_id;
			
			// prepare headers for posting
			var config = {
	                headers : {
	                	'Content-Type': 'application/json',
	                	'Accept': 'text/plain'
	                }
	        }
			
			// prepare data for put messages
			var data = $scope.selectedCustomer;
			
			// do posting
			$http.post(url, data, config).then(function (response) {
				$scope.error = false;
				$scope.putMessage = response.data;
			}, function error(response) {
				$scope.error = true;
				$scope.putMessage = "Error!";
			});
		}
                
                console.log($scope.selectedCustomer.user_id);
	}
             
    


             alert("Resturant Admin active ");
    $scope.image = null;
    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = "/register";
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
            };
        reader.readAsBinaryString(file);
        }
    };
//    if (window.File && window.FileReader && window.FileList && window.Blob) {
//       document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
//    } else {
//        alert('The File APIs are not fully supported in this browser.');
//    }
    $scope.addUser = function (){
        $http.post(url, {
            firstName:  $scope.firstName,
            lastName: $scope.lastName,
            cell: $scope.cell,
            email: $scope.email,
            description: $scope.description,
            town: $scope.town,
            street: $scope.street,
            image: $scope.image
            

        }).then(successCallback, errorCallback);
           function successCallback(response) {
                alert("User Added Successfully");
                console.log(response.data);
                $location.url('/admin');
            }
            function errorCallback(response) {
                console.log(response);
                alert("failed to add Restaurant");
            };        
    };
 
 /*****************************************
  * ****************Admin Product Actions**
  * ***************************************
  */
     alert("product admin active ");
    $scope.image = null;
    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = '/addProduct';
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
            };
        reader.readAsBinaryString(file);
        }
    };
//    if (window.File && window.FileReader && window.FileList && window.Blob) {
//       document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
//    } else {
//        alert('The File APIs are not fully supported in this browser.');
//    }
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
//    
    /**Retrieving Products from the Database**/
    $http.get("/products/all").then(function(response){
            $scope.products = response.data;
    });  
    
    /**Retrieving Products from the Database**/
    $http.get("/order/list").then(function(response){
            $scope.orders = response.data;
    }); 
    
               $http.get('/role/partner').then(function(response){
        $scope.rests = response.data;
             });
                      $http.get('/role/driver').then(function(response){
        $scope.drivers = response.data;
             });
                      $http.get('/role/customer').then(function(response){
        $scope.custs = response.data;
             });
                      $http.get('/role/admin').then(function(response){
        $scope.admin = response.data;
             });
             
               $http.get("/all/request").then(function(response){
      $scope.requests = response.data;
  });
    
   });//end admin cntrl
   
   /*
    * User Service To share all user info accross the user session
    */
 app.service('user', function(){
     var name;
     var loggedin = false;
     this.setFirstName =function(name){
         name=firstName;
         
     };
     this.getFirstName = function(){
         return firstName;
     };
     this.isUserloggedIn = function(){
         return loggedIn;
     };
     this.userLoggedIn = function(){
         loggedin=true;
     };    
     
 });  
 
app.controller('resturantController',function($http,$scope,$location,user){
    
 
      
   /*ADDING RESTAURANT*/
   
   alert("Controller ");
    $scope.image = null;
    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = '/add/restaurant';
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
            };
        reader.readAsBinaryString(file);
        }
    };
//    if (window.File && window.FileReader && window.FileList && window.Blob) {
//       document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
//    } else {
//        alert('The File APIs are not fully supported in this browser.');
//    }
    $scope.saveRest = function (){
        $http.post(url, {
           
            name:  $scope.name,
            description: $scope.description,
            town: $scope.town,
            cell: $scope.cell,
            email: $scope.email,
           street: $scope.street,
            image: $scope.image
            

        }).then(successCallback, errorCallback);
           function successCallback(response) {
                alert("Restaurant Added Successfully");
                console.log(response.data);
                $location.url('/admin');
            }
            function errorCallback(response) {
                console.log(response);
                alert("failed to add Restaurant");
            };        
    };
    
    /**Retrieving Products from the Database**/
    $http.get("/show/all/restaurant").then(function(response){
            $scope.rests = response.data;
    });  
    
 
    
    
 
      });
 
app.controller('logout',function($location,$session){
   $session.clear();
   $location.url("/login");
});  
/***
 * image helper
*** */

app.controller('productController',function($http,$scope,$location){
  alert("product Controller ");
    $scope.image = null;
    $http.defaults.headers.post["Content-Type"] = "application/json";
    var url = '/addProduct';
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
            };
        reader.readAsBinaryString(file);
        }
    };
//    if (window.File && window.FileReader && window.FileList && window.Blob) {
//       document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
//    } else {
//        alert('The File APIs are not fully supported in this browser.');
//    }
    $scope.saveProd = function (){
        $http.post(url, {
        //    u: localStorage.getItem('id'),
            name:  $scope.name,
            description: $scope.description,
            price: $scope.price,
            image: $scope.image
            

        }).then(successCallback, errorCallback);
           function successCallback(response) {
                alert("Product Added Successfully");
                console.log(response.data);
                $location.url('/addProduct');
            }
            function errorCallback(response) {
                console.log(response);
                alert("failed to add Product");
            };        
    };
    
    /**Retrieving Products from the Database**/
    $http.get("/products/all").then(function(response){
            $scope.products = response.data;
    });  
    
//    $http.post("/rest/"+$scope.rests.user_id+"/product").then(function(response){
//        //console.log($scope.rest);
//       $scope.uproduct= response.data; 
//    });
  

    
    /**
     * Cart
     */
    
    $scope.cartItems = [];
    $scope.total = 0;
    $scope.checkOut=""; 
    $scope.quantity =0;
   
    var prodAdded = false;
    $scope.addToCart = function(product){
        if($scope.cartItems.length >= 0){
           $scope.cartItems.push(product);
           console.log($scope.cartItems);
      
            localStorage.setItem('Shopping_Cart',JSON.stringify(product.name) );
      
       
        }else{
            if($scope.cartItems.length !== 0){
                alert("Product Available in cart cart");
                for(var i = 0 ; i < $scope.cartItems.length;i++){
                    alert("Checking existing product ");
                    if($scope.cartItems[i].product_id === product.product_id){
                      prodAdded = true;
                      $scope.quantity +=1;
                      localStorage.setItem('Quant',JSON.stringify($scope.quantity));
                    }else{
                         
                        $scope.cartItems.push(product);
                    }
                }
            }
            
           
        }
    
        $scope.total +=parseFloat(product.price);
       localStorage.setItem('total',JSON.stringify($scope.total));
    };
    var webUser = $scope.payy;
    var pay = {
//     
// 
//           'country':$scope.country
 };
    var order = {
        
       'email':  localStorage.getItem('id' ),
        'price': localStorage.getItem('total'),
        'name': localStorage.getItem('Shopping_Cart'),
//        'holder':  $scope.pay.holder,
//        'number': $scope.pay.number,
//        'exp': $scope.pay.exp,
//        'cvv': $scope.pay.cvv,
 };
    console.log(order);
    
 $scope.checkOut=function($scope){
 
     console.log(order);
     console.log(pay);
 $http.post('/checkout',order,pay,$location, {
        
        });
        $location.url('/payment');
        
         //localStorage.clear();
  
 
 };
 $scope.pay = function(){
      var url="/add/payment";
      var payment = $scope.payy;
      var paymentProcess= $http.post(url,payment)
              .then(function(response){
                 
      });
       $location.url('/address');
      alert("payment saved")
  };
  
  /* displaying *payment items*/
  $http.get("/all/payments").then(function(response){
      $scope.payments = response.data;
  });
  
  
  $scope.address = function(){
      var url="/add/address";
      var addresses = $scope.address;
      var paymentProcess= $http.post(url,addresses,$scope.cartItems)
              .then(function(response){
                 
      });
       $location.url('/cart');
      alert("Address")
  };
  
  /* displaying *payment items*/
  $http.get("/all/payments").then(function(response){
      $scope.payments = response.data;
      $scope.cartItems;
  });
  
 /**Retrieving Products from the Database**/
//    $http.get("/order/list").then(function(response){
//            $scope.orders = response.data;
//    });
    
    // list customer loading at the first time
	$scope.listOrders = [];
	
	// selected customer
	$scope.selectedOrder;

	// for update message
	$scope.error=false;
	$scope.putMessage;
	
	// get all customers from remote servers
	function getAllCustomer(){
		// get URL
		var url = "/order/list";
		
		// do getting
		$http.get(url).then(function (response) {
			$scope.listOrders = response.data;
			if($scope.listOrders.length){ 
				$scope.selectedOrder = $scope.listOrders[0];
			}
		}, function error(response) {
			$scope.postResultMessage = "Error Status: " +  response.statusText;
		});
	}
	
	// load data at initial loading time
	getAllCustomer();
	
	// the function to select a customer
	$scope.selectCustomer = function(index){
		if($scope.listOrders.length){
			$scope.selectedOrder = $scope.listOrders[index]; 	
		}
	}
	
	// using http PUT to update the changed customer info 
	$scope.updateCustomer = function(){
		if($scope.selectedOrder){
			// put URL
			var url = "order/update/" + $scope.selectedOrder.orderDetailsId;
			
			// prepare headers for posting
			var config = {
	                headers : {
	                	'Content-Type': 'application/json',
	                	'Accept': 'text/plain'
	                }
	        }
			
			// prepare data for put messages
			var data = $scope.selectedOrder;
			
			// do posting
			$http.post(url, data, config).then(function (response) {
                            console.log($scope.selectedOrder.orderDetailsId);
				$scope.error = false;
				$scope.putMessage = response.data;
			}, function error(response) {
				$scope.error = true;
				$scope.putMessage = "Error!";
			});
		}
	}

        function getItemIndex(item){
            for(var i=0; i< $scope.cartItems.length; i++){
                if($scope.cartItems[i].id === item.id){
                    return i;
                }
            }

            return -1;
              var count =$scope.cartItems.length();
        }

        $scope.decrease = function(item){
            var index = getItemIndex(index);
            if(item.quantity -1 === 0){
                $scope.cartItems.splice(index,1);
            }
        };

        $scope.cartSum = function(){
            var sum =0;
           
            $scope.cartItems.forEach(function(item){
                sum += item.quantity * item.price;
            });

            return sum;
        };

        $scope.increase = function(item){
            item.quantity++;
        } ;
   // $scope.addToCart();
  

    
    
});


