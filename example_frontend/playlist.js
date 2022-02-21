const addAlbumTrackForm = document.querySelector("#add-album-track-form");
const albumTrackTable = document.querySelector("#album-track-table");
const urlParams = new URLSearchParams(window.location.search);
const id = urlParams.get('id');
//import { globalTruth } from './index.js'
/*
addAlbumTrackForm.onsubmit = function(evt) {
  evt.preventDefault();
  const asin = document.querySelector("#album-asin").value;
  const trackNumber = document.querySelector("#track-number").value;
  const newSong = {
    "asin": asin,
    "trackNumber": trackNumber,
    "queueNext": false
  }
  axios.post(`https://svebsuap66.execute-api.us-west-2.amazonaws.com/prod/playlists/${id}/songs`, newSong, {
    authorization: {
      'x-api-key': 'K7CHRL6aqt1C6eGJ9EHyFaZCn86G0fyI2sTZKSkW'
    }
  })
  .then(res => {
    console.log(res);
    window.location.reload();
  });
}

window.onload = async function(evt) {
  evt.preventDefault();
  console.log("Getting Album Track Data...");
  axios.get("https://svebsuap66.execute-api.us-west-2.amazonaws.com/prod/playlists/"+id+"/songs", {
    authorization: {
      'x-api-key': 'K7CHRL6aqt1C6eGJ9EHyFaZCn86G0fyI2sTZKSkW'
    }
  }).then(res => {
    console.log(res);
    if (!res.data) {
      throw "No data for playlist with id:" + id;
    }

    if (res.data.songList.length > 0) {
      populateAlbumTracks(res.data.songList);
    }
  })
}

function populateAlbumTracks(albumTracksData) {
  let thead = albumTrackTable.createTHead();
  let tbody = albumTrackTable.createTBody();
  let row = thead.insertRow();

  for (let key in albumTracksData[0]) {
    let th = document.createElement("th");
    let text = document.createTextNode(key);
    th.appendChild(text);
    row.appendChild(th);
  }

  for (let albumTrack of albumTracksData) {
    let row = tbody.insertRow();
    for (key in albumTrack) {
      let cell = row.insertCell();
      let text = document.createTextNode(albumTrack[key]);
      cell.appendChild(text);
    }
  }
}
*/

function globalTest() {
  var cat = localStorage.getItem('myCat');
  console.log(cat);
  //localStorage.clear();
}

function updateAccount() {
  //Grabs username and passowrd from document to be used as parameters for API
  //let username = "user_email="+document.getElementById("username").value;
  //let password = "&password="+document.getElementById("password").value;
  //let username = "user_email="+"john.smith@gmail.com";
  //let password = "&password="+"password";
  
  let string1 = "https://ofeus50s1a.execute-api.us-east-2.amazonaws.com/prod/user_profile?email=evan@gmail.com&coinId=btc&amount=1";
  //let string2 = "https://cl9rje8xdi.execute-api.us-east-2.amazonaws.com/prod/user_profile?user_email=john.smith@gmail.com&password=password";

  const user = {
    "email": 'evan@gmail.com',
    "coinId": 'btc',
    "amount": '1'
  }
  axios.post(`https://ofeus50s1a.execute-api.us-east-2.amazonaws.com/prod/user_profile`, user).then((res) => {
    console.log(res);
    if (res.data.statusCode === 200) {
      alert("user created");
      window.location.replace("./portfolio.html");
      localStorage.setItem('myCat', 'Tom');
      var cat = localStorage.getItem('myCat');

    } else {
      alert("Invalid information");
    }
  })
  
}
