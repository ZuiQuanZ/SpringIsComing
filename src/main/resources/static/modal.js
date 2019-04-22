
    function showModal(id,login,password) {

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
