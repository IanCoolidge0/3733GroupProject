
function handleCreateChoiceClick(e) {
	var form = document.createChoiceForm;
	
	var name = form.choice.value;
	var description = form.description.value;
	var numParticipants = form.numparticipants.value;
	
	var alt1 = form.alternative1.value;
	var alt2 = form.alternative2.value;
	var alt3 = form.alternative3.value;
	var alt4 = form.alternative4.value;
	var alt5 = form.alternative5.value;
	
	var data = {};
	data["title"] = name;
	data["description"] = description;
	data["alternatives"] = [];
	
	data["alternatives"].push(alt1);
	data["alternatives"].push(alt2);
	if(alt3 != "") data["alternatives"].push(alt3);
	if(alt4 != "") data["alternatives"].push(alt4);
	if(alt5 != "") data["alternatives"].push(alt5);
	
	console.log("JS: " + js);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", createchoice_url, true);
	
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