<template>
  <div>
       <h1>Create New Event</h1>
       <event-form />
  </div>
</template>

<script>
import EventForm from "../components/EventForm.vue";

export default {
    name: "add-event",
    components: {
        EventForm
    }
};
</script>

<style scoped>
h1 {
    text-align: center;
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
    text-align: center;
}
</style>