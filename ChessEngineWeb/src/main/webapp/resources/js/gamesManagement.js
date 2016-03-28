//load saved matches
//edit matches
//save current match
function saveMatch() {
    var savedMatchName = prompt("Enter a name for the match", "match1");
    
    if (savedMatchName != null) {
        document.getElementById("message").innerHTML =
        "Match has been saved with name: " + savedMatchName+" <a href='load-saved-match.html'>Go to saved matches</a>";
    }
}

function editSavedMatchName() {
    var editedMatchName = prompt("Enter a new name for the match", name);
	
	if (editedMatchName != null) {
		//ajax call to save the updated match name
	}
}

function deleteSavedMatch() {
	confirm("Are you sure you want to delete the match?");
}