<template>
    <div class="event-card">
        <div class="loading" v-if="isLoading">
            <img src="../assets/loading_motion.gif" />
        </div>
        <div v-else>
            <h1 class="eventTitle">{{ events.eventName }}</h1>
                <div class="eventInformation">
                    <p>Event Details</p>
                    <p> {{ events.hostName }}</p>
                    <h3>{{ events.eventInformation }}</h3>
                    <h5>Genre(s): {{ events.genres }}</h5>
                    <button class="edit-event">
                        <router-link class="edit-link" v-bind:to="{name: 'edit-event', params: { eventID: $route.params.eventId }}">Edit Event</router-link>
                    </button>
                    <button class="btn delete-event" v-on:click="deleteEvent">Delete Event</button>
                    <div class="status-message error" v-show="errorMsg !== ''">{{ errorMsg }}</div>
                </div>
            <div>
                <user-search />
                <playlist />
                <music-player /> 
            </div>
        </div>
    </div>
</template>

<script>
import EventService from "../services/EventService";
import Playlist from './Playlist.vue';
import UserSearch from './UserSearch.vue';
import MusicPlayer from './MusicPlayer.vue';

export default {
    name: 'event-card',
    components: { 
        Playlist,
        UserSearch, 
        MusicPlayer
    },
    data() {
        return {
            isLoading: false,
            errorMsg: "",
        };
    },
    methods: {
       retrieveEvent() {
           EventService
            .getEvent(this.$route.params.eventId)
            .then(response => {
                this.$store.commit("SET_CURRENT_EVENT", response.data);
                this.isLoading = false;
            })
            .catch(error => {
                if (error.response && error.response.status === 400) {
                    alert("Event not available. You may have entered and invalid event ID.");
                    this.$router.push({ name: 'events' });
                }
            });
       },
       deleteEvent() {
           if (
               confirm("Are you sure you want to delete this event? This cannot be undone.")
           ) {
               EventService
                .deleteEvent(this.$route.params.eventId)
                .then(response => {
                    if (response.status === 204) {
                        alert("Event successfully deleted");
                        this.$router.push(`/events`);
                    }
                })
                .catch(error => {
                    if (error.response) {
                        this.errorMsg = "Error deleting event. Response received was '" + error.response.statusText + "'.";
                    } else if (error.request) {
                        this.errorMsg = "Error deleting event. Server could not be reached.";
                    } else {
                        this.errorMsg = "Error deleting event. Request could not be created.";
                    }
                });
           }
       },
    },
    created() {
        this.retrieveEvent();
    },
    computed: {
        events() {
            return this.$store.state.event
        }
    }
};
</script>

<style>
.event-card {
    font-family: Arial, Helvetica, sans-serif;
    background-color: rgba(144, 0, 190, .2);
    border-radius: 2px;
    padding: 10px 10px 10px 10px;
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: oblique;
}

.edit-event {
    color: #fff;
    background-color: #A96BCB;
    border-color: #ac66d1;
    margin-right: 10px;
    cursor: pointer;
}

.delete-event {
    color: #fff;
    background-color: #A96BCB;
    border-color: #ac66d1;
    cursor: pointer;
}

.edit-link {
    text-decoration: none;
    color: #fff;
}

.eventTitle{
    text-align: center;
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
}

.eventInformation{
    background: rgba(0,0,0,.75);
    color: white;
    border-radius: 5px;
    padding: 5px;
    margin: 10px;
    border: 2px solid white;
    padding: 10px;
    box-shadow: 6px 4px 8px white;
}
</style>