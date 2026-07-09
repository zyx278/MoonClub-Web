<template>

<section class="banner">


  <div class="left">


    <h1>
      🌙 皎月电竞 Club
    </h1>



    <h2>
      专业三角洲行动护航俱乐部
    </h2>



    <p>
      ⭐ 全绿护航 · ⭐ 极速发车 · ⭐ 售后无忧
    </p>



    <p class="slogan">

      每一次出征，都值得胜利

    </p>



  </div>





  <div class="right">


    <div class="image">


      <!--
        后续这里改成活动轮播组件

        例如：
        ActivityBanner.vue

      -->


      活动宣传图


    </div>


  </div>



</section>

</template>






<script setup>


</script>







<style scoped>


.banner{


    width:100%;


    height:420px;


    background:linear-gradient(135deg,#2563eb,#60a5fa);


    border-radius:24px;


    margin-top:25px;


    display:flex;


    justify-content:space-between;


    align-items:center;


    padding:60px;


    color:white;


}





.left{


    width:50%;


}





.left h1{


    font-size:48px;


    margin-bottom:15px;


}





.left h2{


    font-size:24px;


    font-weight:400;


    margin-bottom:20px;


}





.left p{


    font-size:18px;


    opacity:.95;


    margin-bottom:20px;


}





.slogan{


    font-size:22px !important;


    font-weight:bold;


    margin-top:35px;


}






.right{


    width:40%;


    display:flex;


    justify-content:center;


}





.image{


    width:360px;


    height:260px;


    background:rgba(255,255,255,.2);


    border-radius:20px;


    display:flex;


    justify-content:center;


    align-items:center;


    font-size:28px;


    backdrop-filter:blur(10px);


}



</style>