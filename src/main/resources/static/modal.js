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
        type:'get',
        url: '/delRest',
        data: {id: id},
        error: function(message) {
            console.log(message);
        },
        success: function() {
            // todo: попробовать document
            window.location = '/admin';
        }
    });

}

function addUser(login,password) {
    $.ajax({
        type:'post',
        url:'/addUser',
        data: {login: login, password:password},
        error: function(message) {
            console.log(message);
        },
        success: function() {
            // todo: попробовать document
            window.location = '/admin';
            //history.back();
        }
    });

}