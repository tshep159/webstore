'use strict';

var services = angular.module('ngdemoApp.services', ['ngResource']);



services.factory('UsersFactory', function ($resource) {
    return $resource('/users', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('UserFactory', function ($resource) {
    return $resource( '/users/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});
