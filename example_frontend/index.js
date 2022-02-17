const playlistForm = document.querySelector("#create-playlist-form");
const playlistsList = document.querySelector("#playlists");
const username = document.querySelector("#playlists");
const password = document.querySelector("#playlists");
let globalTruth = {
  status: "false"
};

window.onload = async function(evt) {
  evt.preventDefault();
  console.log("Getting Playlist Data...");
  axios.get("https://svebsuap66.execute-api.us-west-2.amazonaws.com/prod/playlists", {
    authorization: {
      'x-api-key': 'K7CHRL6aqt1C6eGJ9EHyFaZCn86G0fyI2sTZKSkW'
    }
  }).then((res) => {
    console.log(res.data);
    populatePlaylists(res.data.playlists);
  })
}

function populatePlaylists(playlistData) {

  for (let playlist of playlistData) {
    let li = document.createElement("li");
    let a = document.createElement("a");
    let text = document.createTextNode(playlist.name);

    a.setAttribute('href', `./playlist.html?id=${playlist.id}`);

    a.appendChild(text);
    li.appendChild(a);
    playlistsList.appendChild(li);
  }
}

function validateAccount(){
  //Grabs username and passowrd from document to be used as parameters for API
  let username = "user_email="+document.getElementById("username").value;
  let password = "&password="+document.getElementById("password").value;
  //let username = "user_email="+"john.smith@gmail.com";
  //let password = "&password="+"password";
  
  let string1 = "https://cl9rje8xdi.execute-api.us-east-2.amazonaws.com/prod/user_profile?"+username+password;
  //let string2 = "https://cl9rje8xdi.execute-api.us-east-2.amazonaws.com/prod/user_profile?user_email=john.smith@gmail.com&password=password";

  console.log(string1);

  const userObj = {
    "name": username,
    "password": password
  }

  axios.get(string1).then((res) => {
    console.log(res);
    if (res.data.statusCode === 200) {
      window.location.replace("./portfolio.html");
      localStorage.setItem('myCat', 'Tom');
      var cat = localStorage.getItem('myCat');

    } else {
      alert("Invalid information");
    }
  })
}

function createAccount() {
  //Grabs username and passowrd from document to be used as parameters for API
  let username = "user_email="+document.getElementById("username").value;
  let password = "&password="+document.getElementById("password").value;
  //let username = "user_email="+"john.smith@gmail.com";
  //let password = "&password="+"password";
  
  let string1 = "https://cl9rje8xdi.execute-api.us-east-2.amazonaws.com/prod/user_profile?"+username+password;
  //let string2 = "https://cl9rje8xdi.execute-api.us-east-2.amazonaws.com/prod/user_profile?user_email=john.smith@gmail.com&password=password";

  console.log(string1);

  const userObj = {
    "name": username,
    "password": password
  }

  axios.post(string1).then((res) => {
    console.log(res);
    if (res.data.statusCode === 200) {
      window.location.replace("./portfolio.html");
      localStorage.setItem('myCat', 'Tom');
      var cat = localStorage.getItem('myCat');

    } else {
      alert("Invalid information");
    }
  })
  
}
