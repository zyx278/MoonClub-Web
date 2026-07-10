<template>

  <div class="order-page">


    <div class="page-title">

      <h1>
        订单编辑
      </h1>

      <p>
        管理订单内容、图片以及展示信息
      </p>

    </div>



    <div class="content">


      <div class="editor">


        <OrderEditor

            ref="editorRef"

            @success="refreshList"

        />


      </div>



      <div class="list">


        <OrderList

            ref="listRef"

            @edit="handleEdit"

        />


      </div>


    </div>



  </div>


</template>




<script setup>


import {

  ref

} from "vue"



import OrderList from "../../components/admin/OrderList.vue"

import OrderEditor from "../../components/admin/OrderEditor.vue"





const editorRef = ref(null)


const listRef = ref(null)







function handleEdit(item){


  editorRef.value.editOrder(item)


}







function refreshList(){


  listRef.value.loadData()


}





</script>






<style scoped>


.order-page{


    display:flex;

    flex-direction:column;

    gap:25px;


}




.page-title{


    background:white;

    padding:25px;

    border-radius:16px;


}



.page-title h1{


    margin:0;

    font-size:26px;

    color:#1e293b;


}



.page-title p{


    margin-top:8px;

    color:#64748b;


}




.content{


    display:flex;

    gap:25px;

    align-items:flex-start;


}





.editor{


    width:360px;


}




.list{


    flex:1;

}




@media(max-width:1200px){


.content{

    flex-direction:column;

}



.editor{

    width:100%;

}


}



</style>
