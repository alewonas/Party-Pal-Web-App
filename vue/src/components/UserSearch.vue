<template>
    <div class="searchInput">
        <h2>Search A Song</h2>
        <input class="searchBox" type="text" v-model="searchText" v-on:submit.prevent="search" @input="search" placeholder="What song would you like to listen to?" />
        <ul>
            <li class="list" v-for="result in results" v-bind:key="result.id" >
            {{ result.name }} - {{ result.artists[0].name }}
            <button class="request" v-on:click="addSong(result)">Request Song</button> 
            </li>
        </ul>
    </div>
</template>

<script>
import PlaylistService from '../services/PlaylistService';

export default {
    name: 'user-search',
    data() {
        return {
            searchText: '',
            results: [],
            newSong: {
                 uri: '',
                 name: '',
                 artists: '',
                 genreID: '3'
             }
        };
    },
    methods: {
        search() {
            if (this.searchText == ''){
                this.results = [];
            } else {
                PlaylistService.search(this.searchText).then(response => {
                    this.results = response.data;
                });
            }
          },
         addSong(result){
              this.newSong = {
                         uri: result.uri,
                         name: result.name,
                         artists: result.artists[0].name,
                         genreID: '3'
                    }
             
             PlaylistService.addSong(this.newSong).then(response => {
                if(response.status === 200){
                this.addToPlaylist();
                }
             });
         },
         addToPlaylist(){
         PlaylistService.addToPlaylist(this.newSong.uri, this.$store.state.event.playlistUri).then(response =>{
             if(response.status === 200){
                 this.retrieveSongsList();
             }
         });
        },
        retrieveSongsList(){
            PlaylistService.getSongs(this.$route.params.eventId).then(response => {
                this.$store.commit("SET_CURRENT_PLAYLIST", response.data);
            });
        }
    },
};
</script>

<style>
.searchInput{
    text-align: center;
}

.list{
    list-style-type: none;
}

.searchBox{
    width: 20%;
}

.request{
    color: white;
    font-size: 75%;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    background: rgba(0,0,0,.75);
    border-radius: 5px;
    padding: 5px;
    margin: 3px;
    border: 2px solid;
    padding: 10px;
    box-shadow: 3px 2px 4px;
    width: 7%; 
    cursor: pointer;
}

.searchBox[type=text]{
    width:30%;
    border:2px solid #aaa;
    border-radius:4px;
    margin:8px 0;
    outline:none;
    padding:8px;
    box-sizing:border-box;
    transition:.3s;
    border-color:rgb(255, 149, 246);
    background-color: rgb(255, 245, 255);
}
  
.searchBox[type=text]:focus{
    border-color:rgb(255, 149, 246);
    box-shadow:0 0 8px 0 rgb(253, 190, 248);
}
</style>