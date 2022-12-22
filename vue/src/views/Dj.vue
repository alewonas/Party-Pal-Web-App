<template>
  <div class="main">
    <br>
    <button class="btn" id="btn1">
      <router-link class="btn-header" v-bind:to="{ name: 'add-event' }">Create New Event</router-link>  
    </button>
      <br>
      <br>
    <button class="btn" id="btn2">
      <router-link class="btn-header" v-bind:to="{ name: 'authorize' }">Authorize Page</router-link>
    </button>
    <button class="btn" id="btn3">
      <router-link class="btn-header" v-bind:to="{ name: 'dj-profile', params: { djId:djId }}">Dj Profile</router-link>
    </button>
  </div>
</template>

<script>
import AuthService from '../services/AuthService.js';

export default {
    name: "dj",
    data() {
      return {
        djId: ''
      }
    },
    created() {
        this.retrieveDjId();
    },
    methods: {
      retrieveDjId() {
        AuthService.getDjId().then(response => {
          // this.$store.commit("SET_CURRENT_DJ", response.data);
          this.djId = response.data;
        });
      }
    }
};
</script>

<style scoped>
.btn-header {
  text-decoration: none;
  color: white;
  font-size: 90%;
  text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
  padding: 10px;
  width: 7%; 
  cursor: pointer;
}

.btn{
  text-decoration: none;
  color: white;
  font-size: 100%;
  text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
  background: rgba(0,0,0,.75);
  border-radius: 5px;
  padding: 5px;
  margin: 3px;
  border: 2px solid;
  padding: 10px;
  box-shadow: 3px 2px 4px;
  width: 10%; 
  cursor: pointer;
  display:inline-block;
}

.main{
  display:inline-block;
  align-content: center;
}

#btn1{
  position: absolute;
  top:35%;
  left: 50%;
  transform: translate(-50%,-50%);
}

#btn2{
  position: absolute;
  top:35%;
  left: 25%;
  transform: translate(-50%,-50%);
}

#btn3{
  position: absolute;
  top:35%;
  left: 75%;
  transform: translate(-50%,-50%);
}
</style>