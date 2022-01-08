/**
 * This module is about different implementations of Singleton Design Pattern
 * <p>
 * The Singleton Design Pattern aims to keep a check on initialization of
 * objects of a particular class by ensuring that only one instance of the
 * object exists throughout the Java Virtual Machine.
 * </p>
 * <p>
 * A Singleton class also provides one unique global access point to the object
 * so that each subsequent call to the access point returns only that particular
 * object.
 * </p>
 * <p>
 * Also, note that the constructor has the private access modifier. This is a
 * requirement for creating a Singleton since a public constructor would mean
 * anyone could access it and start creating new instances.
 * </p>
 * <p>
 * When to Use Singleton Design Pattern
 * 
 * <li>For resources that are expensive to create (like database connection
 * objects)</li>
 * <li>It's good practice to keep all loggers as Singletons which increases
 * performance</li>
 * <li>Classes which provide access to configuration settings for the
 * application</li>
 * <li>Classes that contain resources that are accessed in shared mode</li>
 * <p>
 * 
 * @author HPSINGH
 *
 * 
 */
package com.piedaholic.design_patterns.singleton;