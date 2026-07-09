<template>

  <div class="admin-page">


    <!-- 顶部标题 -->

    <section class="page-head">


      <div>


        <p class="eyebrow">
          MoonClub Content Management
        </p>


        <h1>
          皎月电竞后台管理
        </h1>


        <p class="sub-title">
          订单中心 · 内容管理 · 客服配置
        </p>


      </div>




      <button

          class="primary-btn"

          @click="editorRef?.resetForm()"

      >

        + 新增订单


      </button>


    </section>





    <div class="workspace">



      <!-- 左侧 -->

      <aside class="side-panel">



        <OrderEditor

            ref="editorRef"

            @success="refreshOrders"

        />




        <ContactSetting />



      </aside>






      <!-- 右侧 -->

      <OrderList

          ref="orderListRef"

          @edit="handleEdit"

      />




    </div>



  </div>


</template>





<script setup>


import {

  ref

} from "vue"



import OrderEditor from "../components/admin/OrderEditor.vue"

import OrderList from "../components/admin/OrderList.vue"

import ContactSetting from "../components/ContactSetting.vue"



const editorRef = ref(null)


const orderListRef = ref(null)





function refreshOrders(){

  orderListRef.value?.loadData()

}





function handleEdit(item){

  editorRef.value?.editOrder(item)

}



</script>







<style scoped>


.admin-page{


  width:min(1400px, calc(100% - 48px));


  margin:40px auto;


  color:#1e293b;


}




.page-head{


  display:flex;


  justify-content:space-between;


  align-items:center;


  margin-bottom:28px;


}




.eyebrow{


  margin:0 0 8px;


  font-size:13px;


  color:#64748b;


  letter-spacing:.5px;


}




h1{


  margin:0;


  font-size:34px;


  font-weight:800;


  color:#2563eb;


}




.sub-title{


  margin-top:8px;


  color:#94a3b8;


  font-size:14px;


}




.primary-btn{


  border:none;


  background:#2563eb;


  color:white;


  padding:12px 22px;


  border-radius:12px;


  cursor:pointer;


  font-size:15px;


  box-shadow:
      0 8px 20px rgba(37,99,235,.25);


}




.primary-btn:hover{


  background:#1d4ed8;


}






.workspace{


  display:grid;


  grid-template-columns:380px minmax(700px,1fr);


  gap:28px;


  align-items:start;


}






.side-panel{


  display:flex;


  flex-direction:column;


  gap:24px;


}






@media(max-width:1100px){


  .workspace{


    grid-template-columns:1fr;


  }



}




</style>
