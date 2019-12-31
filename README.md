# Ex_2- java

This project is gonna implement graph who built by edges  , vertexes.
The graph will capable to be drawn and execute on it functions by Graph_Algo class.


There are 3 basic classes that make the graph stable , DGraph , EdgeData , NodeData.
each class implement his interface.

1)NodeData - is contain fileds : id , weight , tag , metadata , point3D.
This class implements node_data interface.
for each node has special id ,  who relative to it  , and by give an id , 
then got the node who relative to this id.
 
2)EdgeData - contain fileds : src , dest , weight , tag ,metadata.
This class implements edge_data interface.
For each object instance of EdgeData has the the source node 
,and the destnation node ,who go to it.
addtionlly there is the weight of the edge , this is the "cost" for travlling in it.

3)DGraph -  contain fileds : first Hashtable who repressents the vertex on the graph (by given a key ,get his vertex ),
Secondly an hashtable that repressents the edges ,  this filed contain on it , hashtable inner.
by given Node ,  we get the edges who relative on it 
and edgeNum -  return the number of the edges ,  mc- who count the num of the actions.
This class make num of functions ,1) add node to the graph by given key ,
2) add (connent function) edge by given two diffrents nodes key, who connet them to edge, 
3)and capable return a specific Node ,and edges who relative to specific nodes(src, dest  nodes)
4)and can return collections of vertex and Edges , addtionlly we can remove an node by given key ,  and remove edge 
by given  two diffrents keys (src,  dest ) 5) copy function.

The graph_algo class implements graph_algorithims interface ,the most important class ,who make usess on DGraph class, this class contain filed of specific graph .
The functions are implemnted :  isConnected  - return boolean variable if there is a path from each node to another .
Init by given graph  , and capable to init an object instance graph_algo from file , and save to file a given graph , and copy who duplicate the Graph,
In addition there are special functions : 1) shortestPathDist- who return the most short path from a given node to another node,
the function return double variable ,  2) shortestPath - return list of nodes who visited ,of the shortest path .
3) and TSP -(we are assuming that the graph is highConnected )who return again list of nodes of the shortest path 
who existing in the graph


Furthermore exist a gui class who paints graph by given on  a new window that opend , in this window we can make set of opertions, like save, load , 
and return boolean parameter if the graph isConnected and set of acts who based on graph_algo  functions , 
like shortest path who paint the shortest path on the graph by enter 2 diffrent nodes in the grpah .







