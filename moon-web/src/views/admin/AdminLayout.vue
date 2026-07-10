<template>


  <div class="admin-layout">



    <!-- 顶部 -->

    <header class="admin-header">


      <div class="logo">

        🌙 皎月电竞后台管理系统

      </div>





      <div class="user-area">


        <span>

          管理员：

          {{ username }}

        </span>





        <button

            @click="logout"

        >

          退出登录

        </button>


      </div>



    </header>







    <div class="admin-body">





      <!-- 左侧菜单 -->

      <aside class="admin-sidebar">





        <router-link

          to="/admin/dashboard"

          class="menu-item"

        >

          首页

        </router-link>







        <router-link

          to="/admin/banner"

          class="menu-item"

        >

          活动部署

        </router-link>







        <router-link

          to="/admin/category"

          class="menu-item"

        >

          订单类型管理

        </router-link>







        <router-link

          to="/admin/order"

          class="menu-item"

        >

          订单编辑

        </router-link>







        <router-link

          to="/admin/contact"

          class="menu-item"

        >

          客服联系方式

        </router-link>







        <router-link

          to="/admin/rental"

          class="menu-item"

        >

          租号大厅

        </router-link>





      </aside>







      <!-- 内容区域 -->


      <main class="admin-content">


        <router-view />



      </main>





    </div>





  </div>


</template>








<script setup>


import {

    ref

} from "vue"



import {

    useRouter

} from "vue-router"






const router = useRouter()






const username = ref(

    localStorage.getItem("username")

    ||

    "管理员"

)









function logout(){



    localStorage.removeItem(

        "token"

    )



    localStorage.removeItem(

        "username"

    )





    router.push(

        "/login"

    )



}



</script>








<style scoped>


.admin-layout{


    width:100%;


    height:100vh;


    display:flex;


    flex-direction:column;


    background:#f5f7fb;


}






.admin-header{


    height:64px;


    background:#1e293b;


    color:white;


    display:flex;


    align-items:center;


    justify-content:space-between;


    padding:0 30px;


}






.logo{


    font-size:20px;


    font-weight:bold;


}







.user-area{


    display:flex;


    align-items:center;


    gap:20px;


    font-size:14px;


}







.user-area button{


    border:none;


    background:#ef4444;


    color:white;


    padding:8px 16px;


    border-radius:8px;


    cursor:pointer;


}





.user-area button:hover{


    background:#dc2626;


}








.admin-body{


    flex:1;


    display:flex;


}







.admin-sidebar{


    width:220px;


    background:white;


    padding:20px 0;


    box-shadow:


    2px 0 8px rgba(0,0,0,.05);


}







.menu-item{


    display:block;


    padding:14px 30px;


    color:#475569;


    font-size:15px;


}







.menu-item:hover{


    background:#eef3fa;


    color:#2563eb;


}







.router-link-active{


    background:#e0ecff;


    color:#2563eb;


    font-weight:bold;


}







.admin-content{


    flex:1;


    padding:30px;


    overflow:auto;


}



</style>
