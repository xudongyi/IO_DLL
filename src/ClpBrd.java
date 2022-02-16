import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;


public interface ClpBrd extends Library {
	ClpBrd INSTANCE = (ClpBrd) Native.loadLibrary("user32" ,ClpBrd.class);
	public int GetClipboardData(int wFormat);
	public int SetClipboardData(int wFormat, long hMem);
	public int OpenClipboard(int hwnd);
	public int EmptyClipboard();
	public int CloseClipboard();
	boolean IsClipboardFormatAvailable(int format);
}
