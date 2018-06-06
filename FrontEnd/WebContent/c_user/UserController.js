app.controller("UserController",function ($scope,$rootScope,$location, $http,$cookies)
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
			/*$cookies.put('user',response.data);
			console.log($rootScope.currentUser);
			*/
			console.log('heloooo')
			console.log($rootScope.currentUser);
			$http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser;
			$cookies.putObject('currentUser',response.data)
			var cookie = $cookies.get('currentUser')
            console.log(cookie)
            console.log($cookies.get('currentUser'))
            
			$location.path("/home");
				});
	}
/*$scope.logout=function()
{
	console.log('Enter into the logout Function');
delete $rootscope.currentUser;
$cookies.remove('currentuser');
$location.path("/logout");
}
	*/
	
	
	$scope.logout= function()
	{
		console.log("Entering Logout Function");
		$rootScope.currentUser = {};
		$cookies.remove('currentUser');
		
		console.log("Calling Session Logout");
		UserService.logout()
        alert("Successfully Logout...");

		$location.path('/login');
	};
});
		
		
		
		
/*UserService.registerUser($scope.user)
.then(
		function(d) {
			$location.path("/")
			$scope.user=d;
		},
		function(errResponse) {
			console.error('Error while creating user');*/
		