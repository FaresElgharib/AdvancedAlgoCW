package cw;

import java.util.*;

public class Q8RoutingTable {
    public static void main(String[] args) {
        // Running the code
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of nodes in the network: ");
        int numNodes = input.nextInt();
        
        // Reading the connectivity information for each of the nodes
        Map<Character, List<Character>> connectivity = new HashMap<>();
        for (int i = 0; i < numNodes; i++) {
            System.out.print("Enter the connectivity information for node " + (char) ('A' + i) + ": ");
            Scanner input1 = new Scanner(System.in);
            String connectivityInfo = input1.nextLine();
            System.out.println(connectivityInfo);
            char node = connectivityInfo.charAt(5);
            char neighbor = connectivityInfo.charAt(8);
            if (!connectivity.containsKey(node)) {
                connectivity.put(node, new ArrayList<>());
            }
            connectivity.get(node).add(neighbor);
        }
        
        // Building the routing tables for each node
        Map<Character, Map<Character, Character>> routingTables = new HashMap<>();
        for (char node : connectivity.keySet()) {
            Map<Character, Character> routingTable = new HashMap<>();
            Queue<Character> queue = new LinkedList<>();
            Set<Character> visited = new HashSet<>();
            queue.offer(node);
            visited.add(node);
            while (!queue.isEmpty()) {
                char curr = queue.poll();
                for (char neighbor : connectivity.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                        routingTable.put(neighbor, curr);
                    }
                }
            }
            routingTables.put(node, routingTable);
        }
        
        // Printing the routing table
        for (char node : routingTables.keySet()) {
            System.out.println("Routing table for node " + node + ":");
            Map<Character, Character> routingTable = routingTables.get(node);
            for (char dest : routingTable.keySet()) {
                System.out.println("(" + dest + ", " + routingTable.get(dest) + ")");
            }
            System.out.println();
        }
    }
}
