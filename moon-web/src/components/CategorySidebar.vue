<template>


  <aside class="sidebar">


    <div class="title">

      订单分类

    </div>



    <div
        class="category-item active"
    >

      🔥 热门推荐

    </div>



    <div
        class="category-item"
    >

      🎮 体验单

    </div>



    <div
        class="category-item"
    >

      🛡 护航单

    </div>



    <div
        class="category-item"
    >

      🎲 趣味单

    </div>



    <div
        class="category-item"
    >

      🎁 活动专区

    </div>



  </aside>


</template>






<script setup>


</script>







<style scoped>


.sidebar{


    width:220px;


    background:white;


    border-radius:18px;


    padding:25px;


    box-shadow:


    0 8px 25px rgba(0,0,0,.06);



    flex-shrink:0;


}





.title{


    font-size:22px;


    font-weight:bold;


    margin-bottom:25px;


    color:#1f2937;


}





.category-item{


    height:50px;


    display:flex;


    align-items:center;


    padding:0 18px;


    margin-bottom:12px;


    border-radius:12px;


    cursor:pointer;


    color:#555;


    font-size:16px;


    transition:.3s;


}





.category-item:hover{


    background:#eff6ff;


    color:#2563eb;


}





.category-item.active{


    background:#2563eb;


    color:white;


}



</style>
