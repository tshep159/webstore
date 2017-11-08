var app = angular.module('UsersController',[])
        .controller('UsersController',function ($http,$scope,$location,$rootScope){
        

    
$scope.register = function(){
            var url = "test/register";

            var webUser = $scope.cus;
            var vbv = $http.post(url,webUser).then(function(response){
            document.write("Welcome " +  response.data.userObject.firstName); 
            $rootScope.status = response.data.status;
            $rootScope.cname = response.data.userObject.firstName;
            });
            document.write("Succesfully Registered , \n Please login to your email to get your Login details");
            $scope.direct();
            };
        $http.get('test/list').then(function(response){
        $scope.users = response.data;
    });
 
    
$scope.delete = function(index) {
      $scope.users.splice(index,1);
  };






      $scope.login = function (){
            var url = "test/login";
            
            var customer = $scope.cus;
           
             alert(customer.password);
            
            var customerProcess = $http.post(url,customer).then(function(response){ 
                
             localStorage.setItem("user",JSON.stringify(response.data.userL));
             alert("Succesfully logged"); 
             // $scope.dd = response;
             alert("Welcome " +  response.data.userL);
             
              alert($scope.check);
             
             $scope.user = localStorage.getItem(("user"));
             localStorage.setItem("status",response.data.status);
            
               $rootScope.status = localStorage.getItem("status");
          $rootScope.cname = angular.fromJson(localStorage.getItem("user")).name;
               alert( $rootScope.cname);
               alert(localStorage.getItem("user"));
               alert($scope.user);
                $scope.direct();  
              
            });
            
               
        };

           /**************************************************/
    $scope.image = null;
   $http.defaults.headers.post["Content-Type"] = "application/json";
   var url = 'admin/addproduct';
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
       if (window.File && window.FileReader && window.FileList && window.Blob) {
           document.getElementById('filePickerImage').addEventListener('change', handleImageSelect, false);
        } else {
           alert('The File APIs are not fully supported in this browser.');
       }
       }
   };

$scope.addProduct = function(){
        $http.post(url, {
           name:  $scope.pro.name,
           description: $scope.pro.description,
           price: $scope.pro.price,
           image: $scope.pro.image,
           code : $scope.pro.code,
           quantity: $scope.pro.quantity
         

       }).then(successCallback, errorCallback);
          function successCallback(response) {
               alert("Product Added Successfully");
               console.log(response.data);
               $location.url('admin/');
           }
           function errorCallback(response) {
               console.log(response);
               alert("failed to add Product");
           };        
   };

//        var productProcess = $http.post(url,product).then(function(response)
//        {
//           alert("product has been added"); 
//           alert($rootScope.name);
//});
// };
        //retrieving product list
      $http.get('admin/listproduct').then(function(response){
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
            var url = "test/register";
         
            var restaurant = $scope.res;
            var vbv = $http.post(url,restaurant).then(function(response){
            document.write("Welcome " +  response.data.userObject.name); 
            $rootScope.status = response.data.status;
            $rootScope.cname = response.data.userObject.name;
            });
            document.write(" Restaurant Succesfully Registered ,\n\
              \n Please login to your email to get your Login details");
            $scope.direct();
            };
        $http.get('test/list').then(function(response){
        $scope.users = response.data;
    });
 

//   $scope.saveProd = function (){
//       $http.post(url, {
//           name:  $scope.name,
//           description: $scope.description,
//           price: $scope.price,
//           image: $scope.image
//         
//
//       }).then(successCallback, errorCallback);
//          function successCallback(response) {
//               alert("Product Added Successfully");
//               console.log(response.data);
//               $location.url('/admin');
//           }
//           function errorCallback(response) {
//               console.log(response);
//               alert("failed to add Product");
//           };        
//   };

   
   
   
   /**************************************************/
 
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
     
      $scope.welcome = function (){
            $location.path('/customer'); 
};
     $scope.listProduct =  function(){
         $location.path('/admin/listproduct');
     };
     
     /* restuarant*/
     $scope.listProduct =  function(){
         $location.path('/admin/addrest');
     };
     $scope.listrest=  function(){
         $location.path('/admin/listrest');
     };
     
});
