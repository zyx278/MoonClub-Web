<template>


  <div class="main-content">



    <!-- 左侧分类菜单 -->

    <CategorySidebar />





    <!-- 右侧内容区域 -->

    <div class="right-content">



      <!-- 顶部 Banner -->

      <Banner />





      <!-- 订单区域 -->

      <div class="order-area">


        <OrderList />


      </div>



    </div>




  </div>


</template>







<script setup>


import CategorySidebar from "./CategorySidebar.vue"

import OrderList from "./OrderList.vue"

import Banner from "./Banner.vue"



</script>








<style scoped>



.main-content{


    display:flex;


    gap:24px;


    margin-top:30px;


    align-items:flex-start;



}







/* 右侧区域 */


.right-content{


    flex:1;


    min-width:0;


}







/* Banner 和订单之间的距离 */


.order-area{


    margin-top:30px;



}






</style>
