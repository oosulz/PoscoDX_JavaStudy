package prob04;

public class Depart extends Employee {
	
	private String department;
	
	public Depart(String name, int salary, String department) {
		this.setName(name);
		this.setSalary(salary);
		this.department = department;
	}

	@Override
	public void print() {
		System.out.println( "이름:" + getName() + " 연봉:" + getSalary() + " 부서:" + department);
	}
	

}
