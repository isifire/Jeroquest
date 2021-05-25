package jeroquest.utils;

/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Class DynamicVectorObjects - Class that allows to represent
 * dynamic vectors of Object. Includes operations like insert, remove, set, get,
 * ...
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

public class DynamicVectorObjects {
	// data representation
	private Object[] data;

	// Constructors
	public DynamicVectorObjects() {
		data = new Object[0];
	}

	public DynamicVectorObjects(DynamicVectorObjects v) {
		data = new Object[v.length()];
		for (int i = 0; i < data.length; i++)
			data[i] = v.get(i);
	}

	public DynamicVectorObjects(int size) {
		data = new Object[size];
		for (int i = 0; i < data.length; i++)
			data[i] = null;
	}

	public DynamicVectorObjects(Object[] v) {
		data = new Object[v.length];
		for (int i = 0; i < data.length; i++)
			data[i] = v[i];
	}

	// Getters
	public int length() {
		return data.length;
	}

	public boolean isNull() {
		return data.length == 0;
	}

	public Object get(int i) {
		return data[i];
	}

	public void show() {
		System.out.println("\nDynamicVectorObjects");
		System.out.printf("Length: %d", data.length);
		System.out.print("\nData: ");
		for (int i = 0; i < data.length; i++)
			System.out.printf(" %s", data[i]);
		System.out.println();
	}

	public int position(Object x) { // position of the first time x appears, -1 if not present
		int i = 0;
		while (i < length()) {
			if (get(i).equals(x))
				return i;
			i++;
		}
		return -1;
	}

	public boolean member(Object x) {
		return position(x) != -1;
	}

	// Setters
	public void set(int i, Object x) {
		data[i] = x;
	}

	public void add(Object x) { // add at the end
		Object[] temp = new Object[data.length + 1];
		for (int i = 0; i < data.length; i++)
			temp[i] = data[i];
		temp[temp.length - 1] = x;
		data = temp;
	}

	public void insert(int i, Object x) { // insert in position i and move the rest to the right
		Object[] temp = new Object[data.length + 1];
		for (int j = 0; j < i; j++)
			temp[j] = data[j];
		temp[i] = x;
		for (int j = i + 1; j < temp.length; j++)
			temp[j] = data[j - 1];
		data = temp;
	}

	public void remove(int i) { // remove the object in position i and move the rest to the left
		Object[] temp = new Object[data.length - 1];
		for (int j = 0; j < i; j++)
			temp[j] = data[j];
		for (int j = i; j < temp.length; j++)
			temp[j] = data[j + 1];
		data = temp;
	}

	// Other methods
	public Object[] vectorNormal() { // returns a Object[] as the integers os vOI
		Object[] temp = new Object[this.length()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}

}
