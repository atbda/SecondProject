app.controller("UserController",function ($scope, UserService,$rootScope,$location,$cookieStore, $http)
	{
	
	console.log('-----starting controller')

	$scope.user={loginname:'', password:'', userName:'', emailId:'', mobileNo:'', address:'', role:''};
	
	$scope.registerUser=function()
	{
		console.log("Entering Register User")
		$scope.user.role='ROLE_USER';
		$http.post('http://localhost:8085/CollaborationControllers/registerUser',$scope.user)
		
		.then(function(response)
				{
			console.log('Registration Successful');
			console.log(response.statusText);
			$location.path("/login");
				});
	}
	$scope.login=function()
	{
		console.log('Enter the login function');
$http.post('http://localhost:8085/CollaborationControllers/checklogin',$scope.user)
		
		.then(function(response)
				{
			$scope.user=response.data;
			$rootScope.currentUser=response.data;
			$CookieStore.put('user',response.data);
			$location.path("/home");
				});
	}

});
		
		
		
		
/*UserService.registerUser($scope.user)
.then(
		function(d) {
			$location.path("/")
			$scope.user=d;
		},
		function(errResponse) {
			console.error('Error while creating user');*/
		