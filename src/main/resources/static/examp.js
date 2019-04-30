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
        //type: 'GET',
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

function printUser(id, login) {
    $.ajax({
        //type: 'GET',
        url: '/printUser',
        data: {id: id, login: login},
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        },
        success: function () {
            alert("hey");
        }
    });
}

function getUsers() {
    $.ajax({
        url: '/getUsers',
        //type: 'get',
        error: function (message) {
            console.log(message);
        },
        success: function (data) {
            var table = document.getElementById("users_table");
            for (var i = 0; i < data.length; i++) {
                var row = table.insertRow(i + 1);
                var cellId = row.insertCell(0);
                var cellLogin = row.insertCell(1);
                var cellPassword = row.insertCell(2);
                var cellRoles = row.insertCell(3)
                cellId.innerHTML = data[i].id;
                cellLogin.innerHTML = data[i]["login"];
                cellPassword.innerHTML = data[i]['password'];
                for (var j = 0; j < data[i].roles.length; j++) {
                    cellRoles.innerHTML = data[i].roles[j]['role'];
                }
            }
        }
    })
}