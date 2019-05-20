import java.util.Scanner;
 
public class BellmanFord
{
    private int dist[];
    private int number_of_vertices;
    public static final int MAX_VALUE = 999;
 
    public BellmanFord(int number_of_vertices)
    {
        this.number_of_vertices = number_of_vertices;
        dist = new int[number_of_vertices + 1];
    }
 
    public void BellmanFordEvaluation(int source, int adj_matrix[][])
    {
        for (int node = 1; node <= number_of_vertices; node++)
        {
            dist[node] = MAX_VALUE;
        }
 
        dist[source] = 0;
        for (int node = 1; node <= number_of_vertices - 1; node++)
        {
            for (int source_node = 1; source_node <= number_of_vertices; source_node++)
            {
                for (int destination_node = 1; destination_node <= number_of_vertices; destination_node++)
                {
                    if (adj_matrix[source_node][destination_node] != MAX_VALUE)
                    {
                        if (dist[destination_node] > dist[source_node] 
                                + adj_matrix[source_node][destination_node])
                            dist[destination_node] = dist[source_node]
                                + adj_matrix[source_node][destination_node];
                    }
                }
            }
        }
 
        for (int source_node = 1; source_node <= number_of_vertices; source_node++)
        {
            for (int destination_node = 1; destination_node <= number_of_vertices; destination_node++)
            {
                if (adj_matrix[source_node][destination_node] != MAX_VALUE)
                {
                    if (dist[destination_node] > dist[source_node]
                           + adj_matrix[source_node][destination_node])
                        System.out.println("Entered edge cost factors contains negative values");
                }
            }
        }
		System.out.println();
        System.out.println("The Shortest Path to all nodes are as follows ");
        for (int vertex = 1; vertex <= number_of_vertices; vertex++)
        {
            System.out.println(source + " to " + vertex + " is " + dist[vertex]);
			System.out.println("-----------");
        }
		
    }
 
    public static void main(String args[])
    {
        int number_of_vertices = 0;
        int source;
        Scanner scanner = new Scanner(System.in);
		System.out.println();
        System.out.println("Enter the number of vertices");
        number_of_vertices = scanner.nextInt();
 
        int adj_matrix[][] = new int[number_of_vertices + 1][number_of_vertices + 1];
        System.out.println();
		System.out.println("Enter the cost of edges in the network in the form of Node Incidence Matrix");
        for (int source_node = 1; source_node <= number_of_vertices; source_node++)
        {
            for (int destination_node = 1; destination_node <= number_of_vertices; destination_node++)
            {
                adj_matrix[source_node][destination_node] = scanner.nextInt();
 	        if (source_node == destination_node)
                {
                    adj_matrix[source_node][destination_node] = 0;
                    continue;
                }
                if (adj_matrix[source_node][destination_node] == 0)
                {
                    adj_matrix[source_node][destination_node] = MAX_VALUE;
                }
            }
        }
		System.out.println();
        System.out.println("Enter the source node in the network graph ");
        source = scanner.nextInt();
 
        BellmanFord bellmanford = new BellmanFord(number_of_vertices);
        bellmanford.BellmanFordEvaluation(source, adj_matrix);
        scanner.close();	
		
		System.out.println();
		if (number_of_vertices == 6)
			{
			System.out.println("Note: Considered S=1 A=2 B=3 C=4 D=5 t=6");
			}
		else
			{
			System.out.println("Note: Considered node A=1, node B=2, node C=3, node D=4 etc.");
			}
		System.out.println();
		System.out.println("-End of BellmanFord Algorithm-");
    }
}