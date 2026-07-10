<template>


<div class="banner">


  <!-- 左侧文字区域 -->

  <div class="banner-content">


    <div class="brand">


      <span class="moon">
        🌙
      </span>


      <h1>
        皎月电竞 Club
      </h1>


    </div>



    <p class="desc">
      专业三角洲行动护航俱乐部
    </p>



    <div class="tags">


      <span>
        ⭐ 全绿护航
      </span>


      <span>
        ⭐ 极速发车
      </span>


      <span>
        ⭐ 售后无忧
      </span>


    </div>



    <h2>
      每一次出征，都值得胜利
    </h2>



  </div>






  <!-- 右侧活动图片 -->

  <div class="banner-image">



      <img

          v-if="currentBanner"

          :src="imageUrl"

          class="activity-image"

      />



      <div

          v-else

          class="image-placeholder"

      >

          活动宣传图


      </div>



  </div>





</div>



</template>








<script setup>


import {

    ref,

    computed,

    onMounted,

    onUnmounted

} from "vue"



import request from "../api/request"







const banners = ref([])



const index = ref(0)



let timer = null







/**
 * 获取Banner数据
 */
function loadBanner(){


    return request.get("/api/banner")

        .then(res=>{


            banners.value =

                res.data.data || []



        })


}







/**
 * 当前显示Banner
 */
const currentBanner = computed(()=>{


    if(

        banners.value.length === 0

    ){

        return null

    }



    return banners.value[index.value]


})







/**
 * 图片地址
 */
const imageUrl = computed(()=>{


    if(

        !currentBanner.value

    ){

        return ""

    }



    return "http://localhost:8080"

        +

        currentBanner.value.image


})









/**
 * 开始轮播
 */
function startLoop(){



    if(

        banners.value.length <= 1

    ){

        return

    }






    timer = setInterval(()=>{



        index.value++




        if(

            index.value >= banners.value.length

        ){

            index.value = 0

        }



    },4000)



}









onMounted(()=>{


    loadBanner()

        .then(()=>{


            startLoop()


        })

        .catch(err=>{


            console.error(

                "Banner加载失败",

                err

            )


        })


})








onUnmounted(()=>{


    if(timer){


        clearInterval(timer)


    }


})



</script>









<style scoped>


.banner{


    width:100%;


    height:260px;


    background:linear-gradient(

        135deg,

        #2563eb,

        #60a5fa

    );


    border-radius:20px;


    display:flex;


    justify-content:space-between;


    align-items:center;


    padding:0 55px;


    box-sizing:border-box;


    overflow:hidden;


}






.banner-content{


    color:white;


}






.brand{


    display:flex;


    align-items:center;


    gap:15px;


}






.moon{


    font-size:42px;


}






.brand h1{


    font-size:42px;


    margin:0;


    font-weight:800;


}






.desc{


    font-size:20px;


    margin-top:15px;


    margin-bottom:18px;


}






.tags{


    display:flex;


    gap:18px;


    font-size:16px;


}






.tags span{


    white-space:nowrap;


}






.banner-content h2{


    margin-top:25px;


    font-size:22px;


    font-weight:700;


}







.banner-image{


    width:320px;


    height:180px;


    display:flex;


    justify-content:center;


    align-items:center;


}







.activity-image{


    width:100%;


    height:100%;


    object-fit:cover;


    border-radius:20px;


}







.image-placeholder{


    width:100%;


    height:100%;


    background:rgba(255,255,255,.18);


    border-radius:20px;


    display:flex;


    justify-content:center;


    align-items:center;


    color:white;


    font-size:24px;


    font-weight:bold;


}



</style>
