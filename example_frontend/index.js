const playlistForm = document.querySelector("#create-playlist-form");
const playlistsList = document.querySelector("#playlists");
const username = document.querySelector("#playlists");
const password = document.querySelector("#playlists");
// var globalTruth = false;

// playlistForm.onsubmit = async function(evt) {
//   evt.preventDefault();
//   const name = document.querySelector("#playlist-name").value;
//   const customerId = "testCustomer";
//   const playlistObj = {
//     "name": name,
//     "customerId": customerId,
//     "songCount": 0
//   }
//   axios.post("https://svebsuap66.execute-api.us-west-2.amazonaws.com/prod/playlists", playlistObj, {
//     authorization: {
//       'x-api-key': 'K7CHRL6aqt1C6eGJ9EHyFaZCn86G0fyI2sTZKSkW'
//     }
//   }).then((res) => {
//     console.log(res);
//     window.location.reload();
//   })
// }

// window.onload = async function(evt) {
//   evt.preventDefault();
//   console.log("Getting Playlist Data...");
//   axios.get("https://svebsuap66.execute-api.us-west-2.amazonaws.com/prod/playlists", {
//     authorization: {
//       'x-api-key': 'K7CHRL6aqt1C6eGJ9EHyFaZCn86G0fyI2sTZKSkW'
//     }
//   }).then((res) => {
//     console.log(res.data);
//     populatePlaylists(res.data.playlists);
//   })
// }

// function populatePlaylists(playlistData) {

//   for (let playlist of playlistData) {
//     let li = document.createElement("li");
//     let a = document.createElement("a");
//     let text = document.createTextNode(playlist.name);

//     a.setAttribute('href', `./playlist.html?id=${playlist.id}`);

//     a.appendChild(text);
//     li.appendChild(a);
//     playlistsList.appendChild(li);
//   }
// }

function validateAccount(){
  //Grabs username and passowrd from document to be used as parameters for API
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;
  let usernameAttachment = "email="+document.getElementById("username").value;
  let passwordAttachment = "&password="+document.getElementById("password").value;
  
  let string1 = "https://ofeus50s1a.execute-api.us-east-2.amazonaws.com/prod/user_profile?"+usernameAttachment+passwordAttachment;
  //let username = 'ron@gmail.com';
  //let password = '123';
  //let string2 = "https://ofeus50s1a.execute-api.us-east-2.amazonaws.com/prod/user_profile?email=ron@gmail.com&password=123";

  axios.get(string1).then((res) => {
    try {
      
      
      if (res.data.user.email === username && res.data.user.password === password) {
        objKeys = Object.keys(res.data.user.coins);
        objValues = Object.values(res.data.user.coins);
        for(let i = 0; i < Object.keys(res.data.user.coins).length; i++) {
          console.log(objKeys[i]);
          console.log(objValues[i]);
          //converts number to be number with 8 decimal places
          let value = (objValues[i]).toFixed(8); 
          localStorage.setItem(String(objKeys[i]),String(value));
        }
        alert("user logged in");
        for (i = 0; i < localStorage.length; i++)   {
          console.log(localStorage.key(i) + "=[" + localStorage.getItem(localStorage.key(i)) + "]");
        }
        //localStorage.clear();
        window.location.replace("./portfolio.html");
  
      } else {
        alert("Invalid information");
      }
      
    } catch (error) { 
      alert("Invalid information!");
    }
    
  })
}

function createAccount() {
  //Grabs username and passowrd from document to be used as parameters for API
  let username = document.getElementById("username").value;
  let password = document.getElementById("password").value;
  let usernameAttachment = "email="+document.getElementById("username").value;
  let passwordAttachment = "&password="+document.getElementById("password").value;
  //let username = "user_email="+"john.smith@gmail.com";
  //let password = "&password="+"password";
  //let string1 = "https://ofeus50s1a.execute-api.us-east-2.amazonaws.com/prod/user_profile?"
  //let string1 = "https://ofeus50s1a.execute-api.us-east-2.amazonaws.com/prod/user_profile?"+username+password;
  let string2 = "https://ofeus50s1a.execute-api.us-east-2.amazonaws.com/prod/user_profile?"+usernameAttachment+passwordAttachment;

  const userObj = {
    "email": username,
    "password": password
  }

  axios.post(string2, userObj).then((res) => {
    console.log(res);
    try {
      if (res.data.user.email === username && res.data.user.password === password) {
        alert("user created");
        //Native method can only store strings as strings
        localStorage.setItem('BTC','100');
        localStorage.setItem('ETH','1');
        var cat = localStorage.getItem('BTC');
        console.log(cat)
        console.log(localStorage.getItem('BTC'))
        console.log(localStorage.getItem('1'))
        console.log(localStorage.getItem('ETH'))
        window.location.replace("./portfolio.html");
  
      } else {
        alert("Invalid information");
      }
      
    } catch (error) { 
      alert("Invalid information! User not created");
    }
    
  })
  
}


