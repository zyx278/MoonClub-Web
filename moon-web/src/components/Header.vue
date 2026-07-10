<template>


<header class="header">


  <!-- 左侧 Logo -->

  <div class="logo-area">


    <div class="logo">


      🌙 皎月电竞 Club


    </div>


    <div class="sub-title">


      专业三角洲行动护航俱乐部


    </div>


  </div>






  <!-- 中间导航 -->

  <nav class="nav">


    <router-link
      to="/"
      class="nav-item"
    >

      订单合集

    </router-link>



    <router-link
      to="/rent"
      class="nav-item"
    >

      租号大厅

    </router-link>



    <router-link
      to="/notice"
      class="nav-item"
    >

      最新公告

    </router-link>



  </nav>







  <!-- 右侧按钮 -->

  <div class="right-area">



    <button
      class="admin-btn"
      @click="goAdmin"
    >

      ⚙ 管理入口

    </button>





    <ContactButton />



  </div>




</header>


</template>







<script setup>


import {
  useRouter
} from "vue-router"


import ContactButton from "./contact/ContactButton.vue"




const router = useRouter()





const goAdmin=()=>{


  router.push("login")


}



</script>








<style scoped>



.header{


  height:80px;

  background:white;

  display:flex;

  align-items:center;

  justify-content:space-between;

  padding:0 60px;

  box-shadow:0 2px 10px rgba(0,0,0,.05);

}





/* Logo */


.logo-area{


  display:flex;

  flex-direction:column;


}



.logo{


  font-size:28px;

  font-weight:800;

  color:#2563eb;


}



.sub-title{


  font-size:13px;

  color:#888;

  margin-top:4px;


}






/* 导航 */


.nav{


  display:flex;

  gap:45px;

}



.nav-item{


  text-decoration:none;

  color:#444;

  font-size:16px;

  transition:.2s;


}



.nav-item:hover{


  color:#2563eb;


}







/* 右侧 */


.right-area{


  display:flex;

  align-items:center;


}







/* 管理入口 */


.admin-btn{


  border:none;

  background:transparent;

  color:#888;

  font-size:14px;

  cursor:pointer;

  margin-right:20px;

  transition:.2s;


}




.admin-btn:hover{


  color:#2563eb;


}




</style>
