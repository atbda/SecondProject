app.controller("ForumController",function ($scope,$rootScope,$location, $http,$window)
	{
	
	console.log('-----starting forum controller')

	$scope.forum={'forumId':0,'forumName':'','forumContent':'', 'createDate':'','likes':'','loginname':''};
	
	
	$scope.addForum=function()
	{
		console.log("Entering forum information");
		
		$http.post('http://localhost:8085/CollaborationControllers/addForum',$scope.forum)
		
		.then(function(response)
				{
			console.log(response.status);
			console.log(response.data);

			console.log("before redirecting")
			$location.path('/myforum');
				});
	};
	
	
	
	function listUserForum()
	{
		console.log('USER Forum Method');
		$http.get('http://localhost:8085/CollaborationControllers/showUserForums')
		.then(function(response)
		{
			console.log("inside user forum list")
			console.log(response.data);
			$scope.userforumdata=response.data;
		});
		

	}
	/*
	$scope.addBlog=function()
		{
			console.log("Entering Add Blog")
		
			.then
			(
					function(response)
					{
						alert("Blog Added. Waiting for admin approval")
						console.log("Add Blog Success "+response.status)
						$location.path("/viewBlogs")
					}
			
		
			);
		}
*/
function listForums()
	{
		console.log('List Forum Method');
		$http.get('http://localhost:8085/CollaborationControllers/showAllApprovedForums')
		.then(function(response)
		{
			console.log(response.data);
			$scope.forumdata=response.data;
		});
		

	}


	function listAllForums()
	{
		console.log('list all forum method');
		$http.get('http://localhost:8085/CollaborationControllers/showAllForums')
		.then(function(response)
				{
					console.log(response.data);
					$scope.allforumdata=response.data;
				});
		
	}
	
	
	
	
	$scope.incrementLike=function(forumId)
	{
		console.log('I am in Increment Like');
		$http.get('http://localhost:8085/CollaborationControllers/incrementLike/'+forumId)
		.then(function(response)
		{
			console.log('incremented');
		});
		
	}
		
		$scope.approve=function(forumId)
		{
			console.log('I am in Approving forum');
			$http.get('http://localhost:8085/CollaborationControllers/approveForum/'+forumId)
			.then(function(response)
			{
				console.log('Forum Approved');
				//$scope.allforumdata=response.data;
				$window.location.reload()
			
			});
			
		
	}
		$scope.reject=function(forumId)
		{
			console.log('I am in rejecting forum');
			$http.get('http://localhost:8085/CollaborationControllers/rejectForum/'+forumId)
			.then(function(response)
			{
				console.log('Forum rejected');
				$window.location.reload()
			});
		}
		
		
		$scope.deleteForum=function(forumId)
		{
			console.log('I am in Deleting forum');
			$http.get('http://localhost:8085/CollaborationControllers/deleteForum/'+forumId)
			.then(function(response)
			{
				console.log('Forum deleted');
				$window.location.reload()

			});
		}
		
		
		
	listAllForums();
	listForums();
	listUserForum();
	});
