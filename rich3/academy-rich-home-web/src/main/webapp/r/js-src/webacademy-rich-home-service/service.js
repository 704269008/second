'use strict';
angular.module('academy_rich')

    .factory('pathProject', function (commonUtil) {
        return {
                	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                                   ,  
                        
          
         
         	     wechatData: function (id) {
                if (!id) {
                    return "ajax/u/wechatData";
                } else {
                    return "ajax/u/wechatData/" + id;
                }
            },
          wechatData_list: "ajax/u/wechatData/search"
          
                        
          
         
         
        }
    })
    
           
	    .factory('userService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.user(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.user(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.user_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.user(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.user(id));
            }
           
        }
    })
                
	    .factory('userSignService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.userSign(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.userSign(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.userSign_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.userSign(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.userSign(id));
            }
           
        }
    })
                
	    .factory('articleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.article(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.article(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.article_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.article(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.article(id));
            }
           
        }
    })
                
	    .factory('userArticleUpvoteService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.userArticleUpvote(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.userArticleUpvote(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.userArticleUpvote_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.userArticleUpvote(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.userArticleUpvote(id));
            }
           
        }
    })
                
	    .factory('userArticleCollectService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.userArticleCollect(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.userArticleCollect(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.userArticleCollect_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.userArticleCollect(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.userArticleCollect(id));
            }
           
        }
    })
                
	    .factory('videoService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.video(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.video(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.video_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.video(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.video(id));
            }
           
        }
    })
                
	    .factory('userVideoUpvoteService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.userVideoUpvote(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.userVideoUpvote(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.userVideoUpvote_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.userVideoUpvote(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.userVideoUpvote(id));
            }
           
        }
    })
                
	    .factory('userVideoCollectService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.userVideoCollect(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.userVideoCollect(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.userVideoCollect_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.userVideoCollect(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.userVideoCollect(id));
            }
           
        }
    })
                
	    .factory('teacherService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.teacher(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.teacher(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.teacher_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.teacher(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.teacher(id));
            }
           
        }
    })
                
	    .factory('wechatDataService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.wechatData(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.wechatData(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.wechatData_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.wechatData(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.wechatData(id));
            }
           
        }
    })
             
   
    ;






