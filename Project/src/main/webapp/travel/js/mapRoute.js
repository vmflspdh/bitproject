/*var poly;
var map;

function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
	    center: {lat: 37.49, lng: 127.02},
	    zoom: 2,
	    mapTypeControl: false
  });

  poly = new google.maps.Polyline({
    strokeColor: '#000000',
    strokeOpacity: 1.0,
    strokeWeight: 3
  });
  poly.setMap(map);

  // Add a listener for the click event
  map.addListener('click', addLatLng);
}

// Handles click events on a map, and adds a new point to the Polyline.
function addLatLng(event) {
  var path = poly.getPath();

  // Because path is an MVCArray, we can simply append a new coordinate
  // and it will automatically appear.
  path.push(event.latLng);

  // Add a new marker at the new plotted point on the polyline.
  var marker = new google.maps.Marker({
    position: event.latLng,
    title: '#' + path.getLength(),
    map: map
  });
}
*/
$(document).ready(function() {

	var locationArray = [];
  $('.root-schedule').each(function(index, element) {

	  var tag = $(element)
  	locationArray[index] = {

  		lat : tag.find(".bit-latitude").val(),
  		lng : tag.find(".bit-longitude").val()

  	};
  	
  })
  
  console.log(locationArray[0])
  
/*  var schedule = JSON.stringify(locationArray)
  console.log(schedule);*/

});
  

  
  
function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
	  center: {lat: 37.49, lng: 127.02},
	    zoom: 2
  });
  

  
var flightPlanCoordinates = locationArray;
  
  
  
/*  var flightPlanCoordinates = [
                               {lat: 37.772, lng: -122.214},
                               {lat: 21.291, lng: -157.821},
                               {lat: -18.142, lng: 178.431},
                               {lat: -27.467, lng: 153.027}
                               ];*/
  
 
  var flightPath = new google.maps.Polyline({
    path: flightPlanCoordinates,
    geodesic: true,
    strokeColor: '#FF0000',
    strokeOpacity: 1.0,
    strokeWeight: 2
  });

  flightPath.setMap(map);
}

