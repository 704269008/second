'use strict';
angular.module('academy_rich')
    .controller('userCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, userService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     openid: $state.params.openid
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     grade: $state.params.grade
	                              ,  
                     	     avatar: $state.params.avatar
	                              ,  
                     	     phone: $state.params.phone
	                              ,  
                     	     email: $state.params.email
	                              ,  
                     	     area: $state.params.area
	                              ,  
                     	     status: $state.params.status
	                              ,  
                     	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     createAt: $state.params.createAt
	                	     updateAt: $state.params.updateAt
	                         };


    userService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.userList", vm.params,{reload:true});
    };
    });
