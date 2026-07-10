<template>


  <div class="layout">


    <!-- 左侧分类 -->

    <CategorySidebar

        @change="changeCategory"

    />





    <!-- 右侧内容 -->

    <div class="content">


      <Banner />




      <div class="order-area">


        <OrderList

            :category="currentCategory"

        />


      </div>



    </div>



  </div>


</template>





<script setup>


import {

  ref

} from "vue"



import CategorySidebar from "./CategorySidebar.vue"

import Banner from "./Banner.vue"

import OrderList from "./OrderList.vue"





/**
 * 当前选择分类
 */
const currentCategory = ref(

    "热门推荐"

)







/**
 * 接收左侧分类点击
 */
function changeCategory(category){


  console.log(
      "当前选择分类:",
      category
  )



  currentCategory.value = category


}



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






.order-area{


    margin-top:35px;


}



</style>
