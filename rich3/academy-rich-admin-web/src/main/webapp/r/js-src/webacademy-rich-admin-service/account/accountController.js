'use strict';
angular.module('academy_rich')
    .controller('accountCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, accountService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     roleId: $state.params.roleId
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     password: $state.params.password
	                              ,  
                     	     salt: $state.params.salt
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     updateBy: $state.params.updateBy
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     updateAt: $state.params.updateAt
	                              ,  
                              };


    accountService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.accountList", vm.params,{reload:true});
    };
    });
