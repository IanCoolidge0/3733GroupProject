function processListResponse(result) {
    //console.log("res:" + result);
    // Can grab any DIV or SPAN HTML element and can then manipulate its contents dynamically via javascript
    var js = JSON.parse(result);
    var choiceData = document.getElementById('jsonData');

    var output = "<br/>";

    for (var i = 0; i < js.list.length; i++) {
        var choiceJson = js.list[i];
        //console.log(choiceJson);

        var choiceName = choiceJson["name"];
        var choiceId = choiceJson["id"];
        var completed = choiceJson["hasChosenAlternative"];

        if (completed) {
            completed = "completed";
        } else {
            completed = "not completed";
        }

        output = output + "<div id=\"choice" + choiceName + "\"><b>" + choiceName + ":</b>  " + choiceId + " " + completed + "</b>  " + "<br></div>";
    }

    output = output + "<br/>";
    // Update computation result
    choiceData.innerHTML = output;
}

function handleGenerateReportClick(e) {
    var xhttp = new XMLHttpRequest();

    xhttp.onloadend = function() {
        if (this.readyState == 4 && this.status == 200) {
            processListResponse(this.responseText);
        }
    };
    xhttp.open("GET", adminlandingpage_url, true);
    xhttp.send();
}


