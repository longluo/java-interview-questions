package com.longluo.java.interview.generics;

import java.io.Serializable;

/**
 * 此类是用来演示如何定义和使用泛型方法的
 * 
 */
public class GenericMethod {

	public static void main(String[] args) {
		add(3, 5);
		Number x1 = add(3.5, 5);// Integer类型和Double类型的交集就是Number类，Number类是这两个类的父类，所以可以定义Number类型的变量来接收返回值
		Object x2 = add(3, "abc");// Integer类型和String类型的交集就是Object类，因为Object类是所有类的父类，所以可以定义Object类型的变量来接收返回值
		/**
		 * swap(new String[]{"abc","123","xdp"},1,2);的执行结果如下： abc 123 xdp abc
		 * xdp 123 从结果来看，索引为1的元素和索引为2的元素的确是交换了位置
		 */
		swap(new String[] { "abc", "123", "xdp" }, 1, 2);// 调用自定义泛型方法，传入的实际参数必须是引用类型的数组
		// swap(new
		// int[]{1,2,3,4,5},1,3);//只有引用类型才能作为泛型方法的实际参数，这里的int[]数组是属于基本类型，不能作为泛型方法的参数，所以这样会报错
		printArray(new Integer[] { 1, 2, 3 });// 可以传入Integer类型的数组，因为Integer类型的数组是属于引用类型的
		// printArray(new int[]{10,2,5});不能传入非引用类型的数组作为泛型方法的实际参数
	}

	/**
	 * 泛型方法的定义语法： 这里定义的就是一个泛型方法 方法的返回值类型是T，即任意的类型 返回值的具体类型由传入的类型参数来定
	 * 
	 * @param <T>
	 *            代表任意的类型
	 * @param x
	 * @param y
	 * @return
	 */
	private static <T> T add(T x, T y) {
		return null;
	}

	/**
	 * 定义一个泛型方法来交换数组中指定索引位置的两个元素 这里传入的数组可以是任意类型的数组
	 * 传入泛型方法的实际参数类型必须是引用类型的数组，不能是基本类型的数组
	 * 
	 * @param <T>
	 * @param a
	 * @param i
	 * @param j
	 */
	private static <T> void swap(T[] a, int i, int j) {
		// 数组中元素位置未交换前的打印结果
		printArray(a);
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		System.out.println();
		// 数组中元素位置交换后的打印结果
		printArray(a);
	}

	/**
	 * 定义打印任意引用数组类型的方法
	 * 
	 * @param <T>
	 * @param array
	 */
	private static <T> void printArray(T[] array) {
		for (T t : array) {
			System.out.print(t + "\t");
		}
	}

	/**
	 * 定义有extends限定符，并且具有多个上边界的泛型方法，各个边界使用&符号分隔
	 * 
	 * @param <T>
	 */
	public <T extends Serializable & Cloneable> void method() {
		
	}
}
