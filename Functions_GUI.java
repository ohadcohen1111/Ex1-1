package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Functions_GUI implements functions {
	private ArrayList<function> fc = new ArrayList<function>();
	private FileReader FileRead;

	public Functions_GUI() {
		this.fc = new ArrayList<function>();
	}

	public Functions_GUI(Collection<? extends function> c) {
		this.fc.addAll(c);
	}

	/**
	 * Init a new collection of functions from a file
	 * 
	 * @param file - the file name
	 * @throws IOException if the file does not exists of unreadable (wrong format)
	 */
	public void initFromFile(String file) throws IOException {
		ComplexFunction cf = new ComplexFunction();
		String strCurrentLine;
		this.FileRead = new FileReader(file);
		BufferedReader fileread = new BufferedReader(this.FileRead);
		while ((strCurrentLine = fileread.readLine()) != null) {
			function f = cf.initFromString(strCurrentLine);
			this.fc.add(f);
		}
		fileread.close();
	}

	/**
	 * 
	 * @param file - the file name
	 * @throws IOException if the file is not writable
	 */
	public void saveToFile(String file) throws IOException {
		FileWriter filewrite = new FileWriter(file);
		for (int i = 0; i < this.fc.size(); i++) {
			filewrite.write(this.fc.get(i).toString() + "\n");
		}
		filewrite.close();
	}

	/**
	 * Draws all the functions in the collection in a GUI window using the given
	 * parameters for the GUI window and the range & resolution
	 * 
	 * @param width      - the width of the window - in pixels
	 * @param height     - the height of the window - in pixels
	 * @param rx         - the range of the horizontal axis
	 * @param ry         - the range of the vertical axis
	 * @param resolution - the number of samples with in rx: the X_step =
	 *                   rx/resulution
	 */
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {

		// window size
		StdDraw.setCanvasSize(width, height);

		// rescale the coordinate system
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		double x_steps = Math.abs(rx.get_max() - rx.get_min()) / resolution;

		// vertical lines
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = (int) (rx.get_min()); i < rx.get_max(); i++) {
			StdDraw.line(i, ry.get_min(), i, ry.get_max());
		}

		// horizontal lines
		for (int i = (int) (ry.get_min()); i < ry.get_max(); i++) {
			StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		}

		// define pen, font and color
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 12));

		// x axis
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
		for (int i = (int) rx.get_min(); i <= rx.get_max(); i++) {
			StdDraw.text(i ,-0.5, Integer.toString(i));
		}

		// y axis
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());
		for (double i = ry.get_min(); i <= ry.get_max(); i++) {
			StdDraw.text(-0.5, i, Double.toString(i));
		}

		Color[] color = { Color.blue, Color.cyan, Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK };

		// draw the functions
		for (int i = 0; i < this.fc.size(); i++) {
			StdDraw.setPenColor(color[i % 7]); // Selects a different color in each iteration
			for (double j = rx.get_min(); j < rx.get_max(); j += x_steps) {
				StdDraw.line(j, this.fc.get(i).f(j), j + x_steps, this.fc.get(i).f(j + x_steps));
			}
		}

	}

	/**
	 * Draws all the functions in the collection in a GUI window using the given
	 * JSON file
	 * 
	 * @param json_file - the file with all the parameters for the GUI window. Note:
	 *                  is the file id not readable or in wrong format should use
	 *                  default values.
	 */
	public void drawFunctions(String json_file) {

		/*
		 * { "Width":1000, "Height":600, "Resolution":200, "Range_X":[-10,10],
		 * "Range_Y":[-5,15] }
		 */
	}

	@Override
	public boolean contains(Object o) {
		return this.fc.contains(o);
	}

	public int size() {
		return this.fc.size();
	}

	public boolean isEmpty() {
		return this.fc.isEmpty();
	}

	public boolean contains(function o) {
		return this.fc.contains(o);
	}

	public Iterator<function> iterator() {
		return fc.iterator();
	}

	public Object[] toArray() {
		return fc.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return null;
	}

//	default <T> T[] toArray(IntFunction<T[]> generator) {
//		return toArray(generator.apply(0));
//	}

	public boolean add(function e) {
		return this.fc.add(e);
	}

	public boolean remove(Object o) {
		return this.fc.remove(o);
	}

	public boolean containsAll(Collection<?> c) {
		return this.fc.containsAll(c);
	}

	public boolean addAll(Collection<? extends function> c) {
		return this.fc.addAll(c);
	}

	public boolean removeAll(Collection<?> c) {
		return this.fc.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return this.fc.retainAll(c);
	}

	public void clear() {
		this.fc.clear();
	}

	public boolean equals(Object o) {
		return this.fc.equals(o);
	}

	public int hashCode() {
		return this.fc.hashCode();
	}

	public String toString() {
		String ans = "";
		for (int i = 0; i < fc.size(); i++) {
			ans += this.fc.get(i) + "\n";
		}
		return ans;
	}

	/*
	 * default boolean removeIf(Predicate<? super E> filter) {
	 * Objects.requireNonNull(filter); boolean removed = false; final Iterator<E>
	 * each = iterator(); while (each.hasNext()) { if (filter.test(each.next())) {
	 * each.remove(); removed = true; } } return removed; }
	 */

	/*
	 * @Override
	 * 
	 * default Spliterator<E> spliterator() { return Spliterators.spliterator(this,
	 * 0); }
	 * 
	 * 
	 * default Stream<E> stream() { return StreamSupport.stream(spliterator(),
	 * false); }
	 * 
	 * 
	 * 
	 * 
	 * default Stream<E> parallelStream() { return
	 * StreamSupport.stream(spliterator(), true); }
	 */

}
