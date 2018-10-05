app.controller("baseController",function ($scope) {

    $scope.paginationConf = {
        currentPage : 1,        //当前页
        totalItems : 10,         //总记录数
        itemsPerPage : 10,      //每页记录数
        perPageOptions : [10,20,30,40,50],
        onChange: function () {
            $scope.reloadList();
        }
    };

    $scope.reloadList = function(){
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };
    
    //复选框
    $scope.selectIds = [];
    $scope.updateSelectionIds = function ($event,id) {
        if ($event.target.checked){
            $scope.selectIds.push(id);
        }else{
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }
    };
});