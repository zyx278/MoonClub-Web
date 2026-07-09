<template>

  <section class="list-card">


    <div class="list-header">


      <div>

        <p class="eyebrow">
          ORDER MANAGEMENT
        </p>


        <h2>
          订单列表
        </h2>


        <span class="count">

          当前共 {{ orders.length }} 个订单

        </span>


      </div>


    </div>





    <div class="table-container">


      <table>


        <thead>

        <tr>

          <th>
            封面
          </th>

          <th>
            名称
          </th>

          <th>
            分类
          </th>

          <th>
            简介
          </th>

          <th>
            操作
          </th>

        </tr>


        </thead>




        <tbody>


        <tr
            v-for="item in orders"
            :key="item.id"
        >



          <td>


            <img

                v-if="item.coverImage"

                :src="apiOrigin + item.coverImage"

                class="cover"

            />


            <div
                v-else
                class="empty-cover"
            >

              暂无

            </div>


          </td>





          <td>


            <div class="order-name">

              {{ item.title }}

            </div>


          </td>





          <td>


            <span class="tag">


              {{ item.category }}


            </span>


          </td>





          <td>


            <div class="description">


              {{ item.description }}


            </div>


          </td>





          <td>


            <div class="actions">


              <button

                  class="edit"

                  @click="edit(item)"

              >

                编辑

              </button>





              <button

                  class="delete"

                  @click="remove(item.id)"

              >

                删除

              </button>


            </div>


          </td>



        </tr>





        <tr
            v-if="orders.length===0"
        >

          <td
              colspan="5"
              class="empty"
          >

            暂无订单数据


          </td>


        </tr>




        </tbody>


      </table>



    </div>



  </section>



</template>





<script setup>


import {

  ref,

  onMounted,

  defineExpose

} from "vue"



import {

  getOrders,

  deleteOrder

} from "../../api/order"





const emit = defineEmits([

  "edit"

])





const apiOrigin =
    "http://localhost:8080"





const orders=ref([])







function loadData(){


  getOrders()

      .then(res=>{


        orders.value =
            res.data.data || []


      })


}








function edit(item){


  emit(

      "edit",

      item

  )


}








function remove(id){


  if(!confirm("确定删除这个订单吗？")){

    return

  }




  deleteOrder(id)

      .then(()=>{


        alert("删除成功")


        loadData()


      })


}







defineExpose({

  loadData

})







onMounted(()=>{


  loadData()


})


</script>







<style scoped>


.list-card{


  background:white;


  border:1px solid #e2e8f0;


  border-radius:18px;


  padding:28px;


  box-shadow:


      0 10px 30px rgba(15,23,42,.06);


}






.list-header{


  margin-bottom:24px;


}




.eyebrow{


  margin:0 0 6px;


  color:#94a3b8;


  font-size:12px;


  letter-spacing:1px;


}




h2{


  margin:0;


  font-size:24px;


  color:#1e293b;


}




.count{


  display:block;


  margin-top:8px;


  color:#64748b;


  font-size:14px;


}






.table-container{


  overflow:auto;


  border-radius:14px;


  border:1px solid #e2e8f0;


}






table{


  width:100%;


  border-collapse:collapse;


  min-width:760px;


}






thead{


  background:#f8fafc;


}






th{


  padding:16px;


  text-align:left;


  color:#64748b;


  font-size:14px;


  font-weight:600;


}






td{


  padding:16px;


  border-top:1px solid #f1f5f9;


  vertical-align:middle;


}






tr:hover{


  background:#f8fafc;


}






.cover{


  width:90px;


  height:60px;


  border-radius:10px;


  object-fit:cover;


}





.empty-cover{


  width:90px;


  height:60px;


  border-radius:10px;


  background:#f1f5f9;


  display:flex;


  align-items:center;


  justify-content:center;


  color:#94a3b8;


  font-size:13px;


}






.order-name{


  font-weight:700;


  color:#1e293b;


}






.tag{


  display:inline-flex;


  align-items:center;


  padding:6px 14px;


  border-radius:999px;


  background:#dbeafe;


  color:#2563eb;


  font-size:13px;


}






.description{


  max-width:260px;


  color:#64748b;


  line-height:1.6;


}






.actions{


  display:flex;


  gap:10px;


}






.actions button{


  border:none;


  color:white;


  padding:8px 14px;


  border-radius:10px;


  cursor:pointer;


}






.edit{


  background:#16a34a;


}





.delete{


  background:#dc2626;


}





.empty{


  text-align:center;


  padding:40px;


  color:#94a3b8;


}



</style>
