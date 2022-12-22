<template>
  <div class="app">
  
    <div class="header">
      <img class="logo" src="./assets/Elevate_crop 2.png"/>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'home' }">Home</router-link>
      </button>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'login' }">Login</router-link>
      </button>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'register' }">Register</router-link>
      </button>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'events' }">Events</router-link>
      </button>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'dj' }">Dj</router-link>
      </button>
      <button :class="{btn: $store.state.token != ''}" v-if="$store.state.token != ''">
      <router-link class="btn-header" v-bind:to="{ name: 'logout' }">Logout</router-link>
      </button>
    </div>

    <router-view class="main-body" />
   
    <div class="footer">
      <p> &copy; 2022 - Elevate by Zack, Alex, Allen, Jae and Krista</p>
    </div> 

  </div>
</template>


<style scoped>

@import url(https://fonts.googleapis.com/css?family=Open+Sans);
@import url(https://fonts.googleapis.com/css?family=Audiowide);

body{
  background: #f2f2f2;
  font-family: 'Open Sans', sans-serif;
}

.header {
  grid-area: header;
  background: black;
  border-radius: 5px;
}

.main-body {
  grid-area: main-body;
  background-image: linear-gradient(#4A007b, #9000BE, #A96BCB);
  height: 100%;
  width: 100vw; 
}

.footer {
  grid-area: footer;
}

.app {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 200px 1fr 50px;
  grid-template-areas:
    "header header header"
    "main-body main-body main-body"
    "footer footer footer";
  height: 100vh;
  gap: 0px;
}

.logo {
  margin-bottom: -80px;
  height: 200px;
  width: auto;
  border-radius: 5px;
}

.btn {
  display: inline-block;
  padding: 0.6em 2em;
  border: none;
  margin: 30px;
  outline: none;
  color: rgb(255, 255, 255);
  background: #111;
  cursor: pointer;
  position: relative;
  z-index: 0;
  border-radius: 10px;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.btn:before {
  content: "";
  background: linear-gradient(
    45deg,
    #002bff,
    #391E94,
    #7a00ff,
    #ff00c8,
    #FF10F0,
    purple
  );
  position: absolute;
  top: -2px;
  left: -2px;
  background-size: 400%;
  z-index: -1;
  filter: blur(5px);
  -webkit-filter: blur(5px);
  width: calc(100% + 4px);
  height: calc(100% + 4px);
  animation: glowing-button 20s linear infinite;
  transition: opacity 0.3s ease-in-out;
  border-radius: 10px;
}

@keyframes glowing-button {
  0% {
    background-position: 0 0;
  }
  50% {
    background-position: 400% 0;
  }
  100% {
    background-position: 0 0;
  }
}

.btn:after {
  z-index: -1;
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  background: #222;
  left: 0;
  top: 0;
  border-radius: 10px;
}

.btn-header {
  text-decoration: none;
  color: white;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
.app {
   background-color: white;
   height: 100vh; 
 }

 .footer {
   background-color: rgb(230, 230, 230);
 }
</style>

