<template>
  <div class= "buttons">
      <button id="play" v-on:click="playSong(); hideButton = true" v-if="!hideButton"/>
      <button id="pause" v-on:click="pauseSong"/>
      <button id="fwd" v-on:click="skipSong"/>
  </div>
</template>

<script>
import PlaylistService from '../services/PlaylistService';

export default {
    name: 'music-player',
    data() {
        return {
            hideButton: false
        }
    },
    methods: {
        playSong(){
            PlaylistService.playSong(this.$route.params.eventId)
        },
        pauseSong(){
            PlaylistService.pauseSong()
        },
        skipSong(){
            PlaylistService.skipSong()
        }
    }
};
</script>

<style>
.buttons{
    text-align:center;
}

 #play, #pause, #fwd, #rew {
   width:80px;
   height: 80px;
   background: white;
   position: relative;
   margin-top: 10px;
   display: inline-block;
   margin-right: 25px;
   align-content: center;
   border-radius: 5px;
   cursor: pointer;
}

#play:before {
    width: 0;        
    height: 0;
    border-left: 30px solid #9000BE;
    border-right: 30px solid transparent;
    border-top: 30px solid transparent;
    border-bottom: 30px solid transparent; 
    position: absolute;
    content: "";
    top: 10px;
    left: 25px;
}

#pause:before {
    width: 10px;        
    height: 60px;
    background: #9000BE;
    position: absolute;
    content: "";
    top: 10px;
    left: 25px;
}

#pause:after {
    width: 10px;        
    height: 60px;
    background: #9000BE;
    position: absolute;
    content: "";
    top: 10px;
    right: 25px;
}

#fwd:before {
    width: 0;        	
    height: 0;
    border-left: 30px solid #9000BE;
    border-right: 30px solid transparent;
    border-top: 30px solid transparent;
    border-bottom: 30px solid transparent; 
    position: absolute;
    content: "";
    top: 10px;
    left: 17px;
}

#fwd:after {
    width: 0;        	
    height: 0;
    border-left: 30px solid #9000BE;
    border-right: 30px solid transparent;
    border-top: 30px solid transparent;
    border-bottom: 30px solid transparent; 
    position: absolute;
    content: "";
    top: 10px;
    left: 35px;
}

#rew:before {
    width: 0;        	
    height: 0;
    border-left: 30px solid transparent;
    border-right: 30px solid #9000BE;
    border-top: 30px solid transparent;
    border-bottom: 30px solid transparent; 
    position: absolute;
    content: "";
    top: 10px;
    right: 17px;
}

#rew:after {
    width: 0;        	
    height: 0;
    border-left: 30px solid transparent;
    border-right: 30px solid #9000BE;
    border-top: 30px solid transparent;
    border-bottom: 30px solid transparent; 
    position: absolute;
    content: "";
    top: 10px;
    right: 35px;
}
</style>