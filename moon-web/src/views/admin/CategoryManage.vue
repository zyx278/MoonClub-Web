<template>

  <div class="category-page">


    <div class="page-header">

      <h1>
        订单类型管理
      </h1>

      <p>
        管理首页分类导航以及订单分类
      </p>

    </div>




    <div class="content">


      <!-- 编辑区域 -->
      <section class="form-card">


        <h2>

          {{ form.id ? "编辑分类" : "新增分类" }}

        </h2>



        <div class="form">


          <label>

            分类名称

            <input
                v-model="form.name"
                placeholder="请输入分类名称"
            />

          </label>




          <label>

            排序

            <input

                type="number"

                v-model="form.sort"

            />

          </label>





          <label>

            状态


            <select v-model="form.status">

              <option :value="1">
                开启
              </option>


              <option :value="0">
                关闭
              </option>


            </select>


          </label>






          <div class="buttons">


            <button
                class="save"
                @click="save"
            >

              保存

            </button>




            <button

                v-if="form.id"

                class="cancel"

                @click="reset"

            >

              取消

            </button>


          </div>


        </div>


      </section>






      <!-- 列表区域 -->

      <section class="list-card">


        <h2>
          分类列表
        </h2>




        <table>


          <thead>

          <tr>

            <th>
              名称
            </th>

            <th>
              排序
            </th>

            <th>
              状态
            </th>

            <th>
              操作
            </th>


          </tr>


          </thead>




          <tbody>


          <tr
              v-for="item in categories"
              :key="item.id"
          >


            <td>
              {{ item.name }}
            </td>


            <td>
              {{ item.sort }}
            </td>


            <td>

              <span
                  :class="item.status===1?'open':'close'"
              >

                {{ item.status===1?'开启':'关闭' }}

              </span>


            </td>



            <td>


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


            </td>


          </tr>



          </tbody>


        </table>



      </section>



    </div>


  </div>


</template>





<script setup>


import {
  onMounted,
  reactive,
  ref
} from "vue"



import axios from "axios"





const categories = ref([])




const form = reactive({

  id:null,

  name:"",

  sort:1,

  status:1

})







function loadData(){


  axios.get(
      "http://localhost:8080/api/category"
  )

  .then(res=>{


    categories.value =
        res.data.data || []


  })


}








function save(){


  if(!form.name){

    alert("请输入分类名称")

    return

  }




  const request = form.id

      ?

      axios.put(
          "http://localhost:8080/api/category",
          form
      )


      :

      axios.post(
          "http://localhost:8080/api/category",
          form
      )





  request.then(()=>{


    alert("保存成功")


    reset()

    loadData()


  })


}







function edit(item){


  form.id=item.id

  form.name=item.name

  form.sort=item.sort

  form.status=item.status


}








function remove(id){


  if(!confirm("确定删除该分类吗？")){

    return

  }



  axios.delete(

      `http://localhost:8080/api/category/${id}`

  )

  .then(()=>{


    alert("删除成功")


    loadData()


  })


}









function reset(){


  form.id=null

  form.name=""

  form.sort=1

  form.status=1


}








onMounted(()=>{

  loadData()

})



</script>








<style scoped>


.category-page{

    display:flex;

    flex-direction:column;

    gap:25px;

}





.page-header{


    background:white;

    padding:25px;

    border-radius:16px;


}



.page-header h1{


    margin:0;

    color:#1e293b;


}



.page-header p{


    margin-top:8px;

    color:#64748b;


}





.content{


    display:flex;

    gap:25px;

    align-items:flex-start;


}




.form-card,
.list-card{


    background:white;

    border-radius:16px;

    padding:25px;

    box-shadow:

    0 10px 30px rgba(0,0,0,.05);


}





.form-card{


    width:330px;


}




.list-card{


    flex:1;


}




.form{


    margin-top:20px;

    display:flex;

    flex-direction:column;

    gap:18px;


}




label{


    display:flex;

    flex-direction:column;

    gap:8px;

    color:#475569;


}



input,
select{


    padding:10px;

    border-radius:10px;

    border:1px solid #ddd;


}



.buttons{


    display:flex;

    gap:10px;


}



button{


    border:none;

    padding:8px 15px;

    border-radius:8px;

    cursor:pointer;


}



.save{


    background:#2563eb;

    color:white;


}



.cancel{


    background:#eee;


}





table{


    width:100%;

    border-collapse:collapse;


}



th,
td{


    padding:14px;

    border-bottom:1px solid #eee;

    text-align:left;


}





.open{


    color:#16a34a;


}



.close{


    color:#dc2626;


}




.edit{


    background:#16a34a;

    color:white;

    margin-right:8px;


}




.delete{


    background:#dc2626;

    color:white;


}




</style>
