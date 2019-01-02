'use strict';
angular.module('academy_rich')
    .controller('roleModuleCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, roleModuleService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     roleId: $state.params.roleId
	                              ,  
                     	     moduleId: $state.params.moduleId
	                              ,  
                              };


    roleModuleService.getList(vm.params).then(function(res) {
        if (res.data.code === 0) {
            vm.list = res.data.data;
            vm.page = {
                next: res.data.next || 0,
                size: res.data.size || 0,
                page: res.data.page || 0,
                total: res.data.total || 0
            };
        } else {
            $rootScope.alert(res.data.message);
        }
    });
  

    vm.search = function() {
        
        $state.go("field.roleModuleList", vm.params,{reload:true});
    };
    });
