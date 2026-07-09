<template>


<div class="card">


    <!-- 图片 -->

    <div
        class="image-box"
        @click.stop="showImage=true"
    >


        <img
            v-if="item.coverImage"
            :src="imageUrl"
            class="cover"
        />


        <div
            v-else
            class="empty"
        >
            暂无图片
        </div>


    </div>




    <div
        class="content"
        @click="goDetail"
    >


        <h3>
            {{item.title}}
        </h3>


        <span class="tag">
            {{item.category}}
        </span>


        <p>
            {{item.description}}
        </p>


    </div>



</div>



<!-- 图片预览 -->

<div
    v-if="showImage"
    class="mask"
    @click="showImage=false"
>


    <img
        :src="imageUrl"
        class="big-image"
        @click.stop
    />


</div>



</template>



<script setup>


import {
    computed,
    ref
} from "vue"


import {
    useRouter
} from "vue-router"



const props = defineProps({

    item:{
        type:Object,
        required:true
    }

})



const router=useRouter()



const showImage=ref(false)



const imageUrl=computed(()=>{


    if(!props.item.coverImage){

        return ""

    }


    return "http://localhost:8080"
    +
    props.item.coverImage


})




function goDetail(){


    router.push(
        "/detail/"+props.item.id
    )


}


</script>




<style scoped>


.card{


background:white;

border-radius:18px;

overflow:hidden;

box-shadow:
0 8px 25px rgba(0,0,0,.08);


}





.image-box{


height:220px;

cursor:pointer;

background:#f3f4f6;


}




.cover{


width:100%;

height:100%;

object-fit:cover;


}



.empty{


height:100%;

display:flex;

justify-content:center;

align-items:center;

color:#999;


}



.content{


padding:20px;

cursor:pointer;


}



h3{


font-size:22px;

margin-bottom:12px;


}



.tag{


background:#dbeafe;

color:#2563eb;

padding:5px 15px;

border-radius:20px;


}



p{


margin-top:15px;

color:#666;


}





/* 图片遮罩 */


.mask{


position:fixed;

left:0;

top:0;

right:0;

bottom:0;


background:rgba(0,0,0,.75);


display:flex;

justify-content:center;

align-items:center;


z-index:9999;


}




.big-image{


max-width:90%;

max-height:90%;


object-fit:contain;


border-radius:10px;


}


</style>