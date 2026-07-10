<template>


  <aside class="sidebar">


    <div class="title">

      订单分类

    </div>



    <div

        v-for="item in categories"

        :key="item.id"

        class="category-item"

        :class="{

          active:item.name===currentCategory

        }"

        @click="selectCategory(item.name)"

    >

      {{ getIcon(item.name) }}

      {{ item.name }}


    </div>



  </aside>


</template>






<script setup>


import {

  ref,

  onMounted

} from "vue"



import axios from "axios"





const emit = defineEmits([

    "change"

])





const categories = ref([])





const currentCategory = ref(
    "热门推荐"
)






function loadCategories(){


  axios.get(

      "http://localhost:8080/api/category"

  )

  .then(res=>{


    categories.value =

        (res.data.data || [])

            .filter(item=>item.status===1)



  })


}







function selectCategory(name){


  currentCategory.value=name


  emit(

      "change",

      name

  )


}








function getIcon(name){


  const map={


    "热门推荐":"🔥",


    "体验单":"🎮",


    "护航单":"🛡",


    "趣味单":"🎲",


    "活动专区":"🎁"


  }



  return map[name] || "📦"


}








onMounted(()=>{


  loadCategories()


})



</script>







<style scoped>


.sidebar{


    width:220px;


    background:white;


    border-radius:18px;


    padding:25px;


    box-shadow:


    0 8px 25px rgba(0,0,0,.06);



    flex-shrink:0;


}







.title{


    font-size:22px;


    font-weight:bold;


    margin-bottom:25px;


    color:#1f2937;


}







.category-item{


    height:50px;


    display:flex;


    align-items:center;


    padding:0 18px;


    margin-bottom:12px;


    border-radius:12px;


    cursor:pointer;


    color:#555;


    font-size:16px;


    transition:.3s;


}







.category-item:hover{


    background:#eff6ff;


    color:#2563eb;


}







.category-item.active{


    background:#2563eb;


    color:white;


}



</style>
