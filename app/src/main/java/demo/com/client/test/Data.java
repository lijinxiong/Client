package demo.com.client.test;

import java.util.List;

/**
 * Created by jinxiong on 2017/6/26.
 */

public class Data {



    private CourseBean course;
    private double value;
    private String status;
    private List<CommentBean> comment;

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CommentBean> getComment() {
        return comment;
    }

    public void setComment(List<CommentBean> comment) {
        this.comment = comment;
    }

    public static class CourseBean {
        /**
         * ID : 105
         * Class_Recommend : 81.6779
         * Class_Name : 教育心理电影赏析
         * Class_Teacher : 林玲
         * Class_Score : 2
         * Class_Sex : 人文社会科学类
         * Class_Collage : 经济管理学院
         * Class_Audit : 1
         * Class_Delete : 0
         */

        private String ID;
        private String Class_Recommend;
        private String Class_Name;
        private String Class_Teacher;
        private String Class_Score;
        private String Class_Sex;
        private String Class_Collage;
        private String Class_Audit;
        private String Class_Delete;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getClass_Recommend() {
            return Class_Recommend;
        }

        public void setClass_Recommend(String Class_Recommend) {
            this.Class_Recommend = Class_Recommend;
        }

        public String getClass_Name() {
            return Class_Name;
        }

        public void setClass_Name(String Class_Name) {
            this.Class_Name = Class_Name;
        }

        public String getClass_Teacher() {
            return Class_Teacher;
        }

        public void setClass_Teacher(String Class_Teacher) {
            this.Class_Teacher = Class_Teacher;
        }

        public String getClass_Score() {
            return Class_Score;
        }

        public void setClass_Score(String Class_Score) {
            this.Class_Score = Class_Score;
        }

        public String getClass_Sex() {
            return Class_Sex;
        }

        public void setClass_Sex(String Class_Sex) {
            this.Class_Sex = Class_Sex;
        }

        public String getClass_Collage() {
            return Class_Collage;
        }

        public void setClass_Collage(String Class_Collage) {
            this.Class_Collage = Class_Collage;
        }

        public String getClass_Audit() {
            return Class_Audit;
        }

        public void setClass_Audit(String Class_Audit) {
            this.Class_Audit = Class_Audit;
        }

        public String getClass_Delete() {
            return Class_Delete;
        }

        public void setClass_Delete(String Class_Delete) {
            this.Class_Delete = Class_Delete;
        }
    }

    public static class CommentBean {
        /**
         * ID : 4164
         * Class_ID : 105
         * Class_Check : no
         * Class_Homework : some
         * Class_Exam : ok
         * Class_Score : 0
         * Class_User : no
         * Class_Ex : no
         * Class_User_See : 1
         * Class_Comment_Time : 2017-04-13
         * Class_Select : no
         * Class_Value : 0
         * Class_Comment_Like : 0
         * Class_Comment_Dislike : 0
         * Class_Audit : 0
         * Class_Praise_users :
         */

        private String ID;
        private String Class_ID;
        private String Class_Check;
        private String Class_Homework;
        private String Class_Exam;
        private String Class_Score;
        private String Class_User;
        private String Class_Ex;
        private String Class_User_See;
        private String Class_Comment_Time;
        private String Class_Select;
        private String Class_Value;
        private String Class_Comment_Like;
        private String Class_Comment_Dislike;
        private String Class_Audit;
        private String Class_Praise_users;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getClass_ID() {
            return Class_ID;
        }

        public void setClass_ID(String Class_ID) {
            this.Class_ID = Class_ID;
        }

        public String getClass_Check() {
            return Class_Check;
        }

        public void setClass_Check(String Class_Check) {
            this.Class_Check = Class_Check;
        }

        public String getClass_Homework() {
            return Class_Homework;
        }

        public void setClass_Homework(String Class_Homework) {
            this.Class_Homework = Class_Homework;
        }

        public String getClass_Exam() {
            return Class_Exam;
        }

        public void setClass_Exam(String Class_Exam) {
            this.Class_Exam = Class_Exam;
        }

        public String getClass_Score() {
            return Class_Score;
        }

        public void setClass_Score(String Class_Score) {
            this.Class_Score = Class_Score;
        }

        public String getClass_User() {
            return Class_User;
        }

        public void setClass_User(String Class_User) {
            this.Class_User = Class_User;
        }

        public String getClass_Ex() {
            return Class_Ex;
        }

        public void setClass_Ex(String Class_Ex) {
            this.Class_Ex = Class_Ex;
        }

        public String getClass_User_See() {
            return Class_User_See;
        }

        public void setClass_User_See(String Class_User_See) {
            this.Class_User_See = Class_User_See;
        }

        public String getClass_Comment_Time() {
            return Class_Comment_Time;
        }

        public void setClass_Comment_Time(String Class_Comment_Time) {
            this.Class_Comment_Time = Class_Comment_Time;
        }

        public String getClass_Select() {
            return Class_Select;
        }

        public void setClass_Select(String Class_Select) {
            this.Class_Select = Class_Select;
        }

        public String getClass_Value() {
            return Class_Value;
        }

        public void setClass_Value(String Class_Value) {
            this.Class_Value = Class_Value;
        }

        public String getClass_Comment_Like() {
            return Class_Comment_Like;
        }

        public void setClass_Comment_Like(String Class_Comment_Like) {
            this.Class_Comment_Like = Class_Comment_Like;
        }

        public String getClass_Comment_Dislike() {
            return Class_Comment_Dislike;
        }

        public void setClass_Comment_Dislike(String Class_Comment_Dislike) {
            this.Class_Comment_Dislike = Class_Comment_Dislike;
        }

        public String getClass_Audit() {
            return Class_Audit;
        }

        public void setClass_Audit(String Class_Audit) {
            this.Class_Audit = Class_Audit;
        }

        public String getClass_Praise_users() {
            return Class_Praise_users;
        }

        public void setClass_Praise_users(String Class_Praise_users) {
            this.Class_Praise_users = Class_Praise_users;
        }
    }
}
