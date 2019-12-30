package biz;

import dao.SCDao;
import dao.StudentDao;
import entity.IEntity;
import entity.Student;
import entity.SC;
import view.MainUI;

public class StudentBiz {
	StudentDao studentDao;
	SCDao sCDao;
	private Student student;
	//登录
	public void login(String studentNo, String studentPassword)throws Exception {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("用户不存在");
			MainUI.show();
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功");
			MainUI.user=student;
			MainUI.show();
		} else {
			System.out.println("密码不正确");
			MainUI.show();
		}

	}
	//注册，业务逻辑实现
	public void register(String studentNo, 
						String studentName, 
						String studentGender, 
						int studentAge, 
						String studentDepartment, 
						String firstPassword, 
						String secondPassword)throws Exception {
		if(firstPassword.equals(secondPassword)) {
			student = new Student();
			student.setStudentNo(studentNo);
			student.setStudentName(studentName);
			student.setStudentAge(studentAge);
			student.setStudentDepartment(studentDepartment);
			student.setStudentPassword(firstPassword);
			studentDao = StudentDao.getInstance();
			studentDao.insert(student);
			SC sc=new SC();
			sc.setStudentNo(studentNo);
			sCDao=SCDao.getInstance();
			sCDao.insert(sc);
			System.out.println("注册成功！");
			MainUI.show();
		}else {
			
		}
	}
	public void modifyPassword(String newPassword)throws Exception {
		MainUI.user.setStudentPassword(newPassword);
		System.out.println("修改成功！");
		MainUI.show();
	}
}
