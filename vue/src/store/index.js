import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    events: [
      {
        eventID: 1,
        hostID: 2001,
        djID: 3001,
        eventName: "Eat & BE UGLY",
        eventInformation: "Come get your jingle on and compete for prizes in your ugliest christmas sweater!",
        genres: "Hip-Hop / Rap, Pop",
        eventPicture: ""
      },
      {
        eventID: 2,
        hostID: 2001,
        djID: 3001,
        eventName: "Huddle Party",
        eventInformation: "Shuting it down",
        genres: "Pop, Alternative",
        eventPicture: ""
      }
    ],
    event: {
        eventID: 7,
        hostID: 2001,
        djID: 3001,
        eventName: "",
        eventInformation: "",
        genres: "",
        eventPicture: ""
    },
    playlist: [
      {
        songName: "Take Care",
        artist: "Drake"
      },
      {
        songName: "Tuscan Leather",
        artist: "Drake"
      }
    ],
    playlists:[
      {
        playlistURI: 0,
        playlistName: "mock pop playlist"
      }
    ],
    hosts: [
      {
        hostName: "testHost",
        hostID: 0
      }
    ],
    songs: [
      {
        name: "spotify:track:2ZL7WZcjuYKi1KUDtp4kCC",
        uri: "Spin Bout U",
        artists: "Drake",
      },
      {
        name: "spotify:track:2ZL7WZcjuYKi1KUDtp4kCC",
        uri: "The Spins",
        artists: "Drake",
      }
    ],
    djId: ''
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    CREATE_EVENT(state, event) {
      state.events.push(event);
    },
    SET_CURRENT_EVENT(state, data) {
      state.event = data;
    },
    SET_EVENTS(state, data){
      state.events = data;
    },
    SET_CURRENT_PLAYLIST(state, data){
      state.playlist = data;
    },
    SET_HOSTS(state, data){
      state.hosts = data;
    },
    SET_PLAYLISTS(state, data){
      state.playlists = data;
    },
    SET_CURRENT_DJ(state, data) {
      state.djId = data;
    }
  }
})
