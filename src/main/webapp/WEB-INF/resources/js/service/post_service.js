'use strict';

angular.module('myApp').factory('PostService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/posts/';   

    var factory = {
        fetchAllRoutePosts: fetchAllRoutePosts,
        createPost: createPost,
        updatePost: updatePost,
        deletePost: deletePost
    };

    return factory;

    function fetchAllRoutePosts(id) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Posts');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createPost(post) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, post)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updatePost(post, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deletePost(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
