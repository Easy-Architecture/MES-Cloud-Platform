var obj = {
    1: "value1",
    "2": "value2",
    count: 3,
    person: [ //数组结构JSON对象，可以嵌套使用
                {
                    id: 1,
                    name: "张三"
                },
                {
                    id: 2,
                    name: "李四"
                }
           ],
    object: { //对象结构JSON对象
        id: 1,
        msg: "对象里的对象"    
    }
};

var dd={
    "orderNumber":12345678912,
    "productName" :"矿泉水",
    "commodityNumber":121212,
    "form":"液态",
    "size":"大",
    "packing":"塑料",
    "specifications":"100-500ml",
    "materials":"自备",
    "telephone":15623412308,
    "address":"天津市河西区xxx大学",
    "method":"快递送货"
}

console.log(dd);
console.log(typeof dd);
console.log('--------------------------');
//将js对象转化为JSON字符
var last1=JSON.stringify(dd);
console.log(last1);
console.log(typeof last1);//输出last1的类型
console.log('--------------------------');