var app = angular.module('collaboration', [ 'ngRoute','ngCookies']);
app.config(function($routeProvider, $locationProvider)

{
	$locationProvider.hashPrefix('');

	$routeProvider.when('/', {templateUrl : 'template/index.html'})
	.when('/login', {templateUrl : 'template/Login.html'})

	.when('/register', {templateUrl : 'template/Register.html'})
	.when('/contactUs', {templateUrl : 'template/ContactUs.html'})
	.when('/aboutUs', {templateUrl : 'template/AboutUs.html'})
	.when('/home', {templateUrl : 'c_user/home.html'})
	.when('/logout', {templateUrl : 'c_user/Logout.html'})
	.when('/updateProfile', {templateUrl : 'c_user/ProfilePicture.html'})
	
		.when('/blog', {templateUrl : 'c_blog/blog.html','controller':'BlogController'	})
		.when('/myblog', {templateUrl : 'c_blog/MyApprovedBlogs.html','controller':'BlogController'})
		.when('/allblog', {templateUrl : 'c_blog/AllUserBlog.html'})
		.when('/allapprovedblog', {templateUrl : 'c_blog/ShowAllApprovedBlogs.html'})
		.when('/showblog', {templateUrl : 'c_blog/ShowAllBlogs.html'})
		.when('/adminblog', {templateUrl : 'c_blog/AdminBlog.html'})
		
		
		
		.when('/forum', {templateUrl : 'c_forum/forum.html','controller':'ForumController'})
		.when('/myforum', {templateUrl : 'c_forum/MyApprovedForums.html','controller':'ForumController'})
		.when('/allforum', {templateUrl : 'c_forum/AllUserForum.html'})
		.when('/allapprovedforum', {templateUrl : 'c_forum/ShowAllApprovedForums.html'})
		.when('/showforum', {templateUrl : 'c_forum/ShowAllForums.html'})
		.when('/adminforum', {templateUrl : 'c_forum/AdminForum.html'})
			
		
		.when('/publishjob', {templateUrl : 'c_job/PublishJob.html'})
		.when('/jobdetail', {templateUrl : 'c_job/JobDetail.html'})
		
		
		.when('/showFriend', {templateUrl : 'c_friend/ShowFriend.html'})
		.when('/showSuggestedFriend', {templateUrl : 'c_friend/ShowSuggestedFriend.html'})
		.when('/showPendingFriend', {templateUrl : 'c_friend/ShowPendingFriendList.html'})



	
});

app.run(function($rootScope,$cookies,$http)
{
	console.log('I am in run function');
console.log($rootScope.currentUser);

$rootScope.currentUser = $cookies.getObject('currentUser') || {};
if ($rootScope.currentUser) {
	$http.defaults.headers.common['Authorization'] = 'Basic'
			+ $rootScope.currentUser;
}
});