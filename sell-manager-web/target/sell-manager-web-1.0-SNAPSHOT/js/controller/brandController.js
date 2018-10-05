app.controller("brandController",function ($scope, $controller, brandService) {

    //继承baseController
    $controller("baseController",{$scope:$scope});

    //查询全部品牌
    $scope.findAll=function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        )
    };

    //品牌分页查询
    $scope.findPage=function (page,size) {
        brandService.findPage(page,size).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    };

    //增加品牌
    $scope.save = function () {
        var object = null;
        if ($scope.entity.id!=null){
            object = brandService.update($scope.entity);
        }else{
            object = brandService.add($scope.entity);
        }
        object.success(
            function (response) {
                if (response.success){
                    $scope.reloadList();
                } else{
                    alert(response.message);
                }
            }
        )
    };

    //查询单个
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        )
    };

    //删除
    $scope.delete = function () {
        brandService.delete($scope.selectIds).success(
            function (response) {
                if (response.success){
                    $scope.reloadList();
                    $scope.selectIds=[];
                } else{
                    alert("删除失败");
                }
            }
        )
    }

});