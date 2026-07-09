<template>

<div class="sidebar">

    <div
        v-for="item in menus"
        :key="item"

        class="item"

        :class="{active:item===current}"

        @click="change(item)"
    >

        {{ item }}

    </div>

</div>

</template>

<script setup>

const props = defineProps({

    current:String

})

const emit = defineEmits(["change"])

const menus=[

    "热门推荐",

    "体验单",

    "护航单",

    "趣味单",

    "活动专区"

]

function change(name){

    emit("change",name)

}

</script>

<style scoped>

.sidebar{

    width:220px;

    background:white;

    padding:20px;

}

.item{

    padding:15px;

    margin-bottom:15px;

    background:#f5f5f5;

    border-radius:12px;

    cursor:pointer;

    transition:.3s;

}

.item:hover{

    background:#3b82f6;

    color:white;

}

.active{

    background:#3b82f6;

    color:white;

}

</style>