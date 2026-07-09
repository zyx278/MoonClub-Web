<template>

  <Header/>

  <div class="container">

    <Banner/>

    <CategoryBar/>

    <OrderList/>

  </div>

</template>


<script setup>

import Header from "../components/Header.vue"

import Banner from "../components/Banner.vue"

import CategoryBar from "../components/CategoryBar.vue"

import OrderList from "../components/OrderList.vue"


</script>


<style scoped>

.container{

    width:1200px;

    margin:0 auto;

}


</style>