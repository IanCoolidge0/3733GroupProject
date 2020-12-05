function handlePageLoad() {
	
	var xhr = new XMLHttpRequest();
	xhr.open("GET", viewchoices_url, true);
	
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