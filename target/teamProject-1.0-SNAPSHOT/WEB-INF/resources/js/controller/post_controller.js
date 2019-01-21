'use strict';

angular.module('myApp').controller('PostController', ['$scope', 'PostService', function($scope, PostService) {
    var self = this;
    self.post={id:null,user_id:'',post:'',created:''};
    self.posts=[];
    self.routeid=null;

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    
    
    fetchAllRoutePosts(self.routeid);
//    fetchAllRoutePosts(routeid);

    function fetchAllRoutePosts(id){
        PostService.fetchAllRoutePosts(id)
            .then(
            function(d) {
                self.posts = d;
            },
            function(errResponse){
                console.error('Error while fetching Posts');
            }
        );
    }

    function createPost(post){
        PostService.createPost (post)
            .then(
            fetchAllRoutePosts,
            function(errResponse){
                console.error('Error while creating post');
            }
        );
    }

    function updatePost(post, id){
        PostService.updatePost (post, id)
            .then(
            fetchAllRoutePosts,
            function(errResponse){
                console.error('Error while updating Post');
            }
        );
    }

    function deletePost(id){
        PostService.deletePost (id)
            .then(
            fetchAllRoutePosts,
            function(errResponse){
                console.error('Error while deleting post');
            }
        );
    }

    function submit() {
        if(self.user.id===null){
            console.log('Saving New Post', self.post);
            createPost(self.post);
        }else{
            updatePost(self.post, self.post.id);
            console.log('User updated with id ', self.post.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.posts.length; i++){
            if(self.posts[i].id === id) {
                self.post = angular.copy(self.posts[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.post.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deletePost(id);
    }


    function reset(){
        self.post={id:null,user_id:'',post:'',created:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
