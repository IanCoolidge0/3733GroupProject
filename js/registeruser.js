function handleRegisterMemberClick(e) {
	var form = document.registerMemberForm;

	var choiceid = form.choiceid.value;
	var name = form.name.value;
	var password = form.password.value;


	var data = {};
	data["choiceId"] = choiceid;
	data["name"] = name;
	data["password"] = password;



	var js = JSON.stringify(data);
	console.log("JS: " + js);

	var xhr = new XMLHttpRequest();
	xhr.open("POST", registeruser_url, true);

	// send the collected data as JSON
	xhr.send(js);

	// This will process results and update HTML as appropriate.
	xhr.onloadend = function () {
		console.log(xhr);
		console.log(xhr.request);

		if(xhr.readyState == XMLHttpRequest.DONE) {
			console.log("XHR: " + xhr.responseText);
		}
	}
}
