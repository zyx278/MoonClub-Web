<template>


<div class="page">



    <div class="card">


        <h2>
            客服联系方式
        </h2>


        <p class="desc">

            上传客服二维码，用户点击联系客服时展示。

        </p>




        <div class="current">


            <h3>

                当前二维码

            </h3>



            <div class="qr-box">


                <img

                    v-if="contactUrl"

                    :src="imageUrl"

                />



                <span v-else>

                    暂无二维码

                </span>



            </div>



        </div>






        <div class="upload">


            <h3>

                上传新二维码

            </h3>



            <input

                type="file"

                accept="image/*"

                @change="chooseFile"

            />





            <div

                v-if="preview"

                class="preview"

            >


                <img

                    :src="preview"

                />


            </div>





            <button

                @click="save"

            >

                保存


            </button>



        </div>



    </div>



</div>


</template>







<script setup>


import {

    ref,

    computed,

    onMounted

} from "vue"



import request from "../../api/request"



import {

    uploadImage

} from "../../api/order"







const contactUrl = ref("")



const file = ref(null)



const preview = ref(null)






const imageUrl = computed(()=>{


    if(!contactUrl.value){

        return ""

    }



    return "http://localhost:8080"

        +

        contactUrl.value


})








function load(){


    request.get(

        "/api/config/contact"

    )

    .then(res=>{


        contactUrl.value =

            res.data.data || ""


    })


}







function chooseFile(e){


    const f = e.target.files[0]



    if(!f){

        return

    }



    file.value=f



    preview.value =

        URL.createObjectURL(f)


}









function save(){


    if(!file.value){


        alert("请选择二维码图片")


        return


    }





    uploadImage(file.value)

        .then(res=>{


            const url =

                res.data.data




            return request.put(

                "/api/config/contact",

                null,

                {

                    params:{

                        url:url

                    }

                }

            )



        })


        .then(()=>{


            alert("保存成功")



            preview.value=null



            file.value=null



            load()



        })


}








onMounted(()=>{


    load()


})


</script>








<style scoped>


.page{


    padding:20px;


}






.card{


    background:white;


    border-radius:18px;


    padding:30px;


}







.desc{


    color:#64748b;


    margin-bottom:30px;


}







.current,
.upload{


    margin-top:30px;


}







h3{


    margin-bottom:15px;


}







.qr-box{


    width:220px;


    height:220px;


    background:#f1f5f9;


    border-radius:15px;


    display:flex;


    align-items:center;


    justify-content:center;


}







.qr-box img{


    width:100%;


    height:100%;


    object-fit:contain;


    border-radius:15px;


}







.preview{


    margin-top:20px;


    width:180px;


    height:180px;


}







.preview img{


    width:100%;


    height:100%;


    object-fit:contain;


}







button{


    margin-top:25px;


    padding:12px 30px;


    border:none;


    border-radius:10px;


    background:#2563eb;


    color:white;


    cursor:pointer;


}




</style>
