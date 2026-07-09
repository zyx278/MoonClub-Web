import request from "./request"


export function getOrders(){

    return request.get("/api/orders")

}