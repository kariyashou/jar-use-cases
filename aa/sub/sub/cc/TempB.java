package sub.cc;
import sub.ee.TempException;
public class TempB{
	public TempB() throws TempException{
		throw new TempException("error");
	}
}