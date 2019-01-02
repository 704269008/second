'use strict';
angular.module('academy_rich')
    .controller('userVideoUpvoteCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, userVideoUpvoteService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     userId: $state.params.userId
	                              ,  
                     	     articleId: $state.params.articleId
	                              ,  
                     	     upvoteTag: $state.params.upvoteTag
	                              ,  
                     	     upvoteAt: $state.params.upvoteAt
	                              ,  
                              };


    userVideoUpvoteService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.userVideoUpvoteList", vm.params,{reload:true});
    };
    });
