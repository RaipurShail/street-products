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

function removeDuplicatesFromArray(arr){
	let uniqueArray = Array.from(new Set(arr))
	return uniqueArray
}

function searchProductsList(response){
	var arrayDuplicates = [];
	var searchArr=JSON.stringify(response);
	
	var keys = Object.keys(response);
	for(var i=0; i<keys.length;i++){
		var innerKeys = Object.keys(response[keys[i]]);
		for (var j = 0; j < innerKeys.length; j++) {
			var key = innerKeys[j];
			//var value = response[keys[i]][key];
			var manufacturer = response[keys[i]]["manufacturer"];
			var productName = response[keys[i]]["productName"];
			arrayDuplicates.push(productName+" By "+manufacturer);
		}
	}
	return removeDuplicatesFromArray(arrayDuplicates);
}