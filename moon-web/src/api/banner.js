import request from "./request"



export function getBanners(){

    return request.get("/api/banner")

}



export function createBanner(data){

    return request.post("/api/banner", data)

}



export function updateBanner(data){

    return request.put("/api/banner", data)

}



export function deleteBanner(id){

    return request.delete("/api/banner/" + id)

}
