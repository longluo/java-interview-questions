package com.longluo.java.interview.Search;

public class BinarySearch {
	public static final int NOT_FOUND = -1;

	public static void main(String args[]) {
		binarySearchTest();
	}

	/**
	 * Performs the standard binary search using two comparisons per level.
	 * 
	 * 这是定义了一个公共的（public）静态的（static ）泛型方法 其中<AnyType extends Comparable<? super
	 * AnyType>>是泛型的类型，定义类型只能是Comparable或Comparable的子类，并且Comparable也是一个泛型类他的
	 * 类型只能是AnyType或是AayType的超类也就是AnyType父类 int 是方法的返回类型 (AnyType[] a,AnyType
	 * x)参数列表，第一个是传递进来的数组第二个是一个值，也就是查找该值在数组中的下标，他们的类型都是该泛型方发传进来的类型
	 * 
	 * @return index where item is found, or NOT_FOUND.
	 */
	public static <AnyType extends Comparable<? super AnyType>> int binarySearch(
			AnyType[] arr, AnyType target) {
		int begin = 0;
		int end = 0;
		int midIndex = 0;

		end = arr.length - 1;
		while (begin <= end) {
			midIndex = (begin + end) / 2;

			if (arr[midIndex].compareTo(target) < 0) {
				begin = midIndex + 1;
			} else if (arr[midIndex].compareTo(target) > 0) {
				end = midIndex - 1;
			} else {
				return midIndex;
			}
		}

		return NOT_FOUND;
	}

	private static void binarySearchTest() {
		int SIZE = 8;
		Integer[] a = new Integer[SIZE];
		for (int i = 0; i < SIZE; i++) {
			a[i] = i * 2;
		}
		
		for (int i = 0; i < SIZE; i++) {
			System.out.print(" " + a[i]);
		}

		for (int i = 0; i < SIZE * 2; i++) {
			System.out.println("Found " + i + " at " + binarySearch(a, i));
		}
	}
}

