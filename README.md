# Client
坑
### 用户注册 ###
[http://xxx.xxx.xx/addUser?password=123645&phone=12345678774](http://localhost:8080/addUser?password=123645&phone=12345678774)      

#### 参数说明####
	
*方式* :**post**

- password ：客户端判断密码长度大于6，小于16，必须包含字母和数字，进行md5加密后再传给后台    
- phone ：手机号码，保证11位数字再传给后台   

#### 返回数据： ####
**json：注册是否成功，相同号码只能注册一次**

例子：    
成功
	
	{"status": "success"}
失败    

	{"status": "error"}   

### 用户登录 ###

[http://xxx.xx.xx/UserLogin?phone=12345678774&password=123](http://localhost:8080/UserLogin?phone=12345678774&password=123)    

#### 参数说明：  ####

*方式*:**post**     

- phone:手机号码：保证11位数字再传给后台       
- password ：密码，用户输入的密码，用md5加密之后再传给后台     

#### 返回数据 ####
**json:成功就返回当前用户的信息，失败返回不包含当前用户的信息**

例子：  
成功   

	{
	    "status": "success",
	    "user": {
	        "userId": 1,
	        "userName": "",
	        "password": "123645",
	        "address": "",
	        "phoneNumber": "12345678774",
	        "pay_password": "",
	        "status": 1
	    }
	}
其中**user.status**为1代表着账号已经处于登陆状态，否则就不是登陆状态.应该将登陆成功的客户信息保存在本地        

失败     
	
	{
	    "status": "error",
	    "user": {
	        "userId": 0,
	        "userName": "",
	        "password": "",
	        "address": "",
	        "phoneNumber": "",
	        "pay_password": "",
	        "status": 0
	    }
	}

### 修改登录密码 ###
[http://xxx.xx.xx/ModifyPassword?phone=12345678774&newPassword=abc&oldPassword=789d456](http://localhost:8080/ModifyPassword?phone=12345678774&newPassword=abc&oldPassword=789d456)     

#### 参数说明 ####

*方式*：**post**     

- phone：手机号码，保证11位数字再传给后台     
- newPassword:新密码，客户端判断密码长度大于6，小于16，必须包含字母和数字，进行md5加密后再传给后台    
- oldPassword：旧密码,先跟本地保存的客户密码就行匹配，匹配成功才传给后台    

#### 返回数据 ####
**json:返回最新的密码，不管成功否，都会返回最新的文档**

例子      
成功  

	{
	    "status": "success",
	    "password": "123456789"
	}
失败   

	
	{
	    "status": "error",
	    "password": "123645"
	}
### 获取支付密码 ###
[http://xxx.xx.xx/GetPayPassword?phone=12345678774](http://localhost:8080/GetPayPassword?phone=12345678774)       

#### 参数说明 ####
*方式：post*    

- phone 手机号码：返回该用户的支付密码    

**必须是在登陆状态的用户才能调用此方法**

#### 返回数据 ####
**json，假如当前用户没有设置支付密码，*payPassword*的值就会是""

例子    
没有设置支付密码

	{
	    "status": "success",
	    "payPassword": ""
	}


设置了支付密码   
	
	{
	    "status": "success",
	    "payPassword": "456798"
	}

### 修改支付密码 ###

[http://xxx.xxx.xx/ModifyPayPassword?oldPayPassword=&newPayPassword=123456&phone=12345678774](http://localhost:8080/ModifyPayPassword?oldPayPassword=&newPayPassword=123456&phone=12345678774)    

#### 参数说明 ####

*方式:post*     

- oldPassword：旧的支付密码，客户端对本地保存的进行匹配后再传给后台    
- newPassword:新的支付密码，需要**6位纯数字**    
- phone：当前登陆的账号    

#### 返回数据 ####
**Json，返回最新的支付密码**    

例子：   
	
	{
	    "status": "error",
	    "payPassword": ""
	}       
	
或者   
	
	{
	    "status": "error",
	    "payPassword": "456789"
	}	


### 增加护工 ###

[http://xxx.xxx.xx/addCareWorker?name=%E6%9D%8E%E9%94%A6%E9%9B%84&age=12&gender=1&introduce=&phone=123456789&dayWage=12&hourWage=12](http://localhost:8080/addCareWorker?name=%E6%9D%8E%E9%94%A6%E9%9B%84&age=12&gender=1&introduce=&phone=123456789&dayWage=12&hourWage=12)    

#### 参数说明 ####

**方式:post**    

- name 护工的名字，必须先进行百分制编码    

		name = URLEncoder.encode(name, "utf-8");
- age 年龄，int 类型   
- gender 性别 1为男，0为女 ，int 类型   
- introduce:个人介绍，**可选**，String类型     
- phone手机号码    
- dayWage 按天数计算多少工资  int类型   跟hourWage 不能同时为null  
- hourWage 按小时计算工资 int类型		跟dayWage 不能同时为null     

#### 返回数据 ####
**json是否增加成功，同一个phone只能对应一个护工**   

例子    
成功    
	
	{
	    "status": "success"
	}
失败    

	{
	    "status": "error"
	}

### 根据条件查询护工查询护工 ###

[http://xx.xx.xx/GetWorker?type=GENDER&gender=1](http://localhost:8080/GetWorker?type=xxx&xxx=xx&xxx=xx)   

#### 参数说明 ####

**方式：post**   

type的可选值    

- AGE 根据年龄筛选护工    
- GENDER 根据性别筛选护工   
- HOUR_WAGE 根据小时工资筛选护工    
- DAY_WAGE 根据天工资筛选护工   

#### 根据年龄查询 ####
[http://localhost:8080/GetWorker?type=AGE&min=&max=](http://localhost:8080/GetWorker?type=AGE&min=&max=)    

#### 参数说明 ####

- max 查询年龄的上限，可选，默认不写是100 int类型    
- min 查询年龄的下限 ，可选，默认不写是0 ，int 类型   


例子
	
	[
	    {
	        "worker_id": 1,
	        "name": "李锦雄",
	        "age": 12,
	        "gender": 1,
	        "introduce": "",
	        "phone": "123456789",
	        "day_wage": 12,
	        "hour_wage": 12
	    },
	    {
	        "worker_id": 2,
	        "name": "李锦雄",
	        "age": 12,
	        "gender": 1,
	        "introduce": "",
	        "phone": "124456789",
	        "day_wage": 12,
	        "hour_wage": 12
	    }
	]
或者  
 
	[]

#### 根据时/天工资查询 ####

[http://localhost:8080/GetWorker?type=DAY_WAGE&min=0&max=](http://localhost:8080/GetWorker?type=DAY_WAGE&min=0&max=)

#### 参数说明 ####

- min 跟查询年龄一样   
- max 跟查询年龄一样   

例子   

	[
	    {
	        "worker_id": 1,
	        "name": "李锦雄",
	        "age": 12,
	        "gender": 1,
	        "introduce": "",
	        "phone": "123456789",
	        "day_wage": 12,
	        "hour_wage": 12
	    },
	    {
	        "worker_id": 2,
	        "name": "李锦雄",
	        "age": 12,
	        "gender": 1,
	        "introduce": "",
	        "phone": "124456789",
	        "day_wage": 12,
	        "hour_wage": 12
	    }
	]
#### 根据性别查询 ####
[http://localhost:8080/GetWorker?type=GENDER&gender=1](http://localhost:8080/GetWorker?type=GENDER&gender=1)     

参数说明：			

- gender 1为男人   0 为 女人   	


		[
		    {
		        "worker_id": 1,
		        "name": "李锦雄",
		        "age": 12,
		        "gender": 1,
		        "introduce": "",
		        "phone": "123456789",
		        "day_wage": 12,
		        "hour_wage": 12
		    },
		    {
		        "worker_id": 2,
		        "name": "李锦雄",
		        "age": 12,
		        "gender": 1,
		        "introduce": "",
		        "phone": "124456789",
		        "day_wage": 12,
		        "hour_wage": 12
		    }
		]
	
