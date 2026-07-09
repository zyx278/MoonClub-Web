<template>

<div class="detail-page">


  <!-- 返回 -->

  <div
      class="back"
      @click="backHome"
  >
    ← 返回首页
  </div>




  <div
      class="detail-card"
      v-if="order.id"
  >


    <!-- 商品图片 -->

    <div
        class="image-box"
        @click="showImage=true"
    >


      <img
          :src="imageUrl"
          class="cover"
      />



      <div class="tip">

        点击查看完整图片

      </div>


    </div>





    <!-- 信息 -->

    <div class="content">


      <h1>

        {{order.title}}

      </h1>




      <span class="tag">

        {{order.category}}

      </span>





      <p class="desc">

        {{order.description}}

      </p>





      <!-- 公共联系客服组件 -->

      <ContactButton />



    </div>


  </div>







  <!-- 图片放大层 -->

  <div
      v-if="showImage"
      class="mask"
      @click="showImage=false"
  >



    <img

        :src="imageUrl"

        class="big-image"

        @click.stop

    />



  </div>





</div>

</template>







<script setup>


import {

  ref,

  computed,

  onMounted

} from "vue"





import {

  useRoute,

  useRouter

} from "vue-router"





import axios from "axios"





import ContactButton from "../components/contact/ContactButton.vue"






const route = useRoute()


const router = useRouter()





// 当前订单

const order = ref({})





// 图片查看

const showImage = ref(false)







// 商品图片地址

const imageUrl = computed(()=>{



  if(!order.value.coverImage){


    return ""


  }




  return "http://localhost:8080"

      +

      order.value.coverImage



})







// 加载订单

function loadData(){



  axios.get(

      "http://localhost:8080/api/orders/"

      +

      route.params.id


  )

  .then(res=>{


    order.value=res.data.data



  })



}








// 返回首页

function backHome(){


  router.push("/")



}









onMounted(()=>{


  loadData()



})



</script>







<style scoped>


.detail-page{


  width:1200px;


  margin:40px auto;



}






.back{


  color:#2563eb;


  cursor:pointer;


  margin-bottom:20px;



}






.detail-card{


  background:white;


  border-radius:20px;


  overflow:hidden;


  box-shadow:


  0 10px 30px rgba(0,0,0,.08);



}






.image-box{


  position:relative;


  cursor:pointer;



}







.cover{


  width:100%;


  max-height:600px;


  object-fit:contain;


  display:block;



}






.tip{


  position:absolute;


  bottom:20px;


  right:20px;



  background:rgba(0,0,0,.55);



  color:white;



  padding:8px 15px;



  border-radius:20px;



  font-size:14px;



}







.content{


  padding:40px;



}







h1{


  font-size:36px;


  margin-bottom:20px;



}






.tag{


  background:#dbeafe;


  color:#2563eb;



  padding:8px 18px;



  border-radius:20px;



}







.desc{


  margin-top:25px;



  font-size:18px;



  color:#666;



  line-height:1.8;



}









/* 图片查看层 */


.mask{


  position:fixed;



  inset:0;



  background:rgba(0,0,0,.8);



  display:flex;



  justify-content:center;



  align-items:center;



  z-index:9999;



}






.big-image{


  max-width:95%;


  max-height:95%;



  object-fit:contain;



}



</style>