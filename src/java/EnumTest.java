public enum EnumTest {
	FATHER("Frank", 36, 'M'), MOTHER("Mary", 34, 'W'), SON("Tony", 5, 'M');

	private int age;
	private char gender;

	EnumTest(String name, int age, char gender) {
		this.age = age;
		this.gender = gender;
	}

	private String getName() {
		return this.name();
	}

	private int getAge() {
		return this.age;
	}

	private char getGender() {
		return this.gender;
	}

	public static void main(String[] args) {
		for (EnumTest person : EnumTest.values()) {
			System.out.println(person.getName() + ", " + person.getAge() + ", " + person.getGender());
		}
		System.out.println(EnumTest.FATHER.getDeclaringClass());
	}
}
