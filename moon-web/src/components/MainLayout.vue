<template>


  <div class="layout">



    <!-- 左侧分类导航 -->

    <CategorySidebar />





    <!-- 右侧主要内容 -->

    <div class="content">



      <!-- Banner宣传区域 -->

      <Banner />





      <!-- 商品列表 -->

      <div class="order-area">


        <OrderList />


      </div>



    </div>




  </div>


</template>








<script setup>


import CategorySidebar from "./CategorySidebar.vue"

import Banner from "./Banner.vue"

import OrderList from "./OrderList.vue"



</script>








<style scoped>



.layout{


    width:1200px;


    margin:30px auto;


    display:flex;


    gap:25px;


    align-items:flex-start;


}





.content{


    flex:1;


    min-width:0;


}





/*
 Banner和订单之间的距离
*/


.order-area{


    margin-top:35px;


}




</style>
