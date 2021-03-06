
app.controller("FriendController",function($scope,$rootScope,$http,$location)
{

	$scope.friend={friendId:0,loginname:'',friendloginname:'',status:''};
	
	$scope.friendList;
	
	$scope.pendingFriendList;
	
	$scope.suggestedFriendList;
	
	function showFriendList()
	{
		console.log('--I am in show Friend List--');
		$scope.friend.loginname=$rootScope.currentUser.loginname;
		$scope.friend.friendloginname=loginname;
		$http.post('http://localhost:8085/CollaborationControllers/showFriendList')
		.then(function(response)
				{
				$scope.friendList=response.data;
				console.log($scope.friendList);
				});
	}
	
	function showPendingFriendList()
	{
		console.log('--I am in show Pending Friend List--');
		$http.get('http://localhost:8085/CollaborationControllers/showPendingFriendRequest')
		.then(function(response)
				{
				$scope.pendingFriendList=response.data;
				console.log($scope.pendingFriendList);
				});
	}
	
	function showSuggestedFriendList()
	{
		console.log('--I am in show Suggested Friend List--');
		$http.get('http://localhost:8085/CollaborationControllers/showSuggestedFriend')
		.then(function(response)
				{
				$scope.suggestedFriendList=response.data;
				console.log($scope.suggestedFriendList);
				});
	}
	
	showFriendList();

	showPendingFriendList();
	
	showSuggestedFriendList();
	
	$scope.sendFriendRequest=function(loginname)
	{
		console.log('--I am in sendFriendRequest----');
		$scope.friend.loginname=$rootScope.currentUser.loginname;
		$scope.friend.friendloginname=loginname;
		$http.post('http://localhost:8085/CollaborationControllers/sendFriendRequest',$scope.friend)
		.then(function(response)
				{
					console.log('Friend');
					console.log(response.statusText);
					$location.path("/showFriend")
				});
	}
	
	$scope.deleteFriend=function(friendId)
	{
		console.log('---I am in Delete Friend----');
		$http.get('http://localhost:8085/CollaborationControllers/deleteFriendRequest/'+friendId)
		.then(function(response)
				{
				console.log(response.statusText);
				$location.path("/showPendingFriend");
				});
	}
	
	$scope.acceptFriend=function(friendId)
	{
		console.log('---I am in Accept Friend----');
		$http.get('http://localhost:8085/CollaborationControllers/acceptFriendRequest/'+friendId)
		.then(function(response)
				{
				console.log(response.statusText);
				$location.path("/showPendingFriend");
				});
	}
	
});
