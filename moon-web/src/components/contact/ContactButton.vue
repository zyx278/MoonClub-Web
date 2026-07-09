<template>


<button
    class="contact-btn"
    @click="openContact"
>


  联系客服


</button>




<ContactDialog

    :visible="showDialog"

    :imageUrl="contactImage"

    @close="showDialog=false"

/>


</template>






<script setup>


import {

  ref

} from "vue"




import axios from "axios"




import ContactDialog from "./ContactDialog.vue"







const showDialog = ref(false)




const contactImage = ref("")









function openContact(){



  axios.get(

      "http://localhost:8080/api/config/contact"

  )



  .then(res=>{



    console.log(
        "客服配置:",
        res.data
    )





    const url =

        res.data.data.configValue






    contactImage.value =

        "http://localhost:8080"

        +

        url






    showDialog.value=true




  })



  .catch(err=>{



    console.log(
        "获取客服失败:",
        err
    )



    alert("客服二维码获取失败")



  })



}





</script>






<style scoped>


.contact-btn{


  background:#2563eb;


  color:white;


  border:none;


  padding:12px 24px;


  border-radius:10px;


  cursor:pointer;


  font-size:16px;


}





.contact-btn:hover{


  background:#1d4ed8;


}



</style>