package com.example.demo.JavaPractice;

public enum DaysEnum {
	MONDAY(1, "monday-1") {

		@Override
		public void printDesc() {
			System.out.println(this.name() + " : " + this.getDesc());
		}

	},
	TUESDAY(2, "tuesday-2") {

		@Override
		public void printDesc() {
			System.out.println(this.name() + " : " + this.getDesc());
		}

	},
	WEDNESDAY(3, "wednesday-3") {

		@Override
		public void printDesc() {
			System.out.println(this.name() + " : " + this.getDesc());
		}

	},
	THURSDAY(4, "thursday-4") {

		@Override
		public void printDesc() {
			System.out.println(this.name() + " : " + this.getDesc());
		}

	},
	FRIDAY(5, "friday-5") {

		@Override
		public void printDesc() {
			System.out.println(this.name() + " : " + this.getDesc());
		}

	},
	SATURDAY(6, "saturday-6") {

		@Override
		public void printDesc() {
			System.out.println(this.name() + " : " + this.getDesc());
		}

	},
	SUNDAY(7, "sunday-7") {

		@Override
		public void printDesc() {
			System.out.println(this.name() + " : " + this.getDesc());
		}

	};

	private int val;
	private String desc;

	DaysEnum(int val, String desc) {
		this.val = val;
		this.desc = desc;
	}

	public abstract void printDesc();

	public int getVal() {
		return val;
	}

	public String getDesc() {
		return desc;
	}

}
