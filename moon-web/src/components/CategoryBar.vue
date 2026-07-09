<template>

<div class="category">

    <div class="item active">
        🔥 热门推荐
    </div>

    <div class="item">
        🎮 体验单
    </div>

    <div class="item">
        🛡 护航单
    </div>

    <div class="item">
        🎲 趣味单
    </div>

    <div class="item">
        🎁 活动专区
    </div>


</div>

</template>


<style scoped>

.category{

    display:flex;

    gap:25px;

    margin:30px 0;

}


.item{

    padding:14px 30px;

    background:white;

    border-radius:12px;

    cursor:pointer;

    box-shadow:0 5px 15px rgba(0,0,0,.05);

    transition:.3s;

}


.item:hover{

    color:white;

    background:#2563eb;

}


.active{

    background:#2563eb;

    color:white;

}


</style>