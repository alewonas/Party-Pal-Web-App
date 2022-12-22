<template>
    <div>
        <h2 class="eventSongs">Event Songs</h2>
        <div class="scroll">
            <div class="song" v-for="song in playlist" v-bind:key="song.songName">
                <h3>{{ song.songName }}</h3>
                <p class="artist">By:{{ song.artist }}</p>
            </div>
        </div>
  </div>
</template>

<script>
import PlaylistService from "../services/PlaylistService"

export default {
    name: "playlist",
    created() {
        this.retrieveSongs();
    },
    methods: {
        retrieveSongs(){
            PlaylistService.getSongs(this.$route.params.eventId).then(response => {
                this.$store.commit("SET_CURRENT_PLAYLIST", response.data);
            })
        }
    },
    computed: {
        playlist(){
            return this.$store.state.playlist;
        }
    }
};
</script>

<style>
.scroll{
    overflow-y: scroll;
    height: 400px;
    border: 5px solid black;
    border-radius: 5px;
    padding: 10px;
}

.song {
    background: rgba(0,0,0,.75);
    border-style: solid;
    border-color: black;
    border-radius: 5px;
    padding: 5px;
    margin: 10px;
    border: 2px solid white;
    padding: 10px;
    box-shadow: 6px 4px 8px white;
    font-family: "Audiowide";
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
}

.eventSongs{
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
}
</style>