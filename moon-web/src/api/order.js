import request from "./request"


export function getOrders(){

    return request.get("/api/orders")

}

export function createOrder(data){

    return request.post("/api/orders", data)

}

export function updateOrder(data){

    return request.put("/api/orders", data)

}

export function deleteOrder(id){

    return request.delete("/api/orders/" + id)

}

export function uploadImage(file){

    const data = new FormData()

    data.append("file", file)

    return request.post("/api/upload", data)

}
