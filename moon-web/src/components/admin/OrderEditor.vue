<template>

  <section class="editor-card">


    <div class="card-header">


      <div>

        <p class="eyebrow">
          ORDER EDITOR
        </p>


        <h2>
          {{ editId ? "编辑订单" : "创建订单" }}
        </h2>


      </div>



      <button

          v-if="editId"

          class="cancel-btn"

          @click="resetForm"

      >

        取消


      </button>


    </div>





    <div class="form">


      <label>

        <span>
          订单名称
        </span>


        <input

            v-model="form.title"

            placeholder="请输入订单名称"

        />

      </label>





      <label>

        <span>
          订单分类
        </span>


        <select

            v-model="form.category"

        >


          <option

              v-for="item in categories"

              :key="item.id"

              :value="item.name"

          >

            {{ item.name }}

          </option>


        </select>


      </label>







      <label>


        <span>
          订单简介
        </span>



        <textarea

            v-model="form.description"

            placeholder="请输入订单简介"

        />


      </label>






      <label>


        <span>
          上传封面
        </span>



        <input

            type="file"

            accept="image/*"

            @change="selectFile"

        />


      </label>






      <div

          v-if="previewImage"

          class="image-preview"

      >


        <img

            :src="previewImage"

            alt=""

        />


      </div>







      <button

          class="save-btn"

          @click="saveOrder"

      >


        {{ editId ? "保存修改" : "发布订单" }}


      </button>


    </div>


  </section>


</template>





<script setup>


import {

  ref,

  onMounted

} from "vue"



import axios from "axios"



import {

  createOrder,

  updateOrder,

  uploadImage

} from "../../api/order"





const emit = defineEmits([

    "success"

])





const apiOrigin =
    "http://localhost:8080"






/**
 * 分类列表
 * 从后台 category 表获取
 */
const categories = ref([])






const editId = ref(null)


const file = ref(null)


const previewImage = ref(null)








const emptyForm = () => ({


  title:"",


  category:"",


  description:"",


  coverImage:""


})





const form = ref(

    emptyForm()

)







/**
 * 获取订单分类
 */
function loadCategories(){


  axios.get(

      "http://localhost:8080/api/category"

  )

  .then(res=>{


    categories.value =

        res.data.data || []



    /**
     * 新增订单默认选择第一个分类
     */
    if(

        !form.value.category

        &&

        categories.value.length>0

    ){

      form.value.category =
          categories.value[0].name

    }


  })


}









function selectFile(e){


  const selected =
      e.target.files[0]


  if(!selected){

    return

  }


  file.value =
      selected


  previewImage.value =
      URL.createObjectURL(selected)


}









function saveOrder(){


  if(!form.value.title.trim()){


    alert("请输入订单名称")


    return


  }




  if(!form.value.description.trim()){


    alert("请输入订单简介")


    return


  }





  if(

      !editId.value

      &&

      !file.value

  ){


    alert("请选择封面图片")


    return


  }









  const task = file.value


      ?


      uploadImage(file.value)

          .then(res=>{


            form.value.coverImage =
                res.data.data


          })



      :


      Promise.resolve()







  task.then(()=>{


    return editId.value


        ?


        updateOrder(form.value)



        :



        createOrder(form.value)



  })



  .then(()=>{


    alert(

        editId.value

            ?

            "修改成功"

            :

            "新增成功"

    )



    resetForm()



    emit("success")



  })


}









function editOrder(item){



  editId.value =
      item.id






  form.value = {


    id:item.id,


    title:item.title,


    category:item.category,


    description:item.description,


    coverImage:item.coverImage


  }







  file.value=null







  previewImage.value =

      item.coverImage

          ?

          apiOrigin + item.coverImage

          :

          null



}









function resetForm(){



  editId.value=null


  file.value=null


  previewImage.value=null



  form.value =
      emptyForm()



  /**
   * 重置后重新设置默认分类
   */
  if(categories.value.length>0){


    form.value.category =
        categories.value[0].name


  }


}








defineExpose({

  editOrder,

  resetForm

})









onMounted(()=>{


  loadCategories()


})



</script>








<style scoped>


.editor-card{


  background:white;


  border:1px solid #e2e8f0;


  border-radius:18px;


  padding:24px;


  box-shadow:

      0 10px 30px rgba(15,23,42,.06);


}







.card-header{


  display:flex;


  justify-content:space-between;


  align-items:flex-start;


  margin-bottom:24px;


}





.eyebrow{


  margin:0 0 6px;


  font-size:12px;


  color:#94a3b8;


  letter-spacing:1px;


}





h2{


  margin:0;


  font-size:22px;


  color:#1e293b;


}







.form{


  display:flex;


  flex-direction:column;


  gap:18px;


}







label{


  display:flex;


  flex-direction:column;


  gap:8px;


  font-size:14px;


  color:#475569;


}







input,
select,
textarea{


  border:1px solid #dbe3ef;


  border-radius:12px;


  padding:12px;


  font-size:14px;


  outline:none;


}







textarea{


  min-height:120px;


  resize:none;


}







input:focus,
select:focus,
textarea:focus{


  border-color:#2563eb;


  box-shadow:

      0 0 0 3px rgba(37,99,235,.12);


}







image-preview{


  width:100%;


  height:160px;


  overflow:hidden;


  border-radius:14px;


  background:#f1f5f9;


}







.image-preview img{


  width:100%;


  height:100%;


  object-fit:cover;


}







.save-btn{


  margin-top:8px;


  background:#2563eb;


  color:white;


  border:none;


  padding:13px;


  border-radius:12px;


  cursor:pointer;


  font-size:15px;


}







.save-btn:hover{


  background:#1d4ed8;


}







.cancel-btn{


  border:none;


  background:#eff6ff;


  color:#2563eb;


  padding:8px 14px;


  border-radius:10px;


  cursor:pointer;


}



</style>
