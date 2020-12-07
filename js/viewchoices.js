function handlePageLoad() {
	
	var data = {};
	data["memberId"] = window.myMemberId;
	data["choiceId"]
	
	var js = JSON.stringify(data);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", viewchoices_url, true);
	
	xhr.send(js);

	// This will process results and update HTML as appropriate.
	xhr.onloadend = function () {
		console.log(xhr);
		console.log(xhr.request);

		if(xhr.readyState == XMLHttpRequest.DONE) {
			console.log("XHR: " + xhr.responseText);
		}
		var response = JSON.parse(xhr.responseText);
		document.getElementById("choiceName").innerHTML = response["choice"]["name"];
		document.getElementById("choiceDesc").innerHTML = response["choice"]["description"];
		
		var i;
		var j;
		
		var size = response["alternatives"].length;
		for(i = 0; i < size; i++) {
			for(j = 0; j < size; j++) {
				if(response["alternatives"][j].number === i) {
					document.getElementById("alt" + i).innerHTML = response["alternatives"][j].name;
					break;
				}
			}
		}
		
		var allApprovals = [];
		for(j = 0; j < size; j++) allApprovals[j] = [];
		var allDisapprovals = [];
		for(j = 0; j < size; j++) allDisapprovals[j] = [];
		
		var appSize = response["approvals"].length;
		for(i = 0; i < appSize; i++) {
			for(j = 0; j < size; j++) {
				if(response["approvals"][i]["alternativeId"] === response["alternatives"][j]["id"]) {
					if(response["approvals"][i]["isApproval"]) {
						allApprovals[j].push(response["approvals"][i]["memberName"]);
					} else {
						allDisapprovals[j].push(response["approvals"][i]["memberName"]);
					}
				}
			}
		}
		
		for(j = 0; j < size; j++) {
			var pTag = document.getElementById("alt" + j + "app");
			
			if(allApprovals[j].length > 0) {
				pTag.innerHTML = "Approvals: ";
				for(i = 0; i < allApprovals[j].length; i++) {
					pTag.innerHTML += allApprovals[j][i] + ", ";
				}
			}
			
			if(allDisapprovals[j].length > 0) {
				pTag.innerHTML += "  Disapprovals: ";
				for(i = 0; i < allDisapprovals[j].length; i++) {
					pTag.innerHTML += allDisapprovals[j][i] + ", ";
				}
			}
		}
	}
}

function handleApproval(altNumber, isApproval) {
	
}