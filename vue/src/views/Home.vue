<template>
  <div class="home">
    <h1>Welcome to Elevate</h1>
    <div class="btn-nav">
      <h2 class="text-center1">If you are an Elevate Host or DJ, please login</h2>
      <button id="nav1" class="home-nav" role="button">
        <router-link class="nav" v-bind:to="{ name: 'login' }">Login</router-link>
      </button>
      <h2 class="text-center2">If you want to register as an Elevate Host or DJ, please register</h2>
      <button id="nav2" class="home-nav" role="button">
        <router-link class="nav" v-bind:to="{ name: 'register' }">Register</router-link>
      </button>
      <h2 class="text-center3">Feel free to view any of our events by clicking on the dropdown of events</h2>
      <div class="form-group">
          <label class="select">
            <h2 class="text-center4">Event Names:
              <select v-model="routeID">
              <option  v-bind:value="event.eventID" v-for="event in events" v-bind:key="event.eventID">{{ event.eventName }}</option>
              </select>
              <button class="event-route home-nav nav" v-on:click="viewEventDetails()">Select Event</button>
            </h2>
          </label>
      </div>
      <img src="../assets/Club.png" alt="Club" class="center">    
    </div>
  </div>
</template>

<script>
import EventService from '../services/EventService';

export default {
  name: "home",
  data() {
    return {
      routeID: 0
    }
  },
 created(){
        this.retrieveEvents();
    },
    computed: {
        events(){
            return this.$store.state.events;
        }
    },
    methods: {
        retrieveEvents(){
            EventService.getEvents().then(response => {
                this.$store.commit("SET_EVENTS", response.data);
                this.isLoading = false;
            });
        },
        viewEventDetails() {
            this.$router.push(`/events/${this.routeID}`)
        }
    }
};
</script>

<style scoped>
.home {
  background-image: linear-gradient(#000200, #4A007b, #9000BE, #A96BCB);
  height: 100vh;
}

h1 {
  color: white;
  text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
  font-style: italic;
  font-family: "Audiowide", sans-serif;
  padding-top: 10px;
  text-align: center;
}

.center {
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  border: 3px solid #ff00d4;
}

h2 {
  color: white;
  text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
  font-style: oblique;
  text-align: center;
  position: absolute;
}

.text-center1 {
  position: absolute;
  top: 10%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.text-center2 {
  position: absolute;
  top: 23.5%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.text-center3 {
  position: absolute;
  top: 37%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.text-center4 {
  position: absolute;
  top: 45%;
  left: 50%;
  transform: translate(-50%, -50%);
}

#nav1 {
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translate(-50%, -50%);
}

#nav2 {
  position: absolute;
  top: 33.5%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.btn {
  margin: 0;
  position: absolute;
  left: 45%;
  border-radius: 6px; 
  border: none;
  color: rgb(0, 0, 0);
  padding: 5px 9px;
  font-size: 14px;
}

.btn-nav {
  position: relative;
  text-align: center;
  color: white;
}

.nav {
  text-decoration: none;
}

.home-nav {
  align-items: center;
  appearance: none;
  background-image: radial-gradient(100% 100% at 100% 0, white 0, #c90bf8 100%);
  border: 0;
  border-radius: 6px;
  box-shadow: rgba(45, 35, 66, .4) 0 2px 4px,rgba(45, 35, 66, .3) 0 7px 13px -3px,rgba(58, 65, 111, .5) 0 -3px 0 inset;
  box-sizing: border-box;
  color: white;
  cursor: pointer;
  display: inline-flex;
  font-family: "JetBrains Mono",monospace;
  height: 35px;
  justify-content: center;
  line-height: 1;
  list-style: none;
  overflow: hidden;
  padding-left: 16px;
  padding-right: 16px;
  position: relative;
  text-align: left;
  text-decoration: none;
  transition: box-shadow .15s,transform .15s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  white-space: nowrap;
  will-change: box-shadow,transform;
  font-size: 18px;
}

.home-nav:focus {
  box-shadow:#A96BCB 0 0 0 1.5px inset, rgba(45, 35, 66, .4) 0 2px 4px, rgba(45, 35, 66, .3) 0 7px 13px -3px, #A96BCB 0 -3px 0 inset;
}

.home-nav:hover {
  box-shadow: rgba(45, 35, 66, .4) 0 4px 8px, rgba(45, 35, 66, .3) 0 7px 13px -3px, #A96BCB 0 -3px 0 inset;
  transform: translateY(-2px);
}

.home-nav:active {
  box-shadow: #A96BCB 0 3px 7px inset;
  transform: translateY(2px);
}

a.nav {
  color: rgb(243, 202, 237)
}

.event-route {
  margin-left: 15px;
  
}

select{
    width:auto;
    border:2px solid #aaa;
    border-radius:4px;
    margin:8px 0;
    outline:none;
    padding:3px;
    box-sizing:border-box;
    transition:.3s;
    border-color:rgb(255, 149, 246);
    background-color: rgb(255, 240, 255);
}
  
select:focus{
    border-color:rgb(255, 149, 246);
    box-shadow:0 0 8px 0 rgb(253, 190, 248);
}

</style>
