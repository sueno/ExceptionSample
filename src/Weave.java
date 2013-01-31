import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;


public class Weave {

	public static void main (String[] args) {
		define("m");
		Main.m(null);
	}
	
	public static void define (String methodName) {
		ClassPool cp = ClassPool.getDefault();
		
		try {
			CtClass target = cp.get("Main");
			target.removeMethod(target.getDeclaredMethod(methodName));
//			target.addMethod(CtMethod.make("public static void "+methodName+" (String[] a) {try {tht2();} catch (NumberFormatException ex) {System.out.println(\"NE : \"+ex.getClass());} catch (Exception ex){System.out.println(\"E : \"+ex.getClass());}}", target));
			target.addMethod(CtMethod.make("public static void "+methodName+" (String[] a) {tht2();}", target));
			target.toClass(Thread.currentThread().getContextClassLoader());
			
			for (Method m : Main.class.getDeclaredMethods()){
				System.out.println(m.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
