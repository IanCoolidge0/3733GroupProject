// all access driven through BASE. Must end with a SLASH
// be sure you change to accommodate your specific API Gateway entry point
var base_url = "https://exe5sj3z1c.execute-api.us-east-2.amazonaws.com/development/";

var createchoice_url = base_url + "createchoice";   	   // POST
var registeruser_url = base_url + "participatechoice";     // POST
var selectapproval_url = base_url + "selectapproval";      // POST
var selectdisapproval_url = base_url + "selectdisapproval" // POST
var adminlandingpage_url = base_url + "adminlandingpage";  // POST
var viewchoices_url = base_url + "viewchoice"; 			   // POST