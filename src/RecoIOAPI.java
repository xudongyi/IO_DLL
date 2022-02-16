import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;


public interface RecoIOAPI extends Library {
	RecoIOAPI INSTANCE = (RecoIOAPI) Native.loadLibrary("recoio" ,RecoIOAPI.class);
	
	public int IO_Init(String Company,String LicenseKey);
	public int IO_LoadTIFImage(int SessionHandle,String FileName, int ImageIndex);
	public int IO_LoadBMPImage(int SessionHandle, String FileName);
	public int IO_LoadJPGImage(int SessionHandle,String FileName);
	public int IO_LoadPDFImage(int SessionHandle, String FileName, int ImageIndex, int DPIRendering);
	public void IO_Done(int SessionHandle);
	public int IO_GetScaleToGrayImage(int SessionHandle,int DIBHandle,int ZoomFactor);
	public void IO_GetImageInfo(int SessionHandle,int DIBHandle, int[] Width, int[] Height, int[] XRes, int[] YRes, int[] Bits);
	public void IO_FreeImage(int SessionHandle,long DIBHandle);
	public void IO_ShowImage(int SessionHandle,int DIBHandle,int DC, int X,int Y);
	public void IO_ShowStretchedImage(int SessionHandle,int DIBHandle,int DC,int X,int Y,int W,int H);
	public int IO_GetSubImage(int SessionHandle,int DIBHandle,int Left,int Top,int Right,int Bottom);
	public int IO_Duplicate(int SessionHandle,int DIBHandle);
	public int IO_Rotate(int SessionHandle,int DIBHandle,int Angle);
	public int IO_Flip(int SessionHandle,int DIBHandle);
	public int IO_Mirror(int SessionHandle,int DIBHandle);
	public int IO_Invert(int SessionHandle,int DIBHandle);
	public void IO_SaveBMPImage(int SessionHandle,int DIBHandle,String FileName);
	public int IO_CountTIFImages(int SessionHandle,String FileName);
	public int IO_CountPDFImages(int SessionHandle,String FileName);
	public void IO_SaveTIFImage(int SessionHandle,int DIBHandle,String FileName, int Compression);
	public void IO_SavePDFImage(int SessionHandle,long DIBHandle,String FileName, int Quality);
	public void IO_SaveJPGImage(int SessionHandle,int DIBHandle,String FileName, int Quality);
	public void IO_SelectScanner(int SessionHandle,int WinHandle);
	public void IO_SetScannerCallback(int SessionHandle,Pointer Callback);
	public int IO_ScanImage(int SessionHandle,int WinHandle);
	public int IO_ScanImageWithParameters(int SessionHandle,int BitsPerPixel,int Resolution,int Contrast,int Brightness, double Width,double Height, int ADF,int Duplex);
	public void IO_ExportDDB(int SessionHandle,int DIBHandle,int[] Bitmap, int[] Palette);
	public int IO_ImportDDB(int SessionHandle,int DIBHandle, int Bitmap, int Palette);
	public int IO_AcquireDC(int SessionHandle,int DIBHandle);
	public void IO_ReleaseDC(int SessionHandle,int DIBHandle);
	public int IO_ScanImageAsync(int SessionHandle,int THandle);
	public int IO_ScanImageAsyncWithParameters(int SessionHandle,int BitsPerPixel,int Resolution,int Contrast,int Brightness, double Width,double Height, int ADF, int Duplex);
	public int IO_GetNextAsyncScannedImage(int SessionHandle);
	public int IO_LoadTIFImageFromBuffer(int SessionHandle, Pointer Buffer, int BufferSize, int ImageIndex);
	public int IO_LoadBMPImageFromBuffer(int SessionHandle, Pointer Buffer, int BufferSize);
	public int IO_LoadJPGImageFromBuffer(int SessionHandle, Pointer Buffer,int BufferSize);
	public int IO_LoadPDFImageFromBuffer(int SessionHandle,Pointer Buffer, int BufferSize,int ImageIndex,int DPIRendering);
	public int IO_CountTIFImagesFromBuffer(int SessionHandle, Pointer Buffer, int BufferSize);
	public int IO_GetPixel(int SessionHandle, int DIBHandle, int X, int Y);
	public void IO_SetPixel(int SessionHandle, int DIBHandle,int X,int Y,int C);
	public int IO_DebugBuffer(int SessionHandle, Pointer Buffer, int BufferSize);
	public void IO_SetParameter(int SessionHandle, int ParameterIndex, int ParameterValue);
	public int IO_ScanImageTSPFile(int SessionHandle, String TSPFile);
	public int IO_ScanImageTSPRaw(int SessionHandle, String TSPRaw);
	public int IO_ScanImageAsyncTSPFile(int SessionHandle, String TSPFile);
	public int IO_ScanImageAsyncTSPRaw(int SessionHandle, String TSPRow);
	public void IO_MakeSearchablePDF(int SessionHandle, String TifFileIn,String XMLFileIn,String PDFFileOut,String PDFInfo);
	public int IO_GetScannerStatus(int SessionHandle);
	public int IO_GetScannerName(int SessionHandle, String ScannerName);
	
	
}
