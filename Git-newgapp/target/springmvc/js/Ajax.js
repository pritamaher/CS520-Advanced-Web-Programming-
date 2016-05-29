function getprograms(){
	$('#loading').html('');
		var state = $('#department').val();
		$.ajax({
			url : 'Ajax/getprograms',
			method : 'post',
			ContentType : 'json',
			data : {
				department : department
			},

			success : function(response) {
				var options = '';
				if (response != null) {
					$(response).each(function(index, value) {
						options = options + '<option>' + value + '</option>';
					});
					$('#program').html(options);
				}
				$('#loading').html('');
			}
		});
	}