<template>
  <div id="background">
    <div class="for-background">
      <br>
    </div> 
    <div class="login-box">
    <h2 class="main-text">Login</h2>
    <form>
      <div class="user-box">
        <input id="username" type="text" name="" required="" v-model="user.username">
        <label class="box-text" for="username">Username</label>
      </div>
      <div class="user-box">
        <input id="password" type="password" name="" required="" v-model="user.password">
        <label class="box-text" for="password">Password</label>
      </div>
      <a href="#" v-on:click.prevent="login" class="box-text">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        Login
      </a>
    </form>
  </div>
</div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
#background {
  background-image: linear-gradient(#4A007b, #9000BE, #A96BCB)
}

.for-background {
  height: 100vh;
  width: 100vw;
}

.main-text {
  color: white;
  text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
  font-style: italic;
  font-family: "Audiowide", sans-serif;
  padding-top: 10px;
}

.box-text {
  color: white;
  text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
  font-style: oblique;
}

html {
  height: 100%;
}

body {
  margin:0;
  padding:0;
  font-family: sans-serif;
  background: linear-gradient(black, black);
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0,0,0,.75);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: white;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: white;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid white;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  top:0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: white;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #ED50FF;
  font-size: 12px;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #ED50FF;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 25px;
  letter-spacing: 4px
}

.login-box a:hover {
  background: #ED50FF;
  color: white;
  border-radius: 5px;
  box-shadow: 0 0 5px #ED50FF,
              0 0 25px #ED50FF,
              0 0 50px #ED50FF,
              0 0 100px #ED50FF;
}

.login-box a span {
  position: absolute;
  display: block;
}

.login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #ED50FF);
  animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%,100% {
    left: 100%;
  }
}

.login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #ED50FF);
  animation: btn-anim2 1s linear infinite;
  animation-delay: .25s
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%,100% {
    top: 100%;
  }
}

.login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #ED50FF);
  animation: btn-anim3 1s linear infinite;
  animation-delay: .5s
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%,100% {
    right: 100%;
  }
}

.login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #ED50FF);
  animation: btn-anim4 1s linear infinite;
  animation-delay: .75s
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%,100% {
    bottom: 100%;
  }
}

.dropDown {
  color: white;
}
</style>
