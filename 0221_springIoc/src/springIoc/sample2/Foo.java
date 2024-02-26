package springIoc.sample2;

public class Foo {
	
	public Foo() {
		System.out.println("Foo의 기본 생성자");
	}
	
	public Foo(String str) {
		System.out.println("Foo의 오버로딩 생성자 호출" + str);
	}
	
	public Foo(String str, int num) {
		System.out.println("Foo의 오버로딩 생성자 호출" + str + ", " + num);
	}
	
	public Foo(Bar bar) {
		System.out.println("Foo의 생성자 호출 - " + bar);
	}
}
