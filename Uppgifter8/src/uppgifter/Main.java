package uppgifter;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    	MyArrayList2<Integer> list = new MyArrayList2<Integer>();

    	for(int i = 0; i < 15; i++ ){
    		list.add(i);
		}
		System.out.println(list.get(2));

	}

	public static int numAlive(Pet[] animal){
		int alive = 0;

		for(Pet currentPet : animal){
			alive += currentPet.isDead() ? 0 : 1;
		}

		return alive;
	}
}

class A {
    public void f(){
        System.out.println("A");
    }
}

class B extends A{
    public void f(){
        System.out.println("B");
    }
}

class Nat {
	private int n;

	public Nat(int n){
		if(n < 0){
			throw new IllegalArgumentException("Thats not a natural number");
		}
		this.n = n;
	}

	public Nat add(int n){
		return new Nat(this.n + n);
	}

	public int toInt(){
		return n;
	}

}

abstract class Pet {
	protected String name;
	protected int age;
	protected boolean dead;


	public Pet(String name, int age, boolean dead) {
		this.name = name;
		this.age = age;
		this.dead = dead;
	}

	public abstract void inflictWound();
	public abstract boolean isDead();

}

class Mouse extends Pet {

	public Mouse(String name, int age, boolean dead) {
		super(name, age, dead);
	}

	@Override
	public void inflictWound() {
		this.dead = this.dead || Math.random() > 0.4999;		//Without the or-statement, the mouse can be brought
																//back to life using this method
	}

	@Override
	public boolean isDead() {
		return dead;
	}


}

class MyArrayList1 {

	private Object e;
	private MyArrayList1 nextInstance;

	public MyArrayList1(){
		this.e = null;
		nextInstance = null;
	}

	public MyArrayList1(Object e){
		this.e = e;
		nextInstance = null;
	}

	public void add(Object e){
		if(nextInstance == null){
			nextInstance = new MyArrayList1(e);
		}
		else {
			nextInstance.add(e);
		}
	}

	public Object get(int i){

		if(nextInstance == null){
			throw new IndexOutOfBoundsException();
		}
		else if(i == 0){
			return this.e;
		}
		else {
			try {
				return nextInstance.get(i - 1);
			} catch (IndexOutOfBoundsException e) {
				throw new IndexOutOfBoundsException();
			}
		}

	}
}

class MyArrayList2<E>{

	private ArrayList<Object> listaAvGrejs = new ArrayList<Object>();


	private Object[] array;
	private int size;

	public MyArrayList2(){


		array = new Object[10];
		size = 0;
	}

	public void add(E object){

		if(size + 1 < array.length){
			size ++;

			if(size == 10){
				System.out.println("Ompa");
			}

			array[size] = object;
		}
		else{
			Object[] temp = array;
			array = new Object[(int)(array.length * 1.5)];
			System.arraycopy(temp, 0, array, 0, temp.length);

			this.add(object);

		}
	}

	public E get(int pos){

		if(pos > size){
			throw new IndexOutOfBoundsException();
		}

		@SuppressWarnings("unchecked")
		final E e = (E)array[pos];
		return e;
	}

	public void set(int i, E object){
		if(i > size){
			throw new IndexOutOfBoundsException();
		}
		array[i] = object;
	}
}