interface Viewable3 {
	@Deprecated
	public void showIt(String str);
	
	public void brShowIt(String str);
}
class Viewer3 implements Viewable3 {
	
	@Override
	@SuppressWarnings("Deprecation")
	public void showIt(String str) {
		System.out.println(str);
	}
	

	@Override
	public void brShowIt(String str) {
		System.out.println('[' + str + ']');
	}
}
public class D3_AtSuppressWarnings {
	@SuppressWarnings("Deprecation")				//deprecation 관련 경고 메세지 생략
	public static void main(String[] args) {
		Viewable3 view = new Viewer3();
		view.showIt("Hello Annotations");
		view.brShowIt("Hello Annotations");
	}

}
