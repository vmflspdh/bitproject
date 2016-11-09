
function initMap() {
	var map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: 37.49, lng: 127.02},
		zoom: 2,
		mapTypeControl: false
	});
	var input = /** @type {!HTMLInputElement} */(
			document.getElementById('pac-input'));

	/*var types = document.getElementById('type-selector');*/

	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
	/*map.controls[google.maps.ControlPosition.TOP_LEFT].push(types);*/

	var autocomplete = new google.maps.places.Autocomplete(input, {
		types: ['(cities)']});


	autocomplete.bindTo('bounds', map);

	var infowindow = new google.maps.InfoWindow();
	var marker = new google.maps.Marker({
		map: map,
		anchorPoint: new google.maps.Point(0, -29)
	});

	autocomplete.addListener('place_changed', function() {
		infowindow.close();
		marker.setVisible(false);
		var place = autocomplete.getPlace();
		if (!place.geometry) {
			window.alert("Autocomplete's returned place contains no geometry");
			return;
		}

		// If the place has a geometry, then present it on a map.
		if (place.geometry.viewport) {
			map.fitBounds(place.geometry.viewport);
		} else {
			map.setCenter(place.geometry.location);
			map.setZoom(5);  // Why 17? Because it looks good.
		}
		marker.setIcon(/** @type {google.maps.Icon} */({
			url: place.icon,
			size: new google.maps.Size(71, 71),
			origin: new google.maps.Point(0, 0),
			anchor: new google.maps.Point(17, 34),
			scaledSize: new google.maps.Size(35, 35)
		}));
		marker.setPosition(place.geometry.location);
		marker.setVisible(true);

		var address = '';
		if (place.address_components) {
			address = [place.address_components[0].short_name
			           ].join('');

			/*위도 경도 추출*/
			var a = $("#map").find('a').attr('href')
			var b = a.split("=")[1];
			var c = b.split("&")[0];
			var llet = c.split(",")[0];
			var lot = c.split(",")[1];

			if (place.address_components.length == 4) {
				$(".bit-nation1").val(place.address_components[3].long_name)
			} else if (place.address_components.length == 3) {
				$(".bit-nation1").val(place.address_components[2].long_name)
			} else if (place.address_components.length == 2) {
				$(".bit-nation1").val(place.address_components[1].long_name)
			} else if (place.address_components.length == 5) {
				$(".bit-nation1").val(place.address_components[4].long_name)
			} else if (place.address_components.length == 6) {
				$(".bit-nation1").val(place.address_components[5].long_name)
			}

			$(".bit-city1").val(place.address_components[0].short_name)
			$(".bit-latitude1").val(llet)
			$(".bit-longitude1").val(lot)
		}

		infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
		infowindow.open(map, marker);
	});

	// Sets a listener on a radio button to change the filter type on Places
	// Autocomplete.
	function setupClickListener(id, types) {
		var radioButton = document.getElementById(id);
		radioButton.addEventListener('click', function() {
			autocomplete.setTypes(types);
		});
	}

	setupClickListener('changetype-all', []);
	setupClickListener('changetype-address', ['address']);
	setupClickListener('changetype-establishment', ['establishment']);
	setupClickListener('changetype-geocode', ['geocode']);
}

