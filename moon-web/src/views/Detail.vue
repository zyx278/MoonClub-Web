<template>

  <div class="detail-page">


    <div class="detail-container">



      <!-- 返回按钮 -->

      <div class="back-area">


        <button
          class="back-btn"
          @click="goHome"
        >

          ← 返回订单合集

        </button>


      </div>





      <!-- 内容区域 -->

      <div class="content-area">



        <!-- 左侧图片 -->

        <div class="image-area">


          <div class="image-box">


            <img
              v-if="order.coverImage"
              :src="imageUrl(order.coverImage)"
              class="detail-image"
              @click="showImage=true"
            />


          </div>



          <div class="image-tip">

            点击查看完整图片

          </div>


        </div>






        <!-- 右侧信息 -->

        <div class="info-area">



          <h1 class="title">

            {{order.title}}

          </h1>





          <div class="tag">

            {{order.category}}

          </div>







          <!-- 简介 -->

          <div class="intro-card">


            <div class="card-title">

              订单简介

            </div>



            <div class="intro-content">

              {{order.description}}

            </div>



          </div>







          <!-- 联系客服 -->

          <div class="contact-area">


            <ContactButton />


          </div>





        </div>




      </div>



    </div>








    <!-- 图片放大 -->

    <div
      v-if="showImage"
      class="mask"
      @click="showImage=false"
    >


      <img
        :src="imageUrl(order.coverImage)"
        class="big-image"
      />


    </div>



  </div>


</template>






<script setup>


import {
  ref,
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



const order = ref({})


const showImage = ref(false)





const imageUrl=(path)=>{


  if(!path){

    return ""

  }



  if(path.startsWith("http")){

    return path

  }



  return "http://localhost:8080" + path


}






const goHome=()=>{


  router.push("/")


}







onMounted(async()=>{


  try{


    const res = await axios.get(

      `http://localhost:8080/api/orders/${route.params.id}`

    )



    order.value=res.data.data



  }catch(error){


    console.log(
      "获取详情失败",
      error
    )


  }


})



</script>







<style scoped>


.detail-page{


  min-height:100vh;

  background:#f3f6fb;

  padding:40px;


}





.detail-container{


  max-width:1250px;

  margin:auto;

  background:white;

  border-radius:22px;

  padding:35px;


}







/* 返回 */


.back-area{


  margin-bottom:25px;


}




.back-btn{


  border:none;

  background:#edf3ff;

  color:#2563eb;

  padding:10px 22px;

  border-radius:20px;

  font-size:15px;

  cursor:pointer;

  transition:.2s;


}



.back-btn:hover{


  background:#2563eb;

  color:white;


}









/* 内容 */

.content-area{


  display:flex;

  gap:45px;


}









/* 左侧图片 */


.image-area{


  width:45%;

  height:650px;

  position:relative;


}




.image-box{


  width:100%;

  height:100%;

  background:#f7f9ff;

  border-radius:18px;

  display:flex;

  justify-content:center;

  align-items:center;

  padding:20px;


}




.detail-image{


  max-width:100%;

  max-height:600px;

  object-fit:contain;

  border-radius:12px;

  cursor:pointer;


}





.image-tip{


  position:absolute;

  bottom:25px;

  right:25px;

  background:rgba(0,0,0,.55);

  color:white;

  padding:8px 16px;

  border-radius:20px;

  font-size:14px;


}









/* 右侧 */


.info-area{


  flex:1;

  min-width:0;

  padding-top:10px;


}





.title{


  font-size:38px;

  font-weight:800;

  margin-bottom:20px;


}




.tag{


  display:inline-block;

  background:#2563eb;

  color:white;

  padding:7px 18px;

  border-radius:20px;

  font-weight:600;

  margin-bottom:30px;


}








/* 简介 */


.intro-card{


  background:white;

  border:1px solid #e5edff;

  border-radius:18px;

  box-shadow:

  0 8px 25px rgba(0,0,0,.05);

  padding:25px;


}






.card-title{


  font-size:22px;

  font-weight:700;

  color:#2563eb;

  margin-bottom:20px;


}





.intro-content{


  height:300px;

  overflow-y:auto;

  white-space:pre-line;

  line-height:1.9;

  font-size:16px;

  color:#333;


}








/* 客服 */


.contact-area{


  margin-top:45px;


}









/* 放大 */


.mask{


  position:fixed;

  inset:0;

  background:rgba(0,0,0,.75);

  display:flex;

  justify-content:center;

  align-items:center;

  z-index:999;


}





.big-image{


  max-width:90%;

  max-height:90%;


}



</style>
