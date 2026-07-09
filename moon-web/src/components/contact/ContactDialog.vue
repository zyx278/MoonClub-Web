<template>

<div
    v-if="visible"
    class="mask"
    @click="close"
>


  <div
      class="contact-box"
      @click.stop
  >


    <h2>
      联系客服
    </h2>



    <img
        :src="imageUrl"
        class="contact-image"
        @click="showBig=true"
    />



    <p>
      点击二维码放大
    </p>



  </div>


</div>






<!-- 放大二维码 -->

<div
    v-if="showBig"
    class="big-mask"
    @click="showBig=false"
>


  <img

      :src="imageUrl"

      class="big-image"

      @click.stop

  />


</div>


</template>







<script setup>


import {
  ref
} from "vue"




defineProps({

  visible:{
    type:Boolean,
    default:false
  },


  imageUrl:{
    type:String,
    default:""
  }

})





const emit = defineEmits([

  "close"

])





const showBig = ref(false)






function close(){


  emit("close")


}




</script>







<style scoped>


.mask{


  position:fixed;


  inset:0;


  background:rgba(0,0,0,.75);


  display:flex;


  justify-content:center;


  align-items:center;


  z-index:9999;


}







.contact-box{


  background:white;


  padding:40px;


  border-radius:20px;


  text-align:center;


}





.contact-image{


  width:300px;


  height:300px;


  object-fit:contain;


  cursor:pointer;


}





.contact-box p{


  margin-top:15px;


  color:#666;


}








.big-mask{


  position:fixed;


  inset:0;


  background:rgba(0,0,0,.9);


  display:flex;


  justify-content:center;


  align-items:center;


  z-index:10000;


}





.big-image{


  max-width:90%;


  max-height:90%;


  object-fit:contain;


}



</style>