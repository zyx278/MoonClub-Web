<template>


<div class="page">



    <div class="title">


        <h2>
            活动部署
        </h2>


        <p>
            管理首页Banner活动图片
        </p>


    </div>







    <div class="container">





        <!-- 编辑区域 -->


        <div class="card">


            <h3>

                {{ form.id ? "编辑活动" : "新增活动" }}

            </h3>




            <label>

                活动标题

                <input

                    v-model="form.title"

                    placeholder="请输入活动标题"

                />

            </label>







            <label>

                活动图片


                <input

                    type="file"

                    accept="image/*"

                    @change="chooseFile"

                />


            </label>







            <div
                v-if="preview"
                class="preview"
            >

                <img :src="preview">


            </div>







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







            <button

                @click="save"

            >

                保存


            </button>



        </div>








        <!-- 列表 -->

        <div class="card list">


            <h3>

                活动列表

            </h3>





            <table>


                <thead>


                <tr>

                    <th>
                        图片
                    </th>


                    <th>
                        标题
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

                    v-for="item in banners"

                    :key="item.id"

                >


                    <td>


                        <img

                            :src="apiOrigin + item.image"

                            class="cover"

                        />


                    </td>



                    <td>

                        {{item.title}}

                    </td>




                    <td>

                        {{item.sort}}

                    </td>




                    <td>


                        {{item.status===1?"开启":"关闭"}}


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



        </div>





    </div>




</div>


</template>







<script setup>


import {

    ref,

    onMounted

} from "vue"



import {

    uploadImage

} from "../../api/order"



import {

    getBanners,

    createBanner,

    updateBanner,

    deleteBanner

} from "../../api/banner"







const apiOrigin =
    "http://localhost:8080"







const banners=ref([])







const file=ref(null)


const preview=ref(null)







const form=ref({


    title:"",


    image:"",


    sort:1,


    status:1


})










function load(){


    getBanners()

        .then(res=>{


            banners.value =
                res.data.data || []


        })


}








function chooseFile(e){


    const f =
        e.target.files[0]


    if(!f){

        return

    }



    file.value=f



    preview.value =
        URL.createObjectURL(f)


}









function save(){



    const task = file.value

        ?

        uploadImage(file.value)

            .then(res=>{


                form.value.image =
                    res.data.data


            })

        :

        Promise.resolve()







    task.then(()=>{



        return form.value.id

            ?

            updateBanner(form.value)

            :

            createBanner(form.value)



    })


    .then(()=>{


        alert("保存成功")


        reset()


        load()


    })



}









function edit(item){



    form.value={


        id:item.id,


        title:item.title,


        image:item.image,


        sort:item.sort,


        status:item.status


    }



    preview.value =
        apiOrigin + item.image



}








function remove(id){



    if(!confirm("确定删除？")){


        return


    }




    deleteBanner(id)

        .then(()=>{


            load()


        })


}









function reset(){


    form.value={


        title:"",


        image:"",


        sort:1,


        status:1


    }



    file.value=null


    preview.value=null


}









onMounted(()=>{


    load()


})


</script>








<style scoped>


.page{


    padding:20px;


}




.title{


    background:white;


    padding:25px;


    border-radius:18px;


    margin-bottom:25px;


}




.container{


    display:grid;


    grid-template-columns:350px 1fr;


    gap:25px;


}







.card{


    background:white;


    padding:25px;


    border-radius:18px;


}







label{


    display:flex;


    flex-direction:column;


    gap:8px;


    margin-top:15px;


}







input,
select{


    padding:10px;


    border-radius:8px;


    border:1px solid #ddd;


}







button{


    margin-top:20px;


    padding:10px 18px;


    border:none;


    border-radius:8px;


    background:#2563eb;


    color:white;


    cursor:pointer;


}







.preview img{


    width:100%;


    margin-top:15px;


    border-radius:10px;


}







.cover{


    width:120px;


    height:60px;


    object-fit:cover;


    border-radius:8px;


}







table{


    width:100%;


    border-collapse:collapse;


}





td,th{


    padding:12px;


    border-bottom:1px solid #eee;


}







.edit{


    background:#16a34a;


    margin-right:10px;


}







.delete{


    background:#dc2626;


}



</style>
