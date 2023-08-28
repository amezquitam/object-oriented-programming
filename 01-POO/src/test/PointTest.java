package test;

import geometry.Point;

public class PointTest {

    public static void printPoint(Point point, String pointName) {
        // imprime un vector con este estilo: 'Nombre { x: XX, y: YY }'
        System.out.println(pointName + " { x: " + point.getX() + ", y: " + point.getY() + " }");
    }

    public static void main(String[] args) {
        // crea un punto usando el constructor que recibe 
        // cada componente del punto
        Point point1 = new Point(1, 3);
        // imprime punto1
        printPoint(point1, "point1");
        // crea punto dos usando el constructor sin argumentos (el origen)
        Point point2 = new Point();
        // imprime punto 2
        printPoint(point2, "point2");
        // crea el punto3 a partir del punto1, esto implica copiar sus 
        // propiedades o estado
        Point point3 = new Point(point1);
        // imprime el estado de punto3
        printPoint(point3, "point3");
        // crea el punto4 a partir del punto2
        Point point4 = new Point(point2);
        // imprime el estado del punto4
        printPoint(point4, "point4");
        // modifica el estado de punto2, estableciéndose en la coordenada (8, 4)
        point2.setX(8);
        point2.setY(4);
        // imprime el nuevo estado del punto2
        printPoint(point2, "point2");
    }
}
