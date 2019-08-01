import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int points = 0;
        for (Point currPt : s.getPoints()) {
            points++;
        }
        return points;
    }

    public double getAverageLength(Shape s) {
        double perimeter = getPerimeter(s);
        int points = getNumPoints(s);
        double avgLength = perimeter/points;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist > largestSide){
                largestSide = currDist;
            }
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currX = Math.abs(prevPt.getX() - currPt.getX());
            if(currX > largestX){
                largestX = currX;
            }
            prevPt = currPt;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles(DirectoryResource dr) {
        double largestPerimeter = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(perimeter > largestPerimeter){
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter(DirectoryResource dr) {
        String fileName = "No file.";
        double largestPerimeter = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if(perimeter > largestPerimeter){
                largestPerimeter = perimeter;
                fileName = f.getName();
            }
        }
        return fileName;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points = getNumPoints(s);
        System.out.println("points = " + points);
        double avgLength = getAverageLength(s);
        System.out.println("average length = " + avgLength);
        double largestSide = getLargestSide(s);
        System.out.println("largest side = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter=getLargestPerimeterMultipleFiles(dr);
        System.out.println("largest perimeter: " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        String fileName=getFileWithLargestPerimeter(dr);
        System.out.println("largest perimeter file: " + fileName);
    }

   

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
