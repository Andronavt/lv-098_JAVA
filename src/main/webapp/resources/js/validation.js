function validateRegForm() {

    $('#loginform').validate();

    $('#btn').click(function () {
        if ($("#loginform").valid()) {
        	doAjaxPostRegistration();
        }
    });
<<<<<<< HEAD
}
=======
}
>>>>>>> 362cec57dcceece1c58bdc48eb73cc759bfd2045
