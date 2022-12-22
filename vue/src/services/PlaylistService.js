import axios from "axios";

export default {

    getSongs(eventID){
        return axios.get(`/song/playlist/${eventID}`);
    },

    search(searchText){
        return axios.get(`/search/tracks/${searchText}`);
    },

    addSong(newSong){
         return axios.post('/song/add', newSong);
    },

    playSong(eventId){
        return axios.put(`/play/${eventId}`);
    },

    pauseSong(){
        return axios.put('/pause');
    },

    skipSong(){
        return axios.post('/skip');
    },

    addToPlaylist(trackUri, playlistUri){
        return axios.post(`/add/playlist/${trackUri}`, playlistUri);
    }

}