public class GraphChoice {
    public static void Cities(){
        Graph Cities = new Graph();
        Cities.addNode("Turku"); Cities.addNode("Salo");
        Cities.addNode("Helsingfors"); Cities.addNode("Porvoo");
        Cities.addNode("Raumo"); Cities.addNode("Pori");
        Cities.addNode("Mikkeli"); Cities.addNode("Tammerfors");
        Cities.addNode("Forssa"); Cities.addNode("Tavastehus");
        Cities.addNode("Lahtis"); Cities.addNode("Kotka");
        Cities.addNode("Villmanstrand"); Cities.addNode("Imatra");

        Cities.addEdge("Turku","Salo");
        Cities.addEdge("Turku","Raumo");
        Cities.addEdge("Raumo","Pori");
        Cities.addEdge("Raumo","Forssa");
        Cities.addEdge("Pori","Tammerfors");
        Cities.addEdge("Tammerfors","Tavastehus");
        Cities.addEdge("Tavastehus","Lahtis");
        Cities.addEdge("Lahtis","Villmanstrand");
        Cities.addEdge("Salo","Helsingfors");
        Cities.addEdge("Helsingfors","Porvoo");
        Cities.addEdge("Porvoo","Villmanstrand");
        Cities.addEdge("Salo","Forssa");
        Cities.addEdge("Forssa","Tammerfors");
        Cities.addEdge("Mikkeli","Imatra");
        Cities.addEdge("Helsingfors","Lahtis");
        Cities.addEdge("Tammerfors","Lahtis");
        Cities.addEdge("Helsingfors","Kotka");
        Cities.addEdge("Lahtis","Mikkeli");
        Cities.addEdge("Villmanstrand","Kotka");
        Cities.addEdge("Villmanstrand","Imatra");
        Cities.addEdge("Kotka","Imatra");
        System.out.println(Cities.getNodeList());

    }

    public static void Graph1(){
        Graph Graph1 = new Graph();
        Graph1.addNode("A"); Graph1.addNode("B");
        Graph1.addNode("C"); Graph1.addNode("D");
        Graph1.addNode("E"); Graph1.addNode("F");

        Graph1.addEdge("A","B"); Graph1.addEdge("A","C");
        Graph1.addEdge("A","D"); Graph1.addEdge("B","C");
        Graph1.addEdge("B","E"); Graph1.addEdge("B","G");
        Graph1.addEdge("C","E"); Graph1.addEdge("C","D");
        Graph1.addEdge("G","E"); Graph1.addEdge("E","D");
        Graph1.addEdge("E","F"); Graph1.addEdge("D","F");
        System.out.println(Graph1.getNodeList());

    }
    public static void Graph2(){
        Graph Graph2 = new Graph();
        Graph2.addNode("A"); Graph2.addNode("B");
        Graph2.addNode("C"); Graph2.addNode("D");
        Graph2.addNode("E"); Graph2.addNode("F");

        Graph2.addEdge("A","B");  Graph2.addEdge("A","C");
        Graph2.addEdge("A","D"); Graph2.addEdge("B","C");
        Graph2.addEdge("B","E");  Graph2.addEdge("C","E");
        Graph2.addEdge("D","C"); Graph2.addEdge("D","F");
        Graph2.addEdge("E","D"); Graph2.addEdge("E","F");
        System.out.println(Graph2.getNodeList());
    }
    public static void Names(){
        Graph Names = new Graph();
        Names.addNode("Anders");
        Names.addNode("Berit");
        Names.addNode("Christel");
        Names.addNode("Dani");
        Names.addNode("Eva");
        Names.addNode("Fredrik");
        Names.addNode("Greta");

        Names.addEdge("Anders","Berit");
        Names.addEdge("Anders","Christel");
        Names.addEdge("Anders","Dani");
        Names.addEdge("Berit","Christel");
        Names.addEdge("Berit","Eva");
        Names.addEdge("Berit","Greta");
        Names.addEdge("Christel","Eva");
        Names.addEdge("Christel","Dani");
        Names.addEdge("Greta","Eva");
        Names.addEdge("Eva","Dani");
        Names.addEdge("Eva","Fredrik");
        Names.addEdge("Dani","Fredrik");
        System.out.println(Names.getNodeList());
    }
}
