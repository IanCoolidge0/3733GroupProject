function processListResponse(result) {
    //console.log("res:" + result);
    // Can grab any DIV or SPAN HTML element and can then manipulate its contents dynamically via javascript
    var js = JSON.parse(result);
    var choiceData = document.getElementById('jsonData');

    var tableData = "<br/><table><tr><th>Choice</th><th>ID</th><th>Creation Date</th><th>Completed</th></tr>";

    for (var i = 0; i < js["choices"].length; i++) {

        var choiceJson = js["choices"][i];

        var choiceName = choiceJson["name"];
        var choiceId = choiceJson["id"];
        var date = choiceJson["datetime"]
        var formattedDate = new Date(date);
        var completed = choiceJson["chosenAlternative"] != "";

        if (completed) {
            completed = "COMPLETED";
        } else {
            completed = "NOT COMPLETED";
        }

        tableData += "<tr>";
        tableData += "<td>" + choiceName + "</td>";
        tableData += "<td>" + choiceId + "</td>";
        tableData += "<td>" + formattedDate.toString() + "</td>";
        tableData += "<td>" + completed + "</td>";
        tableData += "</tr>";
    }

    tableData += "</table><br/>";
    // Update computation result
    choiceData.innerHTML = tableData;
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

function handleDeleteStaleClick(e) {

    var numdays = parseFloat(document.getElementById("numdays").value) * 86400000;
    var data = {};
    data["timeInMills"] = numdays;
    var js = JSON.stringify(data);
    var xhttp = new XMLHttpRequest();
    console.log("JS: " + js);
    xhttp.onloadend = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log("ready");
        }
    };
    xhttp.open("POST", deletestale_url, true);
    xhttp.send(js);

}
