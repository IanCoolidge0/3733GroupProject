
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
	
	
	// 8digit-4digit-4digit-4digit-12digit
	var p1 = (Math.floor(Math.random()*90000000) + 10000000).toString;
	var p2 = (Math.floor(Math.random()*9000) + 1000).toString;
	var p3 = (Math.floor(Math.random()*9000) + 1000).toString;
	var p4 = (Math.floor(Math.random()*9000) + 1000).toString;
	var p5a = (Math.floor(Math.random()*90000000) + 10000000).toString;
	var p5b = (Math.floor(Math.random()*9000) + 1000).toString;
	var newId = string.concat(p1,"-",p2,"-",p3,"-",p4,"-",p5a,p5b);
	
	data["id"] = newId;
	
	var js = JSON.stringify(data);
	console.log("JS: " + js);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", createchoice_url, true);
	//xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
	//xhr.setRequestHeader("Content-Type", "application/json");
	
	// This will process results and update HTML as appropriate.
	xhr.onloadend = function () {
		console.log(xhr);
		console.log(xhr.request);
		
		if(xhr.readyState == XMLHttpRequest.DONE) {
			console.log("XHR: " + xhr.responseText);
		}
	};
	//window.location.replace('https://3733quakec.s3.us-east-2.amazonaws.com/presentations/registeruser.html?'+choiceid);
	
	// send the collected data as `JSON
	xhr.send(js);
	
	window.location.replace("https://3733quakec.s3.us-east-2.amazonaws.com/presentations/registeruser.html?"+newId);
}
