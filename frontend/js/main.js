const testMain = async () => {
  console.log('hi from main')

  const opts = {
        "Access-Control-Allow-Origin": "*",
        'Content-Type': 'application/json',
  }

  const http = new simpleFETCH;

  await http.get("http://127.0.0.1:8080/readItem/1", opts)
    .then(data => console.log(data))
    .catch(err => console.log(err));

}

testMain()
