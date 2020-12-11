# 3733GroupProject
![XKCD Comic](https://imgs.xkcd.com/comics/exploits_of_a_mom.png)

The Admin Landing Page is run by making a request to the database to retrive all choices. 
The choices are then parsed with JSON and then formatted with Javascript to be displayed with the click of the button.
The delete stale button runs a Javascript function which puts the input data into an HTTP request which request to deletes all choices with a date older than the current date minus the amount of time input into the field on the page.
