function validateRegFormData() {
	let fullName = document.form1.n1.value;
	if(fullName == "") {
		alert("Full Name should not be empty");
		return false;
	}
	
	let phoneNumber = document.form1.n2.value;
	if(phoneNumber == "") {
		alert("phone Number should not be empty");
		return false;
	}
	
	else{
		alert("Data is OK");
		return true;
	}
}





