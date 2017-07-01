package demo.com.client.test;

import java.util.List;

/**
 * Created by jinxiong on 2017/6/26.
 */

public class LoginReturnData {


    /**
     * status : success
     * list : [{"order_id":1987021255,"worker_id":1,"user_id":1,"order_time":"2017-06-29 15:38:38.864","start_time":"2017-12-16","end_time":"2017-12-2","phone":"12345678978","address":"广州","price":45,"isPayed":0,"valid":1,"isDeal":0,"message":""},{"order_id":1997677335,"worker_id":1,"user_id":1,"order_time":"2017-06-30 10:59:44.601","start_time":"2017-12-16","end_time":"2017-12-2","phone":"18819259257","address":"广州","price":45,"isPayed":0,"valid":1,"isDeal":0,"message":""}]
     */

    private String status;
    private List<ListBean> list;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * order_id : 1987021255
         * worker_id : 1
         * user_id : 1
         * order_time : 2017-06-29 15:38:38.864
         * start_time : 2017-12-16
         * end_time : 2017-12-2
         * phone : 12345678978
         * address : 广州
         * price : 45
         * isPayed : 0
         * valid : 1
         * isDeal : 0
         * message :
         */

        private int order_id;
        private int worker_id;
        private int user_id;
        private String order_time;
        private String start_time;
        private String end_time;
        private String phone;
        private String address;
        private int price;
        private int isPayed;
        private int valid;
        private int isDeal;
        private String message;

        public int getOrder_id() {
            return order_id;
        }

        public void setOrder_id(int order_id) {
            this.order_id = order_id;
        }

        public int getWorker_id() {
            return worker_id;
        }

        public void setWorker_id(int worker_id) {
            this.worker_id = worker_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getOrder_time() {
            return order_time;
        }

        public void setOrder_time(String order_time) {
            this.order_time = order_time;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getIsPayed() {
            return isPayed;
        }

        public void setIsPayed(int isPayed) {
            this.isPayed = isPayed;
        }

        public int getValid() {
            return valid;
        }

        public void setValid(int valid) {
            this.valid = valid;
        }

        public int getIsDeal() {
            return isDeal;
        }

        public void setIsDeal(int isDeal) {
            this.isDeal = isDeal;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
