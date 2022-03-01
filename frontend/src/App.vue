<template>
  <div id="app">
    <my-portfolio msg="My Crypto Portfolio"
    :auth="auth"
    :email="getEmail()"
    />
  </div>
</template>

<script>
import MyPortfolio from './components/Portfolio.vue'

export default {
  name: 'App',
  components: {
    MyPortfolio
  },
  computed: {
      auth: function() {
          if (location.href.split('#').length === 1) {
              return null;
          } 
          return (window.location.href.split('#')[1]).split('&')[1].split('=')[1]
      }
  },
  methods: {
    getEmail() {
        if (location.href.split('#').length === 1) {
            return null;
        } 
        var idTokenWithEquals = (location.href.split('#')[1]).split('&')[0];
        var COGNITO_ID_TOKEN = idTokenWithEquals.split('=')[1];
        COGNITO_ID_TOKEN = this.parseJwt(COGNITO_ID_TOKEN);

        return COGNITO_ID_TOKEN.email;

    },
    parseJwt(token) {
        var base64Url = token.split('.')[1];
        var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
        var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));

        return JSON.parse(jsonPayload);
    },

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
