<template>
    <div>
        <h1>My Profile</h1>
        <div class="events">
            <h2>My Events</h2>
            <ul>
                <li class="list-one" v-for="event in events" v-bind:key="event.eventID" v-on:click="routeToEvent(event.eventID)" >{{ event.eventName }}</li>
            </ul>
        </div>
        <div class="playlists">
            <h2>My Playlists</h2>
            <ul>
                <li class="list" v-for="playlist in playlists" v-bind:key="playlist.playlistURI">{{ playlist.playlistName }}</li>
            </ul>
        </div>
    </div>
</template>

<script>
import EventService from '../services/EventService.js';

export default {
    name: 'profile-dj',
    data() {
        return {
            events: [
                {
                    eventID: '',
                    djID: '',
                    hostID: '',
                    playlistUri: '',
                    eventName: '',
                    eventInformation: '',
                    genres: '',
                    eventPicture: ''
                }
            ],
            playlists: [
                {
                    playlistURI: '',
                    playlistName: ''
                }
            ]
        }
    },
    created() {
        this.retrieveDjEvents();
        this.retrieveDjPlaylists();
    },
    methods: {
        retrieveDjEvents() {
            EventService.getDjEvents(this.$route.params.djId).then(response => {
                this.events = response.data;
            });
        },
        retrieveDjPlaylists() {
            EventService.getPlaylists().then(response => {
                this.playlists = response.data;
            });
        },
        routeToEvent(eventID){
            this.$router.push(`/events/${eventID}`)
        }
    }
};
</script>

<style scoped>
h1 {
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
    text-align: center;
}

.list, .list-one {
    list-style-type: none;
}

.events {
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
    margin-left: 10px;
    background: rgba(0,0,0,.75);
    border-radius: 5px;
    padding: 5px;
    margin: 10px;
    border: 2px solid;
    padding: 10px;
    box-shadow: 6px 4px 8px;
    cursor: pointer;
}

.playlists {
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
    cursor: pointer;
}

.list, .list-one {
    font-size: 20px;
    width: fit-content;
    padding: 2px;
    padding-left: 5px;
    padding-right: 10px;
}

.list-one:hover{
    border-color: #ff00d4;
    box-shadow: 0 0 10px #ff00d4;
    
}


</style>