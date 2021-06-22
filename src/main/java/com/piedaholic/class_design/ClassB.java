package com.piedaholic.class_design;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassB {

    // public static Map<String, Integer> entityCountMap = new HashMap<>(20);
    // public static Map<String, Integer> entityCountMap = Collections.synchronizedMap(new HashMap<>(20));
    public static Map<String, Integer> entityCountMap = new ConcurrentHashMap<>();
    static {
        System.out.println("Hi");
    }

    public static Object init(String className, Class<?>[] parameterTypes, Object[] parameterVals) {
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor(parameterTypes);
            return constructor.newInstance(parameterVals);
        } catch (ClassNotFoundException cfe) {
        } catch (NoSuchMethodException nsme) {
        } catch (InstantiationException ie) {
        } catch (IllegalAccessException iae) {
        } catch (IllegalArgumentException iArgE) {
        } catch (InvocationTargetException ite) {
        }
        return null;

    }

    // No Arg Constructor
    public synchronized static Object init(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            if (entityCountMap.containsKey(className))
            {
                entityCountMap.put(className, entityCountMap.get(className) + 1);
                // System.out.println(Thread.currentThread() + "Incremented");
            }
            else
                entityCountMap.put(className, 1);
            return constructor.newInstance();
        } catch (ClassNotFoundException cfe) {
        } catch (NoSuchMethodException nsme) {
        } catch (InstantiationException ie) {
        } catch (IllegalAccessException iae) {
        } catch (IllegalArgumentException iArgE) {
        } catch (InvocationTargetException ite) {
        }
        return null;

    }

    // Instantiates object with primitive or wrapper datatype arguments in
    // constructor
    static Object instantiate(List<String> args, String className) throws Exception {
        // Load the class.
        Class<?> clazz = Class.forName(className);

        // Search for an "appropriate" constructor.
        for (Constructor<?> ctor : clazz.getConstructors()) {
            Class<?>[] paramTypes = ctor.getParameterTypes();

            // If the arity matches, let's use it.
            if (args.size() == paramTypes.length) {

                // Convert the String arguments into the parameters' types.
                Object[] convertedArgs = new Object[args.size()];
                for (int i = 0; i < convertedArgs.length; i++) {
                    convertedArgs[i] = convert(paramTypes[i], args.get(i));
                }

                // Instantiate the object with the converted arguments.
                return ctor.newInstance(convertedArgs);
            }
        }
        throw new IllegalArgumentException("Don't know how to instantiate " + className);
    }

    static Object convert(Class<?> target, String s) {
        if (target == Object.class || target == String.class || s == null) {
            return s;
        }
        if (target == Character.class || target == char.class) {
            return s.charAt(0);
        }
        if (target == Byte.class || target == byte.class) {
            return Byte.parseByte(s);
        }
        if (target == Short.class || target == short.class) {
            return Short.parseShort(s);
        }
        if (target == Integer.class || target == int.class) {
            return Integer.parseInt(s);
        }
        if (target == Long.class || target == long.class) {
            return Long.parseLong(s);
        }
        if (target == Float.class || target == float.class) {
            return Float.parseFloat(s);
        }
        if (target == Double.class || target == double.class) {
            return Double.parseDouble(s);
        }
        if (target == Boolean.class || target == boolean.class) {
            return Boolean.parseBoolean(s);
        }
        throw new IllegalArgumentException("Don't know how to convert to " + target);
    }

}