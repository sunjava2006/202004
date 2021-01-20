package com.thzhima.advance.util;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SystemSortedSet {

	public static void main(String[] args) {
		SortedSet<Integer> set = new TreeSet<>();
		
		set.add(new Integer(7));
		set.add(1);
		set.add(5);
		set.add(2);
		set.add(0);
		
		for(Number i: set) {
			System.out.println(i);
		}
		
		
		
		SortedSet<People> peopleSet = new TreeSet<>();
		People p = new People(20, "Li", "F");
		People p2 = new People(22, "Wang", "M");
		People p3 = new People(30, "Fang", "F");
		People p4 = new People(40, "Zhan", "M");
		People p5 = new People(21, "Tang", "F");
		People p6 = new People(21, "Fan", "F");
		
		
		System.out.println(p5.equals(p6));
		
		peopleSet.add(p);
		peopleSet.add(p2);
		peopleSet.add(p3);
		peopleSet.add(p4);
		peopleSet.add(p5);
		peopleSet.add(p6);
		
		for(People i : peopleSet) {
			System.out.println(i);
		}
		
		
		//========================================================================
		Comparator<Computer> comparator = new Comparator<Computer>() {
			
			@Override
			public int compare(Computer o1, Computer o2) {
				
				if(o1.equals(o2)) {
					return 0;
				}
				return o1.cpuSpeed-o2.cpuSpeed !=0 ? o1.cpuSpeed-o2.cpuSpeed: (o1.memSize - o2.memSize);
			}
		};
		
		
		SortedSet<Computer> computerSet = new TreeSet<>(comparator);
		Computer c = new Computer(3000, 32);
		Computer c2 = new Computer(2000, 32);
		Computer c3 = new Computer(4000, 32);
		Computer c4 = new Computer(3200, 32);
		Computer c5 = new Computer(3800, 16);
		Computer c6 = new Computer(3800, 32);
		
		
		computerSet.add(c);
		computerSet.add(c2);
		computerSet.add(c3);
		computerSet.add(c4);
		computerSet.add(c5);
		computerSet.add(c6);
		
		for(Computer i: computerSet) {
			System.out.println(i);
		}
		
	}
}

class Computer{
	int cpuSpeed;
	int memSize;
	
	Computer(int cpuSpeed, int memSize){
		this.cpuSpeed = cpuSpeed;
		this.memSize = memSize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpuSpeed;
		result = prime * result + memSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (cpuSpeed != other.cpuSpeed)
			return false;
		if (memSize != other.memSize)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Computer [cpuSpeed=" + cpuSpeed + ", memSize=" + memSize + "]";
	}
	
	
}


class People implements Comparable<People>{
	int age;
	String name;
	String gender;
	
	public People(int age, String name, String gender) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
	}

	@Override
	public int compareTo(People o) {
		
		if( this.equals(o)) {
			return 0;
		}
		else {
			return this.age< o.age? -1: (this.age> o.age? 1: (this.name.compareTo(o.name)) );
		}
	}

	@Override
	public String toString() {
		return "People [age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
