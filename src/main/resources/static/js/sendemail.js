function sendEmail(url) {	
	var jqxhr = $.get(url, function() {		
		$("#modal-title").html("Success!!");
		$("#modal-message").html("Your order has been successfully send to your email");
		$("#sendEmailModel").modal('show');
	}).fail(function() {			
		$("#modal-title").html("Fail!!");
		$("#modal-message").html("Error when trying to send the order to your email");
		$("#sendEmailModel").modal('show');
	});
}