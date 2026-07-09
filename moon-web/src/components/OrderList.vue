<template>

<div class="list">

  <OrderCard
      v-for="item in orders"
      :key="item.id"
      :item="item"
  />

</div>

</template>


<script setup>

import {ref,onMounted} from "vue"

import OrderCard from "./OrderCard.vue"

import {getOrders} from "../api/order"


const orders = ref([])



function loadData(){

  getOrders()
  .then(res=>{

    orders.value = res.data.data

  })

}



onMounted(()=>{

  loadData()

})


</script>



<style scoped>

.list{

display:grid;

grid-template-columns:repeat(3,1fr);

gap:25px;

}

</style>