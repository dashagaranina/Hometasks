import java.lang.*;
import java.lang.reflect.*;


public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException   {
        Task10 task10 = new Task10(); 
		Class c = task10.getClass(); 
		//Имя класса
		String s = c.getName(); 
		System.out.println("Class name "+ s);
		
		//Вывожу все методы, передаваемые им типы и возвращаемые типы данных
		Method[] methods = c.getMethods(); 
		for (Method method : methods) { 
			System.out.println("Name: " + method.getName()); 
			System.out.println("Return type: " + method.getReturnType().getName()); 
 
			Class[] paramTypes = method.getParameterTypes(); 
			System.out.print("Types: "); 
			for (Class paramType : paramTypes) { 
				System.out.print(" " + paramType.getName()); 
			} 
			System.out.println(""); 
		}

		//добавляю номер таска
		Class[] paramTypes = new Class[] {int.class}; 
		Method method1 = c.getMethod("setTaskNumber", paramTypes); 
		method1.invoke(task10, 10);
		//вызываю метод done
		Method method2 = c.getMethod("done"); 
		method2.invoke(task10);

		
    }
}