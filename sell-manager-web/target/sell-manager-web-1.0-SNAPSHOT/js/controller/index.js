app.controller('indexController',function($scope,loginService){
    //显示登陆名
   $scope.showLoginName = function () {
        loginService.loginName().success(
            function (response) {
                $scope.loginName = response.loginName;
        })
   }


});