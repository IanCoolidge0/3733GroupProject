function handlePageLoad() {
	
	var data = {};
	data["memberId"] = window.myMemberId;
	data["choiceId"] = window.myChoiceId;
	
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
		document.getElementById("choiceName").innerHTML = "<p style="text-align:center;">" + response["choice"]["name"] + "</p>";
		document.getElementById("choiceDesc").innerHTML = "<p style="text-align:center;">" + response["choice"]["description"] + "</p>";
		
		var i;
		var j;
		
		var size = response["alternatives"].length;
		for(i = 1; i < size + 1; i++) {
			for(j = 0; j < size; j++) {
				if(response["alternatives"][j].number === i) {
					document.getElementById("alt" + i).innerHTML = response["alternatives"][j].name;
					break;
				}
			}
		}
		
		var allApprovals = [];
		for(j = 1; j < size + 1; j++) allApprovals[j] = [];
		var allDisapprovals = [];
		for(j = 1; j < size + 1; j++) allDisapprovals[j] = [];
		
		var appSize = response["approvals"].length;
		for(i = 0; i < appSize; i++) {
			for(j = 0; j < size; j++) {
				if(response["approvals"][i]["alternativeId"] === response["alternatives"][j]["id"]) {
					if(response["approvals"][i]["isApproval"]) {
						allApprovals[response["alternatives"][j]["number"]].push(response["approvals"][i]["memberName"]);
					} else {
						allDisapprovals[response["alternatives"][j]["number"]].push(response["approvals"][i]["memberName"]);
					}
				}
			}
		}
		
		for(j = 1; j < size + 1; j++) {
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
		
		// make extra alternatives invisible
		for(j = size + 1; j <= 5; j++) {
			console.log("here for j = " + j);
			document.getElementById("alt" + j).style.display = "none";
			document.getElementById("app" + j).style.display = "none";
			document.getElementById("dis" + j).style.display = "none";
			document.getElementById("alt" + j + "app").style.display = "none";
		}
		
		window.lastViewResponse = response;
	}
}

function handleApproval(altNumber, isApproval) {
	var data = {};
	data["memberId"] = window.myMemberId;
	data["name"] = ""; // obsolete
	var i;
	var response = window.lastViewResponse;
	for(i = 0; i < response["alternatives"].length; i++) {
		if(response["alternatives"][i]["number"] === altNumber) {
			data["alternativeId"] = response["alternatives"][i]["id"];
			break;
		}
	}
	
	var js = JSON.stringify(data);
	console.log("approval data: ");
	console.log(data);
	
	var xhr = new XMLHttpRequest();
	if(isApproval)
		xhr.open("POST", selectapproval_url, true);
	else
		xhr.open("POST", selectdisapproval_url, true);
	
	xhr.send(js);

	// This will process results and update HTML as appropriate.
	xhr.onloadend = function () {
		console.log(xhr);
		console.log(xhr.request);

		if(xhr.readyState == XMLHttpRequest.DONE) {
			console.log("XHR: " + xhr.responseText);
		}
		
		window.location.reload();
	}
}
