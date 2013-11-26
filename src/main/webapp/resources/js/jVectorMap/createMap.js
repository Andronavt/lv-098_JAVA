function createMap() {
	$('#world-map').vectorMap({
		map : 'world_mill_en',
		series : {
			regions : [ {
				values : array,
				scale : [ '#C8EEFF', '#0071A4' ],
				normalizeFunction : 'polynomial'
			} ]
		},
		onRegionLabelShow : function(e, el, code) {
			el.html(el.html() + ' - ' + array[code]);
		}
	});
}