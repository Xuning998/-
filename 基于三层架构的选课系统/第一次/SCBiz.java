package biz;
import java.util.*;

import dao.CourseDao;
import dao.SCDao;
import entity.*;
import view.MainUI;
public class SCBiz {
public void add(String courseid ) {
	SCDao scs= SCDao.getInstance();
	SC sc=(SC)scs.getEntity(MainUI.user.getStudentNo());
	CourseDao cd=CourseDao.getInstance();
	if(sc.isCourseHere(courseid)){
		System.out.println("选课失败，课程已选");
	}
	else if(!cd.isHere(courseid)) {
		System.out.println("选课失败,无该课程");
	}
	else {
	sc.addone(courseid, 0);
	System.out.println("选课成功");
	}
	
}
public void show()throws Exception {
	CourseDao csd=CourseDao .getInstance();
	SCDao scs= SCDao.getInstance();
	SC sc=(SC)scs.getEntity(MainUI.user.getStudentNo());
	if(sc.isEmpty()) {
		 System.out.println("您还未选课");
		 MainUI.show();
	}
	else {
     Set courseNoGradeSet=sc.getcourseNoGrade().entrySet();
     Iterator it=courseNoGradeSet.iterator();
     System.out.println("您已选的选课信息如下：");
     while(it.hasNext()) {
    	 Map.Entry entry=(Map.Entry)it.next();
    	 String courseNo=(String)entry.getKey();
    	 double courseGrade=(double)entry.getValue();
    	 Course course=(Course)csd.getEntity(courseNo);
    	 String courseName=course.getCourseName();
    	 System.out.println("课号："+courseNo+" 课程名称："+courseName+" 成绩："+courseGrade);
     }
     MainUI.show();
     }
}
public void show2() {
	CourseDao csd=CourseDao .getInstance();
	SCDao scs= SCDao.getInstance();
	SC sc=(SC)scs.getEntity(MainUI.user.getStudentNo());
     Set courseNoGradeSet=sc.getcourseNoGrade().entrySet();
     Iterator it=courseNoGradeSet.iterator();
     System.out.println("您已选的选课信息如下：");
     while(it.hasNext()) {
    	 Map.Entry entry=(Map.Entry)it.next();
    	 String courseNo=(String)entry.getKey();
    	 double courseGrade=(double)entry.getValue();
    	 Course course=(Course)csd.getEntity(courseNo);
    	 String courseName=course.getCourseName();
    	 System.out.println("课号："+courseNo+" 课程名称："+courseName+" 成绩："+courseGrade);
     }
    
}
public boolean check(String courseNo) {

	SCDao scs= SCDao.getInstance();
	SC sc=(SC)scs.getEntity(MainUI.user.getStudentNo());
	return sc.isCourseHere(courseNo);
}
public void dropOutCourse(String courseNo ) {
	SCDao scs= SCDao.getInstance();
	SC sc=(SC)scs.getEntity(MainUI.user.getStudentNo());
	sc.remove(courseNo);
	
}
}
