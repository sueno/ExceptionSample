import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;


public class Main {
	
	public static void m (String[] args) {
		
		try {
			numext2();
		} catch (NumberFormatException ex) {
			System.out.println(ex.getClass());
		}
		
		try {
			extt2();
		} catch (NumberFormatException ex) {
			System.out.println("NE : "+ex.getClass());
		} catch (Exception ex) {
			System.out.println("E : "+ex.getClass());
		}
		
		try {
			tht2();
		} catch (NumberFormatException ex) {
			System.out.println("NE : "+ex.getClass());
		} catch (Exception ex){
			System.out.println("E : "+ex.getClass());
		} catch (Throwable th) {
			System.out.println("E : "+th.getClass());
		}
	}
	
	
	public static int extt1 () throws Exception{
		return ext1();
	}
	public static int extt2 () throws Exception{
		return ext2();
	}
	
	public static int ioext1 () throws IOException{
		throw new IOException();
	}
	public static int numext2 () throws NumberFormatException{
		return Integer.parseInt("hoge---");
	}
	
	public static int ext1 () throws Exception{
		throw new IOException();
	}
	public static int ext2 () throws Exception{
		return Integer.parseInt("hoge---");
	}
	
	public static int tht1 () throws Throwable{
		throw new IOException();
	}
	public static int tht2 () throws Throwable{
		return Integer.parseInt("hoge---");
	}
	
	public static int nnt1 (){
		return nnt2();
	}
	public static int nnt2 (){
		return Integer.parseInt("hoge---");
	}
	

}
