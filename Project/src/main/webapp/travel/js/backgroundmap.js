function mapinitialize() {
    var layers = ["toner", "terrain", "watercolor"];
    <!--
          for (var i = 0; i <layers.length; i++) {
        var layer = layers[i]; 
     --> 
        var map = new L.Map(layer, {
            center: new L.LatLng(25.8631515, -80.1928253),
            zoom: 2,
            dragging: true,
            touchZoom: true,
            scrollWheelZoom: false
        });
        map.addLayer(new L.StamenTileLayer(layer));
    
      L.marker([38.5976262, -80.4549026]).addTo(map)
    .bindPopup('<a href="/story/197">Read the story</a>');


    }
}