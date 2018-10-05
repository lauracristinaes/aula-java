package TesteReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class recuperarCliente {
	
	public static void main(String[] args) {
		
        Cliente cliente = new Cliente();
        Class<Cliente> clazz = (Class<Cliente>) cliente.getClass();
        
        for(Field f : clazz.getDeclaredFields()){
               System.out.println(f.getName());
        }
        
        for(Method m : clazz.getDeclaredMethods()){
            System.out.println(m.getName());
     }
        
        
        Cliente cliente1 = (Cliente) createNewInstance(Cliente.class);
        
        if (cliente1 == null) {
               System.err.println("Ops, não foi possível criar o objeto cliente");
        } else {
               System.out.println("Objeto cliente criado = " + cliente1.toString());
        }

  }
	
	private static Object createNewInstance(Class clazz) {
        Constructor<?> ctor;
        try {
               ctor = clazz.getConstructors()[0];
               Object object = ctor.newInstance();
               return object;
        } catch (SecurityException
                      | InstantiationException | IllegalAccessException
                      | IllegalArgumentException | InvocationTargetException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
         
        return null;
  }

}


