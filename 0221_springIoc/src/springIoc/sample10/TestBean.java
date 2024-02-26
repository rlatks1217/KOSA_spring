package springIoc.sample10;

public class TestBean {
	
	private DataBean data1;
	private DataBean data2;
	

	public TestBean() {
		System.out.println("TestBean Default 생성자 호출!");
	}
	
	public TestBean(DataBean data1, DataBean data3) {
		//byType으로 주입되기 때문에 매개변수의 이름과 필드명은 어떻게 지어도 상관없음
		this.data1 = data1;
		this.data2 = data3;
		System.out.println("TestBean 오버로딩 생성자 호출!");
	}

	public DataBean getData1() {
		return data1;
	}

	public void setData1(DataBean data1) {
		this.data1 = data1;
	}


	public DataBean getData2() {
		return data2;
	}


	public void setData2(DataBean data2) {
		this.data2 = data2;
	}
	
	

}
