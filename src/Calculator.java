public class Calculator {
    static double drawX, drawY;
    public static double calculatePositionX(double[] viewFrom, double[] viewTo, double x, double y, double z){


        return drawX;

    }

    public static double calculatePositionY(double[] viewFrom, double[] viewTo, double x, double y, double z){

        set(viewFrom,viewTo);
        return drawY;

    }

    static void set(double[] viewFrom,double[] viewTo, double x, double y, double z){
        Vector viewVector = new Vector(viewTo[0]- viewFrom[0], viewTo[1]- viewFrom[1], viewTo[2]- viewFrom[2]);
        Vector directionVector = new Vector(1, 1, 1);
        Vector PlaneVector1 = viewVector.crossProduct(directionVector);
        Vector PlaneVector2 = viewVector.crossProduct(PlaneVector1);

        Vector viewToPoint = new Vector(x-viewFrom[0], y-viewFrom[1], z-viewFrom[1]);

        double t = (viewVector.x*viewTo[0]+ viewVector.y*viewTo[1] + viewVector.z*viewTo[2]) 
                - (viewVector.x*viewFrom[0]+ viewVector.y*viewFrom[1] + viewVector.z*viewFrom[2])
                / (viewVector.x*viewToPoint.x+ viewVector.y*viewToPoint.y + viewVector.z*viewToPoint.z);

    }   
    
}
