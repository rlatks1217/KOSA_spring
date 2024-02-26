package springIoc.sample6;

import java.io.FileWriter;

public class FileOutput implements Output{

	private String filePath;
	
	public FileOutput() {
		System.out.println("FileOutput의 Default 생성자 호출");//확인용
	}
	
	public FileOutput(String filePath) {
		this.filePath = filePath;
		System.out.println("FileOutput 오버로딩 생성자 호출! - " + filePath);
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("FileOutput setter 호출! - " + filePath);
	}

	@Override
	public void print(String message) throws Exception {
		FileWriter out = new FileWriter(filePath);
		//해당 경로의 파일을 찾음 없으면 새로 만듬
		
		out.write(message);//버퍼에 담아주는 메소드
		out.flush();//버퍼에 남은 데이터를 다 내보냄
		out.close();//버퍼에 남은 데이터가 있으면 다 내보내고 스트림을 닫는다.
		
		System.out.println("print 수행 완료");
	}

}
