'use strict';
angular.module('academy_rich')
    .controller('videoCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, videoService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     title: $state.params.title
	                              ,  
                     	     type: $state.params.type
	                              ,  
                     	     img: $state.params.img
	                              ,  
                     	     url: $state.params.url
	                              ,  
                     	     grade: $state.params.grade
	                              ,  
                     	     subject: $state.params.subject
	                              ,  
                     	     summary: $state.params.summary
	                              ,  
                     	     content: $state.params.content
	                              ,  
                     	     collection: $state.params.collection
	                              ,  
                     	     upvote: $state.params.upvote
	                              ,  
                     	     status: $state.params.status
	                              ,  
                     	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                	     createAt: $state.params.createAt
	                	     updateAt: $state.params.updateAt
	                         };


    videoService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.videoList", vm.params,{reload:true});
    };
    });
