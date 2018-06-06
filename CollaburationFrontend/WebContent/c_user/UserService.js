app.service('UserService', [
		'$http',
		'$q',
		'$rootScope',
		function($http, $q, $rootScope) {
			console.log("UserService...")
			var BASE_URL = 'http://localhost:8085/CollaborationControllers/'
			return {
				registerUser : function(user) {
					console.log("Creating user in UserService")
					return $http.post(BASE_URL + 'addUser/', user)

					.then(function(response) {
						alert("Regesteration Succcess. Wait for admin aproval")
						console.log(response.status)

						return response.data;
					}, function(errResponse) {
						console.error('Error while creating user');
						return $q.reject(errResponse);
					});
				}
			}
			} ]);
			