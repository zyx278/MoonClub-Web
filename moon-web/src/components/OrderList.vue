<template>


  <section class="order-list">



    <div class="header">


      <p class="eyebrow">

        ORDER LIST

      </p>



      <h2>

        {{ category }}

      </h2>



      <span>

        当前 {{ orders.length }} 个订单

      </span>


    </div>







    <div class="grid">


      <OrderCard


          v-for="item in orders"


          :key="item.id"


          :item="item"


      />



    </div>







    <div

        v-if="orders.length===0"

        class="empty"

    >

      暂无订单


    </div>




  </section>


</template>







<script setup>


import {


  ref,


  watch,


  onMounted


} from "vue"




import OrderCard from "./OrderCard.vue"



import {


  getOrders


} from "../api/order"







const props = defineProps({


  category:{


    type:String,


    default:"热门推荐"


  }


})








const orders = ref([])








function loadData(){



  getOrders()

      .then(res=>{


        let list =

            res.data.data || []





        console.log(
            "当前分类:",
            props.category
        )





        /**
         * 热门推荐显示全部
         */
        if(

            props.category

            &&

            props.category !== "热门推荐"

        ){


          list = list.filter(item =>


              item.category === props.category


          )


        }






        orders.value = list



      })


}








/**
 * 分类变化重新加载
 */
watch(

    ()=>props.category,


    ()=>{


      loadData()


    }


)







onMounted(()=>{


  loadData()


})



</script>








<style scoped>


.order-list{


    background:white;


    padding:25px;


    border-radius:18px;


}





.header{


    margin-bottom:25px;


}





.eyebrow{


    font-size:12px;


    color:#94a3b8;


    letter-spacing:1px;


}





h2{


    margin:8px 0;


    font-size:26px;


}





.header span{


    color:#64748b;


}






.grid{


    display:grid;


    grid-template-columns:


    repeat(3,1fr);


    gap:25px;


}






.empty{


    text-align:center;


    padding:50px;


    color:#999;


}




@media(max-width:900px){


.grid{


    grid-template-columns:repeat(2,1fr);


}


}




@media(max-width:600px){


.grid{


    grid-template-columns:1fr;


}


}



</style>
