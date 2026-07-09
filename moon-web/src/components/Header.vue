<template>

<header class="header">


  <div class="logo">


    🌙


    <div>

      <h1>
        皎月电竞 Club
      </h1>


      <p>
        专业三角洲行动护航俱乐部
      </p>


    </div>


  </div>





  <nav class="nav">


    <a href="#">
      首页
    </a>


    <a href="#">
      体验单
    </a>


    <a href="#">
      护航单
    </a>


    <a href="#">
      趣味单
    </a>


    <a href="#">
      活动专区
    </a>


  </nav>





  <!-- 公共联系客服组件 -->

  <ContactButton />



</header>

</template>






<script setup>


import ContactButton from "./contact/ContactButton.vue"



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




.logo h1{


    color:#2563eb;


    font-size:32px;


}




.logo p{


    color:#666;


    font-size:14px;


}




.nav{


    display:flex;


    gap:40px;


}




.nav a{


    color:#444;


    font-size:17px;


    transition:.3s;


}




.nav a:hover{


    color:#2563eb;


}



</style>