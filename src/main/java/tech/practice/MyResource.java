package tech.practice;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    private static final double PI = 3.14;
    
    
    @GET
    @Path("circlearea")
    @Produces(MediaType.TEXT_PLAIN)
    public double calculateArea(@QueryParam("radius") double radius) {
    	return PI*radius*radius;
    }
    
    
    @GET
    @Path("/car/start")
    @Produces(MediaType.TEXT_PLAIN)
    public Response startCar(@QueryParam("model") String model, @QueryParam("year") int year) {
        VehicleDrive car = new VehicleDrive(model, year);
        car.start();
        String message = "Started car: " + car.getModel() + " (" + car.getYear() + ")";
        return Response.ok(message).build();
    }

    @GET
    @Path("/car/drive")
    @Produces(MediaType.TEXT_PLAIN)
    public Response driveCar(@QueryParam("model") String model, @QueryParam("year") int year) {
        VehicleDrive car = new VehicleDrive(model, year);
        car.drive();
        String message = "Driving car: " + car.getModel() + " (" + car.getYear() + ")";
        return Response.ok(message).build();
    }
    
    @GET
    @Path("/season")
    @Produces(MediaType.TEXT_PLAIN)
    public Response callSeason(@QueryParam("season")String seasonName) {
    	Seasons seasons;
    	
    	try {
            seasons = Seasons.valueOf(seasonName.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("Invalid season name. Please use WINTER, SPRING, SUMMER, or FALL.")
                           .build();
        }
    	
    	String message;
    	
    	switch(seasons) {
    	case WINTER:
    		message = "Winter has an average temp of: " + seasons.getAverageTemprature() +" Celsius" ;
    		break;
    	case SUMMER:
    		message = "Summer has tempreature of " + seasons.getAverageTemprature() +" Celsius";
    		break;
    	case SPRING:
    		message = "Spring has tempreature of " + seasons.getAverageTemprature() +" Celsius";
    		break;
    	case MONSOON:
    		message = "Monsson has tempreature of " + seasons.getAverageTemprature() +" Celsius";
    		break;
    	default:
    		message ="Unknown season";
    	}
    	
    	return Response.ok(message).build();
    	
    }
    
    @GET
    @Path("typeCheck")
    @Produces(MediaType.TEXT_PLAIN)
    public Response checkType(@QueryParam("value") String value) {
    	 Object inputToTypeCheck;
         try {
             if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
            	 inputToTypeCheck = Boolean.parseBoolean(value);
             } else if (value.contains(".")) {
            	 inputToTypeCheck = Double.parseDouble(value);
             } else {
            	 inputToTypeCheck = Integer.parseInt(value);
             }
         } catch (NumberFormatException e) {
        	 inputToTypeCheck = value;
         }
         
         String type = TypeChecker.checkTpye(inputToTypeCheck);
         String message = "The type of the provided value is: " + type;
         return Response.ok(message).build();
         
    }
    
    
    @GET
    @Path("emailvalidate")
    @Produces(MediaType.TEXT_PLAIN)
    public Response validateEmail(@QueryParam("email") String email) {
        try {
            UtilityEmailValidation.validate(email);
            return Response.ok("Valid email format").build();
        } catch (CustomEmailValidation e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
    
    
    @GET
    @Path("dayofweek")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getDayOfWeek(@QueryParam("date") String date) {
        try {
            String dayOfWeek = DateTimeUtils.getDayOfWeek(date);
            return Response.ok("The day of the week for " + date + " is " + dayOfWeek).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date format. Please use YYYY-MM-DD").build();
        }
    }

    @GET
    @Path("currenttime")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCurrentTime(@QueryParam("timezone") String timeZone) {
        try {
            String currentTime = DateTimeUtils.getCurrentTime(timeZone);
            return Response.ok("The current time in " + timeZone + " is " + currentTime).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid timezone format. Please use a valid timezone ID").build();
        }
    }

    @GET
    @Path("datetimecomponents")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getDateTimeComponents(@QueryParam("datetime") String dateTime) {
        try {
            String[] components = DateTimeUtils.getDateTimeComponents(dateTime);
            return Response.ok(Arrays.toString(components)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid datetime format. Please use a valid datetime string").build();
        }
    }
}
