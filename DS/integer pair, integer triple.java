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



class IntegerTriple implements Comparable < IntegerTriple > {
  Integer _first, _second, _third;

  public IntegerTriple(Integer f, Integer s, Integer t) {
    _first = f;
    _second = s;
    _third = t;
  }

  public int compareTo(IntegerTriple o) {
    if (!this.first().equals(o.first()))
      return this.first() - o.first();
    else if (!this.second().equals(o.second()))
      return this.second() - o.second();
    else
      return this.third() - o.third();
  }

  Integer first() { return _first; }
  Integer second() { return _second; }
  Integer third() { return _third; }
}