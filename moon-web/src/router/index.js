import { createRouter, createWebHistory } from "vue-router"



import Home from "../views/Home.vue"

import Detail from "../views/Detail.vue"

import Login from "../views/Login.vue"



import AdminLayout from "../views/admin/AdminLayout.vue"


import DashboardPage from "../views/admin/DashboardPage.vue"

import BannerManage from "../views/admin/BannerManage.vue"

import CategoryManage from "../views/admin/CategoryManage.vue"

import OrderManage from "../views/admin/OrderManage.vue"

import ContactManage from "../views/admin/ContactManage.vue"

import RentalManage from "../views/admin/RentalManage.vue"






const router = createRouter({


    history:createWebHistory(),



    routes:[



        {
            path:"/",

            component:Home
        },





        {
            path:"/detail/:id",

            component:Detail

        },





        {
            path:"/login",

            component:Login

        },







        {


            path:"/admin",


            component:AdminLayout,



            children:[



                {

                    path:"",

                    redirect:"/admin/dashboard"

                },





                {

                    path:"dashboard",

                    component:DashboardPage

                },





                {

                    path:"banner",

                    component:BannerManage

                },





                {

                    path:"category",

                    component:CategoryManage

                },





                {

                    path:"order",

                    component:OrderManage

                },





                {

                    path:"contact",

                    component:ContactManage

                },





                {

                    path:"rental",

                    component:RentalManage

                }



            ]

        }



    ]

})








// 路由守卫

router.beforeEach((to)=>{



    const token =

        localStorage.getItem("token")





    if(

        to.path.startsWith("/admin")

        &&

        !token

    ){



        return "/login"


    }






    return true



})







export default router
