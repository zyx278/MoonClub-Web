import { createRouter, createWebHistory } from "vue-router"

import Home from "../views/Home.vue"
import Detail from "../views/Detail.vue"
import Admin from "../views/Admin.vue"

const router = createRouter({

    history: createWebHistory(),

    routes: [

        {
            path: "/",
            component: Home
        },

        {
            path: "/detail/:id",
            component: Detail
        },

        {
            path: "/admin",
            component: Admin
        }

    ]

})

export default router