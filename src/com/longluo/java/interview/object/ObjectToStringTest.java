package com.longluo.java.interview.object;

public class ObjectToStringTest {

	public static void main(String[] args) {
		Dog d = new Dog();

		/**
		 * 如果没有重写toString方法，那么输出来的默认的字符串内容是“类名+哈希编码”,
		 * 如：dog=com.longluo.java.interview.object.Dog@24c98b07
		 * 
		 * 这里的d就是一个引用类型，打印的时候，这个引用类型d会自动调用toString()方法将自己转换成字符串然后再与字符串”d:=”相连，
		 * 然后一起被打印出来。d为什么可以自动调用toString()方法呢，Dog类里面也没有声明这个toString()方法。
		 * 这是因为toString()方法是Object类里面的方法，而所有的类都是从Object类继承下来的，
		 * Dog类当然也不例外，所以Dog类继承了Object类里面的toString()方法，
		 * 
		 * 所以Dog类的对象当然可以直接调用toString()方法了。 但是Dog类对继承下来的toString()方法很不满意，
		 * 因为使用这个继续下来toString()方法将引用对象转换成字符串输出时输出的是一连串令人看不懂的哈希编码。
		 * 为了使打印出来的信息使得正常人都能看得懂，因此要在Dog类里面把这个继承下来的toString()方法重写，
		 * 使得调用这个toString()方法将引用对象转换成字符串时打印出来的是一些正常的，能看得懂的信息。
		 * 在子类重写从父类继承下来的方法时，从父类把要重写的方法的声明直接copy到子类里面来， 这样在子类里面重写的时候就不会出错了。
		 */
		System.out.println("dog=" + d); // 打印结果：dog=I’m a cool Dog
	}
}

class Dog {
	/**
	 * 在这里重写了Object类里面的toString()方法后， 引用对象自动调用时调用的就是重写后的toString()方法了，
	 * 此时打印出来的显示信息就是我们重写toString()方法时要返回的字符串信息了， 不再是那些看不懂的哈希编码了。
	 */
	public String toString() {
		return "I’m a cool Dog";
	}
}
