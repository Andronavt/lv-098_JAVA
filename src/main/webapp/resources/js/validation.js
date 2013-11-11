function validateRegForm() {

    $('#registration').validate();

    $('#btn').click(function () {
        if ($("#registration").valid()) {
        	doAjaxPostRegistration();
        }
    });
}