var x = document.getElementById("container");

            function getLocation() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(showPosition, showError);
                } else {
                    x.innerHTML = "Geolocation is not supported by this browser.";
                }
            }

            function showPosition(position) {
                x.innerHTML = "Latitude: " + position.coords.latitude +
                        "<br>Longitude: " + position.coords.longitude;
                var latlon = position.coords.latitude + "," + position.coords.longitude;
                alert(latlon);
                var img_url = "http://maps.googleapis.com/maps/api/staticmap?center="
                        + latlon + "&zoom=16&size=500x500&markers=" + latlon + "&sensor=false&libraries=geometry";
                document.getElementById("map").innerHTML = "<img src='" + img_url + "'>";
            }

            function showError(error) {
                switch (error.code) {
                    case error.PERMISSION_DENIED:
                        x.innerHTML = "User denied the request for Geolocation.";
                        alert('Accès refusé');
                        break;
                    case error.POSITION_UNAVAILABLE:
                        x.innerHTML = "Location information is unavailable.";
                        alert("Votre position n'a pas pu être déterminée");
                        break;
                    case error.TIMEOUT:
                        x.innerHTML = "The request to get user location timed out.";
                        alert('Temps expiré');
                        break;
                    case error.UNKNOWN_ERROR:
                        x.innerHTML = "An unknown error occurred.";
                        alert("Votre position n'a pas pu être déterminée\tErreur inconnue");
                        break;
                }
            }