$(function(){
	
	$('#releaseDate').datepicker().click(function(){
		var selected = $('#dropdown option:selected').text();
	});
    
	$("ul#navigation li a").hover(function() {
		$(this).css('text-shadow', '.1rem .1rem .1rem #fff');
		
	}, function(){
		$(this).css('text-shadow', '.4rem .4rem .4rem grey');
	});
	
}); 
		