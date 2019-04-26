// RestGet = function () {
//     $.ajax({
//         type: 'GET',
//         url: '/getLogin?id=2',
//         dataType: 'json',
//         error: function (jqXHR, textStatus, errorThrown) {
//             alert(jqXHR.responseText);
//         },
//         success: function (data) {
//             $('#login-input-edit').val(data.id);
//         }
//     });
//     $('#myModal').modal();
// }
//


function ResponseGet(id) {
    $.ajax({
        type: 'GET',
        url: '/getResp?id=' + id,
        //dataType: 'json',
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
            alert(data.id);
        },
        success: function (data) {
            alert(data.id + ' ' + data.login + ' ' + data.password);
            $("#id-resp").text(data.id);
            $('#myModal').modal();
        }

    });
}

function UserGet(id, login, password) {
    $.ajax({
        type: 'GET',
        url: '/getUser',
        data: {id: id, login: login, password: password},
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        },
        success: function () {
            alert("hey");
        }
    });

}
