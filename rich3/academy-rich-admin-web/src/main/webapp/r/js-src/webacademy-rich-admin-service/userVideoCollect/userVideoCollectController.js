'use strict';
angular.module('academy_rich')
    .controller('userVideoCollectCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, userVideoCollectService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     userId: $state.params.userId
	                              ,  
                     	     articleId: $state.params.articleId
	                              ,  
                     	     collectionTag: $state.params.collectionTag
	                              ,  
                     	     collectAt: $state.params.collectAt
	                              ,  
                              };


    userVideoCollectService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.userVideoCollectList", vm.params,{reload:true});
    };
    });
