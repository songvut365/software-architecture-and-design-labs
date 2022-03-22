const express = require('express');
const cache = require('memory-cache');
const axios = require('axios');

const app = express();
const PORT = 3000

app.use(express.json());

// GET /{area}/{location}
app.get('/api/timezone/:area/:location', (req, res) => {
  var timezone = req.params.area + '/' + req.params.location;

  //check cache
  if(cache.get(timezone)) {
	console.log(cache.get(timezone));
    res.send(cache.get(timezone));
  }

  else {
    axios.get('http://worldtimeapi.org/api/timezone/'+timezone).then(response => {
      cache.put(timezone, response.data.datetime, 120*1000); //expire in 120sec
	    console.log(response.data.datetime);
      res.send(response.data.datetime);
    })
  }
});

// DELETE /{area}/{location}
app.delete('/api/timezone/:area/:location', async (req, res) => {
  var timezone = req.params.area + '/' + req.params.location;
  
  //clear timezone cache
  cache.clear(timezone);

  axios.get('http://worldtimeapi.org/api/timezone/'+timezone).then(response => {
    cache.put(timezone, response.data.datetime, 120*1000); //expire in 120sec
    console.log(response.data.datetime);
    res.send(response.data.datetime);
  })
})


app.listen(PORT, () => {
  console.log(`App listening at http://localhost:${PORT}`);
});