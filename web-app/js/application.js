$(document).ready(function() {
	/**
	 * Sets instance name and form action URL in confirmation 
	 * modal windows used for deleting entities.
	 */
    $("a.delete").live("click", function(event) {
    	var instanceName = $(this).data("instance-name");
    	$("div.modal-body > p > strong").text(instanceName);
        var formAction = $(this).attr("href");
        $("#modal-delete-form").attr("action", formAction);
    });
    
    /**
     * Closes modal window when the cancel button is selected
     * (twitter bootstrap by defaul handles this but only via
     * the close icon in the upper right corner).
     */
    $("a.dismiss").live("click", function(event) {
    	$(this).parents(".modal").modal('hide');
    });
});