'use strict';
angular.module('academy_rich')
    .controller('userSignDetailCtrl', function($state,$scope, $rootScope,commonUtil,userSignService) {
        var vm = $scope.vm = {};
        vm.id = $state.params.id;

        if (vm.id) {
            userSignService.getModule(vm.id).then(function(res) {
                if (res.data.code == 0) {
                    vm.data = res.data.data.userSign;
                }else{
                    commonUtil.showErrMsg(res);
                }
            });
        }
        
        //有查看状态转为编辑状态
    vm.edit = function(){
        vm.status = 1;
        vm.noedit = false;
    };
    // 新增
    vm.add = function() {
        
        userSignService.add(vm.params).then(function(res) {
            if (res.data.code === 0) {
                

                $rootScope.alert("增加信息成功", function() {
                    vm.noedit = true;
                    vm.status=2;
                    $window.history.back();
                });
            } else {
         
               $rootScope.alert(res.data.message);
            }
        });
    };
    // 更新
    vm.update = function() {
        angular.extend(vm.params, {id: id});
        delete vm.params.createTime;
        delete vm.params.updateTime;

        userSignService.update(id, vm.params).then(function(res) {
            if (res.data.code === 0) {
                
                $rootScope.alert("更新信息成功", function() {
                    vm.noedit = true;
                    vm.status=2;
                    $window.history.back();
                });
            } else {
           
              $rootScope.alert(res.data.message);
            }
        });
    };
    // 取消
    vm.cancel = function() {
   
        $window.history.back();
    };



       

    });

 
    
