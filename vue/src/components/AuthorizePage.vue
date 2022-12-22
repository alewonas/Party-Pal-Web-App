<template>
  <div>
      <h2 class="click">Click To Get Auth Code</h2>
      <a class="code" v-on:click="getParams()" href="https://accounts.spotify.com/authorize?client_id=39164483b245448a9b0816a999571e93&redirect_uri=http://localhost:8080/dj/authorize&response_type=code&scope=user-read-playback-state+user-modify-playback-state+user-read-currently-playing app-remote-control+streaming playlist-read-private+playlist-modify-public+user-follow-modify+user-follow-read+user-read-playback-position+user-top-read+user-read-recently-played+user-library-modify+user-library-read">Authorize</a>
        <br>
        <h3 id="auth-code"> </h3>
  </div>
</template>

<script>
export default {
    name: "authorize-page",
    methods: {
        getParams (){
            let urlParam = new URLSearchParams(window.location.search);

            const h3 = document.querySelector("#auth-code");
            h3.innerHtml = urlParam;
        }
    }
};
</script>

<style>
.code{
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
    position: absolute;
    top:35%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
}

.click{
    text-align: center;
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
    text-align: center;
}
</style>