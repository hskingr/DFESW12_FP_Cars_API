const testMain = async () => {
  console.log('hi from main')

  ping('http://car-api').then(function(delta) {
    console.log('Ping time was ' + String(delta) + ' ms');
}).catch(function(err) {
    console.error('Could not ping remote URL', err);
});

  const opts = {
    "Access-Control-Allow-Origin": "http://localhost"
  }

  const http = new simpleFETCH;

  await http.get("http://car-api:8080/readItem/8", opts)
    .then(data => console.log(data))
    .catch(err => console.log(err));

}



testMain()
