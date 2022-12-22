import Vue from 'vue';
import Router from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import Logout from '../views/Logout.vue';
import Register from '../views/Register.vue';
import Event from '../views/Event.vue';
import Dj from '../views/Dj.vue';
import AddEvent from '../views/AddEvent.vue';
import EditEvent from '../views/EditEvent.vue';
import store from '../store/index';
import Authorize from '../views/Authorize';
import EventDetail from '../components/EventDetail.vue'
import DjProfile from '../views/DjProfile.vue';


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/events",
      name: "events",
      component: Event,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/dj",
      name: "dj",
      component: Dj,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/dj/addevent",
      name: "add-event",
      component: AddEvent,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/events/edit/:eventId",
      name: "edit-event",
      component: EditEvent,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/dj/authorize",
      name: "authorize",
      component: Authorize,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/events/:eventId',
      name: 'event',
      component: EventDetail,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/dj/:djId',
      name: 'dj-profile',
      component: DjProfile,
      meta: {
        requiresAuth: true
      }
    }
  ]
});

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
