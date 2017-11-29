function validateEmail($email) {
  var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
  return emailReg.test( $email );
}

function submitForm(formId) {
	document.getElementById(formId).submit();
}

function submitForm_Action(formId, actionName) {
	form=document.getElementById(formId);
    form.action=actionName;
    form.submit();
}