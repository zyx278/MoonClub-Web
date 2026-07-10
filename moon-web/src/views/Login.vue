<template>


<div class="login-page">


    <div class="login-box">


        <h1>
            🌙 皎月电竞
        </h1>


        <p>
            后台管理登录
        </p>




        <input

            v-model="form.username"

            placeholder="请输入账号"

        />



        <input

            v-model="form.password"

            type="password"

            placeholder="请输入密码"

        />




        <button

            @click="login"

        >

            登录


        </button>




    </div>


</div>


</template>





<script setup>


import {

    reactive

} from "vue"



import {

    useRouter

} from "vue-router"



import request from "../api/request"





const router = useRouter()





const form = reactive({


    username:"",


    password:""


})







function login(){



    request.post(

        "/api/login",

        form

    )

    .then(res=>{



        const data =
            res.data.data




        if(!data){


            alert("账号或密码错误")


            return


        }




        localStorage.setItem(

            "token",

            data.token

        )




        localStorage.setItem(

            "username",

            data.username

        )




        router.push(

            "/admin"

        )



    })


}






</script>







<style scoped>


.login-page{


    width:100%;


    height:100%;


    display:flex;


    justify-content:center;


    align-items:center;


    background:#eef3fa;


}





.login-box{


    width:360px;


    background:white;


    padding:40px;


    border-radius:20px;


    box-shadow:


    0 10px 30px rgba(0,0,0,.08);


    text-align:center;


}





h1{


    margin-bottom:10px;


}





p{


    color:#64748b;


    margin-bottom:30px;


}





input{


    width:100%;


    height:45px;


    margin-bottom:15px;


    padding:0 15px;


    border-radius:10px;


    border:1px solid #ddd;


}





button{


    width:100%;


    height:45px;


    border:none;


    border-radius:10px;


    background:#2563eb;


    color:white;


    font-size:16px;


    cursor:pointer;


}



</style>
