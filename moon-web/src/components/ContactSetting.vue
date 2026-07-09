<template>

<div class="contact-box">


  <h2>
    客服二维码设置
  </h2>


  <p class="tip">
    上传后所有订单详情页共用此客服二维码
  </p>



  <div class="content">


    <div class="preview">


      <img
          v-if="qrUrl"
          :src="fullUrl"
          class="qr"
      />


      <span v-else>
        暂无二维码
      </span>


    </div>



    <div>


      <input
          type="file"
          @change="selectFile"
      />



      <button
          @click="save"
      >

        保存二维码

      </button>


    </div>


  </div>


</div>


</template>



<script setup>


import {
  ref,
  computed,
  onMounted
} from "vue"


import axios from "axios"



const file = ref(null)


const qrUrl = ref("");





const fullUrl = computed(()=>{


  if(!qrUrl.value){

    return ""

  }


  return "http://localhost:8080"
      +
      qrUrl.value


})





function selectFile(e){

  file.value=e.target.files[0]

}





function load(){


  axios.get(
      "http://localhost:8080/api/config/contact"
  )

  .then(res=>{


    if(res.data.data){

      qrUrl.value =
          res.data.data.configValue

    }


  })


}




function upload(){


  let formData=new FormData()


  formData.append(
      "file",
      file.value
  )


  return axios.post(

      "http://localhost:8080/api/upload",

      formData

  )


}





function save(){


  if(!file.value){

    alert("请选择二维码")

    return

  }



  upload()

  .then(res=>{


    return axios.put(

        "http://localhost:8080/api/config/contact",

        null,

        {
          params:{
            url:res.data.data
          }
        }

    )


  })


  .then(()=>{


    alert("保存成功")


    load()


  })


}





onMounted(()=>{

  load()

})


</script>




<style scoped>


.contact-box{


background:white;

padding:30px;

border-radius:18px;

margin-bottom:30px;

box-shadow:
0 8px 25px rgba(0,0,0,.06);


}



h2{

margin:0;

}



.tip{

color:#888;

margin-top:10px;

}



.content{


display:flex;

gap:40px;

align-items:center;

margin-top:25px;


}




.preview{


width:220px;

height:220px;

background:#f5f5f5;

border-radius:15px;


display:flex;

align-items:center;

justify-content:center;


}



.qr{


max-width:200px;

max-height:200px;


}



button{


margin-top:20px;

background:#2563eb;

color:white;

border:none;

padding:12px 30px;

border-radius:10px;

cursor:pointer;


}



</style>