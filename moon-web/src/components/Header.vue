<template>

<header class="header">


  <!-- Logo -->

  <div class="logo">


    <div class="moon">
      🌙
    </div>


    <div>

      <h1>
        皎月电竞 Club
      </h1>


      <p>
        专业三角洲行动护航俱乐部
      </p>


    </div>


  </div>





  <!-- 官网导航 -->

  <nav class="nav">


    <div
        class="nav-item"
        @click="goOrder"
    >
      订单合集
    </div>



    <div
        class="nav-item"
        @click="comingSoon"
    >
      租号大厅
    </div>



    <div
        class="nav-item"
        @click="comingSoon"
    >
      最新公告
    </div>


  </nav>





  <!-- 联系客服 -->

  <ContactButton />



</header>

</template>







<script setup>


import ContactButton from "./contact/ContactButton.vue"

import {
  useRouter
} from "vue-router"



const router = useRouter()





// 订单合集

function goOrder(){

  router.push("/")

}





// 暂未开放

function comingSoon(){

  alert("功能正在施工中，敬请期待！")

}



</script>








<style scoped>


.header{


    height:80px;


    background:white;


    display:flex;


    justify-content:space-between;


    align-items:center;


    padding:0 60px;


    box-shadow:0 3px 12px rgba(0,0,0,.06);


    position:sticky;


    top:0;


    z-index:1000;


}





.logo{


    display:flex;


    align-items:center;


    gap:15px;


}





.moon{


    font-size:38px;

}





.logo h1{


    color:#2563eb;


    font-size:32px;


    margin:0;


}





.logo p{


    color:#666;


    font-size:14px;


    margin-top:4px;


}





.nav{


    display:flex;


    gap:55px;


}





.nav-item{


    color:#444;


    font-size:18px;


    cursor:pointer;


    transition:.3s;


    position:relative;


}





.nav-item:hover{


    color:#2563eb;


}






.nav-item::after{


    content:"";


    position:absolute;


    bottom:-8px;


    left:50%;


    width:0;


    height:3px;


    background:#2563eb;


    border-radius:3px;


    transform:translateX(-50%);


    transition:.3s;


}





.nav-item:hover::after{


    width:100%;


}





</style>
