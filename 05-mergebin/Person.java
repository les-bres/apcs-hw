public class Person implements Comparable {

    private int age;
    private String name;

    public Person( int ageG, String nameG) {
	age = ageG;
	name = nameG;
    }

    public int getAge() {
	return age;
    }

    public String getName() {
	return name;
    }

    public int compareTo( Object other ) {
	//	return age - ((Person)other).age;
	return name.compareTo( ((Person)other).name );
    }

    public String toString() {
	return name + "-" + age;
    }
}
