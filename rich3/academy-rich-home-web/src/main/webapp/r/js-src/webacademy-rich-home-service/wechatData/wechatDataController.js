'use strict';
angular.module('academy_rich')
    .controller('wechatDataCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, wechatDataService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     openId: $state.params.openId
	                              ,  
                     	     accessToken: $state.params.accessToken
	                              ,  
                     	     emailCode: $state.params.emailCode
	                              ,  
                     	     phoneCode: $state.params.phoneCode
	                              ,  
                     	     emailCodeTimes: $state.params.emailCodeTimes
	                              ,  
                     	     phoneCodeTimes: $state.params.phoneCodeTimes
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     updateBy: $state.params.updateBy
	                              ,  
                     	     createAt: $state.params.createAt
	                	     updateAt: $state.params.updateAt
	                         };


    wechatDataService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.wechatDataList", vm.params,{reload:true});
    };
    });
