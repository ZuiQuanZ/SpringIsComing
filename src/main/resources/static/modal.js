function showModal(id, login, password) {

    $('#id-input-edit-hidden').val(id);
    $('#login-input-edit').val(login);
    $('#pass-input-edit').val(password);
    $('#myModal').modal();
}


$(document).ready(function () {
    $("#edit-submit").click(function () {
        $("#edit-form").submit();
    })
})

function delRest(id) {
    $.ajax({
        type: 'get',
        url: '/delRest',
        data: {id: id},
        error: function (message) {
            console.log(message);
        },
        success: function () {
            // todo: попробовать document
            window.location = '/admin';
        }
    });

}

// function addUser(login, password) {
//     var idRoles = [];
//     idRoles = $('#rol').val();
//     $.ajax({
//         type: 'post',
//         url: '/addUser',
//         data: {login: login, password:password},
//         error: function (message) {
//             console.log(message);
//             ajaxGet();
//             $('#myTab a[href="#user-panel"]').tab('show');
//         },
//         success: function () {
//             ajaxGet();
//             $('#myTab a[href="#user-panel"]').tab('show');
//         }
//     });
//
// }

function addUser(login, password) {
    var idRoles = [];
    idRoles = $('#rol').val();
    $.ajax({
        type: 'post',
        url: '/addUser',
        data: JSON.stringify(idRoles),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        error: function (message) {
            console.log(message);
            ajaxGet();
            $('#myTab a[href="#user-panel"]').tab('show');
        },
        success: function () {
            ajaxGet();
            $('#myTab a[href="#user-panel"]').tab('show');
        }
    });

}

$(document).ready(function() {
    ajaxGet();
})

function ajaxGet(){
    $.ajax({
        type : "GET",
        url :  "/getUsers",
        success: function(result){
            $('#users_table tbody').empty();
            $.each(result, function(i, user){
                var userRow = '<tr>' +
                    '<td>' + user.id + '</td>' +
                    '<td>' + user.login + '</td>' +
                    '<td>' + user.password + '</td>' +
                    '<td>' + getRoles(user.roles) +'</td>'+
                    '<td> \n' +
                    '<div class="btn-group-vertical btn-group-xs"> \n'+
                    '<a onclick="showModal(' + user.id + ',\'' + user.login +'\',\'' + user.password +'\')" \n' +
                    'class="btn btn-default"> \n' +
                    '<i class="glyphicon glyphicon-pencil"></i>Edit</a> \n' +
                    '<a class="btn btn-success"\n' +
                    'onclick="delRest(' + user.id + ')"><i class="glyphicon glyphicon-trash"></i>Delete</a> \n' +
                    '</div></td> \n'+
                    '</tr>';

                $('#users_table tbody').append(userRow);

            });

        },
        error : function(message) {
            console.log(message);
        }
    });
}

function getRoles(roles) {
    var roleList = '';
    if (roles.length==0){
        roleList='anonymus';
    }
    for(var i=0; i<roles.length;i++){
        roleList+=roles[i].role;
        roleList+=' ';
    }
    return roleList;
}