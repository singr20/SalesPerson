import java.util.*;

public class TravelingSalesPerson
{

    public TravelingSalesPerson()
    {

        String[] cities = {"Boston", "L.A.", "Las Vegas", "Atlanta", "Philadelphia", "Chicago", "Houston"};

        int[][] dist = {{0,   2982,  2715, 1080, 310,  982,  1849},
                        {2982, 0,    270,  2174, 2710, 2015, 1549},
                        {2715, 270,  0,    1959, 2473, 1747, 1473},
                        {1080, 2174, 1959, 0,    777,  715,  794 },
                        {310,  2710, 2473, 777,  0,    785,  1548},
                        {982,  2015, 1747, 715,  785,   0,   1084},
                        {1849, 1549, 1473, 794,  1548, 1084, 0}};
        /*
         * The nearest neighbour algorithm was one of the first algorithms 
         * used to determine a solution to the travelling salesman problem.
         * In it, the salesman starts at a random city and repeatedly visits 
         * the nearest city until all have been visited. It quickly yields a 
         * short tour, but usually not the optimal one.
         * 
         */    
        int start = 4;//this is philly, but you want to make this random
        //print the city that is the starting point - one that coorelates to start variable
        System.out.println(Arrays.toString(nearNeighbor(cities, dist, start).toArray()));
        //print the route that you find in your nearest neighbor function
        //also print the miles between each city
        
    }

    public ArrayList<String> nearNeighbor(String[] cities, int[][] dist, int start){

        ArrayList<String> used = new ArrayList<String>();
        ArrayList<String> nnCities = new ArrayList<String>(7);
        
        String startCity = cities[start];
        used.add(startCity);
        int lowMiles = 999999999;
        int spot = 0;
        String destCity = "";
        
        while(used.size() < 7){
            for(int x = 0; x < dist[start].length; x++){
                if(dist[start][x] < lowMiles && dist[start][x] != 0 && !used.contains(cities[x])){
                    lowMiles = dist[start][x];
                    spot = x;
                    destCity = cities[spot];
                }
            }
            used.add(destCity);
            nnCities.add(cities[start] + " to " + destCity + " - " + lowMiles + " miles");
            start = spot;
            spot = 0;
            lowMiles = 9999999;
        }
            
        return nnCities;

    }

}
