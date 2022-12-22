<template>
  <form v-on:submit.prevent="createEvent" class="new-event-form">
      <div class="status-message error" v-show="errorMsg !== ''">{{ errorMsg }}</div>
      <div class="form-group">
          <label for="eventName">Event Name:</label>
          <input id="eventName" type="text" class="form-control" v-model="event.eventName" autocomplete="off" />
      </div>
      <div class="form-group">
          <label >Host Name:</label>
          <br>
          <select v-model="event.hostID" class="select-1">
              <option v-bind:value="host.hostID" v-for="host in hosts" v-bind:key="host.hostID" >{{ host.hostName }}</option>
          </select>
      </div>
      <div class="form-group">
          <label for="event-info">Event Information:</label>
          <input id="event-info" type="text" class="form-control" v-model="event.eventInformation" autocomplete="off" />
      </div>
      <div class="form-group">
          <label for="event-genres">Genre(s)</label>
          <input id="event-genres" type="text" class="form-control" v-model="event.genres" autocomplete="off" />
      </div>
      <div class="form-group">
          <label for="event-pic">Picture:</label>
          <input id="event-pic" type="text" class="form-control" v-model="event.eventPicture" autocomplete="off" />
      </div>
      <div class="form-group">
          <label >Assign Playlist:</label>
          <br>
          <select name="playlist-name" v-model="event.playlistUri" class="select-2">
              <option v-bind:value="playlist.playlistURI" v-for="playlist in playlists" v-bind:key="playlist.playlistURI">{{ playlist.playlistName }}</option>
          </select>
      </div>
      <button class="btn btn-submit">Submit</button>
      <button class="btn btn-cancel" v-on:click="cancelEvent" type="button">Cancel</button>
  </form>
</template>

<script>
import EventService from "../services/EventService.js";

export default {
    name: 'event-form',
    props: {
        eventID: {
            type: Number,
            default: 0
        }
    },
    data() {
        return {
            event: {
                hostID: 0,
                eventName: '',
                eventInformation: '',
                genres: '',
                eventPicture: '',
                playlistUri: '',
            },
            errorMsg: '',
            hostAsString: '',
            hostToInt: parseInt(this.hostAsString)
        };
    },
    methods: {
        createEvent() {
            const newEvent = {
                eventName: this.event.eventName,
                hostName: this.event.hostName
            };

            if (this.eventID === 0){
                EventService
                    .addEvent(this.event)
                    .then(response => {
                        if (response.status === 201) {
                            this.$router.push(`/events`);
                        }
                    })
                    .catch(error => {
                        this.handleErrorResponse(error, "adding");
                    });
            } else {
                newEvent.id = this.eventID;
                EventService
                    .updateEvent(this.event)
                    .then(response => {
                        if (response.status === 201) {
                            this.$router.push(`/events/${this.event.eventID}`);
                        }
                    })
                    .catch(error => {
                        this.handleErrorResponse(error, "updating");
                    });
            }
        },
        cancelEvent() {
            if (this.eventID === 0){
               this.$router.push(`/dj`); 
            } else {
                this.$router.push(`/events/${this.$route.params.eventId}`);
            }
        },
        handleErrorResponse(error, verb) {
            if (error.response) {
                this.errorMsg = 
                "Error " + verb + " event. Response received was '" +
                error.response.statusText + "'.";
            } else if (error.request) {
                this.errorMsg =
                "Error " + verb + " event. Server could not be reached.";
            } else {
                this.errorMsg =
                "Error " + verb + " event. Request could not be created.";
            }
        },
        addNewEvent() {
            this.$store.commit("ADD_EVENT", this.event)
        },
        retrieveHosts(){
            EventService.getHosts().then(response => {
                this.$store.commit("SET_HOSTS", response.data)
            });
        },
        retrievePlaylists(){
            EventService.getPlaylists().then(response => {
                this.$store.commit("SET_PLAYLISTS", response.data)
            });
        }
    },
    created() {
        this.retrieveHosts();
        this.retrievePlaylists();

        if (this.eventID != 0) {
            EventService
                .getEvent(this.eventID)
                .then(response => {
                    this.event = response.data;
                })
                .catch(error => {
                    if (error.response && error.response.status === 400) {
                        alert(
                            "Event not available. You may have entered an invalid event ID."
                        );
                        this.$router.push({ name: 'Home'})
                    }
                });
        }
    }, 
    computed: {
        hosts(){
            return this.$store.state.hosts
        },
        playlists(){
            return this.$store.state.playlists
        },
    }
};
</script>

<style>
.new-event-form {
    padding: 10px;
    margin-bottom: 10px;
    background-color:rgb(233, 186, 233);
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
    background: rgba(0,0,0,.75);
    border-radius: 5px;
    padding: 5px;
    margin: 10px;
    border: 2px solid;
    padding: 10px;
    box-shadow: 6px 4px 8px;
}

.form-group {
    margin-bottom: 10px;
    margin-top: 10px;
}

label {
    display: inline-block;
    margin-bottom: 0.5rem;
}

.form-control {
    display: block;
    width: 80%;
    height: 30px;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
}

.btn-submit {
    color: #fff;
    background-color: #A96BCB;
    border-color: #ac66d1;
    margin-right: 10px;
    cursor: pointer;
}

.btn-cancel {
    color: #fff;
    background-color: #A96BCB;
    border-color: #ac66d1;
    cursor: pointer;
}

.status-message {
    display: block;
    border-radius: 5px;
    font-weight: bold;
    font-size: 1rem;
    text-align: center;
    padding: 10px;
    margin-bottom: 10px;
}

.status-message.success {
    background-color: #90ee90;
}

.status-message.error {
    background-color: #f08080;
}

.form-control[type=text]{
    width:90%;
    border:2px solid #aaa;
    border-radius:4px;
    margin:8px 0;
    outline:none;
    padding:8px;
    box-sizing:border-box;
    transition:.3s;
    border-color:rgb(255, 149, 246);
}
  
.form-control[type=text]:focus{
    border-color:rgb(255, 149, 246);
    box-shadow:0 0 8px 0 rgb(253, 190, 248);
}

.select-1{
    width:auto;
    border:2px solid #aaa;
    border-radius:4px;
    margin:8px 0;
    outline:none;
    padding:3px;
    box-sizing:border-box;
    transition:.3s;
    border-color:rgb(255, 149, 246);
}
  
.select-1:focus{
    border-color:rgb(255, 149, 246);
    box-shadow:0 0 8px 0 rgb(253, 190, 248);
}

.select-2{
    width:auto;
    border:2px solid #aaa;
    border-radius:4px;
    margin:8px 0;
    outline:none;
    padding:3px;
    box-sizing:border-box;
    transition:.3s;
    border-color:rgb(255, 149, 246);
}
  
.select-2:focus{
    border-color:rgb(255, 149, 246);
    box-shadow:0 0 8px 0 rgb(253, 190, 248);
}

</style>