package tc.lv.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarClassLoader extends ClassLoader {
	private String jarFile;
	static Hashtable classes = new Hashtable();
	private byte classByte[];
	private Class result;

	public JarClassLoader() {
		super(JarClassLoader.class.getClassLoader());
	}

	public Class findClassByName(String className, String path) {
		jarFile = path;
		result = (Class) classes.get(className);
		if (result != null) {
			return result;
		}

		try {
			System.out.println("Creating jar");
			JarFile jar = new JarFile(jarFile);
			System.out.println("Finish jar");
			System.out.println("Creating entry");
			JarEntry entry = jar.getJarEntry(className + ".class");
			System.out.println(entry.getName());
			System.out.println("Creating inputStream");
			InputStream is = jar.getInputStream(entry);
			System.out.println("Finish Creating inputStream");
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			int nextValue = is.read();
			while (-1 != nextValue) {
				byteStream.write(nextValue);
				nextValue = is.read();
			}
			classByte = byteStream.toByteArray();
			System.out.println("defining class");
			result = defineClass(null, classByte, 0, classByte.length, null);
			System.out.println("finish defining class");
			classes.put(className, result);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

}
