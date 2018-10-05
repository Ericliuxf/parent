app.service("brandService",function ($http) {
    //查询全部
    this.findAll= function () {
        return $http.get( '../brand/findAll.do');
    };

    //分页查询
    this.findPage = function (page,size) {
        return $http.get('../brand/findPage.do?page='+page+'&size='+size);
    };

    //保存
    this.add = function (entity) {
        return $http.post('../brand/add.do',entity);
    };

    //查询单个
    this.findOne = function (id) {
        return $http.get('../brand/findOne.do?id='+id);
    };

    //更新
    this.update = function (entity) {
        return $http.post('../brand/update.do',entity);
    };

    //批量删除
    this.delete = function (ids) {
        return  $http.get('../brand/delete.do?ids='+ids);
    }

    //商品列表
    this.selectOptionList=function () {
        return $http.post('../brand/selectOptionList.do');
    }

});