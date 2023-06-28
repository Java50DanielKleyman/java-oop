package telran.shapes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Canvas implements Shape, Iterable<Shape> {
	private Shape[] shapes = new Shape[0];
	private Shape[] removedShapes = new Shape[0];
	Predicate<Shape> predicate = shape -> true;

	public void setPredicate(Predicate<Shape> predicate) {
		this.predicate = predicate;
	}

	private class CanvasIterator implements Iterator<Shape> {
		int current = containsInRemoved(shapes[0]) ? getCurrent(0) : 0;
		boolean flNext = false;
		int previous = 0;// initial value does not matter

		@Override
		public boolean hasNext() {
			return current < shapes.length;
		}

		@Override
		public Shape next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			int res = current;
			previous = current;
			current = getCurrent(current);
			flNext = true;
			return shapes[res];
		}

		@Override
		public void remove() {
			if (!flNext) {
				throw new IllegalStateException();
			}
			flNext = false;
			addRemoved(shapes[previous]);
		}

	}

	private void addRemoved(Shape shape) {
		removedShapes = Arrays.copyOf(removedShapes, removedShapes.length + 1);
		removedShapes[removedShapes.length - 1] = shape;

	}

	private int getCurrent(int current) {
		current++;
		while (current < shapes.length && !predicate.test(shapes[current])) {
			current++;
		}
		return current;
	}

	private boolean containsInRemoved(Shape shape) {
		boolean res = false;
		int index = 0;
		while (index < removedShapes.length && !res) {
			if (removedShapes[index].equals(shape)) {
				res = true;
			}
			index++;
		}
		return res;
	}

	@Override
	public int perimeter() {
		int sum = 0;
		for (Shape shape : this) {
			sum += shape.perimeter();
		}
		return sum;
	}

	@Override
	public int square() {
		int sum = 0;
		for (Shape shape : this) {
			sum += shape.square();
		}
		return sum;
	}

	@Override
	public Iterator<Shape> iterator() {

		return new CanvasIterator();
	}

	public void addShape(Shape shape) {
		Shape[] newShapes = Arrays.copyOf(shapes, shapes.length + 1);
		newShapes[newShapes.length - 1] = shape;
		shapes = newShapes;
	}

	public boolean removeIf(Predicate<Shape> predicate) {
		int oldLength = shapes.length;
		Iterator<Shape> it = iterator();
		while (it.hasNext()) {
			Shape shape = it.next();
			if (predicate.test(shape)) {
				it.remove();
			}
		}
		return oldLength > shapes.length;
	}

	public boolean removeNestedCanvases() {
		return removeIf(shape -> shape instanceof Canvas);
	}

}