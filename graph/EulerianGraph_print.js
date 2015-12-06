//iterator ops: insert(itr,u) move current itr one pos behind(insert before it), return that 
//pointer before the itr
//1. after getting one edge, erase it bidirectionally
//2. use iterator, divide graph into multiple cycles, add in last edge once the cycles connect to 
//this vertex are finished

//can be used for undirected, no multi edge and just for TOUR
import java.util.*;

public class EuledianGraph {
	static LinkedList<Integer> cyc;
	static Vector<Vector<IntegerPair>> AdjList;
	
	static void EulerTour(ListIterator<Integer> i, int u){
		for(int j=0;j<AdjList.get(u).size();j++){
			IntegerPair v=AdjList.get(u).get(j);
			if(v.second()==1){
				v._second=0;
				for(int k=0;k<AdjList.get(v.first()).size();k++){
					IntegerPair uu=AdjList.get(v.first()).get(k);
					if(uu.first()==u&&uu.second()==1){
						uu._second=0;
						break;
					}
				}
				i.add(u);
				i.previous();
				EulerTour(i,v.first());
				i.next();
			}
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		AdjList=new Vector<>();
		cyc=new LinkedList<>();
		Vector<IntegerPair> r1= new Vector<>();
		r1.add(new IntegerPair(1,1));
		r1.add(new IntegerPair(2,1));
		AdjList.add(r1);
		Vector<IntegerPair> r2= new Vector<>();
		r2.add(new IntegerPair(0,1));
		r2.add(new IntegerPair(2,1));
		r2.add(new IntegerPair(3,1));
		r2.add(new IntegerPair(4,1));
		AdjList.add(r2);
		Vector<IntegerPair> r3= new Vector<>();
		r3.add(new IntegerPair(1,1));
		r3.add(new IntegerPair(3,1));
		r3.add(new IntegerPair(0,1));
		r3.add(new IntegerPair(4,1));
		AdjList.add(r3);
		Vector<IntegerPair> r4= new Vector<>();
		r4.add(new IntegerPair(1,1));
		r4.add(new IntegerPair(2,1));
		r4.add(new IntegerPair(4,1));
		r4.add(new IntegerPair(5,1));
		AdjList.add(r4);
		Vector<IntegerPair> r5= new Vector<>();
		r5.add(new IntegerPair(1,1));
		r5.add(new IntegerPair(2,1));
		r5.add(new IntegerPair(3,1));
		r5.add(new IntegerPair(5,1));
		AdjList.add(r5);
		Vector<IntegerPair> r6= new Vector<>();
		r6.add(new IntegerPair(3,1));
		r6.add(new IntegerPair(4,1));
		AdjList.add(r6);
		
		EulerTour(cyc.listIterator(),0);
		for(int i=0; i<cyc.size();i++){
			System.out.println(cyc.get(i));
		}
	}
}

class IntegerPair implements Comparable < IntegerPair > {
	  Integer _first, _second;

	  public IntegerPair(Integer f, Integer s) {
	    _first = f;
	    _second = s;
	  }

	  public int compareTo(IntegerPair o) {
	    if (!this.first().equals(o.first()))
	      return this.first() - o.first();
	    else
	      return this.second() - o.second();
	  }

	  Integer first() { return _first; }
	  Integer second() { return _second; }
	}