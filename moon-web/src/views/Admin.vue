
<template>

<div class="admin-page">
<ContactSetting />

  <!-- 顶部 -->
  <div class="header">

    <div>
      <h1>
        🌙 皎月电竞后台管理
      </h1>

      <p>
        MoonClub Content Management
      </p>
    </div>


  </div>



  <!-- 数据卡片 -->

  <div class="stats">


    <div class="stat-card">

      <span>
        当前订单
      </span>

      <strong>
        {{ orders.length }}
      </strong>

    </div>


    <div class="stat-card">

      <span>
        状态
      </span>

      <strong>
        正常运行
      </strong>

    </div>



    <div class="stat-card">

      <span>
        图片系统
      </span>

      <strong>
        已开启
      </strong>

    </div>


  </div>




  <!-- 编辑区域 -->

  <div class="panel">


    <div class="panel-title">


      <h2>

        {{ editId ? "编辑订单" : "新增订单" }}

      </h2>


      <button
          v-if="editId"
          class="cancel"
          @click="resetForm"
      >
        取消编辑
      </button>


    </div>



    <div class="form">


      <input
          v-model="form.title"
          placeholder="请输入订单名称"
      />



      <select
          v-model="form.category"
      >

        <option value="体验单">
          体验单
        </option>


        <option value="护航单">
          护航单
        </option>


        <option value="趣味单">
          趣味单
        </option>


        <option value="活动专区">
          活动专区
        </option>


      </select>




      <textarea
          v-model="form.description"
          placeholder="请输入订单简介"
      />




      <div class="upload-box">


        <input
            type="file"
            @change="selectFile"
        />


        <img
            v-if="previewImage"
            :src="previewImage"
            class="preview"
        />


      </div>



      <button
          class="primary"
          @click="saveOrder"
      >

        {{ editId ? "保存修改" : "新增订单" }}

      </button>


    </div>


  </div>





  <!-- 列表 -->

  <div class="panel">


    <div class="panel-title">

      <h2>
        订单列表
      </h2>

    </div>



    <table>


      <thead>

      <tr>

        <th>
          ID
        </th>

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
          {{item.id}}
        </td>



        <td>

          <img
              v-if="item.coverImage"
              :src="'http://localhost:8080'+item.coverImage"
              class="cover"
          />

        </td>


        <td>
          {{item.title}}
        </td>


        <td>
          <span class="tag">
            {{item.category}}
          </span>
        </td>


        <td>
          {{item.description}}
        </td>


        <td>


          <button
              class="edit-btn"
              @click="editOrder(item)"
          >

            编辑

          </button>



          <button
              class="delete-btn"
              @click="deleteOrder(item.id)"
          >

            删除

          </button>


        </td>


      </tr>


      </tbody>


    </table>



  </div>



</div>


</template>




<script setup>

import ContactSetting from "../components/ContactSetting.vue"

import {
  ref,
  onMounted
} from "vue"


import axios from "axios"

import {
  getOrders
} from "../api/order"



const orders = ref([])



const file = ref(null)



const editId = ref(null)



const previewImage = ref(null)



const form = ref({

  title:"",

  category:"体验单",

  description:"",

  coverImage:""

})





function loadData(){


  getOrders()

  .then(res=>{

    orders.value=res.data.data

  })


}





function selectFile(e){


  file.value=e.target.files[0]


  previewImage.value =
      URL.createObjectURL(file.value)


}





function uploadImage(){


  let data=new FormData()


  data.append(
      "file",
      file.value
  )


  return axios.post(

      "http://localhost:8080/api/upload",

      data

  )


}




function saveOrder(){



  // 编辑

 // 编辑

if(editId.value){


    // 如果重新选择了图片
    if(file.value){


        uploadImage()

        .then(res=>{


            form.value.coverImage =
                res.data.data



            return axios.put(

                "http://localhost:8080/api/orders",

                form.value

            )


        })


        .then(()=>{


            alert("修改成功")


            resetForm()

            loadData()


        })



    }
    else{


        // 没换图片，只修改文字

        axios.put(

            "http://localhost:8080/api/orders",

            form.value

        )


        .then(()=>{


            alert("修改成功")


            resetForm()

            loadData()


        })


    }



    return

}





  // 新增


  if(!file.value){

    alert("请选择封面图片")

    return

  }




  uploadImage()

  .then(res=>{


    form.value.coverImage =
        res.data.data



    return axios.post(

        "http://localhost:8080/api/orders",

        form.value

    )


  })

  .then(()=>{


    alert("新增成功")


    resetForm()

    loadData()


  })


}





function editOrder(item){


  editId.value=item.id


  form.value={

    id:item.id,

    title:item.title,

    category:item.category,

    description:item.description,

    coverImage:item.coverImage

  }



  previewImage.value =
      item.coverImage
          ?
          "http://localhost:8080"+item.coverImage
          :
          null


}





function deleteOrder(id){



  if(!confirm("确定删除这个订单吗？")){

    return

  }




  axios.delete(

      "http://localhost:8080/api/orders/"+id

  )

  .then(()=>{


    alert("删除成功")

    loadData()


  })



}





function resetForm(){


  editId.value=null


  file.value=null


  previewImage.value=null



  form.value={

    title:"",

    category:"体验单",

    description:"",

    coverImage:""

  }


}





onMounted(()=>{

  loadData()

})


</script>





<style scoped>


.admin-page{

  width:1200px;

  margin:40px auto;

}



.header{

  background:white;

  padding:30px;

  border-radius:18px;

  box-shadow:0 10px 30px rgba(0,0,0,.06);

}


.header h1{

  font-size:32px;

  color:#2563eb;

}


.header p{

  color:#888;

}





.stats{

  display:flex;

  gap:20px;

  margin:25px 0;

}



.stat-card{

  flex:1;

  background:white;

  padding:25px;

  border-radius:16px;

  box-shadow:0 8px 25px rgba(0,0,0,.05);

}


.stat-card span{

  color:#888;

}


.stat-card strong{

  display:block;

  margin-top:10px;

  font-size:25px;

}





.panel{

  background:white;

  padding:30px;

  border-radius:18px;

  margin-bottom:30px;

  box-shadow:0 8px 25px rgba(0,0,0,.05);

}



.panel-title{

  display:flex;

  justify-content:space-between;

  margin-bottom:20px;

}




.form input,
.form select,
.form textarea{


  width:500px;

  display:block;

  margin-bottom:15px;

  padding:12px;

  border:1px solid #ddd;

  border-radius:8px;


}




.form textarea{

  height:100px;

}





.preview{

  width:200px;

  margin:15px 0;

  border-radius:12px;

}





.primary{

  background:#2563eb;

  color:white;

  border:none;

  padding:12px 30px;

  border-radius:10px;

  cursor:pointer;

}





.cancel{

  background:#eee;

  border:none;

  padding:10px 20px;

  border-radius:8px;

}




table{

  width:100%;

  border-collapse:collapse;

}



th{

  background:#f5f7fb;

}



td,th{

  padding:15px;

  border-bottom:1px solid #eee;

  text-align:center;

}




.cover{

  width:100px;

  height:70px;

  object-fit:cover;

  border-radius:10px;

}





.tag{

  background:#dbeafe;

  color:#2563eb;

  padding:5px 12px;

  border-radius:20px;

}





.edit-btn{

  background:#22c55e;

  color:white;

  border:none;

  padding:8px 15px;

  border-radius:8px;

  margin-right:10px;

}




.delete-btn{

  background:#ef4444;

  color:white;

  border:none;

  padding:8px 15px;

  border-radius:8px;

}



button{

  cursor:pointer;

}


</style>