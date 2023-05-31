package com.ssk;

import java.util.Optional;

class Employee {
	int empId;
	String empName;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

}

public class OptionalDemo {

	public static Optional<Employee> getEmployeeById(int empId) {
		if (empId == 1)
			return Optional.of(new Employee(empId, "Sagar Khati"));

		return Optional.empty();
	}

	public static Employee getDefaulEmployee() {
		return new Employee(007, "James Bond");
	}

	public static void main(String[] args) {

		// of
		Optional<Employee> of = Optional.of(new Employee(1, "Sagar Khati"));
		System.out.println(of);

		// empty
		Optional<Object> empty = Optional.empty();
		System.out.println(empty);

		// ofNullable
		Optional<Employee> ofNullable = Optional.ofNullable(new Employee(1, "Sagar Khati"));
		Optional<Object> ofNullable2 = Optional.ofNullable(null);
		System.out.println(ofNullable);
		System.out.println(ofNullable2);

		Optional<Employee> employeeById = OptionalDemo.getEmployeeById(1);
		Optional<Employee> employeeById2 = OptionalDemo.getEmployeeById(2);

		// isPresent and get
		if (employeeById.isPresent()) {
			System.out.println(employeeById.get());
		}

		// isEmpty
		if (employeeById2.isEmpty()) {
			System.out.println("Employee Not Present");
		}

		// ifPresent
		employeeById.ifPresent(System.out::println);

		// ifPresentOrElse
		employeeById2.ifPresentOrElse(System.out::println, () -> System.out.println("Employee not present"));

		Employee employee = new Employee(007, "James Bond");

		// or
		System.out.println(OptionalDemo.getEmployeeById(3).or(() -> Optional.of(employee)));

		// orElse
		Employee orElse = OptionalDemo.getEmployeeById(3).orElse(employee);
		System.out.println(orElse);

		// orElseGet
		System.out.println(employeeById2.orElseGet(OptionalDemo::getDefaulEmployee));

		// orElseThrow
		Employee orElseThrow = OptionalDemo.getEmployeeById(1).orElseThrow();
		System.out.println(orElseThrow);
		Employee orElseThrow2 = OptionalDemo.getEmployeeById(1)
				.orElseThrow(() -> new RuntimeException("NO RECORDS PRESENT"));
		System.out.println(orElseThrow2);

		// filter
		System.out.println(employeeById.filter(i -> i.empId % 2 != 0));
		System.out.println(employeeById.filter(i -> i.empId % 2 == 0));
		System.out.println(employeeById2.filter(i -> i.empId % 2 != 0));
		System.out.println(employeeById2.filter(i -> i.empId % 2 == 0));

		// map
		System.out.println(employeeById.map(i -> i.empId % 2 != 0));
		System.out.println(employeeById.map(i -> i.empId % 2 == 0));
		System.out.println(employeeById.map(i -> i.empName.charAt(0)));
		System.out.println(employeeById.map(i -> i.empName.concat("Hello")));
		System.out.println(employeeById2.map(i -> i.empId % 2 != 0));
		System.out.println(employeeById2.map(i -> i.empId % 2 == 0));

		// flatMap
		System.out.println(employeeById.flatMap(i -> Optional.of(i.empId)));
		System.out.println(employeeById2.flatMap(i -> Optional.of(i.empId)));

		// stream
		System.out.println(employeeById.stream().map(i -> i.empId % 2 != 0).count());
	}

}
