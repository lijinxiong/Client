请求方式皆为： **post**      

# 用户相关 #
## 注册用户 ##

url：[http://localhost:8080/addUser?password=789464&phone=18819259258](http://localhost:8080/addUser?password=789464&phone=18819259258)      

  

参数说明     

- phone：11位纯数字手机号码    
- password ： MD5 加密后再传，长度大于6 小于16 必须包含字母和数字(客户端验证)    

返回    
成功:  
	
	{"status": "success"}     
失败    

	{"status": "error"}    
## 用户登录 ##

url:[http://localhost:8080/UserLogin?phone=12345678774&password=123456789](http://localhost:8080/UserLogin?phone=12345678774&password=123456789)      

参数说明    

- phone ：11位纯数字手机号码    
- password ： MD5 加密后再传，长度大于6 小于16 必须包含字母和数字(客户端验证)       

成功    

	{
	    "status": "success",
	    "user": {
	        "userId": 1,
	        "userName": "",
	        "password": "123456789",
	        "address": "",
	        "phoneNumber": "12345678774",
	        "pay_password": "456798",
	        "status": 1
	    }
	}     
失败  

	{
	    "status": "error",
	    "user": {}
	}

*status:* 为1 表示处于登陆状态，0则相反    

## 用户退出登录 ##

url:[http://localhost:8080/UserLogout?id=2](http://localhost:8080/UserLogout?id=2)     

参数说明   

- id 用户id    

返回    
成功

	{
	    "status": "success"
	}
用户id不存在   
	
	{"status":"error"}

## 修改登录密码 ##

url:[http://localhost:8080/ModifyPassword?phone=12345678774&newPassword=abc&oldPassword=789d456](http://localhost:8080/ModifyPassword?phone=12345678774&newPassword=abc&oldPassword=789d456)     

参数说明    

- phone 11位纯数字手机号码      
- newPassword  新密码    MD5 加密后再传，长度大于6 小于16 必须包含字母和数字(客户端验证)      
- oldPassword 旧密码，客户端先验证是否与本地保存的密码相同 再md5加密传     

返回     
成功    

	{
	    "status": "success",
	    "password": "abc"
	}
失败    

	{"status": "error","password":"123456789"}
*成功失败都会返回最新的密码*     

## 修改支付密码 ##

url ： [http://localhost:8080/ModifyPayPassword?oldPayPassword=&newPayPassword=123456&phone=12345678774](http://localhost:8080/ModifyPayPassword?oldPayPassword=&newPayPassword=123456&phone=12345678774)   

参数说明    

- phone  11位纯数字手机号码        
- oldPayPassword 旧的支付密码 可以为空，假设用户没有设定，6位纯数字组成(客户端验证)需要MD5加密      
- newPayPassword ：新的支付密码  6位纯数字 ，md5 加密    

返回    
成功      

	{
	    "status": "success",
	    "payPassword": "123456"
	}
失败    

	{
	    "status": "error",
	    "payPassword": "456798"
	}

*都返回最新的支付密码*     

## 修改用户信息 ##

url ： [http://localhost:8080/ModifyInfo?id=1&userName=xianyu&address=China](http://localhost:8080/ModifyInfo?id=1&userName=xianyu&address=China)    

参数说明    

- id  用户id    
- userName **可选参数** 新修改的用户名字，用URLEncode进行utf-8编码后再进行传输    
- address **可选参数** 新修改的用户名字，用URLEncode进行utf-8编码后再进行传输       

返回    
成功    
	
	{
	    "status": "success",
	    "user": {
	        "userId": 1,
	        "userName": "xianyu",
	        "password": "abc",
	        "address": "China",
	        "phoneNumber": "12345678774",
	        "pay_password": "123456",
	        "status": 1
	    }
	}

失败(用户id不存在)       
	
	{
	    "status": "error",
	    "user": {}
	}

## 获取支付密码 ##

url ：[http://localhost:8080/GetPayPassword?phone=12345678774](http://localhost:8080/GetPayPassword?phone=12345678774)      

参数说明  

- phone  11位纯数字手机号码          

返回    

成功   
	
	{
	    "status": "success",
	    "payPassword": "123456"
	}
失败(phone 不存在/没有处于登陆状态)    

	{"status": "error","payPassword":""}    

## 根据手机号码获取用户信息 ##

url ：[http://localhost:8080/GetUserInfo?phone=12345678774](http://localhost:8080/GetUserInfo?phone=12345678774)      


参数说明  

- phone  11位纯数字手机号码        

返回    
成功    

	{
	    "status": "success",
	    "user": {
	        "userId": 1,
	        "userName": "xianyu",
	        "password": "abc",
	        "address": "China",
	        "phoneNumber": "12345678774",
	        "pay_password": "123456",
	        "status": 1
	    }
	}	
失败     

	{
	    "status": "error",
	    "user": {}
	}

## 根据用户id获取用户信息 ##
url [http://localhost:8080/GetUserById?id=1](http://localhost:8080/GetUserById?id=1)    

参数说明   

- id 用户id   

返回   
成功   

	{
	    "status": "success",
	    "user": {
	        "userId": 1,
	        "userName": "xianyu",
	        "password": "abc",
	        "address": "China",
	        "phoneNumber": "12345678774",
	        "pay_password": "123456",
	        "status": 1
	    }
	}
失败(id不存在)     

	 {
	    "status": "error",
	    "user": {}
	}

# 管理相关 #
## 管理员登陆 ##
url [http://localhost:8080/ManagerLogin?id=12345678&password=12345678](http://localhost:8080/ManagerLogin?id=12345678&password=12345678)     

参数说明   

- id 管理员id    
- password 密码   

返回    
成功 返回没有处理的订单(isDeal = 0 代表没处理)   
	
	{
	    "status": "success",
	    "list": [
	        {
	            "order_id": 1985173349,
	            "worker_id": 1,
	            "user_id": 1,
	            "order_time": "2017-06-29 15:38:36.798",
	            "start_time": "2017-12-16",
	            "end_time": "2017-12-2",
	            "phone": "18819259257",
	            "address": "广州",
	            "price": 45,
	            "isPayed": 0,
	            "valid": 1,
	            "isDeal": 0,
	            "message": ""
	        },
	        {
	            "order_id": 1987021255,
	            "worker_id": 1,
	            "user_id": 1,
	            "order_time": "2017-06-29 15:38:38.864",
	            "start_time": "2017-12-16",
	            "end_time": "2017-12-2",
	            "phone": "12345678978",
	            "address": "广州",
	            "price": 45,
	            "isPayed": 0,
	            "valid": 1,
	            "isDeal": 0,
	            "message": ""
	        }
	    ]
	}

失败(没此id / 密码错误)      

	{
	    "status": "error",
	    "list": []
	}

# 订单相关 #
## 获取所有已经处理订单 ##
url：[http://localhost:8080/GetAllDealOrders](http://localhost:8080/GetAllDealOrders)       

返回   
成功有订单 


		{
	    "list": [
	        {
	            "order_id": 1987021255,
	            "worker_id": 1,
	            "user_id": 1,
	            "order_time": "2017-06-29 15:38:38.864",
	            "start_time": "2017-12-16",
	            "end_time": "2017-12-2",
	            "phone": "12345678978",
	            "address": "广州",
	            "price": 45,
	            "isPayed": 0,
	            "valid": 1,
	            "isDeal": 1,
	            "message": ""
	        },
	        {
	            "order_id": 1997677335,
	            "worker_id": 1,
	            "user_id": 1,
	            "order_time": "2017-06-30 10:59:44.601",
	            "start_time": "2017-12-16",
	            "end_time": "2017-12-2",
	            "phone": "18819259257",
	            "address": "广州",
	            "price": 45,
	            "isPayed": 0,
	            "valid": 1,
	            "isDeal": 1,
	            "message": ""
	        }
	    ]
	}
没有订单

	{"list":[]}
## 支付订单 ##

url ：[http://localhost:8080/PayOrder?orderId=1985173349&userId=1](http://localhost:8080/PayOrder?orderId=1985173349&userId=1)     

参数说明   

- orderId 订单id
- userId 用户id    

返回    
成功     


	{
	    "status": "success",
	    "order": {
	        "order_id": 1985173349,
	        "worker_id": 1,
	        "user_id": 1,
	        "order_time": "2017-06-29 15:38:36.798",
	        "start_time": "2017-12-16",
	        "end_time": "2017-12-2",
	        "phone": "18819259257",
	        "address": "广州",
	        "price": 45,
	        "isPayed": 1,
	        "valid": 1,
	        "isDeal": 0,
	        "message": ""
	    }
	}  

status 值说明    
- null 订单id 不存在   
- invalid 订单已经被取消   
- payed 订单已经在之前支付过   
- success 成功支付了    

## 取消订单 ##

url ：[http://localhost:8080/CancelOrder?orderId=1318522461&userId=1](http://localhost:8080/CancelOrder?orderId=1318522461&userId=1)    

参数说明   

- orderId 订单id    
- userId 用户id   

返回    

	{
	    "status": "success",
	    "order": {
	        "order_id": 1985173349,
	        "worker_id": 1,
	        "user_id": 1,
	        "order_time": "2017-06-29 15:38:36.798",
	        "start_time": "2017-12-16",
	        "end_time": "2017-12-2",
	        "phone": "18819259257",
	        "address": "广州",
	        "price": 45,
	        "isPayed": 0,
	        "valid": 0,
	        "isDeal": 0,
	        "message": ""
	    }
	}

status *说明*      

- success 成功取消订单(包含退款)    
- error 用户id为null 或者没有处于登陆状态    
- null 订单不存在      

## 获取所有/支付/未支付的订单 ##

url [http://localhost:8080/GetAllOrder?id=1&type=2](http://localhost:8080/GetAllOrder?id=1&type=2)     

参数说明   

- id 用户id    
- type 

	1.  为0 获取 没有支付了的订单  
	2.  为1 获取	支付了的订单    
	3.  为2 获取所有的订单    

返回    
	
	{
	    "list": [
	        {
	            "order_id": 1987021255,
	            "worker_id": 1,
	            "user_id": 1,
	            "order_time": "2017-06-29 15:38:38.864",
	            "start_time": "2017-12-16",
	            "end_time": "2017-12-2",
	            "phone": "12345678978",
	            "address": "广州",
	            "price": 45,
	            "isPayed": 0,
	            "valid": 1,
	            "isDeal": 1,
	            "message": ""
	        },
	        {
	            "order_id": 1997677335,
	            "worker_id": 1,
	            "user_id": 1,
	            "order_time": "2017-06-30 10:59:44.601",
	            "start_time": "2017-12-16",
	            "end_time": "2017-12-2",
	            "phone": "18819259257",
	            "address": "广州",
	            "price": 45,
	            "isPayed": 0,
	            "valid": 1,
	            "isDeal": 1,
	            "message": ""
	        }
	    ]
	}

## 处理订单 ##

url ：[http://localhost:8080/DealOrder?orderId=1985173349&deal=1](http://localhost:8080/DealOrder?orderId=1985173349&deal=1)     

参数说明    
	
- orderId 订单id    
- deal  1为处理  0 为没处理    

返回   
成功   

	{
	    "order_id": 1985173349,
	    "worker_id": 1,
	    "user_id": 1,
	    "order_time": "2017-06-29 15:38:36.798",
	    "start_time": "2017-12-16",
	    "end_time": "2017-12-2",
	    "phone": "18819259257",
	    "address": "广州",
	    "price": 45,
	    "isPayed": 0,
	    "valid": 0,
	    "isDeal": 1,
	    "message": ""
	}	
订单不存在   
	
	{}

## 删除订单 ##

url [http://localhost:8080/DeleteOrder?id=1318522461](http://localhost:8080/DeleteOrder?id=1318522461)      

参数说明   
- id  订单id    

返回   
订单不存在    
	
	{
	    "status": "null",
	    "order": {}
	}
成功   
	
	{
	    "status": "success",
	    "order": {
	        "order_id": 1985173349,
	        "worker_id": 1,
	        "user_id": 1,
	        "order_time": "2017-06-29 15:38:36.798",
	        "start_time": "2017-12-16",
	        "end_time": "2017-12-2",
	        "phone": "18819259257",
	        "address": "广州",
	        "price": 45,
	        "isPayed": 0,
	        "valid": 0,
	        "isDeal": 1,
	        "message": ""
	    }
	}

## 修改订单 ##

url [http://localhost:8080/ModifyOrder?id=1987021255&phone=12345678978](http://localhost:8080/ModifyOrder?id=1987021255&phone=12345678978)     

参数说明   

- id 订单id  
- phone 订单中手机号码**可选**   
- address 订单中的地址  **可选**  URLEncode utf-8 编码之后再传    
- message 订单说明   **可选**  URLEncode utf-8 编码之后再传    

返回最新的订单信息      
 
	{
	    "status": "success",
	    "order": {
	        "order_id": 1987021255,
	        "worker_id": 1,
	        "user_id": 1,
	        "order_time": "2017-06-29 15:38:38.864",
	        "start_time": "2017-12-16",
	        "end_time": "2017-12-2",
	        "phone": "12345678978",
	        "address": "广州",
	        "price": 45,
	        "isPayed": 0,
	        "valid": 1,
	        "isDeal": 0,
	        "message": ""
	    }
	}
 
## 增加订单 ##

url [http://localhost:8080/AddOrder?order={"order_id":0,"worker_id":1,"user_id":1,"start_time":"2017-12-16","end_time":"2017-12-2","phone":"18819259257","address":"广州","price":45.0,"isPayed":0,"valid":1,"isDeal":0,"message":""}](http://localhost:8080/AddOrder?order={"order_id":0,"worker_id":1,"user_id":1,"start_time":"2017-12-16","end_time":"2017-12-2","phone":"18819259257","address":"广州","price":45.0,"isPayed":0,"valid":1,"isDeal":0,"message":""})    

参数说明   

- order  客户端生成Order 类的对象 用Gson 生成字符串 ，  
	**注意的是 Order对象中的message 和 address 要用URLEncode 编码之后再用Gson 生成字符串**   

Order 类  
	
	public class Order {

	    private int order_id;//不需要填
	    private int worker_id;//必填
	    private int user_id;//必填
	    private String order_time;//不要填
	    private String start_time;//必填
	    private String end_time;//必填
	    private String phone;//必填
	    private String address;//必填
	    private float price;//必填，根据开始天数和结束天数还有护工的工资计算
	
	    private int isPayed;//0 没有支付，默认是0
	    private int valid = 1;//订单是否有效 1为有效
	    private int isDeal = 0;//是否已经处理了 ,默认是0
	
	    private String message = "";//可选
		
		//对应各个属性的get 方法和set 方法 
		// ......
		//.....
		
	}
		Gson gson = new Gson();
		String str = gson.toJson(order);	
		//.....
		//....

返回   
成功    
	
	{
	    "order_id": 1997677335,
	    "worker_id": 1,
	    "user_id": 1,
	    "order_time": "2017-06-30 10:59:44.601",
	    "start_time": "2017-12-16",
	    "end_time": "2017-12-2",
	    "phone": "18819259257",
	    "address": "广州",
	    "price": 45,
	    "isPayed": 0,
	    "valid": 1,
	    "isDeal": 0,
	    "message": ""
	}
失败   

	{}

## 根据订单id获取订单详细 ##

url [http://localhost:8080/GetOrderById?id=1987021255](http://localhost:8080/GetOrderById?id=1987021255)     

参数说明  
- id 订单id    

返回   
	
	{
	    "status": "success",
	    "order": {
	        "order_id": 1987021255,
	        "worker_id": 1,
	        "user_id": 1,
	        "order_time": "2017-06-29 15:38:38.864",
	        "start_time": "2017-12-16",
	        "end_time": "2017-12-2",
	        "phone": "12345678978",
	        "address": "广州",
	        "price": 45,
	        "isPayed": 0,
	        "valid": 1,
	        "isDeal": 0,
	        "message": ""
	    }
	}
失败   
	
	{
	    "status": "null",
	    "order": {
	       
	    }
	}

# 护工相关 #

## 增加护工 ##

url [http://localhost:8080/addCareWorker?name=%E6%9D%8E%E9%94%A6%E9%9B%84&age=12&gender=1&introduce=&phone=123456788&dayWage=12&hourWage=12](http://localhost:8080/addCareWorker?name=%E6%9D%8E%E9%94%A6%E9%9B%84&age=12&gender=1&introduce=&phone=123456788&dayWage=12&hourWage=12)     

参数说明    

- name 护工名字   URLEncode utf-8 编码后再传    
- age 年龄 int  
- gender  1 为男 0 为 女   
- introduce 个人介绍**可选**   
- phone 护工手机号码    
- dayWage 每天工资 int  和时薪不能同时为null  
- hourWage 时薪  int 和日薪不能同时为null   

返回   
成功  
	
	{
	    "status": "success"
	}
失败

	{
	    "status": "error"
	}

## 删去护工 ##
url [http://localhost:8080/DeleteWorker?id=4](http://localhost:8080/DeleteWorker?id=4)     

参数说明   
- id 护工id

返回    
成功    

	{
	    "status": "success",
	    "worker": {
	        "worker_id": 4,
	        "name": "李锦雄",
	        "age": 12,
	        "gender": 1,
	        "introduce": "",
	        "phone": "123456788",
	        "day_wage": 12,
	        "hour_wage": 12
	    }
	}

护工id 不存在    
	
	{
	    "status": "null",
	    "worker": {}
	}

## 根据条件获得护工 ##

参数说明    
- type  
	1. AGE 根据年龄查询护工    
	2. GENDER 根据性别查询护工   
	3. HOUR_WAGE 根据时薪查询护工   
	4. DAY_WAGE 根据日薪查询护工  
- min 下限   不填为0   
- max 上限   不填为100

### 性别 ###

url  [http://localhost:8080/GetWorker?type=GENDER&gender=1](http://localhost:8080/GetWorker?type=GENDER&gender=1)   

参数说明    
1 代表 男 0 代表 女


返回
有数据   


	{
	    "list": [
	        {
	            "worker_id": 1,
	            "name": "李锦雄",
	            "age": 21,
	            "gender": 1,
	            "introduce": "",
	            "phone": "18819259257",
	            "day_wage": 16,
	            "hour_wage": 12
	        }
	    ]
	}

没数据   
	
	{"list":[]}

### 年龄 ###

url  [http://localhost:8080/GetWorker?type=AGE&min=&max=45](http://localhost:8080/GetWorker?type=AGE&min=&max=45)       

参数说明     
- min 最低年龄**可选**   
- max 最大年龄**可选**    

	
返回     
	
	{
	    "list": [
	        {
	            "worker_id": 1,
	            "name": "李锦雄",
	            "age": 21,
	            "gender": 1,
	            "introduce": "",
	            "phone": "18819259257",
	            "day_wage": 16,
	            "hour_wage": 12
	        }
	    ]
	}
或者   
	
	{"list":[]}   

### 时薪 ###

url [http://localhost:8080/GetWorker?type=HOUR_WAGE&min=&max=](http://localhost:8080/GetWorker?type=HOUR_WAGE&min=&max=)      

参数说明    

- min 最低时薪 **可选**    
- max 最高时薪 **可选**    

返回     
	
	{
	    "list": [
	        {
	            "worker_id": 1,
	            "name": "李锦雄",
	            "age": 21,
	            "gender": 1,
	            "introduce": "",
	            "phone": "18819259257",
	            "day_wage": 16,
	            "hour_wage": 12
	        }
	    ]
	}
或者   
	
	{"list":[]}

### 日薪 ###

url  [http://localhost:8080/GetWorker?type=DAY_WAGE&min=&max=](http://localhost:8080/GetWorker?type=DAY_WAGE&min=&max=)     

参数说明   
- min 最低日薪 **可选**
- max 最高日薪  **可选**   

返回     
	
	{
	    "list": [
	        {
	            "worker_id": 1,
	            "name": "李锦雄",
	            "age": 21,
	            "gender": 1,
	            "introduce": "",
	            "phone": "18819259257",
	            "day_wage": 16,
	            "hour_wage": 12
	        }
	    ]
	}
或者   
	
	{
		"list":[]		
	}     

## 修改护工的信息 ##

url    
http://localhost:8080/ModifyWorker?worker={"worker_id": 1,"name": "李锦雄","age": 21,"gender": 1,"introduce": "","phone": "18819259257","day_wage": 16,"hour_wage": 12}      

参数说明   

- worker CareWorker 类对象的json 字符串


CareWorker 类  


	private int worker_id;
    private String name="";
    private int age;
    private int gender;
    private String introduce;
    private String phone;
    private int day_wage;
    private int hour_wage;
	//对应的get 和set 方法

	
返回   
成功 

	
	{
	    "status": "success",
	    "worker": {
	        "worker_id": 1,
	        "name": "李锦雄",
	        "age": 21,
	        "gender": 1,
	        "introduce": "",
	        "phone": "18819259257",
	        "day_wage": 16,
	        "hour_wage": 12
	    }
	}

失败   

	{
	    "status": "error",
	    "worker": {
	    
	    }
	}

## 获取所有的护工 ##

[http://localhost:8080/GetAllCareWorker](http://localhost:8080/GetAllCareWorker)     

返回    

	{
	    "list": [
	        {
	            "worker_id": 1,
	            "name": "李锦雄",
	            "age": 21,
	            "gender": 1,
	            "introduce": "",
	            "phone": "18819259257",
	            "day_wage": 16,
	            "hour_wage": 12
	        }
	    ]
	}

## 根据护工 id 返回护工信息 ##

[http://localhost:8080/GetWorkerById?id=1](http://localhost:8080/GetWorkerById?id=1)     

参数说明   

- id  护工id  


返回   

	{
	    "status": "success",
	    "user": {
	        "worker_id": 1,
	        "name": "李锦雄",
	        "age": 21,
	        "gender": 1,
	        "introduce": "",
	        "phone": "18819259257",
	        "day_wage": 16,
	        "hour_wage": 12
	    }
	}

失败    

	{
	    "status": "error",
	    "user": {
	        
	    }
	}
