/*	function initMap() {
		var uluru = {
			lat : 37.49,
			lng : 127.02
		};
		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 13,
			center : uluru
		});

		var contentString = '<div id="content">'
				+ '<div id="siteNotice">'
				+ '</div>'
				+ '<h1 id="firstHeading" class="firstHeading">비트컴퓨터</h1>'
				+ '<div id="bodyContent">'
				+ '<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large '
				+ 'sandstone rock formation in the southern part of the '
				+ 'Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) '
				+ 'south west of the nearest large town, Alice Springs; 450&#160;km '
				+ '(280&#160;mi) by road. Kata Tjuta and Uluru are the two major '
				+ 'features of the Uluru - Kata Tjuta National Park. Uluru is '
				+ 'sacred to the Pitjantjatjara and Yankunytjatjara, the '
				+ 'Aboriginal people of the area. It has many springs, waterholes, '
				+ 'rock caves and ancient paintings. Uluru is listed as a World '
				+ 'Heritage Site.</p>'
				+ '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'
				+ 'https://en.wikipedia.org/w/index.php?title=Uluru</a> '
				+ '(last visited June 22, 2009).</p>' + '</div>' + '</div>';

		var infowindow = new google.maps.InfoWindow({
			content : contentString
		});

		var marker = new google.maps.Marker({
			position : uluru,
			map : map,
			title : 'Uluru (Ayers Rock)'
		});
		marker.addListener('click', function() {
			infowindow.open(map, marker);
		});
	}
 */

function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 37.49, lng: 127.02},
    zoom: 2,
    mapTypeControl: false
  });
  var input = /** @type {!HTMLInputElement} */(
      document.getElementById('pac-input'));

  var types = document.getElementById('type-selector');
  
/* map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
  map.controls[google.maps.ControlPosition.TOP_LEFT].push(types);*/

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
      address = [
        (place.address_components[0] && place.address_components[0].short_name || ''),
        (place.address_components[1] && place.address_components[1].short_name || ''),
        (place.address_components[2] && place.address_components[2].short_name || '')
      ].join(' ');
      
/*위도 경도 추출*/
      var a = $("#map").find('a').attr('href')
      var b = a.split("=")[1];
      var c = b.split("&")[0];
      var llet = c.split(",")[0];
      var lot = c.split(",")[1];

      
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

