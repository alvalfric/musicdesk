jQuery(function() {
	changePlaylist();
})

function changePlaylist() {
	$("#playlist-select").change(function() {
		console.log(this.value);
		$("#playlist").attr('src', this.value);
		$("#playlist").text($("#playlist-select option:selected").text());
	});
};
