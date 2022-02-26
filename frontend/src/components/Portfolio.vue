<template>
  <div>
    <h1>{{ msg }}</h1>
    <body>
        <a v-if="email === undefined || email === null" 
        href="https://my-coins.auth.us-east-2.amazoncognito.com/login?client_id=n2l1crskuigpqp3lrbsj8r7nj&response_type=token&scope=email+openid&redirect_uri=https://main.d1cm820nfbsmxw.amplifyapp.com/">Login</a>
        
        <div v-else>
            <div>
                <h2>Total Portfolio Value: ${{portfolio || 0}} </h2>
            </div>

            <div>
                <div></div>
                <input v-model="newCoin.name" placeholder="coin name">
                <input v-model="newCoin.amount" type="text" placeholder="amount">
                <input :class="isCoinNotfound()" @click="updateCoin" type="button" :value="sumbitText">
            </div>

            <div class="container">
                <table>
                    <thead>
                        <tr>
                            <th>Coin</th>
                            <th>Amount</th>
                            <th>Price</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody v-if="state === 'ready'">
                        <tr v-for="(coin, value) in coins" :key="coin.name">
                            <td>{{value}}</td>
                            <td>{{coin.amount}}</td>
                            <td>${{coin.price.toFixed(2)}}</td>
                            <td>${{coin.value.toFixed(2)}}</td>
                        </tr>
                    </tbody>
                </table>  
                <div v-if="state === 'loading'">
                    <p>loading data...</p>
                </div>
            </div>
        </div>
    </body>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'MyPortfolio',
  props: {
    msg: String,
    auth: String,
    email: String
  },

  data: function() {
      return {
          coins: {},
          coinNotfound: false, 
          //Changes Here
          ourCoinList: new Map(),
          state: "ready",
          newCoin: {
              name: null,
              amount: null,
          },
          userEmail: "",
          url: `https://t3d210uhn7.execute-api.us-east-2.amazonaws.com/test/portfolio?emailId=${this.email}`
      }
  },
  mounted () {
      this.state = "loading"
      this.getEmail();
      this.getCoin();
      //Changes Here
      this.getOurCoinList();
  },
  computed: {
      sumbitText: function() {
         if(this.coinNotfound) {
             return 'Coin Not Found';
         } else {
             return 'Update Portfolio';
         }
      },
      portfolio: function() {
        let networth = 0; 
        // this.state = "loading";
        let size = Object.keys(this.coins).length
        if (size === 0) {
            return;
        }

        for (const myCoin in this.coins) {
            networth += this.coins[myCoin].value;
        }


        return networth.toFixed(2);
      },
  },
  methods: {
    isCoinNotfound() {
        if(this.coinNotfound) {
          return 'coin-not-found';  
        }
    },
    getCoin() {
      if (location.href.split('#').length === 1) {
          return null;
      }
      this.state = "loading"
      axios
        .get(this.url,
        {headers: {
            "Authorization": this.auth
        }})
        .then(response => {
           if (response.data.errorMessage === "java.lang.NullPointerException") {
             return this.createUser();
            }
            this.coins = response.data.coins
            this.state = "ready"
        }
        )
    },
    getEmail() {
        if (location.href.split('#').length === 1) {
            return null;
        } 
        var idTokenWithEquals = (location.href.split('#')[1]).split('&')[0];
        var COGNITO_ID_TOKEN = idTokenWithEquals.split('=')[1];
        COGNITO_ID_TOKEN = this.parseJwt(COGNITO_ID_TOKEN);

        this.userEmail = COGNITO_ID_TOKEN.email 

    },
    parseJwt(token) {
        var base64Url = token.split('.')[1];
        var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
        var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));

        return JSON.parse(jsonPayload);
    },
    createUser() {
        this.state = "loading";
        axios.post(this.url, {}, {
        headers: {
            'Authorization': this.auth,
        }
        }).then((res) => {
            try {
                this.info = res.data;
                this.getCoin();
            } catch (error) { 
                alert("API offline: UPDATE");
                this.state = "ready";
            }
        })
    },
    updateCoin() {
        if (this.newCoin.name === null || this.newCoin.amount === null) {
            return;
        }

        if (!this.ourCoinList.get(this.newCoin.name)) {

            this.coinNotfound = true;
            setTimeout(()=>{
                this.coinNotfound = false;
            },2000);

            return;
        }

        //
        this.state = "loading";
        let extraParams = `&coinId=${this.newCoin.name}&amount=${this.newCoin.amount}`
        axios.put(this.url + extraParams, {}, {
        headers: {
            'Authorization': this.auth,
        }
        }).then((res) => {
            try {
                this.info = res.data;
                this.getCoin();
            } catch (error) { 
                alert("API offline: UPDATE");
                this.state = "ready";
            }
        })
   },
    getOurCoinList() {
        if (location.href.split('#').length === 1) {
            return null;
        } 
        this.state = "loading";

        axios.get('https://t3d210uhn7.execute-api.us-east-2.amazonaws.com/test/graball', {}
        ).then((res) => {
            try {
                for (let i =0;i<res.data.body.Items.length;i++){
                    var item = res.data.body.Items[i].id;
                    this.ourCoinList.set(item, true)
                }
                
            } catch (error) { 
                alert("API getOurCoinList offline");
                this.state = "ready";
            }
        })
   },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
@import url('~simpledotcss/simple.min.css');

.margin-standard {
    margin-right: 20px;
}
.coin-not-found {
    color: red;
    background-color: transparent;
}
</style>
