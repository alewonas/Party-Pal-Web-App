import axios from "axios";



export default {

    addEvent(event) {
        return axios.post('/event/create', event);
    },

    updateEvent(event) {
        return axios.put(`/event/update`, event);
    },

    getEvents(){
        return axios.get('/event/list');
    },

    getEvent(eventID) {
        return axios.get(`/event/${eventID}`);
    },

    deleteEvent(eventID) {
        return axios.delete(`/event/delete/${eventID}`);
    },

    getHosts(){
        return axios.get('/dj/hosts');
    },

    getPlaylists(){
        return axios.get('/playlist/list');
    },

    getDjEvents(djId) {
        return axios.get(`/event/dj/${djId}`);
    }
    
}

axios