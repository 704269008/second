'use strict';
angular.module('academy_rich')

    .factory('pathProject', function (commonUtil) {
        return {
                	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                                   ,  
                        
          
         
         	     roleModule: function (id) {
                if (!id) {
                    return "ajax/u/roleModule";
                } else {
                    return "ajax/u/roleModule/" + id;
                }
            },
          roleModule_list: "ajax/u/roleModule/search"
          
                        
          
         
         
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
                
	    .factory('accountService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.account(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.account(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.account_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.account(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.account(id));
            }
           
        }
    })
                
	    .factory('roleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.role(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.role(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.role_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.role(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.role(id));
            }
           
        }
    })
                
	    .factory('moduleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.module(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.module(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.module_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.module(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.module(id));
            }
           
        }
    })
                
	    .factory('roleModuleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.roleModule(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.roleModule(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.roleModule_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.roleModule(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.roleModule(id));
            }
           
        }
    })
             
   
    ;






