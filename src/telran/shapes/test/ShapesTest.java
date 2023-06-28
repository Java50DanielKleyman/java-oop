package telran.shapes.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.shapes.Canvas;
import telran.shapes.Rectangle;
import telran.shapes.Shape;
import telran.shapes.Square;

class ShapesTest {
    Rectangle rectangle;
    Square square;
    Canvas canvas;
    Canvas newCanvas;

    @BeforeEach
    void setUp() {
        rectangle = new Rectangle(2, 3);
        square = new Square(2);
        canvas = new Canvas();
        newCanvas = new Canvas();
        newCanvas.addShape(rectangle);
        newCanvas.addShape(square);
        newCanvas.addShape(canvas);
    }

    @Test
    void addShapeTest() {        
        Shape[] expected = {rectangle, square, canvas};
        assertArrayEquals(expected, newCanvas.getShapes());
    }
    @Test
    void removiIfTest() {
        newCanvas.removeNestedCanvases();
        Shape[] expected = {canvas};
        assertArrayEquals(expected, newCanvas.getRemovedShapes());
    }
    @Test
	void iteratorTest() {
    	int index = 0;
    	Iterator<Shape> it = newCanvas.iterator();
    	while(it.hasNext()) {
    		assertEquals(newCanvas.getShapes()[index], it.next());
    		index++;
    	}
    	assertThrowsExactly(NoSuchElementException.class, () -> it.next());
    	assertFalse(it.hasNext());
    }
    @Test
    void removeTest() {
    	Iterator<Shape> it = newCanvas.iterator();
    	for(int i= 0; i < newCanvas.getShapes().length; i++) {
    		it.next();
    		it.remove();
    	}
    	 Shape[] expected = {rectangle, square, canvas};
         assertArrayEquals(expected, newCanvas.getRemovedShapes());
    }
}