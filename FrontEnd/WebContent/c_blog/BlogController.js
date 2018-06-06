app.controller("BlogController",function ($scope,$rootScope,$location, $http,$window)
	{
	
	console.log('-----starting blog controller')

	$scope.blog={'blogId':0,'blogName':'','blogContent':'', 'createDate':'','likes':'','loginname':''};
	
	
	$scope.addBlog=function()
	{
		console.log("Entering blog information");
		
		$http.post('http://localhost:8085/CollaborationControllers/addBlog',$scope.blog)
		
		.then(function(response)
				{
			console.log(response.status);
			console.log(response.data);

			console.log("before redirecting")
			$location.path('/myblog');
				});
	};
	
	
	
	function listUserBlog()
	{
		console.log('USER Blog Method');
		$http.get('http://localhost:8085/CollaborationControllers/showUserBlogs')
		.then(function(response)
		{
			console.log("inside user blog list")
			console.log(response.data);
			$scope.userblogdata=response.data;
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
function listBlogs()
	{
		console.log('List Blog Method');
		$http.get('http://localhost:8085/CollaborationControllers/showAllApprovedBlogs')
		.then(function(response)
		{
			console.log(response.data);
			$scope.blogdata=response.data;
		});
		

	}


	function listAllBlogs()
	{
		console.log('list all blog method');
		$http.get('http://localhost:8085/CollaborationControllers/showAllBlogs')
		.then(function(response)
				{
					console.log(response.data);
					$scope.allblogdata=response.data;
				});
		
	}
	
	
	
	
	$scope.incrementLike=function(blogId)
	{
		console.log('I am in Increment Like');
		$http.get('http://localhost:8085/CollaborationControllers/incrementLike/'+blogId)
		.then(function(response)
		{
			console.log('incremented');
		});
		
	}
		
		$scope.approve=function(blogId)
		{
			console.log('I am in Approving blog');
			$http.get('http://localhost:8085/CollaborationControllers/approveBlog/'+blogId)
			.then(function(response)
			{
				console.log('Blog Approved');
				//$scope.allblogdata=response.data;
				$window.location.reload()
			
			});
			
		
	}
		$scope.reject=function(blogId)
		{
			console.log('I am in rejecting blog');
			$http.get('http://localhost:8085/CollaborationControllers/rejectBlog/'+blogId)
			.then(function(response)
			{
				console.log('Blog rejected');
				$window.location.reload()
			});
		}
		
		
		$scope.deleteBlog=function(blogId)
		{
			console.log('I am in Deleting blog');
			$http.get('http://localhost:8085/CollaborationControllers/deleteBlog/'+blogId)
			.then(function(response)
			{
				console.log('Blog deleted');
				$window.location.reload()

			});
		}
		
		
		
	listAllBlogs();
	listBlogs();
	listUserBlog();
	});
