import java.util.Scanner;

abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public abstract double getArea();


    public abstract void draw(char character);

    @Override
    public String toString() {
        return "Color: " + color;
    }
}

class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(String color, int length, int width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public void draw(char character) {
        System.out.println("Drawing Rectangle with character '" + character + "':");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Rectangle [Color: " + color + ", Length: " + length + ", Width: " + width + "]";
    }
}

class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle(String color, int base, int height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw(char character) {
        System.out.println("Drawing Triangle with character '" + character + "':");
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Triangle [Color: " + color + ", Base: " + base + ", Height: " + height + "]";
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rectangle rectangle = new Rectangle("Red", 5, 10);
        Triangle triangle = new Triangle("Blue", 8, 6);

        System.out.println(rectangle);
        System.out.println("Area: " + rectangle.getArea());
        System.out.print("Enter a character to draw the rectangle: ");
        char rectChar = scanner.next().charAt(0);
        rectangle.draw(rectChar);
        System.out.println();

        System.out.println(triangle);
        System.out.println("Area: " + triangle.getArea());
        System.out.print("Enter a character to draw the triangle: ");
        char triChar = scanner.next().charAt(0);
        triangle.draw(triChar);

        scanner.close();
    }
}

