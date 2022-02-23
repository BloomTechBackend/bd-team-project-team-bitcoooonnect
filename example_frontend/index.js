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
//Use authToken with GET request for portfolio data
function createAccount() {

  let username = document.getElementById("username").value;
  let usernameAttachment = "authToken="+document.getElementById("username").value;
  let BITCOOOONECT_API = "https://t3d210uhn7.execute-api.us-east-2.amazonaws.com/test/portfolio"

  const userObj = {
  };

  axios.post(BITCOOOONECT_API, userObj).then((res) => {
    console.log(res.data);
    try {
        let authToken = res.data.user.authToken;
        var para=document.createElement("p");
            var node=document.createTextNode(String(authToken));
            para.appendChild(node);
            para.style.color="red";
            var element=document.getElementById("d2");
            element.appendChild(para)
      
    } catch (error) { 
      alert("API is disconnected");
    }
    
  })
  
}






