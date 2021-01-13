package main.dd;
import sub.bb.TempA;
import sub.ee.TempException;
public class TempC{
	public static void main(String[]args){
		try{
			TempA a = new TempA();
		}catch(TempException e){
			System.out.println(e);
		}
	}
}