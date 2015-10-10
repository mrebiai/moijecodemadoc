angular.module('moijecodemadoc').factory('MaDocResource', function($resource){
    var resource = $resource('rest/madocs/:MaDocId',{MaDocId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});